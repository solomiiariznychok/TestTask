package AtomationTestsUtil.ResourcesUtil;

import java.io.*;
import java.util.Properties;

public class ChromeDriverProperty {

    private final static String CHROME_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";

    public  void loadChromeDriverProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            prop.load(input);
            System.setProperty(CHROME_DRIVER_PROPERTY_NAME, prop.getProperty(CHROME_DRIVER_PROPERTY_NAME));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

