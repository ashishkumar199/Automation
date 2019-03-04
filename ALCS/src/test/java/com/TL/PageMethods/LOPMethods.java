package com.TL.PageMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.LOPObjects;
import com.TL.Utils.PropertyReader;

public class LOPMethods extends BaseClass {
	public WebDriver driver;
	Genric genric;

	
	public LOPMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;		
	}
	
	
	//To go to Loss of Pay Page
	public void Go_to_Loss_Of_Pay_Page()
	{
	
		genric.waitForLoading();
		genric.element(LOPObjects.Inputs_Dropdown).click();
		genric.waitForLoading();
		genric.element(LOPObjects.MonthlyInputs).click();
		genric.waitForLoading();
		genric.element(LOPObjects.LossOfPay).click();
	}
	
	
	//To go to Loss of Pay / Revised Loss of Pay Approval Page
	public void Go_to_Revised_Loss_Of_Pay_Page()
	{
	
		genric.waitForLoading();
		genric.element(LOPObjects.Inputs_Dropdown).click();
		genric.waitForLoading();
		genric.element(LOPObjects.MonthlyInputs).click();
		genric.waitForLoading();
		genric.element(LOPObjects.RevisedLossOfPay).click();
	}
	
	// Select client to apply LOP
	public void SelectClientLOP()
	{
		genric.waitForLoading();
		genric.element(LOPObjects.ClientName_ID).click();
		genric.element(LOPObjects.SearchBox).sendKeys("00FBG");
		genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);
		genric.waitForLoading();
		genric.element(LOPObjects.Type).click();
		genric.element(LOPObjects.SearchBox).sendKeys("LOP");
		genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);	
		genric.waitForLoading();
		genric.element(LOPObjects.Month).click();
		genric.element(LOPObjects.SearchBox).sendKeys(PropertyReader.readDataProperty("LOPMonth"));
		genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);	
		genric.waitForLoading();
		genric.element(LOPObjects.SearchBtn).click();
		genric.waitForLoading();
		
	}
	
	//Select client to cancel LOP
	public void SelectClientCancelLOP()
	{
		genric.waitForLoading();
		genric.element(LOPObjects.ClientName_ID_revisedPage).click();
		genric.element(LOPObjects.SearchBox).sendKeys("00FBG");
		genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);
		genric.waitForLoading();
		genric.element(LOPObjects.LOPType_revisedPage).click();
		genric.element(LOPObjects.SearchBox).sendKeys("LOP");
		genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);	
		genric.waitForLoading();
		genric.element(LOPObjects.LOPStatus).click();
		genric.element(LOPObjects.SearchBox).sendKeys("Approved");
		genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);	
		genric.waitForLoading();
		genric.element(LOPObjects.AssociateID).click();
		genric.element(LOPObjects.SearchBox).sendKeys(PropertyReader.readDataProperty("LOPEmployeeID"));
		genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);	
		genric.waitForLoading();
		genric.element(LOPObjects.SearchBtn).click();
		genric.waitForLoading();
	}
	
	//Select client to cancel LOP
		public void SelectClientCancelledStatus()
		{
			genric.waitForLoading();
			genric.element(LOPObjects.ClientName_ID_revisedPage).click();
			genric.element(LOPObjects.SearchBox).sendKeys("00FBG");
			genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);
			genric.waitForLoading();
			genric.element(LOPObjects.LOPType_revisedPage).click();
			genric.element(LOPObjects.SearchBox).sendKeys("LOP");
			genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPObjects.LOPStatus).click();
			genric.element(LOPObjects.SearchBox).sendKeys("Cancelled");
			genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPObjects.AssociateID).click();
			genric.element(LOPObjects.SearchBox).sendKeys(PropertyReader.readDataProperty("LOPEmployeeID"));
			genric.element(LOPObjects.SearchBox).sendKeys(Keys.ENTER);	
			genric.waitForLoading();
			genric.element(LOPObjects.SearchBtn).click();
			genric.waitForLoading();
			Assert.assertEquals(genric.element(LOPObjects.EmployeeIDCancelledLOPStatus).getText(), PropertyReader.readDataProperty("LOPEmployeeID"));
		}
	
	//Select employee and apply LOP
	public void SelectEmployeeAndApplyLOP()
	{
		genric.waitForLoading();		
		genric.element(LOPObjects.EmployeeSearchBox).sendKeys(PropertyReader.readDataProperty("LOPEmployeeID"));
		genric.element(LOPObjects.EmployeeSearchBox).sendKeys(Keys.ENTER);	
		genric.waitForLoading();
		genric.element(LOPObjects.NO_OF_LOP_DAYS_textbox).sendKeys(PropertyReader.readDataProperty("NO_OF_LOP_DAYS"));	
		genric.element(LOPObjects.INTERACTION_ID_textbox).sendKeys(PropertyReader.readDataProperty("INTERACTION_ID"));
		genric.element(LOPObjects.Submit_Btn).click();
		genric.waitForLoading();
        Assert.assertTrue(genric.element(LOPObjects.SuccessMsg).isDisplayed());	    
        genric.element(LOPObjects.OKBtn).click();
	    
	}
	
	//Select employee to cancel LOP
		public void SelectEmployeeAndCancelLOP()
		{
			genric.waitForLoading();		
			genric.element(LOPObjects.LOPCancelCheckBox).click();
			genric.element(LOPObjects.CancelBtn).click();
			genric.waitForLoading();
		    Assert.assertTrue(genric.element(LOPObjects.SuccessMsg).isDisplayed());	    
		    genric.element(LOPObjects.OKBtn).click();
		}
	
}
