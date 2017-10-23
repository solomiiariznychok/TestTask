package AtomationTestsUtil.ApplicationUtil;

import java.util.concurrent.TimeUnit;

import AtomationTestsUtil.Pages.IAIndividualsPage;
import AtomationTestsUtil.ResourcesUtil.ChromeDriverProperty;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Application {

    private ApplicationSources applicationSources;
    public static WebDriver driver;

    public Application(ApplicationSources applicationSources) {
        this.applicationSources = applicationSources;
        System.out.println("\t*** Application Sources ***");
        System.out.println("\t" + applicationSources.getBaseUrl());
        System.out.println("\t" + applicationSources.getBrowserName());
    }

    private void initFireFoxBrowser() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts()
                    .implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
        }
    }

    private void initChromeBrowser() {
        new ChromeDriverProperty().loadChromeDriverProperties();
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts()
                    .implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
        }
    }

    public IAIndividualsPage loadChrome() {
        initChromeBrowser();
        driver.get(applicationSources.getBaseUrl());
        return new IAIndividualsPage();
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void close() {
        if (driver != null) {
            driver.close();
        }
    }

    public static void  windowScrollToWebElement(WebElement element) {
        ((JavascriptExecutor)
                driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

