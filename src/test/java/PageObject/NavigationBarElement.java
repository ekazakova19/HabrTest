package PageObject;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NavigationBarElement {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css ="div.main-navbar > div.main-navbar__section_right > a[title=\"Трекер\"]")
    public WebElement trackerIcon;
    @FindBy(css = "div.main-navbar > div.main-navbar__section_right > a[title=\"Написать\"")
    public WebElement writeToIcon;
    @FindBy (css ="div.main-navbar > div.main-navbar__section_right > div.dropdown > button")
    public WebElement userMenu;
    @FindBy(id ="search-form-btn")
    public WebElement searchIcon;
    @FindBy(css = "input.search-form__field")
    private WebElement searchInputField;

    @FindBy(css="ul.content-list li.content-list__item")
    private List<WebElement> searchResultList;

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

    public void clickOnSearch(){
        searchIcon.click();
    }

    public void inputSearchText(String text){
        wait.until(ExpectedConditions.visibilityOf(searchInputField));
        if(!searchInputField.getAttribute("value").isEmpty()){
            searchInputField.clear();
        }
        searchInputField.sendKeys(text);
    }

    public int getSearchResultlistSize(){
        return searchResultList.size();
    }

}
