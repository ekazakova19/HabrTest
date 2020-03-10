package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrackerPage {
    private WebDriver driver;
    @FindBy(linkText = "Публикации")
    private WebElement POSTS_TAB;

    @FindBy(css="table.tracker-table.tracker_comments tr")
    private List<WebElement> POSTS_SIZE;

    @FindBy(css="div.buttons > input[name=r]")
    public WebElement REMOVE_FROM_TRACKER_BTN;

    @FindBy(css = "div.buttons > input[name=m]")
    public WebElement MARK_READ_BTN;

    @FindBy(id="check_all")
    public WebElement CHECK_ALL_BOX;

    public TrackerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openPosts(){
        POSTS_TAB.click();
    }

    public int getTrackerItemsCounts(){
        // size without header
        return POSTS_SIZE.size()-1;
    }

    public WebElement findPostByTitle(String title){
        for (int i = 1; i < POSTS_SIZE.size(); i++) {
            String currentTitle = POSTS_SIZE.get(i).findElement(By.cssSelector("td.post_title")).getText();
            if(title.equalsIgnoreCase(currentTitle)){
                return POSTS_SIZE.get(i);
            }
        }
        return null;
    }

    public boolean isButtonEnabled(WebElement button){
        if(button.getAttribute("disabled")==null){
            return true;
        }
        else {
            return false;
        }
    }

    public void selectAll(){
        if(CHECK_ALL_BOX.getAttribute("checked")==null){
            CHECK_ALL_BOX.click();
        }
    }
}
