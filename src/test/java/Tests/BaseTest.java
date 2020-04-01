package Tests;

import Helper.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp(){
        String browser = System.getProperty("browser");
        System.out.println(browser);
        if(browser==null){
            driver = DriverManager.getDriver("chrome");
        }
        else {
            driver = DriverManager.getDriver(browser);
        }
    }

    @After
    public void tearDown(){
        DriverManager.closeDriver();
    }
}
