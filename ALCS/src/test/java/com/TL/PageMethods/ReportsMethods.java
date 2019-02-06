package com.TL.PageMethods;

import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.ReportsObjects;
import com.TL.Utils.CsvReader;
import com.TL.Utils.PropertyReader;

import org.openqa.selenium.Keys;


public class ReportsMethods extends BaseClass{
	public WebDriver driver;
	Genric genric;
	public ReportsMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;
	}
		
	// Navigate to reports page
	public void proceedToReports()
	{
		genric.element(ReportsObjects.Hamburger_Menu).click();
		genric.waitForLoading();	
		genric.element(ReportsObjects.Recon).click();
		genric.waitForLoading();	
		genric.element(ReportsObjects.Reconcilation_button).click();
		genric.waitForLoading();	
		genric.element(ReportsObjects.View_And_Download_Report_button).click();
	}
	
	// Select report, download and verify report name in downloaded csv file
	public void SelectReport(String Report_Names, String Client_Name_ID) throws IOException {

		genric.waitForLoading();
		genric.element(ReportsObjects.Select_Report).click();
		genric.waitForLoading();
		genric.element(ReportsObjects.dropdown_Search).sendKeys(Report_Names);
		genric.element(ReportsObjects.reportPlaceHolder).click();
		genric.waitForLoading();	
		
		
		try {
	    if(genric.element(ReportsObjects.Invoice_Business_Type).isDisplayed())			
		 {		
		   genric.element(ReportsObjects.Invoice_Business_Type_dropdown).click();
		   genric.element(ReportsObjects.dropdown_Search)
		            .sendKeys(PropertyReader.readDataProperty("InvoiceBusinessType"));
		   genric.element(ReportsObjects.dropdown_Search).sendKeys(Keys.ENTER);		   
	       genric.waitForLoading();	      
	     }
		
		if(genric.element(ReportsObjects.Client_Name).isDisplayed())
		 {
		   genric.element(ReportsObjects.clientNames).click();
		   genric.driver.findElement(
					By.xpath(".//*[@class='form-field multiSelect']/descendant::*[text()='"
							+ Client_Name_ID + "']")).click();		   
	     }
		
		if(genric.element(ReportsObjects.Month).isDisplayed())
		 {
		   genric.element(ReportsObjects.Month).click();
		   genric.element(ReportsObjects.dropdown_Search).sendKeys(PropertyReader.readDataProperty("Month"));
		   genric.element(ReportsObjects.dropdown_Search).sendKeys(Keys.ENTER);		
	       genric.waitForLoading();	       
		 }
		
		if(genric.element(ReportsObjects.Year).isDisplayed())		
		 {
		   genric.element(ReportsObjects.Year).click();
		   genric.element(ReportsObjects.dropdown_Search).sendKeys(PropertyReader.readDataProperty("Year"));
		   genric.element(ReportsObjects.dropdown_Search).sendKeys(Keys.ENTER);		
	       genric.waitForLoading();	       
		 }
		
		if(genric.element(ReportsObjects.TypeOfEvent).isDisplayed())		
		 {
		   genric.element(ReportsObjects.TypeOfEvent_dropdown).click();
		   genric.element(ReportsObjects.TypeOfEvent_dropdown).sendKeys(PropertyReader.readDataProperty("TypeOfEvent"));
	       genric.waitForLoading();	       
		 }
		
		if(genric.element(ReportsObjects.Mandate_Type_dropdown).isDisplayed())		
		 {
		   genric.element(ReportsObjects.Mandate_Type_dropdown).click();
		   genric.element(ReportsObjects.dropdown_Search).sendKeys(PropertyReader.readDataProperty("MandateType"));
	       genric.waitForLoading();	       
		 }
		
		if(genric.element(ReportsObjects.Candidate_Type).isDisplayed())
		 {		
		 //  genric.waitUntilClickable(genric.element(ReportsKeyword.Select_dropdown_Candidate_Type));
		   genric.element(ReportsObjects.Select_dropdown_Candidate_Type).click();
		   genric.element(ReportsObjects.Select_Candidate_Type).click();
	       genric.waitForLoading();	   	   
		 }
		
		if(genric.element(ReportsObjects.fromDate).isDisplayed())
		 {
		   genric.element(ReportsObjects.fromDateInput).sendKeys(PropertyReader.readDataProperty("ReportsStartDate"));		  
		   genric.waitForLoading();
		 }
		
		if(genric.element(ReportsObjects.ToDateInput).isDisplayed())
		 {
		   genric.element(ReportsObjects.ToDateInput).sendKeys(PropertyReader.readDataProperty("ReportsEndDate"));		 
		   genric.waitForLoading();
		 }
		
		} catch (Exception e) {
			System.out.println("No Alert window appeared...");
		}
				
		genric.waitForLoading();
		genric.element(ReportsObjects.Download_btn).click();
		genric.waitForLoading();
		
	
	} 
	
	//Read csv file name in header
	public String csvreturn () throws IOException
	{
		CsvReader cv1 = new CsvReader(DownloadPath+lastFileModified(DownloadPath).getName());
		String report_header =  cv1.read_csv(0,1);
		System.out.println(cv1.read_csv(0,1));
		return report_header;	
	}
	
	// returns newly downloaded file 
	
	public static File lastFileModified(String dir) throws FileNotFoundException {
	    File fl = new File(dir);
	    File[] files = fl.listFiles(new FileFilter() {          
	        public boolean accept(File file) {
	            return file.isFile();
	        }
	    });
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	        if (file.lastModified() > lastMod) {
	            choice = file;
	            lastMod = file.lastModified();
	        }
	    }
	
	    
	    //File f = choice;
	    //String ff = f.getPath();
	   // System.out.println(choice);
	    return choice;
	 
	}
	
	// read file data
	public static String Scanner() throws FileNotFoundException {
		  String name = null;
		  int index = 0;
			Scanner dataScanner = null;
			Scanner scanner = new Scanner(ReportsMethods.lastFileModified(PropertyReader.readDataProperty("DownloadPath")));
			//Scanner scanner = new Scanner(new File(PropertyReader.readDataProperty("DownloadPath")));	
		while (scanner.hasNextLine()) {
			dataScanner = new Scanner(scanner.nextLine());
			dataScanner.useDelimiter(",");

			while (dataScanner.hasNext()) {
				String data = dataScanner.next();
			//	System.out.println(data);
				
				if (index == 0)
					System.out.println(data);
				else
					System.out.println("invalid data::" + data);
				//index++;  
			}				

		scanner.close();	
		}
		return name;
	}
	
	
	
}
