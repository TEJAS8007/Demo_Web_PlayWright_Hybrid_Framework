package Com.QA.Pages;

import com.microsoft.playwright.Page;

public class AddressPage {

	Page page;
	
	private String Companybox="input#BillingNewAddress_Company";
	private String Citybox="input#BillingNewAddress_City";
	private String Address1box="input#BillingNewAddress_Address1";
	private String Address2box="input#BillingNewAddress_Address2";
	private String Zipbox="input#BillingNewAddress_ZipPostalCode";
	private String Phonebox="input#BillingNewAddress_PhoneNumber";
	private String Faxbox="input#BillingNewAddress_FaxNumber";
	private String ContinueButton="input[class='button-1 new-address-next-step-button']";
	
	public AddressPage(Page page) {
		this.page=page;
	}
	
	public String VerifyAddressPageTitle() {
		return page.title();
	}
	
	public String VerifyAddressPageUrl() {
		return page.url();
	}
	
	public void FillingAddressPageData(String comp,String city,String add1,String add2,String zip,String ph,String fax) {
		/*
		page.locator(Companybox).fill(comp);
		page.locator(Citybox).fill(city);
		page.locator(Address1box).fill(add1);
		page.locator(Address2box).fill(add2);
		page.locator(Zipbox).fill(zip);
		page.locator(Phonebox).fill(ph);
		page.locator(Faxbox).fill(fax);
		*/
		page.locator(ContinueButton).first().click();
	}
}
