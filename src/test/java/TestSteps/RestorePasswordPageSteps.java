package TestSteps;

import PageObject.RestorePasswordPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPageSteps {
    private RestorePasswordPage restorePasswordPage;
    private SoftAssertions softly;
    private static final Logger logger = LogManager.getLogger(RestorePasswordPageSteps.class);

    public RestorePasswordPageSteps(WebDriver driver) {
        restorePasswordPage = new RestorePasswordPage(driver);
        softly = new SoftAssertions();
    }

    public  RestorePasswordPageSteps assertThatAllElementsOnFormPresented(){
        softly.assertThat(getTitle())
                .as("Check title")
                .isEqualTo("Remind password");
        softly.assertThat(getEmailLabel())
                .as("Check email label")
                .isEqualTo("Email");
        softly.assertThat(isSubmitButtonIsActive())
                .as("Check that submit button is not active")
                .isFalse();

        logger.info("Starting check elements...");
        softly.assertAll();
        try {
            softly.assertAll();
            logger.info("Step: Assert that all elements presented on the form - completed");
            return this;
        } catch (Exception e) {
            logger.error("Step: Assert that all elements presented on the form - fails. Error {}",e.getMessage());
            throw e;
        }
    }

    public String getTitle(){
        try {
            return restorePasswordPage.getTitleValue();
        } catch (NoSuchElementException e) {
            logger.error("Could not find element due to error {}", e.getMessage());
            return "";
        }
    }

    public String getEmailLabel(){
        try {
            return restorePasswordPage.getEmailLabelValue();
        } catch (NoSuchElementException e) {
            logger.error("Could not find element due to error {}", e.getMessage());
            return "";
        }
    }

    public boolean isSubmitButtonIsActive(){
        try {
            return  restorePasswordPage.isSubmitButtonActive();
        } catch (NoSuchElementException e) {
            logger.error("Could not find element due to error {}", e.getMessage());
            throw e;
        }
    }
}
