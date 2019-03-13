package com.TL.PageMethods;

import org.openqa.selenium.WebDriver;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;

public class LopsPageMethods extends BaseClass {

	public WebDriver driver;
	Genric genric;
	
	public LopsPageMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;

	}

	 public void go_To_Lops_Page() {
			genric.waitForLoading();
			
		}
	

}
