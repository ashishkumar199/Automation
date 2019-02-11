package com.TL.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.TL.Base.BaseClass;
import com.TL.Base.ExtentManager;
import com.TL.Base.Genric;
import com.TL.PageMethods.InputsMethods;
import com.TL.PageMethods.LoginMethods;
import com.TL.PageMethods.ReportsMethods;
import com.TL.PageObjects.PagesLoadingObjects;
import com.TL.Utils.XlsReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class PagesLoadingTest {
	
	public class LoginTest extends BaseClass {
		
		ExtentReports extent = ExtentManager.getReporter(filePath);
		
		@BeforeMethod	
		public void before() {
			genric = new Genric(driver);
			driver = genric.getDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			genric.launchApplication();		
			PageLoading = new PagesLoadingObjects(driver, genric);
			reports = new ReportsMethods(driver, genric);
			inputs = new InputsMethods(driver, genric);
			loginMethods = new LoginMethods(driver, genric);
		}
		
		// Verify that dashboard page is loading
		@Test()
		public void TC_01_DashboardPageLoading() {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
			loginMethods.UserLogin();
			inputs.hamburgericonclick();
			genric.element(PagesLoadingObjects.dashboardlink).click();
			Assert.assertTrue(genric.element(PagesLoadingObjects.dashboardHeader).isDisplayed(), 
					"Expected: Dashboard Page is Displayed");
			Assert.assertTrue(genric.element(PagesLoadingObjects.dashboardBCT).isDisplayed(), 
					"Expected: Dashboard Page BCT is Displayed");			

		}
		
		@DataProvider(name = "MaterPages")
		public Object[][] View_and_Download_Report() {
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			String Sheet = "MarterPages";
			int rowcount = datatable.getRowCount(Sheet);
			Object[][] result = new Object[rowcount - 1][3];		
			for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
				result[rowNum - 2][0] = datatable.getCellData(Sheet, "Root", rowNum);
				result[rowNum - 2][1] = datatable.getCellData(Sheet, "Parent", rowNum);
				result[rowNum - 2][2] = datatable.getCellData(Sheet, "Child", rowNum);
			}
			return result;
		}

		// Verify that all pages under master tab are loading properly
		@Test(dataProvider = "MaterPages")
		public void TC_02_MasterTabPagesLoading(String Root, String Parent, String Child) throws InterruptedException {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Root+"_"+Parent+"_"+Child);
			loginMethods.UserLogin();
			inputs.hamburgericonclick();
			driver.findElement(
					By.xpath(".//span[text()='"+ Root + "']")).click();
			genric.waitForLoading();
			driver.findElement(
						By.xpath(".//a[text()='"+ Parent + "']")).click();	
			genric.waitForLoading();
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
						By.xpath(".//a[text()='"+ Child + "']")));
				
			driver.findElement(
					By.xpath(".//a[text()='"+ Child + "']")).click();	
			genric.waitForLoading();
			System.out.println(genric.element(PagesLoadingObjects.Page_Header).getText());
			Assert.assertTrue(genric.element(PagesLoadingObjects.All_page_text).isDisplayed(), 
					"Expected: Page is Displayed");
			
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
}
