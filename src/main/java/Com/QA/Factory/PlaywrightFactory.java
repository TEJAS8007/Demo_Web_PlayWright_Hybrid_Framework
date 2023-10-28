package Com.QA.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;


public class PlaywrightFactory {

	 
	static Properties pro;
	static Playwright playwright;
	static Browser browser;
	static BrowserContext context;
	static Page page;
	
	public static Page init_browser() {
		pro=initialize_properties();
		
		String BrowserName=pro.getProperty("browser").toLowerCase().trim();
	    System.out.println("Browser Name : "+BrowserName);
	   
	    playwright=Playwright.create();
	    
	    if(BrowserName.equals("chromium")) {
	    	browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    }
	    
	    else if(BrowserName.equals("firefox")) {
	    	browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    }
	    
	    else if(BrowserName.equals("safari")) {
	    	browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    }
	    
	    else {
	    	System.out.println("Please Check BrowserName been Correctly entered....");
	    }
	    
	    context= browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("MyTestVideos/")));
	    page= context.newPage();
	    page.navigate(pro.getProperty("url"));
	    return page;
	    
	}
	
	public static Properties initialize_properties() {
		try {
			FileInputStream file=new FileInputStream("src//test//resources//Config//config.properties");
		    pro=new Properties();
		    pro.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public static Properties initialize_Data_properties() {
		try {
			FileInputStream file=new FileInputStream("src//test//resources//TestAssertData//Data.properties");
		    pro=new Properties();
		    pro.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer =page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}
}
