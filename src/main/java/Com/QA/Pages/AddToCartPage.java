package Com.QA.Pages;

import java.util.List;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions.IsVisibleOptions;

public class AddToCartPage {

	Page page;
	
	private String ProductImage="xpath=/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[1]/a/img";
	private String ProductOverview="div.overview";
	private String productSpecification="table.data-table";
	private String productInfo="div.full-description p";
	private String productPrice="span.price-value-31";
	private String AddtoCartPageFooterLinks="div.footer-menu-wrapper div";
	private String AddtoCartPageLinks="div.footer-menu-wrapper div";
	private String AddToCartButton="input#add-to-cart-button-31";
	private String CartButton="a.ico-cart";
	
	public AddToCartPage(Page page) {
		this.page=page;
	}
	
	public void ClickonProductImage() {
		page.locator(ProductImage).first().click();
	}
	
	public String VerifyAddtoCartPageTitle() {
		return page.title();
	}
	
	public String VerifyAddtoCartPageurl() {
		return page.url();
	}
	
	
	public boolean VerifyAddtoCartPageProductOverview() {
		boolean found;
		
		Locator overview= page.locator(ProductOverview);
		
		if(overview.isEnabled() &&overview.isVisible()) {
			
			found=true;
			
			if(found=true) {
				List<String> overviewList= overview.allInnerTexts();
				
				for(String list:overviewList) {
					System.out.println(list);
				}
			}
			else {
				System.out.println("Over_View Locator Not found");
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public boolean VerifyAddtoCartPageProductSpecification() {
		boolean found;
		
		Locator productspec=page.locator(productSpecification);
		
		if(productspec.isEnabled() && productspec.isVisible()) {
			found=true;
			
			if(found==true)
			{
				List<String> overviewList= productspec.allInnerTexts();
				
				for(String list:overviewList) 
				{
					System.out.println(list);
				}
			}
			else {
				System.out.println("ProductSpec Locator Not found");
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public String VerifyAddtoCartPageProductInfo() {
		return page.locator(productInfo).innerText();
	}
	
	public String VerifyAddtoCartPageProductPrice() {
		return page.locator(productPrice).innerText();
	}
	
	public int VerifyLinksonAddToCartPage() {
		int count=0;
		
		List<String> linksList= page.locator(AddtoCartPageLinks).allInnerTexts();
		
		for(int a=0;a<linksList.size();a++) {
			String link= page.locator(AddtoCartPageLinks).nth(a).innerText();
			System.out.println(link);
			count++;
		}
		System.out.println("No of Links on LoginPage : "+count);
		
		return count;
	}
	
	public int verifyLoginPageFooterLinks() {
		int count=0;
		
		List<String> footerLinks= page.locator(AddtoCartPageFooterLinks).allInnerTexts();
		
		for(int a=0;a<footerLinks.size();a++) {
			String text= page.locator(AddtoCartPageFooterLinks).nth(a).innerText();
			System.out.println(text);
			count++;
		}
		System.out.println("no of Links in footer : "+count);
		return count;
	}
	
	public void clickOnAddToCartButton() {
		page.locator(AddToCartButton).click();
		page.locator(CartButton).first().click();
	}
}
