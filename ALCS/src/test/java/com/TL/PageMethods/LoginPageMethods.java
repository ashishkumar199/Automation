package com.TL.PageMethods;

import org.openqa.selenium.WebDriver;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.LoginPageObjects;
import com.TL.Utils.PropertyReader;

public class LoginPageMethods extends BaseClass{

		public WebDriver driver;
		Genric genric;
		public LoginPageMethods(WebDriver driver, Genric genric){
			this.driver=driver;
			this.genric=genric;
		}
	
		
    	//ALCS user login
		public void UserLogin(){			
			genric.waitForLoading();
			genric.element(LoginPageObjects.User_Name).sendKeys(PropertyReader.readDataProperty("Valid_username"));
			genric.element(LoginPageObjects.Password).sendKeys(PropertyReader.readDataProperty("ValidPassword"));
			genric.element(LoginPageObjects.SignIn_btn).click();
			genric.waitForLoading();			
		}

}
