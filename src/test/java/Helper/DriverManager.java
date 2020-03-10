package Helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverManager.class);

    public static WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            logger.info("Chrome browser set up successfully");
            return driver;
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Firefox browser set up successfully");
            return driver;
        }

        logger.error("Not supported browser {} has been passed as argument",browser );
        throw new IllegalArgumentException("Not supported browser");
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
