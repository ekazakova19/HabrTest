package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllArticlesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private TabsMenuElement tabsMenuElement;
    public static final String url = "https://habr.com/ru/top/";

    @FindBy(css = "div.posts_list>ul>li>article")
    private List<WebElement> listOfArticles;
    @FindBy(css = "div.posts_list>ul>li>div.new-block")
    private WebElement newsBlock;
    @FindBy(css="div.posts_list>ul>li>div.promo-block_vacancies")

    private WebElement vacanciesBlock;
    @FindBy(css="div.posts_list>ul>li>div.promo-block_questions")
    private WebElement questionBlock;
    @FindBy(css="div.posts_list>ul>li>promo-block_freelansim-tasks")
    private WebElement frelancimBlock;

    By bookmark = By.cssSelector("li.post-stats__item_bookmark>button");
    By counter = By.cssSelector("span.bookmark__counter");

    public AllArticlesPage(WebDriver driver) {
        this.driver = driver;
        tabsMenuElement = new TabsMenuElement(driver);
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,7);
    }

    public void clickOnArcticlesItem(){
        tabsMenuElement.clickOnArcticleItem();
    }

    public int getCountOfArticles(){
        return  listOfArticles.size();
    }

    public WebElement getNewsBlock(){
        return newsBlock;
    }

    public WebElement getQuestionBlock(){
        return questionBlock;
    }

    public WebElement getVacanciesBlock(){
        return vacanciesBlock;
    }

    public WebElement getFrelancimBlock(){
        return frelancimBlock;
    }

    public void addFirstArticleToBookmark(){
        WebElement bookmarkElement =listOfArticles.get(0).findElement(bookmark);
        int cntBefore = getBookmarkCounter(bookmarkElement);
        bookmarkElement.click();
        wait.until(ExpectedConditions.attributeToBe(bookmark,"data-action","remove"));
        int cntAfter = getBookmarkCounter(bookmarkElement);
    }

    public int getBookmarkCounter(WebElement bookmark){
        return  Integer.parseInt(bookmark.findElement(counter).getText());
    }





}
