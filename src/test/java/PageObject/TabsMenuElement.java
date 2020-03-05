package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabsMenuElement {
    private WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "div.tabs>div.tabs__level>a[href*=top]")
    WebElement articlesItem;
    @FindBy(css = "div.tabs>div.tabs__level>a[href*=news]")
    WebElement newsItem;
    @FindBy(css = "div.tabs>div.tabs__level>a[href*=hubs]")
    WebElement hubsItem;
    @FindBy(css = "div.tabs>div.tabs__level>a[href*=users]")
    WebElement authorsItem;
    @FindBy(css = "div.tabs>div.tabs__level>a[href*=companies]")
    WebElement companiesItem;

    public TabsMenuElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,5);
    }

    public void clickOnArcticleItem(){
        articlesItem.click();
        wait.until(ExpectedConditions.urlContains("/top"));
    }
    public void clickOnAuthorItem(){
        authorsItem.click();
        wait.until(ExpectedConditions.urlContains("/users"));
    }

    public void clickOnHubsItem(){
        hubsItem.click();
        wait.until(ExpectedConditions.urlContains("/hubs"));
    }

    public void clickOnCompaniesItem(){
        hubsItem.click();
        wait.until(ExpectedConditions.urlContains("/companies"));
    }
}
