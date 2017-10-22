package AtomationTestsUtil.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static AtomationTestsUtil.ApplicationUtil.Application.driver;

public class MortagageProductsPage {

    WebElement calculatePaymentsButton;

    public MortagageProductsPage() {

        this.calculatePaymentsButton = driver.findElement(By.xpath("//a[text()='Calculate your payments']"));

    }

    public WebElement getCalculatePaymentsButton() {
        return this.calculatePaymentsButton;
    }

    public MortgagePaymentCalculatorPage clickCalculatePaymentButton() {
        getCalculatePaymentsButton().click();
        return new MortgagePaymentCalculatorPage();
    }
}
