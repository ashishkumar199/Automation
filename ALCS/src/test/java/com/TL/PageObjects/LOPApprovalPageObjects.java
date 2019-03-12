package com.TL.PageObjects;

public class LOPApprovalPageObjects {
	
	public static final String RevisedLossOfPayApproval = "xpath:.//a[text()='Loss of Pay / Revised Loss of Pay Approval']";
	public static final String LOPStatus = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlStatus-container']";
	public static final String AssociateID = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlAssociates-container']";
	public static final String ClientName_ID_revisedPage = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlClient-container']";
	public static final String LOPType_revisedPage = "xpath:.//*[@id='select2-AlcsContentPlaceHolder_ddlLOPstatus-container']";
	public static final String SuccessMsg = "xpath:.//*[@id='AlcsContentPlaceHolder_lblsuccess']/strong";
	public static final String ExpectedSuccessMsg = "xpath:.//strong[text()='Success!'']";
	public static final String LOPCancelCheckBox = "xpath:.//*[@id='AlcsContentPlaceHolder_GridSearch_tlGridView_chkItem_0']";
	public static final String CancelBtn = "xpath:.//*[@id='AlcsContentPlaceHolder_btnCancel']";
	public static final String PopUpWindow = "xpath:.//div[@class='modal-body']";
	public static final String OKBtn = "xpath:.//*[@class='btn']";
	public static final String EmployeeIDCancelledLOPStatus = "xpath:.//*[@id='AlcsContentPlaceHolder_GridSearch_tlGridView']/tbody/tr[2]/td[3]";

}
