package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PostPage {
    private WebDriver driver;

    @FindBy(css = "h1.post__title ")
    private WebElement POST_TITLE;
    @FindBy(id="comment_text")
    private WebElement WRITE_COMMENT_TEXT;
    @FindBy(css ="button[name=preview]")
    private WebElement COMMENT_PREVIEW_BUTTON;
    @FindBy(css="div.comment-form div.form__buttons>button[name=send]")
    private WebElement SEND_COMMENT_BUTTON;

    public PostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getPostTitleValue(){
        return POST_TITLE.getText();
    }

    public void enterTextInCommentField(String text){
        WRITE_COMMENT_TEXT.sendKeys(text);
    }

    public boolean isPreviewButtonEnabled(){
        return COMMENT_PREVIEW_BUTTON.isEnabled();
    }

    public boolean isSendCommentButtonEnabled(){
        String value = SEND_COMMENT_BUTTON.getAttribute("disabled");
        if(value!=null){
            return true;
        }
        else {
            return false;
        }
    }


}
