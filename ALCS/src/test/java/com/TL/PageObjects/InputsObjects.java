package com.TL.PageObjects;

public class InputsObjects {


		


	
	
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
	
	public static final String pre_Associate_history = "xpath:.//a[contains (text(), 'Pre Associate History')]";
	public static final String Associate_name_dropdown = "xpath:.//span[@id= 'select2-AlcsContentPlaceHolder_ddlAssoicateNameId-container']";
	public static final String Associate_name_text_field = "xpath:.//input[@class='select2-search__field']";

	public static final String Associate_name_select = "xpath:.//li[@class= 'select2-results__option select2-results__option--highlighted']";
	public static final String associate_pre_history_search_bttn = "xpath:.//a[@id= 'AlcsContentPlaceHolder_btnSearch']";
	public static final String no_result_found = "xpath:.//*[@class = 'select2-results__options']/li";
	
	public static final String Emp_ID_text_box = "xpath:.//*[@id='AlcsContentPlaceHolder_txtEmployeeId']";
	public static final String Basic_details_EMP_ID = "xpath:.//*[@id=\"AlcsContentPlaceHolder_dtgBasicDetails\"]/tbody/tr[2]/td[2]";
	public static final String Basic_details_First_Name = "xpath:.//*[@id=\"AlcsContentPlaceHolder_dtgBasicDetails\"]/tbody/tr[6]/td[2]";
	
	public static final String Offer_Letter_Approval = "xpath:.//a[text()='Offer Letter Approval']";
	public static final String client_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlClient-container']";
	public static final String offer_letter_status_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlStatus-container']";
	public static final String offer_letter_status_select = "xpath:.//li[contains(text(), 'Approved')]";
	
	public static final String approved_emp_id = "xpath:.//*[@class='table md-table-main']/tbody//a";
	public static final String pagination_count_offer_letter_page = "xpath:.//*[@class='table md-table-main']//tr[@class = 'tablePagination odd']//tr/td";

	public static final String Details_window = "xpath:.//form[@id = 'form1']//table[@id = 'grdHistory']//tr[4]/td[2]";	

}
