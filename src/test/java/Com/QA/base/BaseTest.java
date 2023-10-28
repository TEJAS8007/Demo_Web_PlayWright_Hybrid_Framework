package Com.QA.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import Com.QA.Factory.PlaywrightFactory;
import Com.QA.Pages.AddToCartPage;
import Com.QA.Pages.AddressPage;
import Com.QA.Pages.CheckoutPage;
import Com.QA.Pages.HomePage;
import Com.QA.Pages.LoginPage;
import Com.QA.Pages.PaymentPage;

public class BaseTest {

	protected static Page page;
	protected static Properties pro;
	protected static HomePage homepage;
	protected static LoginPage login;
	protected static AddToCartPage add;
	protected static CheckoutPage checkout;
	protected static AddressPage address;
	protected static PaymentPage payment;
	protected static Properties dataProp;
	protected static Logger log;
	
	@BeforeTest
	public void setUpTest() {
		page= PlaywrightFactory.init_browser();
		pro=PlaywrightFactory.initialize_properties();
		dataProp=PlaywrightFactory.initialize_Data_properties();
		homepage=new HomePage(page);
		login=new LoginPage(page);
		add=new AddToCartPage(page);
		checkout=new CheckoutPage(page);
		address=new AddressPage(page);
		payment=new PaymentPage(page);
		log=LogManager.getLogger(this.getClass());
		log.debug("Debugging................");
	}
	
	@AfterTest
	public void tearDown() {
		page.close();
		log.info("Page Closed...............");
	}
	
}
