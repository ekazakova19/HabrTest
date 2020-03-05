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

    public void assertThatPostTitleIs(String expectedValue){
        assertThat(postPage.getPostTitleValue()).isEqualToIgnoringCase(expectedValue);
        logger.info("Step: Assert that title is correct - completed");
    }
}
