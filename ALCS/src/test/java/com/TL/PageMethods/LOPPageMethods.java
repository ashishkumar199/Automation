package com.TL.PageMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.LOPApprovalPageObjects;
import com.TL.PageObjects.LOPPageObjects;
import com.TL.Utils.PropertyReader;

public class LOPPageMethods extends BaseClass {
	
		public WebDriver driver;
		Genric genric;

		
		public LOPPageMethods(WebDriver driver, Genric genric){
			this.driver=driver;
			this.genric=genric;		
		}
		
		
		//To go to Loss of Pay Page
		public void Go_to_Loss_Of_Pay_Page()
		{
		
			genric.waitForLoading();
			genric.element(LOPPageObjects.Inputs_Dropdown).click();
			genric.waitForLoading();
			genric.element(LOPPageObjects.MonthlyInputs).click();
			genric.waitForLoading();
			genric.element(LOPPageObjects.LossOfPay).click();
		}
		
		// Select client to apply LOP
		public void SelectClientLOP()
		{
			genric.waitForLoading();
			genric.element(LOPPageObjects.ClientName_ID).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys("00FBG");
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);
			genric.waitForLoading();
			genric.element(LOPPageObjects.Type).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys("LOP");
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPPageObjects.Month).click();
			genric.element(LOPPageObjects.SearchBox).sendKeys(PropertyReader.readDataProperty("LOPMonth"));
			genric.element(LOPPageObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPPageObjects.SearchBtn).click();
			genric.waitForLoading();
			
		}

		
		//Select employee and apply LOP
		public void SelectEmployeeAndApplyLOP()
		{
			genric.waitForLoading();		
			genric.element(LOPPageObjects.EmployeeSearchBox).sendKeys(PropertyReader.readDataProperty("LOPEmployeeID"));
			genric.element(LOPPageObjects.EmployeeSearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPPageObjects.NO_OF_LOP_DAYS_textbox).sendKeys(PropertyReader.readDataProperty("NO_OF_LOP_DAYS"));	
			genric.element(LOPPageObjects.INTERACTION_ID_textbox).sendKeys(PropertyReader.readDataProperty("INTERACTION_ID"));
			genric.element(LOPPageObjects.Submit_Btn).click();
			genric.waitForLoading();
	        Assert.assertTrue(genric.element(LOPApprovalPageObjects.SuccessMsg).isDisplayed());	    
	        genric.element(LOPApprovalPageObjects.OKBtn).click();
		    
		}
		
		//Select employee to cancel LOP
			public void SelectEmployeeAndCancelLOP()
			{
				genric.waitForLoading();		
				genric.element(LOPApprovalPageObjects.LOPCancelCheckBox).click();
				genric.element(LOPApprovalPageObjects.CancelBtn).click();
				genric.waitForLoading();
			    Assert.assertTrue(genric.element(LOPApprovalPageObjects.SuccessMsg).isDisplayed());	    
			    genric.element(LOPApprovalPageObjects.OKBtn).click();
			}
}
