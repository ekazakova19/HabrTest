package Tests;

import TestSteps.AllArticlesSteps;
import TestSteps.PostPageSteps;
import TestSteps.TrackerPageSteps;
import org.junit.Before;
import org.junit.Test;

public class PostTests extends BaseTest{
    PostPageSteps postPageSteps;
    AllArticlesSteps allArticlesSteps;

    @Before
    public void initSteps() {
        postPageSteps = new PostPageSteps(driver);
        allArticlesSteps = new AllArticlesSteps(driver);
    }

    @Test
    public void testPostComment(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.readMoreOfArticleNumber(2);
        postPageSteps.assertThatCommentPreviewButtonNotEnabled();
        postPageSteps.assertThatSendCommentButtonNotEnabled();
        postPageSteps.enterComment("This is my opinion");
        postPageSteps.assertThatCommentPreviewButtonEnabled();
        postPageSteps.assertThatSendCommentButtonEnabled();
    }

    @Test
    public void testPostInTracker(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        String title = allArticlesSteps.getTitleForArticleNumber(1);
        allArticlesSteps.addAArticleToBookmark(1);
        allArticlesSteps.navigationBarElementSteps.clickOnTracker().AssertThatPostPresented(title);
    }
}
