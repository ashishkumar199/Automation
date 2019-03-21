package com.TL.PageMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.AssociateHistoryPageObjects;
import com.TL.PageObjects.LopsPageObjects;
import com.TL.PageObjects.PreAssociateHistoryPageObjects;
import com.TL.PageObjects.StandardOfferLetterPageObjects;
import com.TL.Utils.XlsReader;

public class AssociateHistoryPageMethods extends BaseClass {

	public WebDriver driver;
	Genric genric;
	
	public AssociateHistoryPageMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;

	}
	
	 public void go_to_Associate_History_Page() {
		    genric.waitForLoading();
			genric.element(StandardOfferLetterPageObjects.Inputs_Btn).click();
			genric.waitForLoading();
			genric.element(StandardOfferLetterPageObjects.AssociateMaster_Btn).click();
			genric.waitForLoading();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
							                              By.xpath(".//a[text() = 'Associate History']")));		
			genric.element(AssociateHistoryPageObjects.AssociateHistoryPage).click();
			genric.waitForLoading();
			
		}
	 
	 // Select Client Name ID on Lops page
	 public void dropdown_Select_ClientNameID() {
			genric.waitForLoading();
	        genric.element(AssociateHistoryPageObjects.SearchClient).click();
	    	genric.waitForLoading();
			genric.element(PreAssociateHistoryPageObjects.client_select).click();
			genric.waitForLoading();
		}
	 
	 // search Newly Created Associate ID
	 public void Search_Newly_Created_Associate() {
			genric.waitForLoading();		
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			genric.element(AssociateHistoryPageObjects.SearchEmployee).sendKeys(datatable.getCellData("OfferLetterEmpCreated", 0, 2));
			genric.waitForLoading();			
			genric.element(AssociateHistoryPageObjects.Search_btn).click();
			genric.hardWait(4);
	       }

}
