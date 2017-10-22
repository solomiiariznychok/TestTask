package AtomationTestsUtil.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static AtomationTestsUtil.ApplicationUtil.Application.driver;

public class MortgagePaymentCalculatorPage {

    private Actions builder;

    @FindBy(id = "sliderPrixPropriete")
    private WebElement sliderPrixPropriete;

    @FindBy(xpath = "//button[@id='PrixProprieteMinus'] /parent::*//div[@class='slider-handle min-slider-handle custom']")
    private  WebElement purchasePriceSlider;

    @FindBy(xpath = "//div[contains(@id,'exempleMontantPropriete')]" +
            "/parent::div/parent::*//div[contains(@class, 'slider-tick-label')]/span[contains(text(),'500 K')]/..")
    private WebElement purchasePriceSliderMovementPoint;

    @FindBy(css = "div [class='col-med-1-2 col-lg-1-3'] div [class = 'selectric'] p[class = 'label']")
    private WebElement amortizationDropDownList;

    @FindBy(xpath = "//select[@id='FrequenceVersement']/parent::*/parent::*/div[@class='selectric']/b")
    private WebElement paymentFrequencyDropDownList;

    @FindBy (id = "PrixProprietePlus")
    private WebElement increasePurchaceButton;

    @FindBy (id = "TauxInteret")
    private WebElement interestRateTextBox;

    @FindBy(css = "button[id=btn_calculer]")
    private WebElement calculateButton;

    @FindBy(xpath = "//button[@id='PrixProprieteMinus'] /parent::*//div[@class='slider-selection tick-slider-selection']")
    private WebElement sliderSelection;

    @FindBy(xpath = "//li[contains(text(), '15 years')]")
    private WebElement amortizationYearsValue;

    @FindBy(xpath = "//div[@class='selectric-scroll'] //ul //li//text()[normalize-space(.)='weekly']/parent::*")
    private WebElement paymentFrequencyValue;

    @FindBy(css = "input[id=MiseDeFond]")
    private WebElement downPaymentTextBox;

    @FindBy(css = "span[id='paiement-resultats']")
    private WebElement weeklyPaymentsLabelResult;

    @FindBy(id = "PrixProprieteMinus")
    private WebElement decreasePurchaceButton;

    public MortgagePaymentCalculatorPage() {
        PageFactory.initElements(driver, this);
        builder = new Actions(driver);
    }

    public WebElement getIncreasePurchaceButton() {
        return this.increasePurchaceButton;
    }

    public WebElement getPurchasePriceSlider() {
        return this.purchasePriceSlider;
    }

    public WebElement getPurchasePriceSliderMovementPoint() {
        return this.purchasePriceSliderMovementPoint;
    }

    public WebElement getAmortizationDropDownList() {
        return this.amortizationDropDownList;
    }

    public WebElement getPaymentFrequencyDropDownList() {
        return this.paymentFrequencyDropDownList;
    }

    public WebElement getInterestRateTextBox() {
        return this.interestRateTextBox;
    }

    public WebElement getCalculateButton() {
        return this.calculateButton;
    }

    public WebElement getSliderSelection(){
        return this.sliderSelection;
    }

    public  WebElement getDownPaymentTextBox(){
        return this.downPaymentTextBox;
    }


    public WebElement getSliderPrixPropriete() {
        return this.sliderPrixPropriete;
    }

    public WebElement getAmortizationYearsValue() {
        return this.amortizationYearsValue;
    }

    public WebElement getPaymentFrequencyValue() {
        return this.paymentFrequencyValue;
    }

    public WebElement getWeeklyPaymentsLabelResult(){return this.weeklyPaymentsLabelResult; }

    public WebElement getDecreasePurchaceButton() {return this.decreasePurchaceButton; }

    public void clickPaymentFrequencyDropDownList(){
        getPaymentFrequencyDropDownList().click();
    }

    public void clickPaymentFrequencyValue() {
        getPaymentFrequencyValue().click();
    }

    public String getPurchasePriceSliderStyleAttribute() {
        String style = this.getPurchasePriceSlider().getAttribute("style");
        return style.substring(style.lastIndexOf("left: ") + "left: ".length(), style.lastIndexOf('%'));
    }

    public String getSliderSelectionWidthPercentage() {
        String style = this.getPurchasePriceSlider().getAttribute("style");
        return style.substring(style.lastIndexOf("width: ") + "width: ".length(), style.lastIndexOf('%'));
    }

    public String getSliderPrixProprieteValue() {
        return this.getSliderPrixPropriete().getAttribute("value");
    }

    public void verifyPurchasePriceSliderMovement() {
        builder.
                clickAndHold(getPurchasePriceSlider()).moveToElement(getPurchasePriceSliderMovementPoint()).click()
                .build().perform();
    }

    public void clickIncreasePurchaceButton() {
        builder.
                click(getIncreasePurchaceButton()).click(getIncreasePurchaceButton()).build().perform();

    }

    public void clickDecreasePurchaceButton() {
        builder.
                click(getDecreasePurchaceButton()).click(getDecreasePurchaceButton()).build().perform();
               // click(getPurchasePriceSlider()).moveToElement(getDecreasePurchaceButton()).doubleClick()
               // .build().perform();
    }

    public void clickAmortizationDropDownList(){
        getAmortizationDropDownList().click();
    }

    public void clickAmortizationYearsValue(){
        getAmortizationYearsValue().click();
    }

    public void checkAmortizationYearsValue(){
        clickAmortizationDropDownList();
        clickAmortizationYearsValue();
    }

    public void checkPaymentFrequencyValue(){
        clickPaymentFrequencyDropDownList();
        clickPaymentFrequencyValue();
    }
    public void inputDownPaymentTextBox(String input) {
        builder.
                click(getDownPaymentTextBox()).sendKeys("50000").sendKeys(Keys.RETURN).build().perform();

    }

    public void inputInterestRateTextBox(){
        builder. doubleClick(getInterestRateTextBox()).sendKeys("5.00").sendKeys(Keys.RETURN).build().perform();
    }

    public void clickCalculateButton(){
        builder.moveToElement(getCalculateButton()).click(getCalculateButton()).sendKeys(Keys.RETURN)
                .build().perform();
    }

    public String getTextWeeklyPaymentsLabelResult(){
        return getWeeklyPaymentsLabelResult().getText();
    }
    //

}
