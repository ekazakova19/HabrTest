package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public static void setUpClass(){
        WebDriverManager.chromedriver().setup();
      //  WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
      //  driver = new FirefoxDriver();
    }
}
