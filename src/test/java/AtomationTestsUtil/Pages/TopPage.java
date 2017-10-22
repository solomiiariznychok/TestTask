package AtomationTestsUtil.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TopPage {

        public static enum ChangeLanguageFields {
            FRENCH("FR"),
            ENGLISH("EN");
            //
            private String field;

            private ChangeLanguageFields(String field) {
                this.field = field;
            }

            @Override
            public String toString() {
                return this.field;
            }
        }

        protected WebDriver driver;

        private Select changeLanguage;

        public TopPage(WebDriver driver) {
            this.driver = driver;
            this.changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
        }


        public Select getChangeLanguage() {
            return this.changeLanguage;
        }

        public String getChangeLanguageSelectedText() {
            return this.changeLanguage.getFirstSelectedOption().getText();
        }

        public void setChangeLanguage(ChangeLanguageFields language) {
            getChangeLanguage().selectByVisibleText(language.toString());
        }

    }
