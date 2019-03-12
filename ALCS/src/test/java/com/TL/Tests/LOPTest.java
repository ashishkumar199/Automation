package com.TL.Tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.TL.Base.BaseClass;
import com.TL.Base.ExtentManager;
import com.TL.Base.Genric;
import com.TL.Base.RetryAnalyzer;
import com.TL.PageMethods.LoginPageMethods;
import com.TL.PageMethods.InputsMethods;
import com.TL.PageMethods.LOPPageMethods;
import com.TL.PageMethods.LOPApprovalPageMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class LOPTest extends BaseClass{
	
ExtentReports extent = ExtentManager.getReporter(filePath);
	
	@BeforeMethod	
	public void before() {
		genric = new Genric(driver);
		driver = genric.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		genric.launchApplication();
		loginMethods = new LoginPageMethods(driver, genric);
		LOPPageMethods = new LOPPageMethods(driver, genric);
		LOPApprovalPageMethods = new LOPApprovalPageMethods(driver, genric);
		inputs = new InputsMethods(driver, genric);		
	
	}

	//To verify Adding loss of pay for an associate
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_01_Add_Loss_Of_Pay() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		LOPPageMethods.Go_to_Loss_Of_Pay_Page(); 
		LOPPageMethods.SelectClientLOP();
		LOPPageMethods.SelectEmployeeAndApplyLOP();
	}
	
	//To verify canceling loss of pay for an associate and verify it in cancelled status
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_02_Cancel_Loss_Of_Pay() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		LOPApprovalPageMethods.Go_to_Loss_Of_Pay_Approval_Page();
		LOPApprovalPageMethods.SelectClientCancelLOP();
		LOPPageMethods.SelectEmployeeAndCancelLOP();
		inputs.HamburgerIconClick();
		LOPApprovalPageMethods.Go_to_Loss_Of_Pay_Approval_Page();
		LOPApprovalPageMethods.SelectClientCancelledStatus();
				
		
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
