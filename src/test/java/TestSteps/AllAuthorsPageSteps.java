package TestSteps;

import PageObject.AllAuthorsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllAuthorsPageSteps extends BaseSteps {
    WebDriver driver;
    AllAuthorsPage allAuthorsPage;
    private static final Logger logger = LogManager.getLogger(AllAuthorsPageSteps.class);
    private WebElement author;
    public TabsMenuSteps tabsMenuSteps;

    public AllAuthorsPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        allAuthorsPage = new AllAuthorsPage(driver);
        tabsMenuSteps = new TabsMenuSteps(driver);
    }

    public AllAuthorsPageSteps openAllAuthorsPage(){
        openUrl(allAuthorsPage.url);
        return this;
    }

    public AllAuthorsPageSteps searchAuthorByName(String name) {
        allAuthorsPage.searchAuthorByName(name);
        logger.info("Step: Search author by name - completed");
        return this;
    }

    public void assertThatAmountOfFoundAuthorsIs(int expectedAmount){
        try {
            Assert.assertEquals(expectedAmount,allAuthorsPage.getCountOfAuthors());
            logger.info("Step: Assert that amount of found authors is equal to {} - completed",expectedAmount);
        } catch (AssertionError e) {
            logger.error("Step: Assert that amount of found authors is equal to {} - failed. Error {} ", expectedAmount, e.getMessage());
            throw e;
        }
    }

    public void assertThatAmountOfFoundAuthorsMoreThan(int expectedAmount){
        try {
            Assert.assertTrue(allAuthorsPage.getCountOfAuthors()>expectedAmount);
            logger.info("Step: Assert that amount of found authors is more than  {} - completed",expectedAmount);
        } catch (AssertionError e) {
            logger.error("Step: Assert that amount of found authors is more than {} - failed. Error {} ", expectedAmount, e.getMessage());
            throw e;
        }
    }

    public AllAuthorsPageSteps clearSearchField() {
        try {
            allAuthorsPage.clearSearchField();
            logger.info("Step: Clear search field - completed");
        } catch (TimeoutException e) {
            logger.error("Step: Clear search field - failed. Error {}", e.getMessage());
           throw e;
        }
        return this;
    }

    public AllAuthorsPageSteps followAuthor() {
        try {
            author = allAuthorsPage.getAnyAuthorOnThePage();
            allAuthorsPage.followTheAuthor(author);
            logger.info("Step: Follow the author - completed");
        } catch (Exception e) {
            logger.info("Step: Follow the author - failed. Error {}", e.getMessage());
            throw e;
        }
        return this;
    }

    public AllAuthorsPageSteps unfollowAuthor() {
        if(author==null){
            logger.error("Step: Unfollow the author - failed. Error - there is no author to unsubscribe");
            Assert.fail();
            return this;
        }
        else {
            allAuthorsPage.unfollowTheAuthor(author);
            logger.info("Step: Unfollow the author - completed");
            return this;
        }
    }



}
