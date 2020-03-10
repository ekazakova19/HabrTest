package TestSteps;

import Helper.CookieManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchCookieException;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BaseSteps {
    WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    public BaseSteps refreshPage(){
        driver.navigate().refresh();
        return this;
    }

    public void openUrl(String url){
        driver.get(url);
    }


    public BaseSteps logInWithCookie(){
        CookieManager cookieManager = new CookieManager(driver);
        Set<Cookie> cookies = cookieManager.readCookiesFromFile();
        cookieManager.addCookiesToDriver(cookies);
        refreshPage();
        return this;
    }

}
