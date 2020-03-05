package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllAuthorsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    @FindBy(id = "people_suggest")
    private WebElement searchBox;
    @FindBy(css ="ul.sort-panel")
    private WebElement sortPanel;
    @FindBy(css="ul[id=peoples]>li")
    private List<WebElement> listOfAuthors;
    @FindBy(id="people_suggest_clear")
    private WebElement clearSearchButton;

    private By subscribeButton = By.cssSelector("button");
    public static final String url ="https://habr.com/ru/users/";

    public AllAuthorsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    public void openPage(){
        driver.get(url);
    }

    public void searchAuthorByName(String name){
        int initialSize = getCountOfAuthors();
        searchBox.sendKeys(name);
        wait.until(ExpectedConditions.not(ExpectedConditions.numberOfElementsToBe(By.cssSelector("ul[id=peoples]>li"),initialSize)));
    }

    public int getCountOfAuthors(){
     return listOfAuthors.size();
    }

    public void clearSearchField(){
        actions.moveToElement(clearSearchButton).click().perform();
        wait.until(ExpectedConditions.attributeToBe(searchBox,"value",""));
    }



    public void followTheAuthor(WebElement author) {
        actions.moveToElement(author).perform();
        WebElement button = author.findElement(subscribeButton);
        button.click();
        wait.until(ExpectedConditions.attributeToBe(button,"data-state","unfollow"));
    }

    public void unfollowTheAuthor(WebElement author){
        actions.moveToElement(author).perform();
        WebElement button = author.findElement(subscribeButton);
        button.click();
        wait.until(ExpectedConditions.attributeToBe(button,"data-state","follow"));
    }

    public WebElement getAnyAuthorOnThePage(){
        if(getCountOfAuthors()==0){
            throw new NoSuchElementException("Could not find any authors element on the page");
        }
        return listOfAuthors.get(0);
    }

}
