package Com.QA.Pages;

import java.util.List;

import com.microsoft.playwright.*;

public class CheckoutPage {

	Page page;

	private String CountryDropdown="select.country-input";
	private String StateDropdown="select.state-input";
	private String zipcodeBox="input#ZipPostalCode";
	private String estimateShippingButton="input[class='button-2 estimate-shipping-button']";
	private String estimateShippingInfo="ul.shipping-results";
	private String paymentPriceInfo="table.cart-total";
	private String ProductInCartTable="tr.cart-item-row :nth-child(3)";
	private String Checkoutbutton="button#checkout";
	private String TermsOfService="input#termsofservice";

	public CheckoutPage(Page page) {
		this.page=page;
	}

	public String VerifyCheckoutPageTitle() {
		return page.title();
	}

	public String VerifyCheckoutPageUrl() {
		return page.url();
	}

	public boolean VerifyEstimateShippingInformation(String pin) {
		boolean found;

		Locator country= page.locator(CountryDropdown);
		Locator state= page.locator(StateDropdown);
		Locator pincode= page.locator(zipcodeBox);

		List<String> countryNames= country.allInnerTexts();

		for(int a=0;a<countryNames.size();a++) {

			if(countryNames.get(a).equals("India")) {
				country.nth(a).click();
			}
		}

		List<String> stateNames= state.allInnerTexts();

		for(int a=0;a<stateNames.size();a++) {

			if(stateNames.get(a).equals("Other (Non US)")) {
				state.nth(a).click();
			}
		}
		
		pincode.fill(pin);
		
		page.click(estimateShippingButton);
		page.waitForLoadState();
		
		Locator shippingInfo= page.locator(estimateShippingInfo);
		
		if(shippingInfo.isVisible()) {
			found=true;
			
			if(found==true) {
				String text= page.locator(estimateShippingInfo).innerText();
				System.out.println(text);
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public List<String> verifyProductPrice () {
		
		return page.locator(paymentPriceInfo).allInnerTexts();
	}
	
	public boolean VerifyProductInCart() {
		boolean found;
		
		Locator productinCart= page.locator(ProductInCartTable);
		
		if(productinCart.isVisible()) {
			found=true;
		}
		else {
			found=false;
		}
		return found;
	}
	
	public void clickonCheckoutButton() {
		page.locator(TermsOfService).click();
		page.locator(Checkoutbutton).click();
	}
}
