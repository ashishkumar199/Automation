package com.TL.PageMethods;

import java.io.IOException;
import java.time.LocalDate;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.TL.Base.BaseClass;
import com.TL.Base.Genric;
import com.TL.PageObjects.ReportsPageObjects;
import com.TL.PageObjects.StandardOfferLetterPageObjects;
import com.TL.Utils.CsvReader;
import com.TL.Utils.XlsReader;

public class StandardOfferLetterPageMethods extends BaseClass {

	public WebDriver driver;
	Genric genric;
	
	public StandardOfferLetterPageMethods(WebDriver driver, Genric genric){
		this.driver=driver;
		this.genric=genric;

	}	

	public static String generatedString = "";

	// Go to Standard offer letter Page
    public void go_to_offer_letter_page() {
		genric.element(StandardOfferLetterPageObjects.Inputs_Btn).click();
		genric.element(StandardOfferLetterPageObjects.AssociateMaster_Btn).click();	
		genric.waitForLoading();		
		genric.element(StandardOfferLetterPageObjects.StandardOfferLetter_Btn).click();
		genric.waitForLoading();
		
	}	
	
    //
	public void Go_To_Standard_Offer_Letter_Page()	{	
		genric.element(ReportsPageObjects.Hamburger_Menu).click();
		go_to_offer_letter_page();
		genric.element(StandardOfferLetterPageObjects.MultipleRadio_Btn).click();
		genric.waitForLoading();
		Actions actions = new Actions(driver);
		actions.moveToElement(genric.element(StandardOfferLetterPageObjects.Upload_Btn)).sendKeys("C:\\Users\\AshishK\\Downloads\\OL Template _00FBG.csv");
		genric.waitForLoading();
	}
	
	//select client
	public void dropdown_select_clientNameID() {
		genric.hardWait(3);
        genric.element(StandardOfferLetterPageObjects.clientNameID_dropdown).click();
		genric.hardWait(3);
		genric.element(StandardOfferLetterPageObjects.client_select).click();
		genric.waitForLoading();
	}
	
	public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
	
	//For creating randon date
	public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
	
	// Generates random values to enter in standard offer letter sheet
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
//		xr.setCellData(PropertyReader.readDataProperty("WorkbookName"), "*Aadhaar No", 2, adhaar);
		//xr.setCellData(PropertyReader.readDataProperty("WorkbookName"), "*Associate_Name", 2, generatedString);
		
			}
	
	// Generates random values to enter in standard offer letter sheet
	public void Random_sheet_info_OLD(CsvReader cv) throws IOException {
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
	
	
	public void dropdown_requirement_title() {
		genric.waitForLoading();
		genric.element(StandardOfferLetterPageObjects.requirement_title_dropdown).click();
		genric.waitForLoading();
		genric.element(StandardOfferLetterPageObjects.requirement_title_select).click();
		genric.waitForLoading();
	}
	
   // upload offer letter
	public void upload_offer_letter_file(CsvReader cv)  {
		try {
			Random_sheet_info(cv);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		genric.element(StandardOfferLetterPageObjects.MultipleRadio_Btn).click();
		genric.waitForLoading();
		dropdown_select_clientNameID();
		genric.waitForLoading();
		dropdown_requirement_title();
		genric.waitForLoading();
		genric.element(StandardOfferLetterPageObjects.Browse_file_btn).click();
		genric.hardWait(2);
		try {
			Runtime.getRuntime().exec("D:\\ALCS\\Automation\\ALCS\\src\\test\\resources\\drivers\\StandardOfferLetterUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		genric.hardWait(1);
		genric.element(StandardOfferLetterPageObjects.upload_btn).click();
		genric.waitForLoading();
	}
	
	// reset uploaded offer letter
	public void upload_Offer_Letter_File_Reset_button(CsvReader cv)  {
		try {
			Random_sheet_info(cv);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		genric.element(StandardOfferLetterPageObjects.MultipleRadio_Btn).click();
		genric.waitForLoading();
		dropdown_select_clientNameID();
		genric.waitForLoading();
		dropdown_requirement_title();
		genric.waitForLoading();
		genric.element(StandardOfferLetterPageObjects.Browse_file_btn).click();
		genric.hardWait(2);
		try {
			Runtime.getRuntime().exec("D:\\ALCS\\Automation\\ALCS\\src\\test\\resources\\drivers\\StandardOfferLetterUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		genric.hardWait(1);
		genric.element(StandardOfferLetterPageObjects.Reset_btn).click();
		genric.waitForLoading();
		}
	
	
	public String all_page_get_text() {
		return genric.element(StandardOfferLetterPageObjects.All_page_text).getText();
	}
	
	
	

}
