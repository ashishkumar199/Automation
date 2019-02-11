package com.TL.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageMethods.LoginMethods;
import com.TL.PageMethods.ReportsMethods;
import com.TL.PageObjects.ReportsObjects;
import com.TL.Utils.CsvReader;
import com.TL.Utils.XlsReader;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsTest extends BaseClass {
		
	@BeforeMethod
	public void before() {		
		
		genric = new Genric(driver);
		driver = genric.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		genric.launchApplication();
		genric.waitForLoading(); 
		reports = new ReportsMethods(driver, genric);
		loginMethods = new LoginMethods(driver, genric);
		cv = new CsvReader(DownloadPath);
		
	}	
        
	//To verify that Reports Page is loading
	@Test
	public void TC_01_VerifyReportsPageLoading() {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		loginMethods.UserLogin();
		reports.proceedToReports();
		Assert.assertTrue(genric.element(ReportsObjects.View_And_Download_Report_Page) 
				.isDisplayed(), "Expected: View_And_Download_Report_Page to be displayed");
		Assert.assertTrue(genric.element(ReportsObjects.Report_View_OR_Download)
				.isDisplayed(), "Expected: Report_View_OR_Download radio button to be displayed"); 
		Assert.assertTrue(genric.element(ReportsObjects.Request_Report_Through_mail)
				.isDisplayed(), "Expected: Request_Report_Through_mail radio button to be displayed"); 
	}
	
	@DataProvider(name = "Download.Report")
	public Object[][] View_and_Download_Report() {
		XlsReader datatable = new XlsReader(Testdatasheetpath);
		String Sheet = "Reports";
		int rowcount = datatable.getRowCount(Sheet);
		Object[][] result = new Object[rowcount - 1][2];		
		for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
			result[rowNum - 2][0] = datatable.getCellData(Sheet, "Report_Names", rowNum);
			result[rowNum - 2][1] = datatable.getCellData(Sheet, "Client_Name_ID", rowNum);
		}
		return result;
	}

	// To verify that correct reports are downloading
	@Test(dataProvider = "Download.Report")
	public void TC02_verify_reports_downloading(String Report_Names, String Client_Name_ID) throws IOException {
		test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Report_Names);
		System.out.println(Report_Names + " : " + Client_Name_ID);
		loginMethods.UserLogin();
		reports.proceedToReports();
		reports.SelectReport(Report_Names, Client_Name_ID);		
		Assert.assertTrue(reports.csvreturn().contains(Report_Names));
		
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
