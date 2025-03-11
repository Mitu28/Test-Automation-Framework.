package com.utility;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public class BrowserUtility {
	
	 
     
	
	private static ThreadLocal <WebDriver> driver=new ThreadLocal <WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	
	
	public BrowserUtility(WebDriver driver) {
		
        this.driver.set(driver);//Initialize the instance variable driver
       
    }
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			
		}else  {
			System.err.print("Invalid Browser Name..Please select chrome or edge only");
		}
		
	}
	
	
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME) {
			
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true); // Accept invalid SSL certificates
            options.addArguments("--ignore-certificate-errors"); // Ignore SSL warnings
            options.addArguments("--allow-running-insecure-content"); // Allow mixed content
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://www.automationpractice.pl"); // Treat the site as secure

	        driver.set(new ChromeDriver(options));
			
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
			
		}else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		
		

		
		
	}
	
	
	
	
	public BrowserUtility(Browser browserName,boolean isHeadless) {
		//logger.info("Launching Browser for " + browserName);
		if(browserName==Browser.CHROME ) {
			if (isHeadless) {
			
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true); // Accept invalid SSL certificates
            options.addArguments("--ignore-certificate-errors"); // Ignore SSL warnings
            options.addArguments("--allow-running-insecure-content"); // Allow mixed content
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://www.automationpractice.pl"); // Treat the site as secure
            options.addArguments("--headless=old");//driver going to launch in headless mode
            options.addArguments("--window-size=1920,1080");
	        driver.set(new ChromeDriver(options));
			}
	        else {
	        	 driver.set(new ChromeDriver());
	        	
	        }
			
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
			
		}else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		
		

		
		
	}
	
	
    public void maximizeWindow() {
		
		 driver.get().manage().window().maximize();
		
	}

   public void goToWebsite(String url) {
	  driver.get().get(url);
   }

    public void clickOn(By Locator) {
    	   WebElement element= driver.get().findElement(Locator);
    	    element.click();
    	
    	
    }
    public void enterText(By Locator,String textToEnter) {
    	WebElement element=driver.get().findElement(Locator);
      element.sendKeys(textToEnter);
    }
public String getVisibleText(By Locator) {
	WebElement element= driver.get().findElement(Locator);
	return element.getText();
	
	
	
}
/**
 * Handles security warning page (if present)
 */
public void handleSecurityPage() {
    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
    try {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-button")));
        continueButton.click();
        System.out.println("Security warning bypassed successfully.");
    } catch (Exception e) {
        System.out.println("No security warning detected or failed to bypass.");
    }
}
public static String takeScreenshot(String name) {
	TakesScreenshot screenshot=(TakesScreenshot)driver.get();
	Date date = new Date();
	SimpleDateFormat format =new SimpleDateFormat("HH-mm-ss");
	String timeStamp=format.format(date);
	File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+ "//screenshots//" + name +" - "+timeStamp+ ".png";
	File screenshotFile=new File(path);
	try {
		
		FileUtils.copyFile(screenshotData, screenshotFile);
		
	}catch(IOException e ){
		e.printStackTrace();
		
	}
	return path;
	
	
	
	
}
	

	




}
