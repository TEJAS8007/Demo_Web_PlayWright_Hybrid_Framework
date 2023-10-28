package Com.QA.Pages;

import java.util.List;

import com.microsoft.playwright.*;

public class LoginPage {

	Page page;
	
	private String LoginLink="a.ico-login";
	private String LoginPageHeader="text=Welcome, Please Sign In!";
	private String LoginPageLinks="a";
	private String LoginPageaccountInfo="div.text";
	private String LoginPageFooterLinks="div.footer-menu-wrapper div";
	private String usernameBox="input#Email";
	private String passwordBox="input#Password";
	private String loginButton="input[class='button-1 login-button']";
	
	public LoginPage(Page page) {
		this.page=page;
	}
	
	public void ClickOnLogin() {
		page.locator(LoginLink).click();
	}
	
	public String VerifyLoginPageTitle() {
		return page.title();
	}
	
	public String VerifyLoginPageUrl() {
		return page.url();
	}
	
	public boolean VerifyLoginPageHeader() {
		
		boolean found;
		
		Locator loginHeader= page.locator(LoginPageHeader);
		
		if(loginHeader.isVisible()) {
			found=true;
			
			if(found==true) {
				String text= loginHeader.innerText();
				System.out.println(text);
			}
			else {
				System.out.println("Header locator no found...");
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public int VerifyLinksonLoginPage() {
		int count=0;
		
		List<String> linksList= page.locator(LoginPageLinks).allInnerTexts();
		
		for(int a=0;a<linksList.size();a++) {
			String link= page.locator(LoginPageLinks).nth(a).innerText();
			System.out.println(link);
			count++;
		}
		System.out.println("No of Links on LoginPage : "+count);
		
		return count;
	}
	
	public boolean VerifyLginPageAccountInfo() {
		boolean found;
		
		Locator accinfo= page.locator(LoginPageaccountInfo);
		
		if(accinfo.isVisible()) {
			found=true;
			
			if(found==true) {
				String text= accinfo.innerText();
				System.out.println(text);
			}
			else {
				System.out.println("Account info locator not found...");
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public int verifyLoginPageFooterLinks() {
		int count=0;
		
		List<String> footerLinks= page.locator(LoginPageFooterLinks).allInnerTexts();
		
		for(int a=0;a<footerLinks.size();a++) {
			String text= page.locator(LoginPageFooterLinks).nth(a).innerText();
			System.out.println(text);
			count++;
		}
		System.out.println("no of Links in footer : "+count);
		return count;
	}
	
	public void performLoginAction(String username, String password) {

	    Locator unBox = page.locator(usernameBox);
	    Locator psBox = page.locator(passwordBox);
	    Locator login = page.locator(loginButton);

	    unBox.fill(username);
	    psBox.fill(password);
	    login.click();

	}

}
