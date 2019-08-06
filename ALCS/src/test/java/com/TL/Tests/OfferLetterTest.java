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
import com.TL.PageMethods.AssociateConfirmDOJPageMethods;
import com.TL.PageMethods.AssociateHistoryPageMethods;
import com.TL.PageMethods.AssociateModifyProfileMethods;
import com.TL.PageMethods.DashboardPageMethods;
import com.TL.PageMethods.LoginPageMethods;
import com.TL.PageMethods.LopsPageMethods;
import com.TL.PageMethods.OfferLetterApprovalPageMethods;
import com.TL.PageMethods.PreAssocoateHistoryPageMethods;
import com.TL.PageMethods.ReportsPageMethods;
import com.TL.PageMethods.StandardOfferLetterPageMethods;
import com.TL.PageObjects.AssociateConfirmDOJPageObjects;
import com.TL.PageObjects.AssociateHistoryPageObjects;
import com.TL.PageObjects.AssociateModifyProfilePageObjects;
import com.TL.PageObjects.LopsPageObjects;
import com.TL.PageObjects.StandardOfferLetterPageObjects;
import com.TL.Utils.CsvReader;
import com.TL.Utils.XlsReader;


public class OfferLetterTest extends BaseClass {	
    
	
	@BeforeMethod
	public void before() {
		genric = new Genric(driver);
		driver = genric.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		genric.launchApplication();
		StandardOL = new StandardOfferLetterPageMethods(driver, genric);
		PreAssociateHistory = new PreAssocoateHistoryPageMethods(driver, genric);
		OLApproval = new OfferLetterApprovalPageMethods(driver, genric);
		Dashboard = new DashboardPageMethods(driver, genric);
		reports = new ReportsPageMethods(driver, genric);
		cv = new CsvReader(csvpath);
		loginMethods = new LoginPageMethods(driver, genric);
		Lops = new LopsPageMethods(driver, genric);
		ConfirmDOJ = new AssociateConfirmDOJPageMethods(driver, genric);
		AssociateHistory = new AssociateHistoryPageMethods(driver, genric);
		AssociateModifyProfile = new AssociateModifyProfileMethods(driver, genric);
		xls = new XlsReader(Testdatasheetpath);
	} 
    
	//To verify Standard offer letter page is loaded successfully.
	@Test
	public void TC_01_go_To_Standard_Offer_Letter_Page() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		genric.waitForLoading();
		StandardOL.go_to_offer_letter_page();
		Assert.assertEquals(StandardOL.all_page_get_text(), "Standard Offer Letter", "Expected:Standard offer Letter text should be present");
		}

	//To check reset button functionality on standard offer letter page (Mass upload option)
	@Test
	public void TC_02_Standard_Offer_Letter_Reset_Button() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		genric.waitForLoading();
		StandardOL.go_to_offer_letter_page();
		StandardOL.upload_Offer_Letter_File_Reset_button(cv);
		Assert.assertEquals(genric.getCurrentURL(), StandardOfferLetterPageObjects.Standard_Offer_Letter_URL);
		
	}

	//To Upload standard offer letter (Mass upload option)
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void TC_03_upload_Standard_Offer_Letter() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		genric.waitForLoading();
		StandardOL.go_to_offer_letter_page();
		StandardOL.upload_offer_letter_file(cv);
		Assert.assertTrue(genric.element(StandardOfferLetterPageObjects.validation_mssg).isDisplayed());
	}

	//To verify Pre-Associate History Page opens successfully
	@Test
	public void TC_04_go_To_Pre_Associate_History_Page() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		PreAssociateHistory.go_to_pre_associate_history_page();
		Assert.assertEquals(StandardOL.all_page_get_text(), "Pre Associate History", "Expected:Pre Associate History text should be present");
		}

	//To verify uploaded Associate on Pre-Associate History Page
	//execute this test if offer letter approval needs to be executed
	@Test
	public void TC_05_pre_Associate_History_Search_Page() throws IOException {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());			
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();		
		PreAssociateHistory.go_to_pre_associate_history_page();
		PreAssociateHistory.fil_pre_associate_history_details(cv);		
		Assert.assertEquals(PreAssociateHistory.get_emp_id(), PreAssociateHistory.get_Basic_Details_Emp_id(), "Employee ID should Match");
		Assert.assertEquals(PreAssociateHistory.Basic_details_First_Name(), cv.read_csv(1, 3), "Employee name should Match");
	}

	//To verify Offer Letter Approval Status
	@Test
	public void TC_06_Offer_Letter_Approval() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		OLApproval.go_to_Offer_Letter_Approval_page();
		OLApproval.go_to_offer_letter_approval_approved_page();
	//	OLApproval.search_approved_offer_letter(cv);
		Assert.assertEquals(OLApproval.Find_Associate(), xls.getCellData("OfferLetterEmpCreated", 0, 2));
	}
	
	//upload associate documents on Associate Documentation Verification-LOPS page
	@Test
	public void TC_07_AssociateDocumentUpload() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		Lops.go_To_Lops_Page();
		Lops.dropdown_Select_ClientNameID();
		Lops.Select_Newly_Created_Associate_And_Search(cv);
		Lops.UploadDocuments();
		Assert.assertEquals(genric.element(LopsPageObjects.FileUploadPopUp).getText(), "SUCCESS!");
		genric.element(LopsPageObjects.Ok_btn).click();
	}

	//Confirm DOJ
	@Test
	public void TC_08_AssociateConfirmDOJ() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		ConfirmDOJ.go_To_Confirm_DOJ_Page();
		Lops.dropdown_Select_ClientNameID();
		ConfirmDOJ.Search_Newly_Created_Associate();
		Assert.assertEquals(genric.element(AssociateConfirmDOJPageObjects.EMPLOYEE_NO).getText(), xls.getCellData("OfferLetterEmpCreated", 0, 2));
		ConfirmDOJ.Select_Candidate_And_Transfer_To_Associate();
		Assert.assertEquals(genric.element(LopsPageObjects.FileUploadPopUp).getText(), "SUCCESS!");
		genric.element(LopsPageObjects.Ok_btn).click();
		}

	//To verify newly created associate on Associate History Page
	@Test
	public void TC_09_Verify_Associate_On_AssociateHistory_Page() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		AssociateHistory.go_to_Associate_History_Page();
		AssociateHistory.dropdown_Select_ClientNameID();
		AssociateHistory.Search_Newly_Created_Associate();
		Assert.assertEquals(genric.element(AssociateHistoryPageObjects.AssociateNameSearch).getText(), xls.getCellData("OfferLetterEmpCreated", 0, 3));
	}

	//Associate Modify Profile for single associate, Change Pay Mode
	@Test
	public void TC_10_Associate_Modify_Profile() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		Dashboard.HamburgerIconClick();
		AssociateModifyProfile.go_to_Associate_Modify_Profile_Page();
		AssociateModifyProfile.dropdown_Select_ClientNameID();
		AssociateModifyProfile.Search_Newly_Created_Associate_Modify_Profile();
		AssociateModifyProfile.ChangePayMode();
		Assert.assertEquals(genric.element(AssociateModifyProfilePageObjects.SuccessPopUp).getText(), "SUCCESS!");
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
