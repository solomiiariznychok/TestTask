package AtomationTestsUtil.UITestSuite;
import AtomationTestsUtil.ApplicationUtil.Application;
import AtomationTestsUtil.ApplicationUtil.ApplicationSourcesRepository;
import AtomationTestsUtil.Pages.IAIndividualsPage;
import AtomationTestsUtil.Pages.MortgageProductsPage;
import AtomationTestsUtil.Pages.MortgagePaymentCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("Report regarding UI test suite")
public class VerifyBasePaymentFunctionality {

    public static Application application;
    public static IAIndividualsPage IAIndividualsPage;
    public static MortgageProductsPage mortgageProductsPage;
    public static MortgagePaymentCalculatorPage mortgagePaymentCalculatorPage;
    public static final String EXPECTED_PURCHASE_PRICE_VALUE = "500000";
    public static final String DOWN_PAYMENT_VALUE = "50000";
    public static final String RATE_TEXT_BOX_VALUE = "5.00";
    public static final String WEEKLY_PAYMENTS_LABEL_RESULT = "$ 842.47";

    @Title("Open browser window and getting all necessary data about application sources")
    @BeforeClass
    public void oneTimeSetUp() {
        application = new Application(ApplicationSourcesRepository.get().getURLByChrome());
    }

    @Severity(SeverityLevel.NORMAL)
    @Title("Verify weekly payments result test")
    @Description("Verify weekly payments test include the following verification steps: " +
            "open 'http://ia.ca' link in chrome browser;" +
            "click on 'Loans' button and 'Mortgage' link and verify them functionality;" +
            "go to the 'Calculate yours payments' and verify that  button redirect active user to 'MortgagePaymentCalculator' page';" +
            "go to the 'MortgagePaymentCalculator' page and verify that Purchase price slider correctly movement;" +
            "verify 'Increase purchace' and 'Decrease purcase' button functionality;" +
            "go to the 'AmortizationYear' and 'PaymentFrequency' dropdown lists and select '15 years' and 'weekly' values according;" +
            "go to 'Interest rate' text box and change value to '5';" +
            "click on 'Calculate' button and verify that 'Weekly payments result' text box contains value equal to '$ 842.47'"
             )
    @Test
    public void verifyWeeklyPaymentsResult()  {
        IAIndividualsPage = application.loadChrome();
        IAIndividualsPage.clickLoanTab();
        mortgageProductsPage = IAIndividualsPage.clickMortagageLink();
        mortgagePaymentCalculatorPage = mortgageProductsPage.clickCalculatePaymentButton();
        mortgagePaymentCalculatorPage.verifyPurchasePriceSliderMovement();
        Assert.assertTrue(mortgagePaymentCalculatorPage.getSliderSelectionWidthPercentage() > 0, "Purchase Price Slider was not movement correctly");
        Assert.assertTrue(mortgagePaymentCalculatorPage.getPurchasePriceSliderStyleAttribute() > 0, "Purchase Price Slider was not movement correctly");
        Assert.assertEquals(mortgagePaymentCalculatorPage.getSliderSelectionWidthPercentage(),
                mortgagePaymentCalculatorPage.getPurchasePriceSliderStyleAttribute(), 0.00001, "Purchase Price Slider was not movement correctly");
        mortgagePaymentCalculatorPage.clickDecreasePurchaseButton();
        mortgagePaymentCalculatorPage.clickIncreasePurchaseButton();
        Assert.assertEquals(mortgagePaymentCalculatorPage.getSliderPrixProprieteValue(), EXPECTED_PURCHASE_PRICE_VALUE);
        mortgagePaymentCalculatorPage.inputDownPaymentTextBox(DOWN_PAYMENT_VALUE);
        mortgagePaymentCalculatorPage.checkAmortizationYearsValue();
        mortgagePaymentCalculatorPage.checkPaymentFrequencyValue();
        mortgagePaymentCalculatorPage.inputInterestRateTextBox(RATE_TEXT_BOX_VALUE);
        mortgagePaymentCalculatorPage.clickCalculateButton();
        Assert.assertEquals(mortgagePaymentCalculatorPage.getTextWeeklyPaymentsLabelResult(), WEEKLY_PAYMENTS_LABEL_RESULT, "Weekly payments result is not correct");
        application.close();
    }
}


