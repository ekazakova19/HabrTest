package PageObject;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBarElement {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css ="div.main-navbar > div.main-navbar__section_right > a[title=\"Трекер\"]")
    WebElement trackerIcon;
    @FindBy(css = "div.main-navbar > div.main-navbar__section_right > a[title=\"Написать\"")
    WebElement writeToIcon;
    @FindBy (css ="div.main-navbar > div.main-navbar__section_right > div.dropdown > button")
    WebElement userMenu;

    public NavigationBarElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,5);
    }

    public boolean isUserMenuPresented(){
        try {
            wait.until(ExpectedConditions.visibilityOf(userMenu));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

}
