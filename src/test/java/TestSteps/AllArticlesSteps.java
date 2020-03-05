package TestSteps;

import PageObject.AllArticlesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllArticlesSteps extends BaseSteps {
    private WebDriver driver;
    private AllArticlesPage allArcticlesPage;


    private static final Logger logger = LogManager.getLogger(AllArticlesSteps.class);

    public AllArticlesSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        allArcticlesPage = new AllArticlesPage(driver);

    }

    public AllArticlesSteps openAllArticlesPage(){
        openUrl(allArcticlesPage.url);
        logger.info("Step: Open all articles page - completed");
        return this;
    }

    public AllArticlesSteps clickOnArticlesItem(){
        allArcticlesPage.clickOnArcticlesItem();
        logger.info("Step: Click on articles tab - completed");
        return this;
    }

    public AllArticlesSteps checkArticlesBlockPresented(){

        try {
            Assert.assertTrue(allArcticlesPage.getCountOfArticles() > 0);
            logger.info("Step: Check that news block presented on the page - completed");
            return this;
        } catch (AssertionError e) {
            logger.error("Step: Check that news block presented on the page - failed. Error {}", e.getMessage());
            throw e;
        }
    }

    public AllArticlesSteps checkNewsBlockPresented(){
        try {
            allArcticlesPage.getNewsBlock();
            logger.info("Step: Check that news block presented on the page - completed");
            return this;
        } catch (NoSuchElementException e) {
            logger.error("Step: Check that news block presented on the page - failed. Error {}", e.getMessage());
            throw e;
        }
    }

    public AllArticlesSteps checkVacanciesBlockPresented(){
        try {
            allArcticlesPage.getVacanciesBlock();
            logger.info("Step: Check that vacancies block presented on the page - completed");
            return this;
        } catch (NoSuchElementException e) {
            logger.error("Step: Check that vacancies block presented on the page - failed. Error {}", e.getMessage());
            throw e;
        }
    }

    public AllArticlesSteps checkQuestionsBlockPresented(){
        try {
            allArcticlesPage.getQuestionBlock();
            logger.info("Step: Check that questions block presented on the page - completed");
            return this;
        } catch (NoSuchElementException e) {
            logger.error("Step: Check that questions block presented on the page - failed. Error {}", e.getMessage());
            throw e;
        }
    }


    public AllArticlesSteps checkFreelanceBlockPresented(){
        try {
            allArcticlesPage.getFrelancimBlock();
            logger.info("Step: Check that freelance block presented on the page - completed");
            return this;
        } catch (NoSuchElementException e) {
            logger.error("Step: Check that freelance block presented on the page - failed. Error {}", e.getMessage());
            throw e;
        }
    }

    public void addAArticleToBookmark(int num){
        allArcticlesPage.addArticleToBookmark(allArcticlesPage.getArticleByItem(num));
        logger.info("Step: Add article number {} to bookmark - completed", num);
    }

    public int countBookmarkCountForArticle(int num){
        int count = allArcticlesPage.getBookmarkCounter(allArcticlesPage.getArticleByItem(num));
        logger.info("Step: Count bookmarks for article {} - completed. Bookmarks count {}", num,count);
        return allArcticlesPage.getBookmarkCounter(allArcticlesPage.getArticleByItem(num));
    }

    public String getTitleForArticleNumber(int num){
       String title = allArcticlesPage.getArticleTitle(allArcticlesPage.getArticleByItem(num));
        logger.info("Step: Get title for article {} - completed. Title is {}", num,title);
        return title;
    }

    public PostPageSteps readMoreOfArticleNumber(int num){
        allArcticlesPage.clickOnReadMoreButton(allArcticlesPage.getArticleByItem(1));
        logger.info("Step: Click on read more - completed");
        return new PostPageSteps(driver);
    }

}
