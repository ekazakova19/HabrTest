package TestSteps;

import PageObject.NavigationBarElement;
import PageObject.TrackerPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NavigationBarElementSteps extends BaseSteps {
    private NavigationBarElement navigationBarElement;
    private static final Logger logger = LogManager.getLogger(NavigationBarElement.class);


    public NavigationBarElementSteps(WebDriver driver) {
        super(driver);
        navigationBarElement = new NavigationBarElement(driver);
    }

    public TrackerPageSteps clickOnTracker(){
        navigationBarElement.clickOnElement(navigationBarElement.trackerIcon);
        logger.info("Step: Open tracker - completed");
        return new TrackerPageSteps(driver);
    }
    public NavigationBarElementSteps clickOnSearch(){
        navigationBarElement.clickOnElement(navigationBarElement.searchIcon);
        logger.info("Step: Click on search - completed");
        return this;
    }

    public NavigationBarElementSteps inputSearchText(String text){
        navigationBarElement.inputSearchText(text);
        logger.info("Step: Input search text - completed");
        return this;
    }

    public void assertThatSearchResultsNotEmpty(){
        try {
            Assert.assertTrue(navigationBarElement.getSearchResultlistSize()>0);
            logger.info("Step: Assert that search results not empty - completed");
        } catch (AssertionError e) {
            logger.error("Search results are empty, expected not to be empty");
            Assert.fail();
        }
    }
}
