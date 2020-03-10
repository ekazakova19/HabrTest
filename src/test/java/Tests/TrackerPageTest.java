package Tests;

import Helper.RandomGenerator;
import TestSteps.AllArticlesSteps;
import TestSteps.TrackerPageSteps;
import org.junit.Before;
import org.junit.Test;

public class TrackerPageTest extends BaseTest {
    TrackerPageSteps trackerPageSteps;
    AllArticlesSteps allArticlesSteps;


    @Before
    public void initSteps(){
        trackerPageSteps = new TrackerPageSteps(driver);
        allArticlesSteps = new AllArticlesSteps(driver);
    }

    @Test
    public void testTrackerButtons(){
        int postNumber;
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        postNumber = allArticlesSteps.generateRandomArticleNumber();
        allArticlesSteps.addAArticleToBookmark(postNumber);
        trackerPageSteps.openTrackerPage();
        trackerPageSteps.AssertThatRemoveFromTrackerButtonNotEnabled();
        trackerPageSteps.AssertThatMarkReadButtonNotEnabled();
        trackerPageSteps.selectAllPosts();
        trackerPageSteps.AssertThatRemoveFromTrackerButtonEnabled();
        trackerPageSteps.AssertThatMarkReadButtonEnabled();
    }
}
