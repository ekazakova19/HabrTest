package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPage {
    private WebDriver driver;

    @FindBy(css = "h1.post__title ")
    private WebElement POST_TITLE;

    public PostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getPostTitleValue(){
        return POST_TITLE.getText();
    }

}
