package com.TL.PageObjects;

public class DashboardPageObjects {
	
	
	
	public static final String dashboardlink="xpath:.//span[contains(text(), 'Dashboard')]";
	public static final String dashboardHeader="xpath:.//h1[contains(text(), 'Dashboard')]";
	public static final String dashboardBCT="xpath:.//li[contains(text(), 'Dashboard')]";
	public static final String All_page_text ="xpath:.//ol[@class = 'breadcrumb']/li[@class = 'active']";
	public static final String Page_Header ="xpath:.//h1[@class='page-header']";
	
	public static final String links = "xpath:.//a";
	public static final String drag = "xpath:.//*[@id='menuStructure']//li[@class = 'open' or @class = 'active']//div[@class = 'jspDrag']/div[2]";
	public static final String Main_header = "xpath:.//a[@class = 'navbar-brand']";
	public static final String hamburger_icon = "xpath:.//ul[@class='nav navbar-nav toggle-ctrl']/li[1]";
	public static final String iner_release_bttn = "xpath:.//*[@id='menuStructure']/li//span[contains(text(), 'Input')]/../../ul/li";
	public static final String release_button = "xpath:.//*[@id='menuStructure']/li//span[contains(text(), 'Input')]";
	public static final String iner_rel_btn_dropdown = "xpath:.//*[@id='menuStructure']//li[@class = 'open' or @class = 'active']//ul/li";
	public static final String iner_rel_btn_dropdown1="xpath:.//ol[@class = 'breadcrumb']/li[@class = 'active']";
	public static final String textual = "xpath:.//*[@id='menuStructure']//a";
	
}
