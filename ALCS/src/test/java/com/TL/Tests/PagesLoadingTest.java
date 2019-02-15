package com.TL.Tests;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
			inputs.HamburgerIconClick();
			genric.element(PagesLoadingObjects.dashboardlink).click();
			Assert.assertTrue(genric.element(PagesLoadingObjects.dashboardHeader).isDisplayed(), 
					"Expected: Dashboard Page is Displayed");
			Assert.assertTrue(genric.element(PagesLoadingObjects.dashboardBCT).isDisplayed(), 
					"Expected: Dashboard Page BCT is Displayed");			

		}
		
		@DataProvider(name = "MasterPages")
		public Object[][] MasterPagesLoading() {
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			String Sheet = "MasterPages";
			int rowcount = datatable.getRowCount(Sheet);
			Object[][] result = new Object[rowcount - 1][4];		
			for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
				result[rowNum - 2][0] = datatable.getCellData(Sheet, "Root", rowNum);
				result[rowNum - 2][1] = datatable.getCellData(Sheet, "Parent", rowNum);
				result[rowNum - 2][2] = datatable.getCellData(Sheet, "Child", rowNum);
				result[rowNum - 2][3] = datatable.getCellData(Sheet, "Page_Title", rowNum);
			}
			return result;
		}

		// To verify that all pages under master tab are loading properly and navigating to correct page
		@Test(dataProvider = "MasterPages")
		public void TC_02_MasterTabPagesLoading(String Root, String Parent, String Child, String Page_Title) throws InterruptedException {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Root+"_"+Parent+"_"+Child);
			loginMethods.UserLogin();
			inputs.HamburgerIconClick();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//span[text()='"+ Root + "']")).click();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Parent + "']")).click();	
			genric.waitForLoading();
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
						                              By.xpath(".//a[text()='"+ Child + "']")));				
			driver.findElement(By.xpath(".//a[text()='"+ Child + "']")).click();							
			genric.waitForLoading();
			System.out.println(genric.element(PagesLoadingObjects.Page_Header).getText());			
			Assert.assertEquals((genric.element(PagesLoadingObjects.Page_Header).getText()), Page_Title, "Expected: Page is Displayed");
			
		}
		
		
		@DataProvider(name = "InputsPages")
		public Object[][] InputsPagesLoading() {
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			String Sheet = "InputsPages";
			int rowcount = datatable.getRowCount(Sheet);
			Object[][] result = new Object[rowcount - 1][4];		
			for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
				result[rowNum - 2][0] = datatable.getCellData(Sheet, "Root", rowNum);
				result[rowNum - 2][1] = datatable.getCellData(Sheet, "Parent", rowNum);
				result[rowNum - 2][2] = datatable.getCellData(Sheet, "Child", rowNum);
				result[rowNum - 2][3] = datatable.getCellData(Sheet, "Page_Title", rowNum);
			}
			return result;
		}

		// To verify that all pages under Inputs tab are loading properly and navigating to correct page
		@Test(dataProvider = "InputsPages")
		public void TC_03_InputsPagesLoading(String Root, String Parent, String Child, String Page_Title) throws InterruptedException, AWTException {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Root+"_"+Parent+"_"+Child);
			loginMethods.UserLogin();
			inputs.HamburgerIconClick();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//span[text()='"+ Root + "']")).click();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Parent + "']")).click();	
			genric.waitForLoading();									
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
						                              By.xpath(".//a[text()='"+ Child + "']")));
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Child + "']")).sendKeys(Keys.ENTER);						
			genric.waitForLoading();
			System.out.println(genric.element(PagesLoadingObjects.Page_Header).getText());	
			Assert.assertEquals((genric.element(PagesLoadingObjects.Page_Header).getText()), Page_Title, "Expected: Page is Displayed");
			
		}   
		
		
		@DataProvider(name = "InvoicePages")
		public Object[][] InvoicePagesLoading() {
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			String Sheet = "InvoicePages";
			int rowcount = datatable.getRowCount(Sheet);
			Object[][] result = new Object[rowcount - 1][4];		
			for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
				result[rowNum - 2][0] = datatable.getCellData(Sheet, "Root", rowNum);
				result[rowNum - 2][1] = datatable.getCellData(Sheet, "Parent", rowNum);
				result[rowNum - 2][2] = datatable.getCellData(Sheet, "Child", rowNum);
				result[rowNum - 2][3] = datatable.getCellData(Sheet, "Page_Title", rowNum);
			}
			return result;
		}

		// To verify that all pages under Invoice tab are loading properly and navigating to correct page
		@Test(dataProvider = "InvoicePages")
		public void TC_04_InvoicePagesLoading(String Root, String Parent, String Child, String Page_Title) throws InterruptedException, AWTException {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Root+"_"+Parent+"_"+Child);
			loginMethods.UserLogin();
			inputs.HamburgerIconClick();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//span[text()='"+ Root + "']")).click();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Parent + "']")).click();	
			genric.waitForLoading();									
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
						                              By.xpath(".//a[text()='"+ Child + "']")));
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Child + "']")).sendKeys(Keys.ENTER);						
			genric.waitForLoading();
			System.out.println(genric.element(PagesLoadingObjects.Page_Header).getText());	
			Assert.assertEquals((genric.element(PagesLoadingObjects.Page_Header).getText()), Page_Title, "Expected: Page is Displayed");
			
		}   
		
		@DataProvider(name = "CollectionPages")
		public Object[][] CollectionPagesLoading() {
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			String Sheet = "CollectionPages";
			int rowcount = datatable.getRowCount(Sheet);
			Object[][] result = new Object[rowcount - 1][4];		
			for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
				result[rowNum - 2][0] = datatable.getCellData(Sheet, "Root", rowNum);
				result[rowNum - 2][1] = datatable.getCellData(Sheet, "Parent", rowNum);
				result[rowNum - 2][2] = datatable.getCellData(Sheet, "Child", rowNum);
				result[rowNum - 2][3] = datatable.getCellData(Sheet, "Page_Title", rowNum);
			}
			return result;
		}

		// To verify that all pages under Collection tab are loading properly and navigating to correct page
		@Test(dataProvider = "CollectionPages")
		public void TC_05_CollectionPagesLoading(String Root, String Parent, String Child, String Page_Title) throws InterruptedException, AWTException {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Root+"_"+Parent+"_"+Child);
			loginMethods.UserLogin();
			inputs.HamburgerIconClick();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//span[text()='"+ Root + "']")).click();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Parent + "']")).click();	
			genric.waitForLoading();									
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
						                              By.xpath(".//a[text()='"+ Child + "']")));
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Child + "']")).sendKeys(Keys.ENTER);						
			genric.waitForLoading();
			System.out.println(genric.element(PagesLoadingObjects.Page_Header).getText());	
			Assert.assertEquals((genric.element(PagesLoadingObjects.Page_Header).getText()), Page_Title, "Expected: Page is Displayed");
			
		}   
            
		@DataProvider(name = "ReleasePages")
		public Object[][] ReleasePagesLoading() {
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			String Sheet = "ReleasePages";
			int rowcount = datatable.getRowCount(Sheet);
			Object[][] result = new Object[rowcount - 1][4];		
			for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
				result[rowNum - 2][0] = datatable.getCellData(Sheet, "Root", rowNum);
				result[rowNum - 2][1] = datatable.getCellData(Sheet, "Parent", rowNum);
				result[rowNum - 2][2] = datatable.getCellData(Sheet, "Child", rowNum);
				result[rowNum - 2][3] = datatable.getCellData(Sheet, "Page_Title", rowNum);
			}
			return result;
		}

		// To verify that all pages under Release tab are loading properly and navigating to correct page
		@Test(dataProvider = "ReleasePages")
		public void TC_06_ReleasePagesLoading(String Root, String Parent, String Child, String Page_Title) throws InterruptedException, AWTException {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Root+"_"+Parent+"_"+Child);
			loginMethods.UserLogin();
			inputs.HamburgerIconClick();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//span[text()='"+ Root + "']")).click();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Parent + "']")).click();	
			genric.waitForLoading();									
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
						                              By.xpath(".//a[text()='"+ Child + "']")));
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Child + "']")).sendKeys(Keys.ENTER);						
			genric.waitForLoading();
			System.out.println(genric.element(PagesLoadingObjects.Page_Header).getText());		
			Assert.assertEquals((genric.element(PagesLoadingObjects.Page_Header).getText()), Page_Title, "Expected: Page is Displayed");
			
		}   
		
		
		@DataProvider(name = "Recon_AuditPages")
		public Object[][] Recon_AuditPages() {
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			String Sheet = "Recon_AuditPages";
			int rowcount = datatable.getRowCount(Sheet);
			Object[][] result = new Object[rowcount - 1][4];		
			for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
				result[rowNum - 2][0] = datatable.getCellData(Sheet, "Root", rowNum);
				result[rowNum - 2][1] = datatable.getCellData(Sheet, "Parent", rowNum);
				result[rowNum - 2][2] = datatable.getCellData(Sheet, "Child", rowNum);
				result[rowNum - 2][3] = datatable.getCellData(Sheet, "Page_Title", rowNum);
			}
			return result;
		}

		// To verify that all pages under Recon and Audit tab are loading properly and navigating to correct page
		@Test(dataProvider = "Recon_AuditPages")
		public void TC_07_ReconAndAuditPagesLoading(String Root, String Parent, String Child, String Page_Title) throws InterruptedException, AWTException {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Root+"_"+Parent+"_"+Child);
			loginMethods.UserLogin();
			inputs.HamburgerIconClick();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//span[text()='"+ Root + "']")).click();
			genric.waitForLoading();		
			driver.findElement(By.xpath(".//a[contains (text(),'"+ Parent + "')]")).click();		
			genric.waitForLoading();									
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
						                              By.xpath(".//a[text()='"+ Child + "']")));
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Child + "']")).sendKeys(Keys.ENTER);						
			genric.waitForLoading();
			System.out.println(genric.element(PagesLoadingObjects.Page_Header).getText());	
			Assert.assertEquals((genric.element(PagesLoadingObjects.Page_Header).getText()), Page_Title, "Expected: Page is Displayed");
			
		}   
		
		
		@DataProvider(name = "SupportPages")
		public Object[][] SupportPagesLoading() {
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			String Sheet = "SupportPages";
			int rowcount = datatable.getRowCount(Sheet);
			Object[][] result = new Object[rowcount - 1][4];		
			for (int rowNum = 2; rowNum < rowcount + 1; rowNum++) {
				result[rowNum - 2][0] = datatable.getCellData(Sheet, "Root", rowNum);
				result[rowNum - 2][1] = datatable.getCellData(Sheet, "Parent", rowNum);
				result[rowNum - 2][2] = datatable.getCellData(Sheet, "Child", rowNum);
				result[rowNum - 2][3] = datatable.getCellData(Sheet, "Page_Title", rowNum);
			}
			return result;
		}

		// To verify that all pages under Support tab are loading properly and navigating to correct page
		@Test(dataProvider = "SupportPages")
		public void TC_08_SupportPagesLoading(String Root, String Parent, String Child, String Page_Title) throws InterruptedException, AWTException {
			test = extent.startTest(this.getClass().getName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+Root+"_"+Parent+"_"+Child);
			
			loginMethods.UserLogin();
			inputs.HamburgerIconClick();
			genric.waitForLoading();
			driver.findElement(By.xpath(".//span[text()='"+ Root + "']")).click();
			genric.waitForLoading();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
                    By.xpath(".//a[text()='"+ Parent + "']")));
			driver.findElement(By.xpath(".//a[text()='"+ Parent + "']")).sendKeys(Keys.ENTER);
			genric.waitForLoading();									
		   
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
				    By.xpath(".//a[text()='"+ Child + "']")));
			genric.waitForLoading();
			driver.findElement(By.xpath(".//a[text()='"+ Child + "']")).sendKeys(Keys.ENTER);						
			genric.waitForLoading();
			System.out.println(genric.element(PagesLoadingObjects.Page_Header).getText());	
			Assert.assertEquals((genric.element(PagesLoadingObjects.Page_Header).getText()), Page_Title, "Expected: Page is Displayed");
			
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
