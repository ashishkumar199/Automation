package com.TL.PageObjects;

public class OfferLetterApprovalPageObjects {
	
	public static final String Offer_Letter_Approval = "xpath:.//a[text()='Offer Letter Approval']";
	public static final String client_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlClient-container']";
	public static final String offer_letter_status_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlStatus-container']";
	public static final String offer_letter_status_select = "xpath:.//li[contains(text(), 'Approved')]";
	public static final String client_select = "xpath:.//li[contains(text(), 'TeamLease Services Ltd...')]";
	
	public static final String approved_emp_id = "xpath:.//*[@class='table md-table-main']/tbody//a";
	public static final String pagination_count_offer_letter_page = "xpath:.//*[@class='table md-table-main']//tr[@class = 'tablePagination odd']//tr/td";

	public static final String Details_window = "xpath:.//form[@id = 'form1']//table[@id = 'grdHistory']//tr[4]/td[2]";	

}
