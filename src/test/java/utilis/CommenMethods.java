package utilis;

import ClassesForLMS.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommenMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchAplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader. getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver =new ChromeDriver();
                break ;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break ;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializepageobjest();
    }


    public static void sendText(WebElement element,String sendvalue){
        element.clear();
        element.sendKeys(sendvalue);

    }
    public static WebDriverWait getwait(){
        WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }
    public static void waitforclickibility(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void finallyclick(WebElement element){
        waitforclickibility(element);
        element.click();
    }

public static JavascriptExecutor getjavascript(){
    JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
    return javascriptExecutor;
}


    public static void getjavascriptExecutorclick(WebElement element){
        getjavascript().executeScript("arguments[0].click();",element);

    }
                             //class8
    public static void dropdown(WebElement element,String Text){
        Select select=new Select(element);
        select.selectByVisibleText(Text);
    }
    public static byte[] screenshot(String filename){
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
       byte[] bytefile= takesScreenshot.getScreenshotAs(OutputType.BYTES);
       File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourcefile,new File(Constants.SCREENSHOT_FILEPATH+filename+" "+
                    gettimespan("yyyy-MM-dd-HH-mm-ss")+".png"  ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytefile;
    }
    public static String gettimespan(String pattern){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);

    }


















    public static void closeBrowser(){
        driver.quit();
    }
}
