package com.TL.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.TL.Base.Genric;

public class InputsObjects {

	public WebDriver driver;
	Genric genric;
	
	public InputsObjects(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;
		
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	public static final String Inputs_Btn="xpath:.//span[contains (text(), 'Inputs')]";
	public static final String AssociateMaster_Btn="xpath:.//a[@id='menu7']";
	public static final String StandardOfferLetter_Btn="xpath:.//a[contains (text(), 'Standard Offer Letter')]";
	public static final String MultipleRadio_Btn="xpath:.//label[@for='AlcsContentPlaceHolder_rblOfferLetterType_1']";
	public static final String Upload_Btn="xpath:.//label[@for='AlcsContentPlaceHolder_fuBankStatementMassUpload']";
	
	public static final String links = "xpath:.//a";
	public static final String drag = "xpath:.//*[@id='menuStructure']//li[@class = 'open' or @class = 'active']//div[@class = 'jspDrag']/div[2]";
	public static final String Main_header = "xpath:.//a[@class = 'navbar-brand']";
	public static final String user_name = "xpath:.//input[@id='txtLoginId']";
	public static final String Password = "xpath:.//input[@id='txtPassword']";
	public static final String hamburger_icon = "xpath:.//ul[@class='nav navbar-nav toggle-ctrl']/li[1]";
	public static final String Login_btn = "xpath:.//input[@id='btnsignin']";
	public static final String iner_release_bttn = "xpath:.//*[@id='menuStructure']/li//span[contains(text(), 'Input')]/../../ul/li";
	public static final String release_button = "xpath:.//*[@id='menuStructure']/li//span[contains(text(), 'Input')]";
	public static final String iner_rel_btn_dropdown = "xpath:.//*[@id='menuStructure']//li[@class = 'open' or @class = 'active']//ul/li";
	public static final String iner_rel_btn_dropdown1="xpath:.//ol[@class = 'breadcrumb']/li[@class = 'active']";
	public static final String Submit_btn="xpath:.//input[@value='Submit']";
	public static final String Validation_Msg_Mobile="xpath:.//div[@class='validation-error-message invalid-mobile-msg hidden-msg']";
	public static final String Validation_Msg_Password="xpath:.//div[@class='validation-error-message invalid-password-msg hidden-msg']";
	public static final String textual = "xpath:.//*[@id='menuStructure']//a";
	
	
	public static final String input_button = "xpath:.//*[@id='menuStructure']/li//span[contains(text(), 'Input')]";
	public static final String Browse_file_btn="xpath:.//label[@for='AlcsContentPlaceHolder_fuBankStatementMassUpload']";
	public static final String All_page_text ="xpath:.//ol[@class = 'breadcrumb']/li[@class = 'active']";
	public static final String upload_btn = "xpath:.//*[@id='AlcsContentPlaceHolder_btnUpload']";
	public static final String clientNameID_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlClientNameId-container']";
	
	public static final String client_select = "xpath:.//li[contains(text(), 'TeamLease Services Ltd...')]";
	public static final String requirement_title_dropdown = "xpath:.//*[@id = 'select2-AlcsContentPlaceHolder_ddlRequirementTitleId-container']";
	public static final String requirement_title_select = "xpath:.//li[contains(text(), 'TestReqIdCreation\\00FBG-14890')]";
	public static final String validation_mssg = "xpath:.//span[contains(text(), 'OFFER LETTER CREATED SUCCESSFULLY and Count of Successfull Inserted Offer Letter Is 1')]";
	
	public static final String pre_Associate_history = "xpath:.//a[contains (text(), 'Pre Associate History')]";
	public static final String Associate_name_dropdown = "xpath:.//span[@id= 'select2-AlcsContentPlaceHolder_ddlAssoicateNameId-container']";
	public static final String Associate_name_text_field = "xpath:.//input[@type = 'search']";
	//public static String generatedString = "";
	public static final String Associate_name_select = "xpath:.//li[@class= 'select2-results__option select2-results__option--highlighted']";
	public static final String associate_pre_history_search_bttn = "xpath:.//a[@id= 'AlcsContentPlaceHolder_btnSearch']";
	public static final String no_result_found = "xpath:.//*[@class = 'select2-results__options']/li";
	
	public static final String Emp_ID_text_box = "xpath:.//*[@id='AlcsContentPlaceHolder_txtEmployeeId']";
	public static final String Basic_details_EMP_ID = "xpath:.//*[@id=\"AlcsContentPlaceHolder_dtgBasicDetails\"]/tbody/tr[2]/td[2]";
	public static final String Basic_details_First_Name = "xpath:.//*[@id=\"AlcsContentPlaceHolder_dtgBasicDetails\"]/tbody/tr[6]/td[2]";
	
	public static final String Offer_Letter_Approval = "xpath:.//a[contains (text(), 'Offer Letter Approval')]";
	public static final String client_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlClient-container']";
	public static final String offer_letter_status_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlStatus-container']";
	public static final String offer_letter_status_select = "xpath:.//li[contains(text(), 'Approved')]";
	
	public static final String approved_emp_id = "xpath:.//*[@class='table md-table-main']/tbody//a";
	public static final String pagination_count_offer_letter_page = "xpath:.//*[@class='table md-table-main']//tr[@class = 'tablePagination odd']//tr/td";
	//public static String Employee_ID = "";
	//public static String Employee_First_Name = "";
	public static final String Details_window = "xpath:.//form[@id = 'form1']//table[@id = 'grdHistory']//tr[4]/td[2]";	

}
