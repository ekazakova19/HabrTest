package TestSteps;

import PageObject.NavigationBarElement;
import PageObject.TrackerPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class NavigationBarElementSteps extends BaseSteps {
    private NavigationBarElement navigationBarElement;
    private static final Logger logger = LogManager.getLogger(NavigationBarElement.class);


    public NavigationBarElementSteps(WebDriver driver) {
        super(driver);
        navigationBarElement = new NavigationBarElement(driver);
    }

    public TrackerPageSteps clickOnTracker(){
        navigationBarElement.clickOnTracker();
        logger.info("Step: Open tracker - completed");
        return  new TrackerPageSteps(driver);
    }
}
