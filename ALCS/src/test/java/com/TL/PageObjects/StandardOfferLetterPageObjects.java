package com.TL.PageObjects;

public class StandardOfferLetterPageObjects {
	
	public static final String Inputs_Btn="xpath:.//span[contains (text(), 'Inputs')]";
	public static final String AssociateMaster_Btn="xpath:.//a[text()='Associate Master']";
	public static final String StandardOfferLetter_Btn="xpath:.//a[text() = 'Standard Offer Letter']";
	public static final String MultipleRadio_Btn="xpath:.//label[text()='Multiple']";
	public static final String Upload_Btn="xpath:.//label[@for='AlcsContentPlaceHolder_fuBankStatementMassUpload']";
	
	
    public static final String Browse_file_btn="xpath:.//label[@for='AlcsContentPlaceHolder_fuBankStatementMassUpload']";
    public static final String All_page_text ="xpath:.//ol[@class = 'breadcrumb']/li[@class = 'active']";
    public static final String upload_btn = "xpath:.//*[@id='AlcsContentPlaceHolder_btnUpload']";
    public static final String Reset_btn = "xpath:.//*[@id='AlcsContentPlaceHolder_btnMassReset']";
    public static final String Standard_Offer_Letter_URL= "http://alcs.teamlease.com/GUI/Associate/CreateOfferLetter.aspx";
    
    public static final String clientNameID_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlClientNameId-container']";	
	public static final String client_select = "xpath:.//li[contains(text(), 'TeamLease Services Ltd...')]";
	public static final String requirement_title_dropdown = "xpath:.//*[@id = 'select2-AlcsContentPlaceHolder_ddlRequirementTitleId-container']";
	public static final String requirement_title_select = "xpath:.//li[contains(text(), 'TestReqIdCreation\\00FBG-14890')]";
	public static final String validation_mssg = "xpath:.//span[contains(text(), 'OFFER LETTER CREATED SUCCESSFULLY and Count of Successfull Inserted Offer Letter Is 1')]";
	
	
	

}
