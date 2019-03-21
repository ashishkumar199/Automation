package com.TL.Base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import com.TL.PageMethods.AssociateConfirmDOJPageMethods;
import com.TL.PageMethods.AssociateHistoryPageMethods;
import com.TL.PageMethods.DashboardPageMethods;
import com.TL.PageMethods.LOPApprovalPageMethods;
import com.TL.PageMethods.LOPPageMethods;
import com.TL.PageMethods.LoginPageMethods;
import com.TL.PageMethods.LopsPageMethods;
import com.TL.PageMethods.OfferLetterApprovalPageMethods;
import com.TL.PageMethods.PreAssocoateHistoryPageMethods;
import com.TL.PageMethods.ReportsPageMethods;
import com.TL.PageMethods.StandardOfferLetterPageMethods;
import com.TL.Utils.CsvReader;
import com.TL.Utils.PropertyReader;
import com.TL.Utils.XlsReader;
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
	protected DashboardPageMethods Dashboard;
	protected LoginPageMethods loginMethods;
	protected LOPPageMethods LOPPageMethods;
	protected LOPApprovalPageMethods LOPApprovalPageMethods;
	protected PreAssocoateHistoryPageMethods PreAssocoateHistory;
	protected StandardOfferLetterPageMethods StandardOL;
	protected PreAssocoateHistoryPageMethods PreAssociateHistory;
	protected OfferLetterApprovalPageMethods OLApproval;
	protected LopsPageMethods Lops;
	protected AssociateConfirmDOJPageMethods ConfirmDOJ;
	protected AssociateHistoryPageMethods AssociateHistory;
	protected CsvReader cv;
	protected XlsReader xls;
	
	
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
