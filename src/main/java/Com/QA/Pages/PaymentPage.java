package Com.QA.Pages;

import java.util.List;

import com.microsoft.playwright.*;

public class PaymentPage {

	Page page;
	
	private String ShippingAddressContinueButton="//input[@title='Continue']";//first
	private String ShippingmethodContinueButton="input[class='button-1 shipping-method-next-step-button']";
	private String PaymentMethods="div[class='section payment-method'] >ul";
	private String PayMentMetodContinueButton="input[class='button-1 payment-method-next-step-button']";
	private String PaymentInformation="div.info";
	private String PaymentInfromationContinueButton="input[class='button-1 payment-info-next-step-button']";
	
	private String BillingInfo="ul.billing-info";
	private String ShippingInfo="ul.shipping-info";
	private String FinalPrice="div.total-info";
	private String ConfirmOrderContinueButton="input[class='button-1 confirm-order-next-step-button']";
	
	private String FinalPageLogo="div.page-title";
	private String OrderConfirmationMessage="div.title strong";
	private String orderNumber="ul.details li";//first
	
	public PaymentPage(Page page) {
		this.page=page;
	}
	
	public String VerifyTitle() {
		return page.title();
	}
	
	public String VerifyUr() {
		return page.url();
	}
	
	public void performContinueAction() {
		page.locator(ShippingAddressContinueButton).last().click();
		page.waitForLoadState();
		page.locator(ShippingmethodContinueButton).click();
	}
	
	public boolean VerifyPaymentMethods() {
		boolean found;
		
		Locator payMethods= page.locator(PaymentMethods);
		
		if(payMethods.isVisible()) {
			found=true;
			
			if(found==true) {
				List<String> paymethodsList= payMethods.allInnerTexts();
				
				for(String list :paymethodsList) {
					System.out.println(list);
				}
			}
			else {
				System.out.println("Paymethod Method problem................");
			}
		}
		else {
			found=false;
		}
		page.click(PayMentMetodContinueButton);
		return found;
	}
	
	public boolean VerifyPaymentInformation() {
		boolean found;
		
		Locator payMethods= page.locator(PaymentInformation);
		
		if(payMethods.isVisible()) {
			found=true;
			
			if(found==true) {
				List<String> paymethodsList= payMethods.allInnerTexts();
				
				for(String list :paymethodsList) {
					System.out.println(list);
				}
			}
			else {
				System.out.println("Paymethod Infoo problem................");
			}
		}
		else {
			found=false;
		}
		page.click(PaymentInfromationContinueButton);
		return found;
	}
	
	public List<String> VerifyBillingInfo() {
		return page.locator(BillingInfo).allInnerTexts();
	}
	
	public List<String> VerifyShippingInfo() {
		return page.locator(ShippingInfo).allInnerTexts();
	}
	
	public List<String> VerifyFinalPriceInfo() {
		return page.locator(FinalPrice).allInnerTexts();
	}
	
	public void clickOnConfirmOrderContButton() {
		page.locator(ConfirmOrderContinueButton).click();
	}
	
	public boolean VerifyFinalPageLogo() {
		boolean found;
		
		Locator finalpage= page.locator(FinalPageLogo);
		
		if(page.waitForSelector(FinalPageLogo).isVisible()) {
			found=true;
			
			if(found==true) {
				String text= finalpage.innerText();
				System.out.println(text);
			}
			else {
				System.out.println("Final page logo problem ..............");
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public boolean VerifyOrderConfirmationMessage() {
		boolean found;
		
		Locator finalpage= page.locator(OrderConfirmationMessage);
		page.waitForLoadState();
		
		if(page.waitForSelector(OrderConfirmationMessage).isVisible()) {
			found=true;
			
			if(found==true) {
				String text= finalpage.textContent();
				System.out.println(text);
			}
			else {
				System.out.println("Final page order confi problem ..............");
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public boolean VerifyOrderNumber() {
		boolean found;
		
		Locator finalpage= page.locator(orderNumber).first();
		page.waitForLoadState();
		
		if(page.waitForSelector(orderNumber).isVisible()) {
			found=true;
			
			if(found==true) {
				String text= finalpage.innerText();
				System.out.println(text);
			}
			else {
				System.out.println("Final page order confi problem ..............");
			}
		}
		else {
			found=false;
		}
		return found;
	}
}
