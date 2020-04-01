package Tests;

import TestSteps.AllArticlesSteps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticlesTest extends BaseTest {
    AllArticlesSteps allArticlesSteps;

    @Before
    public void initSteps(){
        allArticlesSteps = new AllArticlesSteps(driver);
    }

    @Test
    public void testMainElementsPresented(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.clickOnArticleItem()
                .checkArticlesBlockPresented()
                .checkNewsBlockPresented()
                .checkQuestionsBlockPresented()
                .checkFreelanceBlockPresented()
                .checkVacanciesBlockPresented();
    }
    @Test
    public void testAddBookmark(){
        int counterBefore,counterAfter;
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.clickOnArticleItem();
        int articleNumber = allArticlesSteps.generateRandomArticleNumber();
        counterBefore = allArticlesSteps.countBookmarkCountForArticle(articleNumber);
        allArticlesSteps.addAArticleToBookmark(articleNumber);
        counterAfter = allArticlesSteps.countBookmarkCountForArticle(articleNumber);
        Assert.assertTrue("Previous bookmarks count has to be more than actual ",counterBefore < counterAfter);
    }

    @Test
    public void testReadMore(){
        allArticlesSteps.openAllArticlesPage().logInWithCookie();
        allArticlesSteps.clickOnArticleItem();
        int articleNumber = allArticlesSteps.generateRandomArticleNumber();
        String title = allArticlesSteps.getTitleForArticleNumber(articleNumber);
        allArticlesSteps.readMoreOfArticleNumber(articleNumber)
                .assertThatPostTitleIs(title);
    }
}
