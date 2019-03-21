package com.TL.PageMethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.LopsPageObjects;
import com.TL.PageObjects.PreAssociateHistoryPageObjects;
import com.TL.Utils.CsvReader;

public class LopsPageMethods extends BaseClass {

	public WebDriver driver;
	Genric genric;
	DashboardPageMethods Dashboard;
	
	public LopsPageMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;

	}

	// Go to Lops Page
	 public void go_To_Lops_Page() {
			genric.waitForLoading();
			genric.element(LopsPageObjects.Inputs_btn).click();
			genric.waitForLoading();
			genric.element(LopsPageObjects.Lops_btn).click();
			genric.waitForLoading();
			genric.element(LopsPageObjects.AssociateDocumentVerificationPage).click();
			genric.waitForLoading();
		}
	
	 // Select Client Name ID on Lops page
	 public void dropdown_Select_ClientNameID() {
			genric.waitForLoading();
	        genric.element(PreAssociateHistoryPageObjects.clientNameID_dropdown).click();
	    	genric.waitForLoading();
			genric.element(PreAssociateHistoryPageObjects.client_select).click();
			genric.waitForLoading();
		}
	 
	 // Select Newly Created Associate Name/ID and click on Search button
	 public void Select_Newly_Created_Associate_And_Search(CsvReader cv) {
			genric.waitForLoading();
			genric.element(PreAssociateHistoryPageObjects.Associate_name_dropdown).click();
			genric.hardWait(2);
			try {
			genric.element(PreAssociateHistoryPageObjects.Associate_name_text_field).sendKeys(cv.read_csv(1, 3));
			    } 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
			genric.element(PreAssociateHistoryPageObjects.Associate_name_select).click();
			genric.waitForLoading();
			genric.element(LopsPageObjects.Search_btn).click();
			genric.waitForLoading();
	       }
	 
	 //To upload associate documents
	 public void UploadDocuments() {
			genric.waitForLoading();
			genric.element(LopsPageObjects.Educational_Certificates).sendKeys("D:\\ALCS\\Automation\\ALCS\\src\\test\\resources\\testdata\\Educational_Certificates.pdf");
			genric.waitForLoading();
			genric.element(LopsPageObjects.Aadhar_Card).sendKeys("D:\\ALCS\\Automation\\ALCS\\src\\test\\resources\\testdata\\Aadhar_Card.pdf");
			genric.waitForLoading();
			genric.element(LopsPageObjects.PAN_Card).sendKeys("D:\\ALCS\\Automation\\ALCS\\src\\test\\resources\\testdata\\PAN_Card.pdf");
			genric.waitForLoading();
			genric.element(LopsPageObjects.Bank_Account_Modification_Proof).sendKeys("D:\\ALCS\\Automation\\ALCS\\src\\test\\resources\\testdata\\Bank_Account_Modification_Proof.pdf");
			genric.waitForLoading();
			genric.element(LopsPageObjects.Upload_btn).click();
			genric.waitForLoading();
			
	    }
	 
	 
}
