package Tests;

import TestSteps.AllArticlesSteps;
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


    }
}
