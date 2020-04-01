package Tests;

import TestSteps.AllArticlesSteps;
import TestSteps.PostPageSteps;
import TestSteps.TrackerPageSteps;
import org.junit.Before;
import org.junit.Test;

public class PostTest extends BaseTest{
    PostPageSteps postPageSteps;
    AllArticlesSteps allArticlesSteps;
    TrackerPageSteps trackerPageSteps;

    @Before
    public void initSteps() {
        postPageSteps = new PostPageSteps(driver);
        allArticlesSteps = new AllArticlesSteps(driver);
        trackerPageSteps = new TrackerPageSteps(driver);

    }

    @Test
    public void testPostComment(){
        int postNumber =  allArticlesSteps.generateRandomArticleNumber();
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.readMoreOfArticleNumber(postNumber);
        postPageSteps.assertThatCommentPreviewButtonNotEnabled();
        postPageSteps.assertThatSendCommentButtonNotEnabled();
        postPageSteps.enterComment("This is my opinion");
        postPageSteps.assertThatCommentPreviewButtonEnabled();
        postPageSteps.assertThatSendCommentButtonEnabled();
    }

    @Test
    public void testPostInTracker(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        int postNumber = allArticlesSteps.generateRandomArticleNumber();
        String title = allArticlesSteps.getTitleForArticleNumber(postNumber);
        allArticlesSteps.addAArticleToBookmark(postNumber);
        trackerPageSteps.openTrackerPage().AssertThatPostPresented(title);
    }

    @Test
    public void testFindPosts(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.clickOnSearch()
                .inputSearchText("git")
                .assertThatSearchResultsNotEmpty();
    }
}
