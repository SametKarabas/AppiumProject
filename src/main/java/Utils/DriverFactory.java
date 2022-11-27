package Utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    // Gerekli driver işlemleri ve bekleme işlemleri yapıldı.
    static AppiumDriver driver;
    static Properties properties;
    static DesiredCapabilities capabilities;

    public static AppiumDriver initializeDriver(String browser){
        properties=ConfigReader.getProperties();
        capabilities=new DesiredCapabilities();
        // Android ve IOS için farklı çalıştıma fonksiyonu oluşturuldu.
        if (browser.equals("Android")){
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("udid","");
            capabilities.setCapability("appPackage","");
            capabilities.setCapability("appActivity","");
        } else if (browser.equals("IOS")) {
            capabilities.setCapability("platformName","IOS");
            capabilities.setCapability("udid","");
            capabilities.setCapability("appPackage","");
            capabilities.setCapability("appActivity","");
        }
        // Appium port ayarları ve wait fonsiyonları ayarlandı
        try {
            driver=new AppiumDriver(new URL("https://0.0.0.0:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        int impWait=Integer.parseInt(properties.getProperty("implicityWait"));
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        return getDriver();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
