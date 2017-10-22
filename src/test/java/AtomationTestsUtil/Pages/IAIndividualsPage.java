package AtomationTestsUtil.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static AtomationTestsUtil.ApplicationUtil.Application.driver;

public class IAIndividualsPage {

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

    public MortagageProductsPage clickMortagageLink(){
        getMortagageLink().click();
        return new MortagageProductsPage();
    }

}
