package TestSteps;

import PageObject.PostPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.*;

public class PostPageSteps {
    private WebDriver driver;
    private PostPage postPage;
    private static final Logger logger = LogManager.getLogger(PostPageSteps.class);


    public PostPageSteps(WebDriver driver) {
        this.driver = driver;
        postPage = new PostPage(driver);
    }

    public void enterComment(String text){
        postPage.enterTextInCommentField(text);
        logger.info("Step: Enter comment - completed");
    }

    public void assertThatPostTitleIs(String expectedValue){
        String postTitle =postPage.getPostTitleValue();
        try {
            assertThat(postTitle).isEqualToIgnoringCase(expectedValue);
            logger.info("Step: Assert that title is correct - completed");
        } catch (AssertionError e) {
            logger.error("Post title does not match with expected value.Actual is {} , but expected {}",postTitle,expectedValue);
            Assert.fail();
        }
    }

    public void assertThatCommentPreviewButtonNotEnabled(){
        try {
            Assert.assertFalse(postPage.isPreviewButtonEnabled());
            logger.info("Step: Assert that comment preview button not enabled - completed");
        } catch (AssertionError e) {
            logger.error("Comment preview button is enabled, but it expected to be not enabled");
            Assert.fail();
        }
    }
    public void assertThatCommentPreviewButtonEnabled(){
        try {
            Assert.assertTrue(postPage.isPreviewButtonEnabled());
            logger.info("Step: Assert that comment preview button is enabled - completed");
        } catch (AssertionError e) {
            logger.error("Comment preview button is not enabled, but it expected to be enabled");
            Assert.fail();
        }
    }
    public void assertThatSendCommentButtonNotEnabled(){
        try {
            Assert.assertTrue(postPage.isSendCommentButtonEnabled());
            logger.info("Step: Assert that send comment button not enabled - completed");
        } catch (AssertionError e) {
            logger.error("Send comment button is enabled, but it expected to be not enabled");
            Assert.fail();
        }
    }
    public void assertThatSendCommentButtonEnabled(){
        try {
            boolean b = postPage.isSendCommentButtonEnabled();
            Assert.assertFalse(postPage.isSendCommentButtonEnabled());
            logger.info("Step: Assert that send comment button is enabled - completed");
        } catch (AssertionError e) {
            logger.error("Send comment button is not enabled, but it expected to be enabled");
            Assert.fail();
        }
    }


}
