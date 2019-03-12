package com.TL.PageMethods;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.InputsObjects;
import com.TL.PageObjects.ReportsPageObjects;
import com.TL.Utils.CsvReader;
import com.TL.Utils.PropertyReader;
import com.TL.Utils.XlsReader;

public class InputsMethods extends BaseClass {

	public WebDriver driver;
	Genric genric;
	
	public InputsMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;
		
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static String generatedString = "";
	public static String Employee_ID = "";
	public static String Employee_First_Name = "";
			
	public void Go_To_Standard_Offer_Letter_Page()
	{
		genric.element(ReportsPageObjects.Hamburger_Menu).click();
		genric.element(InputsObjects.Inputs_Btn).click();
		genric.element(InputsObjects.AssociateMaster_Btn).click();
		genric.waitForLoading();
		genric.element(InputsObjects.StandardOfferLetter_Btn).click();
		genric.waitForLoading();
		genric.element(InputsObjects.MultipleRadio_Btn).click();
		genric.waitForLoading();
		Actions actions = new Actions(driver);
		actions.moveToElement(genric.element(InputsObjects.Upload_Btn)).sendKeys("C:\\Users\\AshishK\\Downloads\\OL Template _00FBG.csv");
		//genric.element(InputsObjects.Upload_Btn).sendKeys("C:\\Users\\AshishK\\Downloads\\OL Template _00FBG..csv");
		genric.waitForLoading();
		//genric.element(InputsObjects.View_And_Download_Report_button).click();
	}
	
public void loginAlcs() {
		
		genric.element(InputsObjects.user_name).sendKeys(PropertyReader.readDataProperty("validusername"));
		genric.element(InputsObjects.Password).sendKeys(PropertyReader.readDataProperty("ValidPassword"));
		genric.element(InputsObjects.Login_btn).click();
		genric.waitForLoading();
	}

	public  void HamburgerIconClick() {
		genric.waitForLoading();
		genric.element(InputsObjects.Main_header).click();
		genric.waitForLoading();
		genric.element(InputsObjects.hamburger_icon).click();
	}
	
 	public String get_emp_id() {
		return genric.element(InputsObjects.Emp_ID_text_box).getAttribute("value");
	}
	
	public String get_Basic_Details_Emp_id() {
		return genric.element(InputsObjects.Basic_details_EMP_ID).getText();
	}
	
	public String Basic_details_First_Name() {
		return genric.element(InputsObjects.Basic_details_First_Name).getText();
	}
	
    public void go_to_Offer_Letter_Approval_page() {
		
		genric.element(InputsObjects.input_button).click();
		genric.element(InputsObjects.AssociateMaster_Btn).click();
		genric.element(InputsObjects.Offer_Letter_Approval).click();
		genric.waitForLoading();
		
	}
	
	public void go_to_offer_letter_page() {
		
		genric.element(InputsObjects.input_button).click();
		genric.element(InputsObjects.AssociateMaster_Btn).click();
		genric.element(InputsObjects.StandardOfferLetter_Btn).click();
		genric.waitForLoading();
		
	}
	
