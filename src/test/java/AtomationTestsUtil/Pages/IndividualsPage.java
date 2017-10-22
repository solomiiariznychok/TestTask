package AtomationTestsUtil.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static AtomationTestsUtil.ApplicationUtil.Application.driver;

public class IndividualsPage {

    private WebElement LoanTab;

    public IndividualsPage() {

        this.LoanTab = driver.findElement(By.cssSelector(".dropdown-toggle.nav-mfocus"));
    }

    public WebElement getLoanTab() {
        return this.LoanTab;
    }

    public LoansTabBox clickLoanTab() {
        getLoanTab().click();
         return new LoansTabBox();
    }
}
