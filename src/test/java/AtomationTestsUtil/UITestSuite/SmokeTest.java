package AtomationTestsUtil.UITestSuite;

import AtomationTestsUtil.ApplicationUtil.Application;
import AtomationTestsUtil.ApplicationUtil.ApplicationSourcesRepository;

import AtomationTestsUtil.Pages.IndividualsPage;
import AtomationTestsUtil.Pages.LoansTabBox;
import AtomationTestsUtil.Pages.StartPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTest {

    public static Application application;
    public static LoansTabBox loansTabBox;
    public static IndividualsPage individualsPage;

    @BeforeClass
    public void beforeClass(){

    }

    @BeforeTest
    public void beforeTest() {
    }

    @Test
    public  void test() {
        application = new Application(ApplicationSourcesRepository.get().getURLByChrome());
        individualsPage = application.loadChrome();
    }
}
