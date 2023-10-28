package Com.QA.Pages;

import java.util.List;

import com.microsoft.playwright.*;

public class HomePage {

	Page page;

	private String HomePageLogo="div[class='header-logo']";
	private String HomePageLinks="a";
	private String HomePageProductsLink="div[class='product-grid home-page-product-grid'] h2";
	private String FooterSection="div[class='footer'] :nth-child(1)";
	private String HeaderSectionLinks="div.header-menu ul li a";
	

	public HomePage(Page page) {
		this.page=page;
	}

	public String VerifyHomePageTitle() {
		return page.title();
	}

	public String VerifyHomePageUrl() {
		return page.url();
	}

	public boolean VerifyHomePageLogo() {
		boolean found;

		Locator homePageLogo= page.locator(HomePageLogo);

		if(homePageLogo.isVisible()) {
			found=true;

			if(found=true) {
				System.out.println(homePageLogo.textContent());
			}
			else {
				System.out.println("Home page logo not found");
			}
		}

		else {
			found=false;
		}
		return found;
	}

	public String VerifyHomePageLinks() {
		String link = null;

		List<ElementHandle> links= page.querySelectorAll(HomePageLinks);

		if(links.isEmpty()==false) {

			for(ElementHandle li:links) {
				link= li.innerText();
			}
		}

		return link;
	}

	public int VerifyHomePageProducts() {

		int count=0;
		
		List<String> Productslist= page.locator(HomePageProductsLink).allInnerTexts();
		
		for(int a=0;a<Productslist.size();a++) {
			String text= page.locator(HomePageProductsLink).nth(a).innerText();
			System.out.println(text);
			count++;
		}
		System.out.println("No Of Products : "+count);
		return count;
	}
	

	public int verifyHomePageFooter() {

		int count=0;

		List<String> footerLinksList= page.locator(FooterSection).allInnerTexts();

		for(int a=0;a<footerLinksList.size();a++) {
			String link=page.locator(FooterSection).nth(a).innerText();
			System.out.println(link);
			count++;
		}

		return count;
	}

	public int  VerifyHeaderSectionLinks() {
		
		int count=0;
		
		List<String> HeaderLinks= page.locator(HeaderSectionLinks).allInnerTexts();
		
		for(int a=0;a<HeaderLinks.size();a++) {
			String text= page.locator(HeaderSectionLinks).nth(a).innerText();
			System.out.println(text);
			count++;
		}
		
		return count;
	}
}
