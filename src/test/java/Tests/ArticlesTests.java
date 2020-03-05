package Tests;

import TestSteps.AllArticlesSteps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticlesTests extends BaseTest {
    AllArticlesSteps allArticlesSteps;
    @Before
    public void initSteps(){
        allArticlesSteps = new AllArticlesSteps(driver);
    }

    @Test
    public void testMainElementsPresented(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.clickOnArticlesItem()
                .checkArticlesBlockPresented()
                .checkNewsBlockPresented()
                .checkQuestionsBlockPresented()
                .checkFreelanceBlockPresented()
                .checkVacanciesBlockPresented();
    }
    @Test
    public void testAddBookmark(){
        int counterBefore,counterAfter;
        int articleNumber =1;
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.clickOnArticlesItem();
        counterBefore = allArticlesSteps.countBookmarkCountForArticle(articleNumber);
        allArticlesSteps.addAArticleToBookmark(articleNumber);
        counterAfter = allArticlesSteps.countBookmarkCountForArticle(articleNumber);
        Assert.assertTrue("Previous bookmarks count has to be more than actual ",counterBefore < counterAfter);
    }

    @Test
    public void testReadMore(){
        String title;
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.clickOnArticlesItem();
        title = allArticlesSteps.getTitleForArticleNumber(1);
        allArticlesSteps.readMoreOfArticleNumber(1)
                .assertThatPostTitleIs(title);
    }
}
