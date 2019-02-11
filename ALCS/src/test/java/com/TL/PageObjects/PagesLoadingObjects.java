package com.TL.PageObjects;

import org.openqa.selenium.WebDriver;

import com.TL.Base.Genric;

public class PagesLoadingObjects {
	
	public WebDriver driver;
	Genric genric;
	
	public PagesLoadingObjects(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;
		
	}
	
	public static final String dashboardlink="xpath:.//span[contains(text(), 'Dashboard')]";
	public static final String dashboardHeader="xpath:.//h1[contains(text(), 'Dashboard')]";
	public static final String dashboardBCT="xpath:.//li[contains(text(), 'Dashboard')]";
	public static final String All_page_text ="xpath:.//ol[@class = 'breadcrumb']/li[@class = 'active']";
	public static final String Page_Header ="xpath:.//h1[@class='page-header']";
	
	
}
