package com.TL.PageObjects;

public class PreAssociateHistoryPageObjects {
	
	public static final String pre_Associate_history = "xpath:.//a[text()='Pre Associate History']";
	public static final String Associate_name_dropdown = "xpath:.//span[@id= 'select2-AlcsContentPlaceHolder_ddlAssoicateNameId-container']";
	public static final String Associate_name_text_field = "xpath:.//input[@class='select2-search__field']";

	public static final String Associate_name_select = "xpath:.//li[@class= 'select2-results__option select2-results__option--highlighted']";
	public static final String associate_pre_history_search_bttn = "xpath:.//a[@id= 'AlcsContentPlaceHolder_btnSearch']";
	public static final String no_result_found = "xpath:.//*[@class = 'select2-results__options']/li";
	
	public static final String Emp_ID_text_box = "xpath:.//*[@id='AlcsContentPlaceHolder_txtEmployeeId']";
	public static final String Basic_details_EMP_ID = "xpath:.//*[@id=\"AlcsContentPlaceHolder_dtgBasicDetails\"]/tbody/tr[2]/td[2]";
	public static final String Basic_details_First_Name = "xpath:.//*[@id=\"AlcsContentPlaceHolder_dtgBasicDetails\"]/tbody/tr[6]/td[2]";
	public static final String clientNameID_dropdown = "xpath:.//span[@id='select2-AlcsContentPlaceHolder_ddlClientNameId-container']";	
	public static final String client_select = "xpath:.//li[contains(text(), 'TeamLease Services Ltd...')]";

}
