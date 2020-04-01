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
    public static final String url = "https://habr.com/ru/top/";
    public TabsMenuElement tabsMenuElement;
    public NavigationBarElement navigationBarElement;

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

    By readMoreButton = By.cssSelector("div.post__body > a.btn");
    By bookmark = By.cssSelector("button.bookmark-btn");
    By counter = By.cssSelector("span.bookmark__counter");
    By articleTitle = By.cssSelector("a.post__title_link");

    public AllArticlesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,7);
        tabsMenuElement = new TabsMenuElement(driver);
        navigationBarElement = new NavigationBarElement(driver);
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

    public void addArticleToBookmark(WebElement article){
        WebElement bookmarkElement = article.findElement(bookmark);
        bookmarkElement.click();
        wait.until(ExpectedConditions.attributeToBe(bookmarkElement,"data-action","remove"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.jGrowl-notification.highlight")));
    }

    public int getBookmarkCounter(WebElement article){
        return  Integer.parseInt(article.findElement(counter).getText());
    }
    public void clickOnReadMoreButton(WebElement article){
        article.findElement(readMoreButton).click();
    }
    public WebElement getArticleByItem(int num){
        return listOfArticles.get(num+1);
    }
    public String getArticleTitle(WebElement article){
        return article.findElement(articleTitle).getText();
    }


}
