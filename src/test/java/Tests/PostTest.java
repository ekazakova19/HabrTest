package Tests;

import TestSteps.AllArticlesSteps;
import TestSteps.PostPageSteps;
import TestSteps.TrackerPageSteps;
import org.junit.Before;
import org.junit.Test;

public class PostTest extends BaseTest{
    PostPageSteps postPageSteps;
    AllArticlesSteps allArticlesSteps;

    @Before
    public void initSteps() {
        postPageSteps = new PostPageSteps(driver);
        allArticlesSteps = new AllArticlesSteps(driver);
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
        allArticlesSteps.navigationBarElementSteps.clickOnTracker().AssertThatPostPresented(title);
    }

    @Test
    public void testFindPosts(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.navigationBarElementSteps.clickOnSearch()
                .inputSearchText("git")
                .assertThatSearchResultsNotEmpty();
    }
}
