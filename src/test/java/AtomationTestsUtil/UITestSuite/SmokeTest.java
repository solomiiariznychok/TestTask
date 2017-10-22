package AtomationTestsUtil.UITestSuite;

import AtomationTestsUtil.ApplicationUtil.Application;

import AtomationTestsUtil.ApplicationUtil.ApplicationSourcesRepository;
import AtomationTestsUtil.Pages.IAIndividualsPage;
import AtomationTestsUtil.Pages.LoansTabBox;

import AtomationTestsUtil.Pages.MortagageProductsPage;
import AtomationTestsUtil.Pages.MortgagePaymentCalculatorPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AtomationTestsUtil.Pages.IndividualsPage;

public class SmokeTest {

    public static Application application;
    public static IAIndividualsPage IAIndividualsPage;
    public static MortagageProductsPage mortagageProductsPage;
    public static MortgagePaymentCalculatorPage mortgagePaymentCalculatorPage;
    public static final String WEEKLY_PAYMENTS_LABEL_RESULT = "$ 842.47";
    public static final String Const1 = "24.8668";
    public static final String Const2 = "24.8668";
    public static LoansTabBox loansTabBox;
    public static IndividualsPage individualsPage;


    @BeforeTest
    public void beforeTest() {
    }


    @BeforeClass
    public void oneTimeSetUp() {
        application = new Application(ApplicationSourcesRepository.get().getURLByChrome());
    }

    @Test
    public void tryScroll() {
//        System.setProperty("webdriver.chrome.driver", "/Users/mtustanovskyy/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ia.ca/mortgage-payment-calculator");
        ((JavascriptExecutor)
                driver).executeScript("window.scrollBy(600,1000)");
    }

    @Test
    public void test()  {
        IAIndividualsPage = application.loadChrome();
        IAIndividualsPage.clickLoanTab();
        mortagageProductsPage = IAIndividualsPage.clickMortagageLink();
        mortgagePaymentCalculatorPage = mortagageProductsPage.clickCalculatePaymentButton();
        mortgagePaymentCalculatorPage.verifyPointer();
        Assert.assertTrue(Double.parseDouble(mortgagePaymentCalculatorPage.getPointerLeftPercentage()) > 0, "");
        System.out.println(mortgagePaymentCalculatorPage.getPointerLeftPercentage());
        System.out.println(mortgagePaymentCalculatorPage.getSliderSelectionWidthPercentage());
        /*mortgagePaymentCalculatorPage.clickIncreasePurchaceButton();
        Assert.assertEquals(mortgagePaymentCalculatorPage.getSliderPrixProprieteValue(), "500000");
        mortgagePaymentCalculatorPage.inputDownPaymentTextBox(" 50000");
        mortgagePaymentCalculatorPage.checkAmortizationYearsValue();
        mortgagePaymentCalculatorPage.checkPaymentFrequencyValue();
        mortgagePaymentCalculatorPage.inputInterestRateTextBox();
        mortgagePaymentCalculatorPage.clickCalculateButton();
        System.out.println("YYYY " + mortgagePaymentCalculatorPage.getTextWeeklyPaymentsLabelResult());
        Assert.assertEquals(mortgagePaymentCalculatorPage.getTextWeeklyPaymentsLabelResult(), WEEKLY_PAYMENTS_LABEL_RESULT, "Weekly payments result is not correct");
        application.close();*/
    }
}


