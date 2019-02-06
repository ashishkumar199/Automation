package com.TL.PageObjects;

import com.TL.Base.BaseClass;


public class ReportsObjects extends BaseClass{
	
	
	public static final String Hamburger_Menu = "xpath:.//i[@class='material-icons' and contains(text(),'menu')]";
	public static final String Recon = "xpath:.//span[@class='s-text' and contains(text(),'Recon')]";
	public static final String Reconcilation_button = "xpath:.//a[contains(text(),'Reconcilation')]";
	public static final String View_And_Download_Report_button = "xpath:.//a[contains(text(),'View and Download Report')]";
	public static final String View_And_Download_Report_Page = "xpath:.//h1[contains(text(),'View and Download Report')]";
	public static final String Report_View_OR_Download = "xpath:.//label[contains(text(),'Report View or Download')]";
	public static final String Request_Report_Through_mail = "xpath:.//label[contains(text(),'Request report through mail')]";
	public static final String Select_Report = "xpath:.//span[@id='select2-AlcsContentPlaceHolder_ddlReports-container']";
	public static final String reportPlaceHolder = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlReports-results']";
	public static final String Download_btn = "xpath:.//*[@id='AlcsContentPlaceHolder_ucExportReport_btnExport']";
	public static final String fromDate = "xpath:.//label[@id='AlcsContentPlaceHolder_lblFromDate']";
	public static final String fromDateInput = "xpath:.//input[@id='AlcsContentPlaceHolder_txtFromDate']";
	public static final String ToDateInput = "xpath:.//*[@id='AlcsContentPlaceHolder_txtToDate']";	
	public static final String Client_Name = "xpath:.//*[@id='AlcsContentPlaceHolder_lblClientNameId']";
	public static final String FirstClient = "xpath:.//*[@id='AlcsContentPlaceHolder_lstClientNameIds']/option[1]";
	public static final String TypeOfEvent = "xpath:.//*[@id='AlcsContentPlaceHolder_Label5']";
	public static final String TypeOfEvent_dropdown = "xpath://*[@id='select2-AlcsContentPlaceHolder_DdlTypeEvent-container']";
	public static final String select_TypeOfEvent = "xpath:.//option[contains( text(), 'Transferred')]";
	public static final String clientNames = "xpath:.//*[@id='AlcsContentPlaceHolder_lstClientNameIds']";
	public static final String Candidate_Type = "xpath:.//*[@id='AlcsContentPlaceHolder_Label1']";
	public static final String Select_dropdown_Candidate_Type = "xpath:.//span[@id='select2-AlcsContentPlaceHolder_DdlCandidateType-container']";
	public static final String Select_Candidate_Type = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_DdlCandidateType-result-bm1b-A']";
	public static final String Invoice_Business_Type = "xpath://*[@id='AlcsContentPlaceHolder_lblInvoiceBusType']";
	public static final String Invoice_Business_Type_dropdown = "xpath://*[@id='select2-AlcsContentPlaceHolder_ddlInvBusType-container']";
	public static final String Invoice_Business_Type_dropdown_Search = "xpath:.//input[@class='select2-search__field']";
	public static final String Mandate_Type_dropdown = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlMandateType-container']";
	public static final String Month = "xpath:.//span[@id='select2-AlcsContentPlaceHolder_ddlPayrollMonth-container']";
	public static final String Year = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlPayrollYear-container']";
	public static final String dropdown_Search = "xpath:.//input[@class='select2-search__field']";

	
	
}
