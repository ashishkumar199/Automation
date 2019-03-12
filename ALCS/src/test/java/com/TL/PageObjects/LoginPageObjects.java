package com.TL.PageObjects;

public class LoginPageObjects {


	public static final String SignIn_btn="xpath:.//input[@id='btnsignin']";
	public static final String User_Name = "xpath:.//input[@id='txtLoginId']";
	public static final String Password = "xpath:.//input[@id='txtPassword']";
	public static final String Validation_Msg="xpath:.//span[@id='lblMsg']";
	public static final String Teamlease_logo = "xpath:.//a[@class='navbar-brand']";
	public static final String Dashboard_Page = "xpath:.//h1[contains(text(), 'Dashboard')]";
	public static final String TLLogo = "xpath:.//img[@alt='Teamlease logo']";
	public static final String Welcome_Text = "//*[@id='ctl00']/h2";
	public static final String Validation_Msg_Mobile="xpath:.//div[@class='validation-error-message invalid-mobile-msg hidden-msg']";
	public static final String Validation_Msg_Password="xpath:.//div[@class='validation-error-message invalid-password-msg hidden-msg']";
	
}
