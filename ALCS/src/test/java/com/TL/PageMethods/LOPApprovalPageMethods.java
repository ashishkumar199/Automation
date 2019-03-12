package com.TL.PageMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.LOPApprovalPageObjects;
import com.TL.PageObjects.LOPPageObjects;
import com.TL.Utils.PropertyReader;

public class LOPApprovalPageMethods extends BaseClass {
	
	public WebDriver driver;
	Genric genric;

	
	public LOPApprovalPageMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;		
	}
	
	
	//To go to Loss of Pay / Revised Loss of Pay Approval Page
		public void Go_to_Loss_Of_Pay_Approval_Page()
		{
		
			genric.waitForLoading();
			genric.element(LOPPageObjects.Inputs_Dropdown).click();
			genric.waitForLoading();
			genric.element(LOPPageObjects.MonthlyInputs).click();
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.RevisedLossOfPayApproval).click();
		}
		
		//Select client to cancel LOP
		public void SelectClientCancelLOP()
		{
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.ClientName_ID_revisedPage).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys("00FBG");
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.LOPType_revisedPage).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys("LOP");
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.LOPStatus).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys("Approved");
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.AssociateID).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys(PropertyReader.readDataProperty("LOPEmployeeID"));
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPPageObjects.SearchBtn).click();
			genric.waitForLoading();
		}
		
		//Select client to check cancelled LOPs
		public void SelectClientCancelledStatus()
		{
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.ClientName_ID_revisedPage).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys("00FBG");
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.LOPType_revisedPage).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys("LOP");
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.LOPStatus).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys("Cancelled");
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPApprovalPageObjects.AssociateID).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys(PropertyReader.readDataProperty("LOPEmployeeID"));
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPPageObjects.SearchBtn).click();
			genric.waitForLoading();
			Assert.assertEquals(genric.element(LOPApprovalPageObjects.EmployeeIDCancelledLOPStatus).getText(), PropertyReader.readDataProperty("LOPEmployeeID"));
			}

}
