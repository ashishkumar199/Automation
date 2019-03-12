package com.TL.PageMethods;

import org.openqa.selenium.WebDriver;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.DashboardPageObjects;

public class DashboardPageMethods extends BaseClass{
	
	public WebDriver driver;
	Genric genric;
	
	public DashboardPageMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;
	}
		
	public  void HamburgerIconClick() {
		genric.waitForLoading();
		genric.element(DashboardPageObjects.Main_header).click();
		genric.waitForLoading();
		genric.element(DashboardPageObjects.hamburger_icon).click();
	}

}