	public void go_to_offer_letter_approval_approved_page() {
		dropdown_select_client();
		dropdown_select_offerLetterstatusDropDown();
		genric.element(InputsObjects.associate_pre_history_search_bttn).click();
	}
	
public void go_to_pre_associate_history_page() {

	    genric.waitForLoading();
		genric.element(InputsObjects.input_button).click();
		genric.element(InputsObjects.AssociateMaster_Btn).click();
		genric.element(InputsObjects.pre_Associate_history).click();
		genric.waitForLoading();
		
	}

public void fil_pre_associate_history_details(CsvReader cv) {
	genric.waitForLoading();
	dropdown_select_clientNameID();
	genric.waitForLoading();
	genric.element(InputsObjects.Associate_name_dropdown).click();
	genric.hardWait(2);
	try {
		genric.element(InputsObjects.Associate_name_text_field).sendKeys(cv.read_csv(1, 3));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	genric.hardWait(2);
	while(genric.element(InputsObjects.no_result_found).getText().contentEquals("No results found")) {
		genric.element(InputsObjects.Main_header).click();
		genric.waitForLoading();
		driver.navigate().refresh();
		genric.waitForLoading();
		genric.element(InputsObjects.hamburger_icon).click();
		go_to_pre_associate_history_page();
		genric.waitForLoading();
		dropdown_select_clientNameID();
		genric.waitForLoading();
		genric.element(InputsObjects.Associate_name_dropdown).click();
		genric.hardWait(2);
		try {
			genric.element(InputsObjects.Associate_name_text_field).sendKeys(cv.read_csv(1, 3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		genric.element(InputsObjects.Associate_name_select).click();
	

	genric.element(InputsObjects.associate_pre_history_search_bttn).click();
	genric.waitForLoading();
	Employee_ID = get_emp_id();
	Employee_First_Name = Basic_details_First_Name();
	XlsReader datatable = new XlsReader(Testdatasheetpath);
	String Sheet = "OfferLetterEmpCreated";
	datatable.setCellData(Sheet, "EmpID", 1, Employee_ID);

}
	
	
	public String all_page_get_text() {
		return genric.element(InputsObjects.All_page_text).getText();
	}
	
	public void upload_offer_letter_file(CsvReader cv)  {
		try {
			Random_sheet_info(cv);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		genric.element(InputsObjects.MultipleRadio_Btn).click();
		genric.waitForLoading();
		dropdown_select_clientNameID();
		genric.waitForLoading();
		dropdown_requirement_title();
		genric.waitForLoading();
		genric.element(InputsObjects.Browse_file_btn).click();
		genric.hardWait(2);
		try {
			Runtime.getRuntime().exec("D:\\ALCS\\Automation\\ALCS\\src\\test\\resources\\drivers\\StandardOfferLetterUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		genric.hardWait(1);
		genric.element(InputsObjects.upload_btn).click();
		genric.waitForLoading();
		}
	
	public void upload_Offer_Letter_File_Reset_button(CsvReader cv)  {
		try {
			Random_sheet_info(cv);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		genric.element(InputsObjects.MultipleRadio_Btn).click();
		genric.waitForLoading();
		dropdown_select_clientNameID();
		genric.waitForLoading();
		dropdown_requirement_title();
		genric.waitForLoading();
		genric.element(InputsObjects.Browse_file_btn).click();
		genric.hardWait(2);
		try {
			Runtime.getRuntime().exec("D:\\ALCS\\Automation\\ALCS\\src\\test\\resources\\drivers\\StandardOfferLetterUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		genric.hardWait(1);
		genric.element(InputsObjects.Reset_btn).click();
		genric.waitForLoading();
		}
	
	public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
	
	public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
	
	public void Random_sheet_info(CsvReader cv) throws IOException {
		long i = 9999999999L;
		
		int mobile_start = Integer.parseInt("1000000000");
		int mobile_end = (int) (long) i;
		int mobile_number = createRandomIntBetween(mobile_start, mobile_end);
		String mobile = String.valueOf(mobile_number);
		System.out.println(mobile);
		
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z')
			    .build();
			  generatedString = generator.generate(5);
		System.out.println(generatedString);
		
	    String email = generatedString.concat("@tl.com");
	    System.out.println(email);
	    
	   // String fixed_num = "99999"; 
		int x = 100000;
		int y = 999999;
		    int adhar_start = (int) (long) x;
		    int adhar_end = (int) (long) y;
		    int adhar_num1 = createRandomIntBetween(adhar_start, adhar_end);
		    int adhar_num2 = createRandomIntBetween(adhar_start, adhar_end);
		    String adhaar = String.valueOf(adhar_num1).concat(String.valueOf(adhar_num2));
		    System.out.println(adhaar);
		    
		    cv.update_csv(1, 9, mobile);
			cv.update_csv(1, 48, email);
			cv.update_csv(1, 69, adhaar);
			cv.update_csv(1, 3, generatedString);
		
		 //  xr.setCellData(PropertyReader.readDataProperty("WorkbookName"), "*AssociateMobile", 2, mobile);
	//xr.setCellData(PropertyReader.readDataProperty("WorkbookName"), "*Email_ID", 2, email);
//	xr.setCellData(PropertyReader.readDataProperty("WorkbookName"), "*Aadhaar No", 2, adhaar);
	//xr.setCellData(PropertyReader.readDataProperty("WorkbookName"), "*Associate_Name", 2, generatedString);
	
		}
	
	public void dropdown_select_client() {
		genric.waitForLoading();
		genric.element(InputsObjects.client_dropdown).click();
		genric.hardWait(2);
		genric.element(InputsObjects.client_select).click();
		genric.waitForLoading();
	}
	
	public void dropdown_select_offerLetterstatusDropDown() {
		genric.waitForLoading();
		genric.element(InputsObjects.offer_letter_status_dropdown).click();
		genric.hardWait(2);
		genric.element(InputsObjects.offer_letter_status_select).click();
		genric.waitForLoading();
	}
	
	
	public void dropdown_select_clientNameID() {
		genric.hardWait(3);
        genric.element(InputsObjects.clientNameID_dropdown).click();
		genric.hardWait(3);
		genric.element(InputsObjects.client_select).click();
		genric.waitForLoading();
	}
	
	public void dropdown_requirement_title() {
		genric.waitForLoading();
		genric.element(InputsObjects.requirement_title_dropdown).click();
		genric.waitForLoading();
		genric.element(InputsObjects.requirement_title_select).click();
		genric.waitForLoading();
	}
	
	public String search_approved_offer_letter(CsvReader cv) {
		Actions action=new Actions(driver);
		String matched = "";
		List<WebElement> page_count = genric.elements(InputsObjects.pagination_count_offer_letter_page);
		int counter = 0;
		for(int j=0; j<page_count.size()-1; j++) {
			 genric.hardWait(3);
		List<WebElement> emp_list = genric.elements(InputsObjects.approved_emp_id);	
		List<WebElement> Emp_name = genric.elements(InputsObjects.approved_emp_id+"[contains(text(), '"+Employee_First_Name+"')]");
		for (int i = 0; i<emp_list.size(); i++) {
				 if(Emp_name.size() == 1) {
				 if(Emp_name.get(0).getText().contentEquals(Employee_First_Name)) {
					// js.executeScript("arguments[0].scrollIntoView();",  Emp_name.get(0));
					 genric.hardWait(3);
					Emp_name.get(0).click();
					 genric.waitForLoading();
					 genric.SwitchtoNewWindow();
					 matched = genric.element(InputsObjects.Details_window).getText();
					genric.CloseNewWindow();
					 counter++;
					 break;
			 }
				 } 	else {
					 for(int k = 0; k<Emp_name.size(); k++) {
						// js.executeScript("arguments[0].scrollIntoView();",  Emp_name.get(i));
						 genric.waitForLoading();
						 Emp_name.get(k).click();
						 genric.waitForLoading();
						 genric.SwitchtoNewWindow();
						 if(genric.element(InputsObjects.Details_window).getText().contentEquals(Employee_ID)) {
							 matched = genric.element(InputsObjects.Details_window).getText();
							counter++;
							 break;
							
					 }else {
						 genric.CloseNewWindow();
						 genric.SwitchtoOriginalWindow();
					 }
					 }
				 }
		 }
			if (counter==1||(j > page_count.size())) {
				break;
			}else {
				System.out.println(j);
				action.moveToElement(genric.element(InputsObjects.pagination_count_offer_letter_page+"["+(j+2)+"]")).click().perform();
				System.out.println(j);
			// genric.element(pagination_count_offer_letter_page+"["+(j+2)+"]").click();
			// driver.navigate().refresh();
			 genric.waitForLoading();
			}
			
			
	}
		return matched;
	
	}
	
	public void ferji() {
	if (genric.element(InputsObjects.no_result_found).isDisplayed()) {
		genric.element(InputsObjects.Main_header).click();
		//driver.navigate().refresh();
		//go_to_pre_associate_history_page(login);
		dropdown_select_clientNameID();
		genric.hardWait(2);
		genric.element(InputsObjects.Associate_name_dropdown).click();;
		genric.hardWait(2);
		genric.element(InputsObjects.Associate_name_text_field).sendKeys(generatedString);
		genric.hardWait(2);
	}
}
	 
	

}
