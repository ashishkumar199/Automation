package com.TL.PageMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.AssociateConfirmDOJPageObjects;
import com.TL.PageObjects.AssociateHistoryPageObjects;
import com.TL.PageObjects.AssociateModifyProfilePageObjects;
import com.TL.PageObjects.StandardOfferLetterPageObjects;
import com.TL.Utils.XlsReader;

public class AssociateModifyProfileMethods extends BaseClass {

	public WebDriver driver;
	Genric genric;
	
	public AssociateModifyProfileMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;

	}
	XlsReader datatable = new XlsReader(Testdatasheetpath);
	
	   // Go to Associate Modify Profile Page
		 public void go_to_Associate_Modify_Profile_Page() {
			    genric.waitForLoading();
				genric.element(StandardOfferLetterPageObjects.Inputs_Btn).click();
				genric.waitForLoading();
				genric.element(StandardOfferLetterPageObjects.AssociateMaster_Btn).click();
				genric.waitForLoading();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", genric.element(AssociateModifyProfilePageObjects.AssociateModifyProfilePage));		
				genric.element(AssociateModifyProfilePageObjects.AssociateModifyProfilePage).click();
				genric.waitForLoading();
				
			}
		 
		// Select Client Name ID on Modify Profile page
		 public void dropdown_Select_ClientNameID() {
				genric.waitForLoading();
		        genric.element(AssociateModifyProfilePageObjects.ClientDropDown).click();
		    	genric.waitForLoading();
				genric.element(AssociateModifyProfilePageObjects.client_select).click();
				genric.waitForLoading();
			}
		 
	   // Search New Employee
		 public void Search_Newly_Created_Associate_Modify_Profile() {
				genric.waitForLoading();
				genric.element(AssociateConfirmDOJPageObjects.RequirementID).click();
				genric.waitForLoading();			
				genric.element(AssociateModifyProfilePageObjects.RequirementID_All).click();	
				genric.hardWait(2);	
				genric.element(AssociateModifyProfilePageObjects.SearchEmp).sendKeys(datatable.getCellData("OfferLetterEmpCreated", 0, 2));
				genric.waitForLoading();			
				genric.element(AssociateHistoryPageObjects.Search_btn).click();
				genric.hardWait(4);
		 }
		 
		// Edit Employee //Change Pay Mode
		public void ChangePayMode() {
				genric.waitForLoading();
				genric.element(AssociateModifyProfilePageObjects.EditBtn).click();
				genric.hardWait(5);			
				genric.element(AssociateModifyProfilePageObjects.PayMode).click();	
				genric.hardWait(2);	
				genric.element(AssociateModifyProfilePageObjects.SelectCash).click();	
				genric.waitForLoading();			
				genric.element(AssociateModifyProfilePageObjects.InteractionId).sendKeys("111-222-333");
				genric.waitForLoading();			
				genric.element(AssociateModifyProfilePageObjects.SaveBtn).click();	
				
					
		  }
		 
}
