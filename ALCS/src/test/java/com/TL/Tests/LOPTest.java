package com.TL.Tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.TL.Base.BaseClass;
import com.TL.Base.ExtentManager;
import com.TL.Base.Genric;
import com.TL.PageMethods.LoginMethods;
import com.TL.PageMethods.InputsMethods;
import com.TL.PageMethods.LOPMethods;
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
		loginMethods = new LoginMethods(driver, genric);
		LOPMethods = new LOPMethods(driver, genric);
		inputs = new InputsMethods(driver, genric);
	}

	//To verify Adding loss of pay for an associate
	@Test()
	public void TC_01_Add_Loss_Of_Pay() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		LOPMethods.Go_to_Loss_Of_Pay_Page();
		LOPMethods.SelectClientLOP();
		LOPMethods.SelectEmployeeAndApplyLOP();
	}
	
	//To verify cancelling loss of pay for an associate and verify it in cancelled status
	@Test()
	public void TC_02_Cancel_Loss_Of_Pay() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		LOPMethods.Go_to_Revised_Loss_Of_Pay_Page();
		LOPMethods.SelectClientCancelLOP();
		LOPMethods.SelectEmployeeAndCancelLOP();
		inputs.HamburgerIconClick();
		LOPMethods.Go_to_Revised_Loss_Of_Pay_Page();
		LOPMethods.SelectClientCancelledStatus();
				
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
