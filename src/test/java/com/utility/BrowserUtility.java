package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private  Logger logger = LoggerUtility.getLogger(this.getClass());
    private WebDriverWait wait;
    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        
       this.driver.set(driver); // Initialize the instance variable driver
       wait=new WebDriverWait(driver,Duration.ofSeconds(30L));
    }

    public BrowserUtility(String browserName) {
        logger.info("Launching the browser for " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
            wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

        } else {
            logger.error("Invalid Browser Name..Please select chrome or edge only");
            System.err.print("Invalid Browser Name..Please select chrome or edge only");
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadless) {
        logger.info("Launching Browser for " + browserName);
        if (browserName == Browser.CHROME) {
        	ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true); // Accept invalid SSL certificates
            options.addArguments("--ignore-certificate-errors"); // Ignore SSL warnings
            options.addArguments("--allow-running-insecure-content"); // Allow mixed content
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://www.automationpractice.pl"); // Treat as secure
            options.addArguments("--disable-features=CertificateTransparency");
            options.addArguments("--disable-web-security");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            
            if (isHeadless) {
                options.addArguments("--headless");
            }

            driver.set(new ChromeDriver(options));
            wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

        } else if (browserName == Browser.EDGE) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless) {
                options.addArguments("--headless");
                options.setAcceptInsecureCerts(true); // Accept invalid SSL certificates
                options.addArguments("--ignore-certificate-errors"); // Ignore SSL warnings
                options.addArguments("--allow-running-insecure-content"); // Allow mixed content
                options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://www.automationpractice.pl"); // Treat
                // the site as secure
            }
            driver.set(new EdgeDriver(options));
            wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

        } else if (browserName == Browser.FIREFOX) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.addArguments("--headless");
                options.setAcceptInsecureCerts(true); // Accept invalid SSL certificates
                options.addArguments("--ignore-certificate-errors"); // Ignore SSL warnings
                options.addArguments("--allow-running-insecure-content"); // Allow mixed content
                options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://www.automationpractice.pl"); // Treat
                driver.set(new FirefoxDriver(options));
            } else {
                driver.set(new FirefoxDriver());
                wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

            }
        }
    }

    public void goToWebsite(String url) {
        logger.info("Visiting the website " + url);
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.get(url);
        } else {
            logger.error("Driver not initialized.");
        }
    }

    public void maximizeWindow() {
        logger.info("Maximizing the browser window");
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.manage().window().maximize();
        } else {
            logger.error("Driver not initialized.");
        }
    }

    public void clickOn(By locator) {
    	
        WebElement element =wait.until(ExpectedConditions.elementToBeClickable(locator));

        if (element != null) {
            element.click();
        } else {
            logger.error("Element not found: " + locator);
        }
    }
    
    
public void clickOnCheckBox(By locator) {
    	
        WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        if (element != null) {
            element.click();
        } else {
            logger.error("Element not found: " + locator);
        }
    }

    
    
    public void clickOn(WebElement element) {
    	
     
            element.click();
       
    }

    public void enterText(By locator, String textToEnter) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (element != null) {
            element.sendKeys(textToEnter);
        } else {
            logger.error("Element not found: " + locator);
        }
    }
    
    
    
    public void clearText(By textBoxLocator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));        logger.info("Element found and clearing the txt box field" + textBoxLocator);
        
        element.clear();

    }
    public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
    
        logger.info("Finding element with the locator" + dropDownLocator);
        WebElement element = driver.get().findElement(dropDownLocator);
        Select select=new Select(element);
        logger.info("Selecting the Option  " + optionToSelect);

        select.selectByVisibleText(optionToSelect);

    
    
    }
    
    
    public void enterSpecialKey(By locator, Keys keyToEnter) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));        if (element != null) {
        	logger.info("Element found now enter special keys: " + keyToEnter);
            element.sendKeys(keyToEnter);
            
        } else {
            logger.error("Element not found: " + locator);
        }
    }

    public String getVisibleText(By locator) {
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }
    public String getVisibleText(WebElement element) {
    	logger.info("Returning the visible text" ,element.getText());
        return element.getText();
    }
    
    
    
    
    public List<String> getAllVisibleText(By locator) {
        // Wait for the elements to be visible (use the WebDriver and Duration constructor)
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        logger.info("Elements found now printing the list of Elements");

        List<String> productNames = new ArrayList<>();
        for (WebElement element : elementList) {
            String visibleText = getVisibleText(element);
            productNames.add(visibleText);
            System.out.println("Product Name: " + visibleText);
        }

        return productNames;
    }
    
    
    
    
    public List<WebElement> getAllElements(By locator) {
        // Wait for the elements to be visible (use the WebDriver and Duration constructor)
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        logger.info("Elements found now printing the list of Elements");

      

        return elementList;
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
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            TakesScreenshot screenshot = (TakesScreenshot) currentDriver;
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
            String timeStamp = format.format(date);
            File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timeStamp + ".png";
            File screenshotFile = new File(path);
            try {
                FileUtils.copyFile(screenshotData, screenshotFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return path;
        } else {
            LoggerUtility.getLogger(BrowserUtility.class).error("Driver not initialized. Cannot take screenshot.");
            return null;
        }
    }
}
