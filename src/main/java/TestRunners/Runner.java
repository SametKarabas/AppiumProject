package TestRunners;


import Utils.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.sql.Driver;

@CucumberOptions(
        features = {"src/test/java/Features"}, // feature yolu verildi
        glue = {"StepDefinitions","Utils"}, // step adımları ve util
        tags = "",
        plugin = {"summary","pretty","html:Reports/CucumberReport/Reports.html"} // raporlamanın oluşturulacagı yer ve görünüm ayarları




)
public class Runner extends AbstractTestNGCucumberTests {
    static AppiumDriver driver = DriverFactory.getDriver(); // driverFacyory ile eşleştirilme yapıldı.
}
