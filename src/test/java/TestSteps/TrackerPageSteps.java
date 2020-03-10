package TestSteps;

import PageObject.TrackerPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TrackerPageSteps extends BaseSteps {

    TrackerPage trackerPage;
    private static final Logger logger = LogManager.getLogger(TrackerPage.class);
    public static final String  trackerPageURL = "https://habr.com/ru/tracker/";


    public TrackerPageSteps(WebDriver driver) {
        super(driver);
        trackerPage = new TrackerPage(driver);
    }

    public TrackerPageSteps openTrackerPage(){
        openUrl(trackerPageURL);
        logger.info("Step: open tracker page URL - completed.");
        return this;
    }

    public boolean isPostPresentedInTracker(String title){
        if(trackerPage.findPostByTitle(title)!=null){
            logger.info("Step: check that post presented - completed. Post presented");
            return true;
        }
        else {
            logger.info("Step: check that post  presented - completed. Post not presented");
           return  false;
        }
    }

    public void selectAllPosts(){
        trackerPage.selectAll();
        logger.info("Step: Select all posts - completed");
    }

    public void AssertThatPostPresented(String title){
        Assert.assertTrue(isPostPresentedInTracker(title));
    }

    public void AssertThatRemoveFromTrackerButtonEnabled(){
        try {
            Assert.assertTrue(trackerPage.isButtonEnabled(trackerPage.REMOVE_FROM_TRACKER_BTN));
            logger.info("Step: Assert that remove from tracker button is enabled - completed");
        } catch (AssertionError e) {
            logger.error("Remove tracker button is not enabled, but expected to be enable");
            Assert.fail();
        }
    }

    public void AssertThatMarkReadButtonEnabled(){
        try {
            Assert.assertTrue(trackerPage.isButtonEnabled(trackerPage.MARK_READ_BTN));
            logger.info("Step: Assert that mark read button is enabled - completed");
        } catch (AssertionError e) {
            logger.error("Mark read button is not enabled, but expected to be enable");
            Assert.fail();
        }
    }
    public void AssertThatRemoveFromTrackerButtonNotEnabled(){
        try {
            Assert.assertFalse(trackerPage.isButtonEnabled(trackerPage.REMOVE_FROM_TRACKER_BTN));
            logger.info("Step: Assert that remove from tracker button is not enabled - completed");
        } catch (AssertionError e) {
            logger.error("Remove tracker button is  enabled, but expected to be not enable");
            Assert.fail();
        }
    }
    public void AssertThatMarkReadButtonNotEnabled(){
        try {
            Assert.assertFalse(trackerPage.isButtonEnabled(trackerPage.MARK_READ_BTN));
            logger.info("Step: Assert that mark read button is not enabled - completed");
        } catch (AssertionError e) {
            logger.error("Mark read button is  enabled, but expected to be not enable");
            Assert.fail();
        }
    }
}
