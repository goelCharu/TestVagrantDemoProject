package com.demo;

import com.demo.constants.AWConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * this class contains default base methods for tests
 */
public class BaseTest {

    public static WebDriver driver;


    @BeforeTest
    public void beforeTestMethod()
    {
    }

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethodMethod(String browserName)
    {
     setupDriver(browserName);
     driver.manage().window().maximize();
     driver.get(AWConstants.URL);
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethodMethod(){
        driver.quit();
    }

    @AfterTest
    public void afterTestMethod(){

    }

    /**
     *
     * @param browserName
     */
    public void setupDriver(String browserName) {
        if (browserName.equalsIgnoreCase( "Chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver");
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase( "firefox")){
            System.setProperty("webdriver.gecko.driver", "drivers" + File.separator + "drivers" + File.separator + "firefoxdriver");
            driver = new FirefoxDriver();
        }

    }

}
