package Helper;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Drivers {
    CHROME ("chrome"),
    FIREFOX("firefox");

    private String driverName;

    Drivers(String browser){
        this.driverName =browser;
    }
    public String getDriverName(){
        return driverName;
    }


    public WebDriver createDriver(){

        switch (this.getDriverName()) {
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                return  new ChromeDriver();
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default :
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}
