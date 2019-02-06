package com.TL.PageMethods;

import org.openqa.selenium.WebDriver;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.LoginObjects;
import com.TL.Utils.PropertyReader;

public class LoginMethods extends BaseClass{

		public WebDriver driver;
		Genric genric;
		public LoginMethods(WebDriver driver, Genric genric){
			this.driver=driver;
			this.genric=genric;
		}
	
	// ALCS user login
		public void UserLogin(){
			
			genric.waitForLoading();
			genric.element(LoginObjects.User_Name).sendKeys(PropertyReader.readDataProperty("Valid_username"));
			genric.element(LoginObjects.Password).sendKeys(PropertyReader.readDataProperty("ValidPassword"));
			genric.element(LoginObjects.SignIn_btn).click();
			genric.waitForLoading();
			
		}

}
