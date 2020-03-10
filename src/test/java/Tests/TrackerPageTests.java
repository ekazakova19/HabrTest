package Tests;

import PageObject.MainPage;
import PageObject.TrackerPage;
import TestSteps.AllArticlesSteps;
import TestSteps.BaseSteps;
import TestSteps.MainPageSteps;
import TestSteps.TrackerPageSteps;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TrackerPageTests extends BaseTest {
    TrackerPageSteps trackerPageSteps;
    AllArticlesSteps allArticlesSteps;


    @Before
    public void initSteps(){
        trackerPageSteps = new TrackerPageSteps(driver);
        allArticlesSteps = new AllArticlesSteps(driver);
    }

    @Test
    public void testTrackerButtons(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.addAArticleToBookmark(6);
        trackerPageSteps.openTrackerPage();
        trackerPageSteps.AssertThatRemoveFromTrackerButtonNotEnabled();
        trackerPageSteps.AssertThatMarkReadButtonNotEnabled();
        trackerPageSteps.selectAllPosts();
        trackerPageSteps.AssertThatRemoveFromTrackerButtonEnabled();
        trackerPageSteps.AssertThatMarkReadButtonEnabled();
    }
}
