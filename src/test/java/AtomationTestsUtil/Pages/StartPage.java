package AtomationTestsUtil.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class StartPage {

    protected WebDriver driver;

    public StartPage (WebDriver driver) {
        this.driver = driver;
    }
}

