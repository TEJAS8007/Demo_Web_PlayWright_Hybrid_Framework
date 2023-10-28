package Com.QA.test;

import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.*;

import com.microsoft.playwright.*;
import Com.QA.Factory.PlaywrightFactory;
import Com.QA.Pages.AddToCartPage;
import Com.QA.Pages.AddressPage;
import Com.QA.Pages.CheckoutPage;
import Com.QA.Pages.HomePage;
import Com.QA.Pages.LoginPage;
import Com.QA.Utilities.ExcelDataReader;
import Com.QA.base.BaseTest;

public class PagesTest extends BaseTest{


	@Test(priority = 1)
	public void HomePage_Title_Test() {
		String ExpectedTitle= homepage.VerifyHomePageTitle();
		System.out.println(ExpectedTitle);
        
		log.info("Verifying Home Page Title....");
		
		if(ExpectedTitle.equals(dataProp.getProperty("Home_Page_title"))) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page Title Success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page Title failed....");
		}
	}

	@Test(priority = 2)
	public void HomePage_Url_Test() {
		String Expectedurl= homepage.VerifyHomePageUrl();
		System.out.println(Expectedurl);
		
		log.info("Verifying Home Page url....");

		if(Expectedurl.equals(dataProp.getProperty("Home_page_url"))) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page url Success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Home Page url failed....");
		}
	}

	@Test(priority = 3)
	public void HomePage_Logo_Test() {
		boolean found= homepage.VerifyHomePageLogo();
		System.out.println("Home Page Logo : "+found);
		
		log.info("Verifying Home Page logo....");

		if(found=true) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page logo success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page logo failed....");
		}
	}

	@Test(priority = 4)
	public void HomePage_Links_Test() {
		String found= homepage.VerifyHomePageLinks();
		System.out.println("Home Page Links : "+found);
		log.info("Verifying Home Page links....");
	}

	@Test(priority = 5)
	public void HomePage_Products_Test() {
		int found= homepage.VerifyHomePageProducts();
		System.out.println("Home Page Products : "+found);
		
		log.info("Verifying Home Page products....");

		if(found==6) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page products success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page product failed....");
		}
	}

	@Test(priority = 6)
	public void HomePage_Footer_Test() {
		int found= homepage.verifyHomePageFooter();
		System.out.println("Home Page Footer links : "+found);
		
		log.info("Verifying Home Page footer links....");

		if(found==33) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page footer links Success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page footer links failed....");
		}
	}

	@Test(priority = 7)
	public void HomePage_HeaderLinks_Test() {
		int found= homepage.VerifyHeaderSectionLinks();
		System.out.println("Home Page Header links : "+found);
		
		log.info("Verifying Home Page Header links....");

		if(found==24) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page Header links Success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Home Page Hedaer links failed....");
		}
	}

	@Test(priority = 8)
	public void LoginPage_Title_Test() {
		login.ClickOnLogin();
		String ExpectedTitle= login.VerifyLoginPageTitle();
		System.out.println("Login Page title : "+ExpectedTitle);
		
		log.info("Verifying login Page Title....");

		if(ExpectedTitle.equals(dataProp.getProperty("Login_Page_title"))) {
			Assert.assertTrue(true);
			log.info("Verifying login Page Title success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying login Page Title failed....");
		}
	}

	@Test(priority = 9)
	public void LoginPage_Url_Test() {
		String Expectedurl= login.VerifyLoginPageUrl();
		System.out.println("Login Page url : "+Expectedurl);
		log.info("Verifying login Page url....");

		if(Expectedurl.equals(dataProp.getProperty("Login_page_url"))) {
			Assert.assertTrue(true);
			log.info("Verifying login Page url success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying login Page url failed....");
		}
	}

	@Test(priority = 10)
	public void LoginPage_Hedaer_Test() {
		boolean found= login.VerifyLoginPageHeader();
		System.out.println("Login Page Header : "+found);

		log.info("Verifying login Page Header....");
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying login Page Header success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying login Page Header success....");
		}
	}

	@Test(priority = 11)
	public void LoginPage_links_Test() {
		int found= login.VerifyLinksonLoginPage();
		System.out.println("Login Page links : "+found);

		log.info("Verifying login Page links....");
		if(found==62) {
			Assert.assertTrue(true);
			log.info("Verifying login Page links Success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying login Page links failed....");
		}
	}

	@Test(priority = 12)
	public void LoginPage_AccountInfo_Test() {
		boolean found= login.VerifyLginPageAccountInfo();
		System.out.println("Login Page Account Info : "+found);
		
		log.info("Verifying login Page Account info....");

		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying login Page Account info success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying login Page Account info failed....");
		}
	}

	@Test(priority = 13)
	public void LoginPage_FooterLinks_Test() {
		int found= login.verifyLoginPageFooterLinks();
		System.out.println(found);
		
		log.info("Verifying login Page Footer links....");

		if(found==4) {
			Assert.assertTrue(true);
			log.info("Verifying login Page Footer links success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying login Page Footer links failed....");
		}
	}

	@Test(priority = 14)
	public void LoginPage_Login_Test() {
		login.performLoginAction(pro.getProperty("un"), pro.getProperty("ps"));
		log.info("Verifying login Page login Action....");
	}

	@Test(priority = 15)
	public void AddToCartPage_Title_Test() {
		add.ClickonProductImage();

		String ExpectedTitle= add.VerifyAddtoCartPageTitle();
		System.out.println(ExpectedTitle);
		
		log.info("Verifying AddtoCart Page Title....");

		if(ExpectedTitle.equals(dataProp.getProperty("Add_To_Cart_Page_title"))) {
			Assert.assertTrue(true);
			log.info("Verifying AddtoCart Page Title success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying AddtoCart Page Title failed....");
		}
	}

	@Test(priority = 16)
	public void AddToCartPage_Url_Test() {
		String Expectedurl= add.VerifyAddtoCartPageurl();
		System.out.println(Expectedurl);
		
		log.info("Verifying AddtoCart Page url....");

		if(Expectedurl.equals(dataProp.getProperty("Add_To_Cart_page_url"))) {
			Assert.assertTrue(true);
			log.info("Verifying AddtoCart Page url success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying AddtoCart Page url failed....");
		}
	}

	@Test(priority = 17)
	public void AddToCartPage_ProDuctOverview_Test() {
		boolean found= add.VerifyAddtoCartPageProductOverview();
		System.out.println("Product OverView : "+found);
		
		log.info("Verifying AddtoCart Page Product Overview....");

		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying AddtoCart Page Product Overview Success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying AddtoCart Page Product Overview Failed....");
		}
	}

	@Test(priority = 18)
	public void AddToCartPage_ProDuctSpecification_Test() {
		boolean found= add.VerifyAddtoCartPageProductSpecification();
		System.out.println("Product Sepcification : "+found);
		
		log.info("Verifying AddtoCart Page Product Specification....");

		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying AddtoCart Page Product Specification success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying AddtoCart Page Product Specification Failed....");
		}
	}

	@Test(priority = 19)
	public void AddToCartPage_ProDuctInfo_Test() {
		String found= add.VerifyAddtoCartPageProductInfo();
		System.out.println(found);
		
		log.info("Verifying AddtoCart Page Product info....");

		if(found.equals(dataProp.getProperty("Add_TO_Cart_Page_Product_info"))) {
			Assert.assertTrue(true);
			log.info("Verifying AddtoCart Page Product info success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying AddtoCart Page Product info failed....");
		}
	}

	@Test(priority = 20)
	public void AddToCartPage_ProDuctPrice_Test() {
		String found= add.VerifyAddtoCartPageProductPrice();
		System.out.println(found);
		
		log.info("Verifying AddtoCart Page Product price....");

		if(found.equals(dataProp.getProperty("Add_To_Cart_Page_Price"))) {
			Assert.assertTrue(true);
			log.info("Verifying AddtoCart Page Product price success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying AddtoCart Page Product price failed....");
		}
	}

	@Test(priority = 21)
	public void AddToCartPage_Links_Test() {
		int found= add.VerifyLinksonAddToCartPage();
		System.out.println("No Of Links : "+found);
		
		log.info("Verifying AddtoCart Page links....");

		if(found==4) {
			Assert.assertTrue(true);
			log.info("Verifying AddtoCart Page links Success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying AddtoCart Page links failed....");
		}
	}

	@Test(priority = 22)
	public void AddToCartPage_Footer_Links_Test() {
		int found= add.verifyLoginPageFooterLinks();
		System.out.println("No Of Links in footer : "+found);

		log.info("Verifying AddtoCart Page footer links....");
		
		if(found==4) {
			Assert.assertTrue(true);
			log.info("Verifying AddtoCart Page footer links success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying AddtoCart Page footer links failed....");
		}
	}

	@Test(priority = 23)
	public void AddToCartPage_Click_on_AddtoCart_Button_Test() {
		add.clickOnAddToCartButton();
		log.info("Verifying AddtoCart Page click on addtocart button....");
	}


	@Test(priority = 24)
	public void Checkout_Page_TitleTest() {
		String ExpectedTitle= checkout.VerifyCheckoutPageTitle();
		System.out.println("Checkout Page Title : "+ExpectedTitle);

		log.info("Verifying Checkout Page Title....");
		
		if(ExpectedTitle.equals(dataProp.getProperty("Checkout_Page_title"))) {
			Assert.assertTrue(true);
			log.info("Verifying Checkout Page Title success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Checkout Page Title failed....");
		}
	}

	@Test(priority = 25)
	public void Checkout_Page_UrlTest() {
		String Expectedurl= checkout.VerifyCheckoutPageUrl();
		System.out.println("Checkout Page url : "+Expectedurl);
		
		log.info("Verifying Checkout Page url....");

		if(Expectedurl.equals(dataProp.getProperty("Checkout_page_url"))) {
			Assert.assertTrue(true);
			log.info("Verifying Checkout Page url success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Checkout Page url failed....");
		}
	}

	@Test(priority = 26)
	public void Checkout_Page_EstimateShipping_Test() {
		boolean found= checkout.VerifyEstimateShippingInformation(pro.getProperty("pin"));
		System.out.println("Checkout Page Shipping : "+found);

		log.info("Verifying Checkout Page Shipping info....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Checkout Page Shipping info success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Checkout Page Shipping info failed....");
		}
	}

	@Test(priority = 27)
	public void Checkout_Page_Product_Price_Test() {
		List<String> priceList= checkout.verifyProductPrice();

		log.info("Verifying Checkout Page Product price....");
		
		for(String list :priceList) {
			System.out.println(list);
		}
	}

	@Test(priority = 28)
	public void Checkout_Page_Product_InCart_Test() {
		boolean found= checkout.VerifyProductInCart();
		System.out.println("Product in Cart : "+found);

		log.info("Verifying Checkout Page product in cart....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Checkout Page product in cart success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Checkout Page product in cart failed....");
		}
	}

	@Test(priority = 29)
	public void Checkout_Page_Checkout_Click_Test() {
		checkout.clickonCheckoutButton();
		log.info("Verifying Checkout Page click on chckout button....");
	}


	@Test(priority = 30)
	public void Address_Page_Title_Test() {
		String ExpectedTitle= address.VerifyAddressPageTitle();
		System.out.println("Address Page Title : "+ExpectedTitle);
		
		log.info("Verifying Address Page title....");
		
		if(ExpectedTitle.equals(dataProp.getProperty("Address_Page_title"))) {
			Assert.assertTrue(true);
			log.info("Verifying Address Page title success....");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Verifying Address Page title failed....");
		}
	}

	@Test(priority = 31)
	public void Address_Page_Url_Test() {
		String Expectedurl= address.VerifyAddressPageUrl();
		System.out.println("Address Page url : "+Expectedurl);
		
		log.info("Verifying Address Page url....");
		
		if(Expectedurl.equals(dataProp.getProperty("Address_page_url"))) {
			Assert.assertTrue(true);
			log.info("Verifying Address Page url success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Address Page url failed....");
		}
	}

	@Test(priority = 32,dataProvider = "getData")
	public void Address_Page_Address_Data_Test(String com,String ci,String add1,String add2,String zip,String ph,String fx) {
		address.FillingAddressPageData(com, ci, add1, add2, zip, ph, fx);
		log.info("Verifying Address Page Data....");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj=ExcelDataReader.getExcelData();
		return obj;
	}

	@Test(priority = 33)
	public void Payment_Page_Title_Test() {
		String ExpectedTitle= payment.VerifyTitle();
		System.out.println("Payment Page title : "+ExpectedTitle);
		
		log.info("Verifying Payment Page Title....");
		
		if(ExpectedTitle.equals(dataProp.getProperty("Payment_Page_title"))) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Title success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Payment Page Title failed....");
		}
	}

	@Test(priority = 34)
	public void Payment_Page_url_Test() {
		String Expectedurl= payment.VerifyUr();
		System.out.println("Payment Page title : "+Expectedurl);
		
		log.info("Verifying Payment Page url....");
		
		if(Expectedurl.equals(dataProp.getProperty("Payment_page_url"))) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page url success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Payment Page url failed....");
		}
	}

	@Test(priority = 35)
	public void Payment_Page_ContinueAction_Test() {
		payment.performContinueAction();
		log.info("Verifying Payment Page click on continue buttons....");
	}

	@Test(priority = 36)
	public void Payment_Page_PaymentMethods_Test() {
		boolean found= payment.VerifyPaymentMethods();
		System.out.println("Payment Methods : "+found);
		
		log.info("Verifying Payment Page Payment methods....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Payment methods success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Payment Page Payment methods failed....");
		}
	}

	@Test(priority = 37)
	public void Payment_Page_PaymentInformation_Test() {
		boolean found= payment.VerifyPaymentInformation();
		System.out.println("Payment Information : "+found);
		
		log.info("Verifying Payment Page Payment info....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Payment info success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Payment Page Payment info failed....");
		}
	}

	@Test(priority = 38)
	public void Payment_Page_BillingInfo_Test() {
		List<String> infolist= payment.VerifyBillingInfo();

		for(String list :infolist) {
			System.out.println(list);
		}
		log.info("Verifying Payment Page biiling information....");
	}

	@Test(priority = 39)
	public void Payment_Page_ShippingInfo_Test() {
		List<String> infolist= payment.VerifyShippingInfo();

		for(String list :infolist) {
			System.out.println(list);
		}
		log.info("Verifying Payment Page Shipping  information....");
	}

	@Test(priority = 40)
	public void Payment_Page_FinalpriceInfo_Test() {
		List<String> infolist= payment.VerifyFinalPriceInfo();

		for(String list :infolist) {
			System.out.println(list);
		}
		log.info("Verifying Payment Page final price ....");
	}

	@Test(priority = 41)
	public void Payment_Page_ClickConfirmOrder_Test() {
		payment.clickOnConfirmOrderContButton();
		log.info("Verifying Payment Page continue button....");
	}

	@Test(priority = 42)
	public void Payment_Page_FinalPageLogo_Test() {
		boolean found= payment.VerifyFinalPageLogo();
		System.out.println("Final Page Logo : "+found);
		
		log.info("Verifying Payment Page final logo....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page final logo success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Payment Page final logo failed....");
		}
	}

	@Test(priority = 43)
	public void Payment_Page_OrderConfirmation_Test() {
		boolean found= payment.VerifyOrderConfirmationMessage();
		System.out.println("Order Confirmation message : "+found);
		
		log.info("Verifying Payment Page Order confirmtion message....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Order confirmtion message success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Payment Page Order confirmtion message failed....");
		}
	}

	@Test(priority = 44)
	public void Payment_Page_OrderNumber_Test() {
		boolean found= payment.VerifyOrderNumber();
		System.out.println("Order number  : "+found);
		
		log.info("Verifying Payment Page Order confirmtion number....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Order confirmtion number success....");
		}
		else {
			Assert.assertTrue(false);
			log.info("Verifying Payment Page Order confirmtion number failed....");
		}
	}
}
