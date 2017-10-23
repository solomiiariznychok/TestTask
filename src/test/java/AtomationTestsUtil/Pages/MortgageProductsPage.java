package AtomationTestsUtil.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static AtomationTestsUtil.ApplicationUtil.Application.driver;

public class MortgageProductsPage extends TopPage{

    @FindBy(xpath = "//a[text()='Calculate your payments']")
    WebElement calculatePaymentsButton;

    public MortgageProductsPage() {
        PageFactory.initElements(driver, this);

    }

    public WebElement getCalculatePaymentsButton() {
        return this.calculatePaymentsButton;
    }

    public MortgagePaymentCalculatorPage clickCalculatePaymentButton() {
        getCalculatePaymentsButton().click();
        return new MortgagePaymentCalculatorPage();
    }
}
