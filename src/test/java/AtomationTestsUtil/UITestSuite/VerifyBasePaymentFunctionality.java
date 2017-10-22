package AtomationTestsUtil.UITestSuite;
import AtomationTestsUtil.ApplicationUtil.Application;
import AtomationTestsUtil.ApplicationUtil.ApplicationSourcesRepository;
import AtomationTestsUtil.Pages.IAIndividualsPage;
import AtomationTestsUtil.Pages.MortagageProductsPage;
import AtomationTestsUtil.Pages.MortgagePaymentCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyBasePaymentFunctionality {

    public static Application application;
    public static IAIndividualsPage IAIndividualsPage;
    public static MortagageProductsPage mortagageProductsPage;
    public static MortgagePaymentCalculatorPage mortgagePaymentCalculatorPage;
    public static final String EXPECTED_PURCHASE_PRICE_VALUE = "500000";
    public static final String DOWN_PAYMENT_VALUE = "50000";
    public static final String WEEKLY_PAYMENTS_LABEL_RESULT = "$ 842.47";


    @BeforeClass
    public void oneTimeSetUp() {
        application = new Application(ApplicationSourcesRepository.get().getURLByChrome());
    }

    @Test
    public void verifyWeeklyPaymentsResult()  {
        IAIndividualsPage = application.loadChrome();
        IAIndividualsPage.clickLoanTab();
        mortagageProductsPage = IAIndividualsPage.clickMortagageLink();
        mortgagePaymentCalculatorPage = mortagageProductsPage.clickCalculatePaymentButton();
        mortgagePaymentCalculatorPage.verifyPurchasePriceSliderMovement();
        Assert.assertTrue(Double.parseDouble(mortgagePaymentCalculatorPage.getSliderSelectionWidthPercentage()) > 0, "Purchase Price Slider was not movement correctly");
        Assert.assertTrue(Double.parseDouble(mortgagePaymentCalculatorPage.getPurchasePriceSliderStyleAttribute()) > 0, "Purchase Price Slider was not movement correctly");
        //Assert.assertEquals(Double.parseDouble(mortgagePaymentCalculatorPage.getSliderSelectionWidthPercentage()),
         // mortgagePaymentCalculatorPage.getPurchasePriceSliderStyleAttribute(), "Purchase Price Slider was not movement correctly");
        System.out.println(mortgagePaymentCalculatorPage.getPurchasePriceSliderStyleAttribute());
        System.out.println(mortgagePaymentCalculatorPage.getSliderSelectionWidthPercentage());
        mortgagePaymentCalculatorPage.clickDecreasePurchaceButton();
        mortgagePaymentCalculatorPage.clickIncreasePurchaceButton();
        Assert.assertEquals(mortgagePaymentCalculatorPage.getSliderPrixProprieteValue(), EXPECTED_PURCHASE_PRICE_VALUE);
        mortgagePaymentCalculatorPage.inputDownPaymentTextBox(DOWN_PAYMENT_VALUE);
        mortgagePaymentCalculatorPage.checkAmortizationYearsValue();
        mortgagePaymentCalculatorPage.checkPaymentFrequencyValue();
        mortgagePaymentCalculatorPage.inputInterestRateTextBox();
        mortgagePaymentCalculatorPage.clickCalculateButton();
        Assert.assertEquals(mortgagePaymentCalculatorPage.getTextWeeklyPaymentsLabelResult(), WEEKLY_PAYMENTS_LABEL_RESULT, "Weekly payments result is not correct");
        application.close();
    }
}


