package TestSteps;

import PageObject.TabsMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabsMenuSteps {
    TabsMenuElement tabsMenuElement;
    WebDriver driver;


    public TabsMenuSteps(WebDriver driver) {
        this.driver = driver;
        tabsMenuElement = new TabsMenuElement(driver);
    }

    public AllArticlesSteps clickOnArticleItem() {
        tabsMenuElement.clickOnArcticleItem();
        return new AllArticlesSteps(driver);
    }

    public AllAuthorsPageSteps clickOnAuthorItem(){
        tabsMenuElement.clickOnAuthorItem();
        return new AllAuthorsPageSteps(driver);
    }


}
