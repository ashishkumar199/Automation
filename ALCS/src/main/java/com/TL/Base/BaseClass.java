package com.TL.Base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import com.TL.PageMethods.InputsMethods;
import com.TL.PageMethods.LOPMethods;
import com.TL.PageMethods.LoginMethods;
import com.TL.PageMethods.ReportsMethods;
import com.TL.PageObjects.PagesLoadingObjects;
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
	
	protected ReportsMethods reports;
	protected InputsMethods inputs;
	protected PagesLoadingObjects PageLoading;
	protected LoginMethods loginMethods;
	protected LOPMethods LOPMethods;
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
