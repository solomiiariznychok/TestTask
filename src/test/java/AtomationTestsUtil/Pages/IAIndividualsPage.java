package AtomationTestsUtil.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static AtomationTestsUtil.ApplicationUtil.Application.driver;

public class IAIndividualsPage extends StartPage{

    private WebElement LoanTab;
    private WebElement MortagageLink;

    public IAIndividualsPage(WebDriver driver) {
        super(driver);
        this.LoanTab = driver.findElement(By.cssSelector("a[href*='/individuals/pret']"));
        this.MortagageLink = driver.findElement(By.cssSelector("a[data-utag-name='mortgage_loan']"));
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
