package com.TL.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.Base.RetryAnalyzer;
import com.TL.PageMethods.InputsMethods;
import com.TL.PageMethods.LoginPageMethods;
import com.TL.PageMethods.ReportsPageMethods;
import com.TL.PageObjects.InputsObjects;
import com.TL.Utils.CsvReader;


public class InputsTest extends BaseClass {	
    
	
	@BeforeMethod
	public void before() {
		genric = new Genric(driver);
		driver = genric.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		genric.launchApplication();
		inputs = new InputsMethods(driver, genric);
		reports = new ReportsPageMethods(driver, genric);
		cv = new CsvReader(csvpath);
		loginMethods = new LoginPageMethods(driver, genric);
	}


	//To verify Standard offer letter page is loaded successfully.
	@Test
	public void TC_01_go_To_Standard_Offer_Letter_Page() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		inputs.go_to_offer_letter_page();
		Assert.assertEquals(inputs.all_page_get_text(), "Standard Offer Letter", "Expected:Standard offer Letter text should be present");
		}

	//To check reset button functionality on standard offer letter page (Mass upload option)
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_02_Standard_Offer_Letter_Reset_Button() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		inputs.go_to_offer_letter_page();
		inputs.upload_Offer_Letter_File_Reset_button(cv);
		Assert.assertEquals(genric.getCurrentURL(), InputsObjects.Standard_Offer_Letter_URL);
		
	}
	
	//To Upload standard offer letter (Mass upload option)
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_03_upload_Standard_Offer_Letter() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		inputs.go_to_offer_letter_page();
		inputs.upload_offer_letter_file(cv);
		Assert.assertTrue(genric.element(InputsObjects.validation_mssg).isDisplayed());
	}

	//To verify Pre-Associate History Page opens successfully
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_04_go_To_Pre_Associate_History_Page() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		inputs.go_to_pre_associate_history_page();
		Assert.assertEquals(inputs.all_page_get_text(), "Pre Associate History", "Expected:Pre Associate History text should be present");
		}

	@Test
	public void TC_05_pre_Associate_History_Search_Page() throws IOException {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());			
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();		
		inputs.go_to_pre_associate_history_page();
		inputs.fil_pre_associate_history_details(cv);		
		Assert.assertEquals(inputs.get_emp_id(), inputs.get_Basic_Details_Emp_id(), "Employee ID should Match");
		Assert.assertEquals(inputs.Basic_details_First_Name(), cv.read_csv(1, 3), "Employee ID should Match");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_06_Offer_Letter_Approval() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		inputs.HamburgerIconClick();
		inputs.go_to_pre_associate_history_page();
		inputs.fil_pre_associate_history_details(cv);
		inputs.HamburgerIconClick();
		inputs.go_to_Offer_Letter_Approval_page();
		inputs.go_to_offer_letter_approval_approved_page();
		Assert.assertEquals(inputs.search_approved_offer_letter(cv), InputsMethods.Employee_ID);
	
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
