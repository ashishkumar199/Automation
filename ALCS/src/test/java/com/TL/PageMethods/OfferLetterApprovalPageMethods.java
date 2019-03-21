package com.TL.PageMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.OfferLetterApprovalPageObjects;
import com.TL.PageObjects.PreAssociateHistoryPageObjects;
import com.TL.PageObjects.StandardOfferLetterPageObjects;
import com.TL.Utils.CsvReader;
import com.TL.Utils.XlsReader;

public class OfferLetterApprovalPageMethods extends BaseClass {

	public WebDriver driver;
	Genric genric;
	
	public OfferLetterApprovalPageMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;

	}
	
	//public static String Employee_ID = "";
	//public static String Employee_First_Name = "";
	
	 public void go_to_Offer_Letter_Approval_page() {
		    genric.waitForLoading();
			genric.element(StandardOfferLetterPageObjects.Inputs_Btn).click();
			genric.waitForLoading();
			genric.element(StandardOfferLetterPageObjects.AssociateMaster_Btn).click();
			genric.waitForLoading();
			genric.element(OfferLetterApprovalPageObjects.Offer_Letter_Approval).click();
			genric.waitForLoading();
			
		}
	 
	 public void dropdown_select_client() {
			genric.waitForLoading();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
							                              By.xpath(".//*[@id='select2-AlcsContentPlaceHolder_ddlClient-container']")));		
			genric.element(OfferLetterApprovalPageObjects.client_dropdown).click();
			genric.hardWait(2);
			genric.element(OfferLetterApprovalPageObjects.client_select).click();
			genric.waitForLoading();
		}
		
		public void dropdown_select_offerLetterstatusDropDown() {
			genric.waitForLoading();
			genric.element(OfferLetterApprovalPageObjects.offer_letter_status_dropdown).click();
			genric.hardWait(2);
			genric.element(OfferLetterApprovalPageObjects.offer_letter_status_select).click();
			genric.waitForLoading();
		}
	 
	 public void go_to_offer_letter_approval_approved_page() {
			dropdown_select_client();
			dropdown_select_offerLetterstatusDropDown();
			genric.element(PreAssociateHistoryPageObjects.associate_pre_history_search_bttn).click();
			genric.waitForLoading();
		}
	 /*
	 //search uploaded Employee on Offer Letter Approval Page
	 public String search_approved_offer_letter(CsvReader cv) {
			Actions action=new Actions(driver); 
			String matched = "";
			List<WebElement> page_count = genric.elements(OfferLetterApprovalPageObjects.pagination_count_offer_letter_page);
			int counter = 0;
			for(int j=0; j<page_count.size()-1; j++) {
				 genric.hardWait(3);
			List<WebElement> emp_list = genric.elements(OfferLetterApprovalPageObjects.approved_emp_id);	
			List<WebElement> Emp_name = genric.elements(OfferLetterApprovalPageObjects.approved_emp_id+"[contains(text(), '"+Employee_First_Name+"')]");
			for (int i = 0; i<emp_list.size(); i++) {
					 if(Emp_name.size() == 1) {
					 if(Emp_name.get(0).getText().contentEquals(Employee_First_Name)) {
						// js.executeScript("arguments[0].scrollIntoView();",  Emp_name.get(0));
						 genric.hardWait(3);
						Emp_name.get(0).click();
						 genric.waitForLoading();
						 genric.SwitchtoNewWindow();
						 matched = genric.element(OfferLetterApprovalPageObjects.Details_window).getText();
						genric.CloseNewWindow();
						 counter++;
						 break;
				 }
					 } 	else {
						 for(int k = 0; k<Emp_name.size(); k++) {
							// js.executeScript("arguments[0].scrollIntoView();",  Emp_name.get(i));
							 genric.waitForLoading();
							 Emp_name.get(k).click();
							 genric.waitForLoading();
							 genric.SwitchtoNewWindow();
							 if(genric.element(OfferLetterApprovalPageObjects.Details_window).getText().contentEquals(Employee_ID)) {
								 matched = genric.element(OfferLetterApprovalPageObjects.Details_window).getText();
								counter++;
								 break;
								
						 }else {
							 genric.CloseNewWindow();
							 genric.SwitchtoOriginalWindow();
						 }
						 }
					 }
			 }
				if (counter==1||(j > page_count.size())) {
					break;
				}else {
					System.out.println(j);
					action.moveToElement(genric.element(OfferLetterApprovalPageObjects.pagination_count_offer_letter_page+"["+(j+2)+"]")).click().perform();
					System.out.println(j);
				// genric.element(pagination_count_offer_letter_page+"["+(j+2)+"]").click();
				// driver.navigate().refresh();
				 genric.waitForLoading();
				}
				
				
		}
			return matched;
		
		}
	 */
	 
	 public String search_approved_offer_letter2(CsvReader cv) { 
		    XlsReader datatable = new XlsReader(Testdatasheetpath);
		    String Employee_First_Name = datatable.getCellData("OfferLetterEmpCreated", 0, 3);
		    String Employee_ID = datatable.getCellData("OfferLetterEmpCreated", 0, 2);
			Actions action=new Actions(driver);
			String matched = "";
			List<WebElement> page_count = genric.elements(OfferLetterApprovalPageObjects.pagination_count_offer_letter_page);
			int counter = 0;
			if(page_count.size()>0){
				
			for(int j=0; j<page_count.size()-1; j++) {				
			genric.hardWait(3);
			List<WebElement> emp_list = genric.elements(OfferLetterApprovalPageObjects.approved_emp_id);	
			List<WebElement> Emp_name = genric.elements(OfferLetterApprovalPageObjects.approved_emp_id+"[contains(text(), '"+Employee_First_Name+"')]");
			for (int i = 0; i<emp_list.size(); i++) {
					if(Emp_name.size() == 1) {
					if(Emp_name.get(0).getText().contentEquals(Employee_First_Name)) {						
						genric.hardWait(3);
						Emp_name.get(0).click();
						genric.waitForLoading();
						genric.SwitchtoNewWindow();
						matched = genric.element(OfferLetterApprovalPageObjects.Details_window).getText();
						genric.CloseNewWindow();
						counter++;
						break;
				 }
					 } 	else {
						 for(int k = 0; k<Emp_name.size(); k++) {
							// js.executeScript("arguments[0].scrollIntoView();",  Emp_name.get(i));
							 genric.waitForLoading();
							 Emp_name.get(k).click();
							 genric.waitForLoading();
							 genric.SwitchtoNewWindow();
							 if(genric.element(OfferLetterApprovalPageObjects.Details_window).getText().contentEquals(Employee_ID)) {
								 matched = genric.element(OfferLetterApprovalPageObjects.Details_window).getText();
								counter++;
								 break;
								
						 }else {
							 genric.CloseNewWindow();
							 genric.SwitchtoOriginalWindow();
						 }
						 }
					 }
			 }
				if (counter==1||(j > page_count.size())) {
					break;
				}else {
					System.out.println(j);
					action.moveToElement(genric.element(OfferLetterApprovalPageObjects.pagination_count_offer_letter_page+"["+(j+2)+"]")).click().perform();
					System.out.println(j);
				// genric.element(pagination_count_offer_letter_page+"["+(j+2)+"]").click();
				// driver.navigate().refresh();
				 genric.waitForLoading();
				}
				
				
		}}
			return matched;
		
		}
	 
	 
	 
	public String Find_Associate()
	{ 
		  XlsReader datatable = new XlsReader(Testdatasheetpath);
		  String Employee_First_Name = datatable.getCellData("OfferLetterEmpCreated", 0, 3);
		  String matched = "";
		  		
		  
		  if(driver.findElement(By.xpath(".//*[text()='"+ Employee_First_Name + "']")).isDisplayed())
		  {
			    driver.findElement(By.xpath(".//*[text()='"+ Employee_First_Name + "']")).click();
				genric.waitForLoading();
				genric.SwitchtoNewWindow();
				matched = genric.element(OfferLetterApprovalPageObjects.Details_window).getText();
				genric.CloseNewWindow();
			  
		  }
		  		  
		  return matched;
		
	}
	 

}
