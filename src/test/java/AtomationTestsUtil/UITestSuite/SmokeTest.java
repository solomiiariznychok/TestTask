package AtomationTestsUtil.UITestSuite;

import AtomationTestsUtil.ApplicationUtil.Application;
import AtomationTestsUtil.ApplicationUtil.ApplicationSourcesRepository;

import AtomationTestsUtil.Pages.StartPage;
import org.junit.Test;

public class SmokeTest {

    public static Application application;
    public static StartPage startPage;

    @Test
    public  void test() {
        application = new Application(ApplicationSourcesRepository.get().getURLByChrome());
        startPage = application.loadChrome();
    }
}
