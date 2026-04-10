package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;



public class MobileBasePage {

    public AppiumDriver driver = null;

     MobileCommon common = new MobileCommon();

    @BeforeMethod(alwaysRun = true)
    public void init() {
        // DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("appium:platformName", "android");
//        capabilities.setCapability("appium:platformVersion", "10");
//        capabilities.setCapability("appium:deviceName", "ZF622457H6");
//        capabilities.setCapability("appium:autoGrantPermissions", true);
//        capabilities.setCapability("appium:autoAcceptAlerts", false);
//        capabilities.setCapability("appium:app","C:/Projects/EpifiDemo/apk/instagram.apk");
//        capabilities.setCapability("appium:appPackage", "com.instagram.android");
//        capabilities.setCapability("appium:appActivity", "com.instagram.nux.activity.BloksSignedOutFragmentActivity") ;
//        capabilities.setCapability("appium:noReset", true);
//        capabilities.setCapability("appium:full-reset", false);
//        System.out.println("----------------" + "platformName");

        Properties config = common.readConfigFile("runConfig");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", config.getProperty("platformName"));
        capabilities.setCapability("appium:platformVersion", config.getProperty("platformVersion"));
        capabilities.setCapability("appium:deviceName", config.getProperty("deviceName"));
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:autoAcceptAlerts", false);
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + config.getProperty("appPath"));
    //    capabilities.setCapability("appium:appPackage", config.getProperty("appPackage"));
   //     capabilities.setCapability("appium:appActivity", config.getProperty("appActivity"));
        capabilities.setCapability("appium:noReset", true);
        capabilities.setCapability("appium:full-reset", false);
        System.out.println("----------------" + config.getProperty("platformName"));

        if (config.getProperty("platformName").equals("android")) {

            try {
                driver = new AndroidDriver(new URL(config.getProperty("server")), capabilities);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) throws IOException, AWTException {
        driver.resetApp();
        driver.quit();
    }
}