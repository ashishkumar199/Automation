package com.TL.Tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.TL.Base.BaseClass;
import com.TL.Base.ExtentManager;
import com.TL.Base.Genric;
import com.TL.Base.RetryAnalyzer;
import com.TL.PageObjects.LoginPageObjects;
import com.TL.Utils.PropertyReader;
import com.TL.Utils.SQLConnector;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseClass {

	ExtentReports extent = ExtentManager.getReporter(filePath);
	
	@BeforeMethod	
	public void before() {
		genric = new Genric(driver);
		driver = genric.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		genric.launchApplication();
		sqlconnection = new SQLConnector();
	}
	
	// Verify that user is not able to login with invalid credentials
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_01_Incorrect_Credentials_Login_Failure() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		genric.waitForLoading();
		genric.element(LoginPageObjects.User_Name).sendKeys(
				PropertyReader.readDataProperty("invalid_username"));
		genric.element(LoginPageObjects.Password).sendKeys(
				PropertyReader.readDataProperty("InvalidPassword"));
		genric.element(LoginPageObjects.SignIn_btn).click();
		Assert.assertTrue(genric.element(LoginPageObjects.Validation_Msg).isDisplayed(), 
				"Expected: Invalid User ID or Password");

	}

	//Verify that user is able to login with valid Login ID and password
	@Test
	public void TC_02_Correct_Credentials_Login_Success() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		genric.waitForLoading();
		genric.element(LoginPageObjects.User_Name).sendKeys(
				PropertyReader.readDataProperty("Valid_username"));
		genric.element(LoginPageObjects.Password).sendKeys(
				PropertyReader.readDataProperty("ValidPassword"));
		genric.element(LoginPageObjects.SignIn_btn).click();
		genric.waitForLoading();
		Assert.assertTrue(genric.element(LoginPageObjects.Dashboard_Page)
				.isDisplayed(), "Expected: Dashboard Page to be displayed"); 
		Assert.assertTrue(genric.element(LoginPageObjects.Teamlease_logo)
				.isDisplayed(), "Expected: Teamlease Logo to be displayed");
	}
	
	//To verify Teamlease logo appears on login page
	@Test
	public void TC_03_Verify_TL_Logo_On_Login_Page() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		genric.waitForLoading();
		Assert.assertTrue(genric.element(LoginPageObjects.TLLogo)
				.isDisplayed(), "Expected: Teamlease Logo to be displayed");
	}
	
	
	@Test
	public void TC4_SQLQuery() throws ClassNotFoundException, SQLException {
		//sqlconnection.ExecuteQuery("SELECT top 1 * FROM Miicrras..associate_master where AM_Status = 'A' and AM_Client_ID = '00fbg' order by AM_Created_Date desc" , "AM_Emp_No");
		Assert.assertEquals((sqlconnection.ExecuteQuery("SELECT top 1 * FROM Miicrras..associate_master where AM_Status = 'A' and AM_Client_ID = '00fbg' order by AM_Created_Date desc" , "AM_Emp_No")), "1605657");	
	    
	}
		
		
	@AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable());
            String screenshot_path= genric.captureScreenShot(driver, result.getName());
    		String image= test.addScreenCapture(screenshot_path);
    		test.log(LogStatus.INFO, result.getName(), image);
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }

        extent.endTest(test);        
        extent.flush();
        driver.quit();
    }
}
