package com.TL.PageMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.AssociateConfirmDOJPageObjects;
import com.TL.PageObjects.LopsPageObjects;
import com.TL.PageObjects.StandardOfferLetterPageObjects;
import com.TL.Utils.XlsReader;

public class AssociateConfirmDOJPageMethods extends BaseClass{

	public WebDriver driver;
	Genric genric;
	DashboardPageMethods Dashboard;
	
	public AssociateConfirmDOJPageMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;

	}

	// Go to confirm DOJ page
	 public void go_To_Confirm_DOJ_Page() {
			genric.waitForLoading();
			genric.element(LopsPageObjects.Inputs_btn).click();
			genric.waitForLoading();
			genric.element(StandardOfferLetterPageObjects.AssociateMaster_Btn).click();
			genric.waitForLoading();
			//genric.element(AssociateConfirmDOJPageObjects.Associate_Confirm_DOJ_Page).click();
			genric.waitForLoading();			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
                    By.xpath(".//a[text()='Associate Confirm DOJ']")));					
			genric.element(AssociateConfirmDOJPageObjects.Associate_Confirm_DOJ_Page).click();			
		}
	 
	 // Select Newly Created Associate ID and click on Search button
	 public void Search_Newly_Created_Associate() {
			genric.waitForLoading();
			genric.element(AssociateConfirmDOJPageObjects.RequirementID).click();
			genric.waitForLoading();			
			genric.element(AssociateConfirmDOJPageObjects.RequirementID_All).click();	
			genric.hardWait(2);
			genric.waitForLoading();		
			XlsReader datatable = new XlsReader(Testdatasheetpath);
			//System.out.println(datatable.getCellData("OfferLetterEmpCreated", 0, 1));
			genric.element(AssociateConfirmDOJPageObjects.Search_Employee_ID).sendKeys(datatable.getCellData("OfferLetterEmpCreated", 0, 2));
			genric.waitForLoading();			
			genric.element(LopsPageObjects.Search_btn).click();
			genric.waitForLoading();
	       }
	 
	 //Select Employee and Transfer Candidate to Associate
	 public void Select_Candidate_And_Transfer_To_Associate() {
		 
		 genric.element(AssociateConfirmDOJPageObjects.Select_Employee_CheckBox).click();
		 genric.element(AssociateConfirmDOJPageObjects.TransferCandidateToAssociate).click();	 
		 
	 }
	 

}
