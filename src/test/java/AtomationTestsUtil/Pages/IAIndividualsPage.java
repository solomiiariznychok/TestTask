package AtomationTestsUtil.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static AtomationTestsUtil.ApplicationUtil.Application.driver;

public class IAIndividualsPage extends TopPage{

    @FindBy(css = "a[href*='/individuals/pret']")
    private WebElement LoanTab;

    @FindBy(css = "a[data-utag-name='mortgage_loan']")
    private WebElement MortagageLink;

    public IAIndividualsPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoanTab() {
        return this.LoanTab;
    }

    public void clickLoanTab() {
        getLoanTab().click();
    }

    public WebElement getMortagageLink() {
        return this.MortagageLink;
    }

    public MortgageProductsPage clickMortagageLink(){
        getMortagageLink().click();
        return new MortgageProductsPage();
    }

}
