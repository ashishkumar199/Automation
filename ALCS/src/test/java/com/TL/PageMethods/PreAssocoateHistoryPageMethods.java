package com.TL.PageMethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.DashboardPageObjects;
import com.TL.PageObjects.PreAssociateHistoryPageObjects;
import com.TL.PageObjects.StandardOfferLetterPageObjects;
import com.TL.Utils.CsvReader;
import com.TL.Utils.XlsReader;

public class PreAssocoateHistoryPageMethods extends BaseClass {

	public WebDriver driver;
	Genric genric;
	
	public PreAssocoateHistoryPageMethods (WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;

	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static String generatedString = "";
	public static String Employee_ID = "";
	public static String Employee_First_Name = "";
	
	
	// Go to preassociate History Page
	public void go_to_pre_associate_history_page() {
	    genric.waitForLoading();
		genric.element(StandardOfferLetterPageObjects.Inputs_Btn).click();
		genric.waitForLoading();
		genric.element(StandardOfferLetterPageObjects.AssociateMaster_Btn).click();
		genric.waitForLoading();
		genric.element(PreAssociateHistoryPageObjects.pre_Associate_history).click();
		genric.waitForLoading();
		
	}
	
	// Select dropdown client Name/Id
	public void dropdown_select_clientNameID() {
		genric.hardWait(3);
		genric.waitUntilClickable(genric.element(PreAssociateHistoryPageObjects.clientNameID_dropdown));
        genric.element(PreAssociateHistoryPageObjects.clientNameID_dropdown).click(); 
		genric.hardWait(3);
		genric.element(PreAssociateHistoryPageObjects.client_select).click();
		genric.waitForLoading();
	}
	
	public String get_emp_id() {
		return genric.element(PreAssociateHistoryPageObjects.Emp_ID_text_box).getAttribute("value");
	}
	
	public String get_Basic_Details_Emp_id() {
		return genric.element(PreAssociateHistoryPageObjects.Basic_details_EMP_ID).getText();
	}
	
	public String Basic_details_First_Name() {
		return genric.element(PreAssociateHistoryPageObjects.Basic_details_First_Name).getText();
	}
	
	//Fill associate history page
	public void fil_pre_associate_history_details(CsvReader cv) {
		dropdown_select_clientNameID();
		genric.element(PreAssociateHistoryPageObjects.Associate_name_dropdown).click();
		genric.hardWait(2);
		try {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
							                              By.xpath(".//input[@class='select2-search__field']")));		
			genric.element(PreAssociateHistoryPageObjects.Associate_name_text_field).sendKeys(cv.read_csv(1, 3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		genric.hardWait(2);
		while(genric.element(PreAssociateHistoryPageObjects.no_result_found).getText().contentEquals("No results found")) {
			genric.waitForLoading();
			genric.element(DashboardPageObjects.Main_header).sendKeys(Keys.ENTER);
			genric.waitForLoading();
			driver.navigate().refresh();
			genric.waitForLoading();
			genric.element(DashboardPageObjects.hamburger_icon).click();
			go_to_pre_associate_history_page();
			genric.waitForLoading();
			dropdown_select_clientNameID();
			genric.waitForLoading();
			genric.element(PreAssociateHistoryPageObjects.Associate_name_dropdown).click();
			genric.hardWait(2);
			try {
				genric.element(PreAssociateHistoryPageObjects.Associate_name_text_field).sendKeys(cv.read_csv(1, 3));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		genric.element(PreAssociateHistoryPageObjects.Associate_name_select).click();		
		genric.element(PreAssociateHistoryPageObjects.associate_pre_history_search_bttn).click();
		
		genric.waitForLoading();
		Employee_ID = get_emp_id();
		Employee_First_Name = Basic_details_First_Name();
		XlsReader datatable = new XlsReader(Testdatasheetpath);
		String Sheet = "OfferLetterEmpCreated";
		datatable.setCellData1(Sheet, "EmpID", 2, Employee_ID);
		datatable.setCellData1(Sheet, "EmpID", 3, Employee_First_Name);
		System.out.println(datatable.getCellData("OfferLetterEmpCreated", 0, 2));
		System.out.println(Employee_ID);

	}

}
