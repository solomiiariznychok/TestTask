package AtomationTestsUtil.ApplicationUtil;

import java.util.concurrent.TimeUnit;

import AtomationTestsUtil.Pages.IndividualsPage;
import AtomationTestsUtil.Pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Application {


    private ApplicationSources applicationSources;
    public static WebDriver driver;

    public Application(ApplicationSources applicationSources) {
        this.applicationSources = applicationSources;
        System.out.println("\t*** Application Sources");
        System.out.println("\t" + applicationSources.getBaseUrl());
        System.out.println("\t" + applicationSources.getBrowserName());
    }

    private void initBrowser() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts()
                    .implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
        }
    }

    private void initChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C://Users//riznychok//Downloads//chrome64_50.0.2661.75//chrome64_50.0.2661.75//chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts()
                    .implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
        }
    }


    public IndividualsPage loadChrome() {
        initChromeBrowser();
        driver.get(applicationSources.getBaseUrl());
        return new IndividualsPage();
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
}

