package Utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Reporter;


import java.util.Properties;

public class Hooks {
    // Before Ve After işlemleri

    AppiumDriver driver;
    Properties properties;

    @Before
    public void before(){
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        // Üstte paralel xml üzerinde browser ı çalıştırmamız için adımlar yapıldı.
        properties = ConfigReader.initializeProperties();
        driver = DriverFactory.initializeDriver(browser);
    }

    @After
    public void after(){
        driver.quit();
    }

}
