package com.TL.Base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import com.TL.PageMethods.InputsMethods;
import com.TL.PageMethods.LOPApprovalPageMethods;
import com.TL.PageMethods.LOPPageMethods;
import com.TL.PageMethods.LoginPageMethods;
import com.TL.PageMethods.ReportsPageMethods;
import com.TL.PageObjects.DashboardPageObjects;
import com.TL.Utils.CsvReader;
import com.TL.Utils.PropertyReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

 
public class BaseClass 
{
	protected static WebDriver driver;
	protected Genric genric;
	protected String filePath = PropertyReader
			.readDataProperty("ExtentPath")+ "Extent.html";
	protected  ExtentReports  extent = ExtentManager.getReporter(filePath);
	protected ExtentTest test;
	protected String csvpath = PropertyReader
			.readDataProperty("CSVPath");
	
	protected String DownloadPath = PropertyReader
			.readDataProperty("DownloadPath");
	
	protected String Testdatasheetpath = PropertyReader
			.readDataProperty("TestDataSheetPath");
	protected String methodname;
	protected ReportsPageMethods reports;
	protected InputsMethods inputs;
	protected DashboardPageObjects PageLoading;
	protected LoginPageMethods loginMethods;
	protected LOPPageMethods LOPPageMethods;
	protected LOPApprovalPageMethods LOPApprovalPageMethods;
	protected CsvReader cv;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	//@BeforeSuite
	protected void beforeSuite(){
		File file = new File(PropertyReader
				.readDataProperty("ExtentPath"));
		try {
			FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@AfterSuite
    protected void afterSuite() {    	
        extent.close();
    }
	
	
	
	
}
