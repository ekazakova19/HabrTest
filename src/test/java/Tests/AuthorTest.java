package Tests;

import TestSteps.AllAuthorsPageSteps;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest extends BaseTest {
    AllAuthorsPageSteps allAuthorsPageSteps;

    @Before
    public void initSteps(){
        allAuthorsPageSteps = new AllAuthorsPageSteps(driver);
    }

    @Test
    public void findOneAuthor() {
        allAuthorsPageSteps.openAllAuthorsPage().logInWithCookie();
        allAuthorsPageSteps.tabsMenuSteps.clickOnAuthorItem()
                .searchAuthorByName("barancev")
                .assertThatAmountOfFoundAuthorsIs(1);
    }

    @Test
    public void findMoreThanOneAuthors(){
        allAuthorsPageSteps.openAllAuthorsPage().logInWithCookie();
        allAuthorsPageSteps.searchAuthorByName("alexey")
                .assertThatAmountOfFoundAuthorsMoreThan(1);
    }

    @Test
    public void findNonExistedAuthor(){
        allAuthorsPageSteps.openAllAuthorsPage().logInWithCookie();
        allAuthorsPageSteps.searchAuthorByName("nonexisteduser")
                            .assertThatAmountOfFoundAuthorsIs(0);
    }

    @Test
    public void clearSearchFiled() {
        allAuthorsPageSteps.openAllAuthorsPage().logInWithCookie();
        allAuthorsPageSteps.searchAuthorByName("alexey")
                .clearSearchField();
    }

    @Test
    public void followAuthor() {
        allAuthorsPageSteps.openAllAuthorsPage().logInWithCookie();
        allAuthorsPageSteps.followAuthor();
    }

    @Test
    public void unfollowAuthor(){
        allAuthorsPageSteps.openAllAuthorsPage().logInWithCookie();
        allAuthorsPageSteps.followAuthor()
                .unfollowAuthor();
    }

}
