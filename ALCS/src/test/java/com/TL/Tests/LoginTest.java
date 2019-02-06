package com.TL.Tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TL.Base.BaseClass;
import com.TL.Base.ExtentManager;
import com.TL.Base.Genric;
import com.TL.Base.RetryAnalyzer;
import com.TL.PageObjects.LoginObjects;
import com.TL.Utils.PropertyReader;
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

	}
	
	// Verify that user is not able to login with invalid credentials
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_01_Incorrect_Credentials_Login_Failure() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		genric.waitForLoading();
		genric.element(LoginObjects.User_Name).sendKeys(
				PropertyReader.readDataProperty("invalid_username"));
		genric.element(LoginObjects.Password).sendKeys(
				PropertyReader.readDataProperty("InvalidPassword"));
		genric.element(LoginObjects.SignIn_btn).click();
		Assert.assertTrue(genric.element(LoginObjects.Validation_Msg).isDisplayed(), 
				"Expected: Invalid User ID or Password");
		System.out.println(genric.element(LoginObjects.Validation_Msg).getText());

	}

	//Verify that user is able to login with valid Login ID and password
	@Test
	public void TC_02_Correct_Credentials_Login_Success() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		genric.waitForLoading();
		genric.element(LoginObjects.User_Name).sendKeys(
				PropertyReader.readDataProperty("Valid_username"));
		genric.element(LoginObjects.Password).sendKeys(
				PropertyReader.readDataProperty("ValidPassword"));
		genric.element(LoginObjects.SignIn_btn).click();
		genric.waitForLoading();
		Assert.assertTrue(genric.element(LoginObjects.Teamlease_logo)
				.isDisplayed(), "Expected: Teamlease Logo to be displayed");
		Assert.assertTrue(genric.element(LoginObjects.Dashboard_Page)
				.isDisplayed(), "Expected: Dashboard Page to be displayed"); 
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