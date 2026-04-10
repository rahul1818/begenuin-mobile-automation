package Pages;

import Utils.Locators;
import Utils.WebCommon;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.management.monitor.CounterMonitorMBean;
import java.net.URL;

public class WhitelabelSettingPage extends Locators {
    WebCommon common = new WebCommon(driver);

    public String PUBLISH_BRAND_COMMUNITY = "//*[contains(text(),'Publish Brand Community')]";
    public String WHITE_LABEL_SETTINGS = "//*[contains(text(),'White label Settings')]";
    public String SET_WHITE_DOMAIN_LABEL = "//h4[text()='Set up white label domain']";
    public String PRODUCTION_ENV_TITLE = "//h5[text()='For Production Environment']";
    public String WHITE_LABEL_URL_TITLE = "//h6[text()='White Label URL']";
    public String SKIP_FOR_NOW_BUTTON = "//button[text()='Skip for now']";
    public String CONTINUE_BUTTON = "//button[text()='Continue']";
    public String WHITE_LABEL_URL = "//input[@id='label_url']";
    public String SAVE_BUTTON = "//button[@class='btn btn-light-info']";
    public String VERIFICATION_MESSAGE = "//div[text()='Brand white label URL successfully updated for prod environment']";
    public String WHITE_LABEL_URL_QA_ENVIRONMENT = "//input[@id='test_label_url']";
    public String VERIFICATION_MESSAGE_QAENV = "//div[text()='Brand white label URL successfully updated for QA environment']";
    public String WHITELABEL_CONTINUE_BUTTON = "//button[normalize-space()='Continue']";
    public String LIVE_ENVIRONMENT_OPTION = "//label[normalize-space()='Live Environment']";
    public String LIVE_WEB_EMBED = "//button[normalize-space()='Web Embed']";
    public String LIVE_IOS = "//button[normalize-space()='iOS']";
    public String LIVE_ANDROID = "//button[normalize-space()='Android']";


    public WhitelabelSettingPage(WebDriver driver) {
        super(driver);
    }

    public void selectBrand() {
        common.click(SELECT_ANY_BRAND);
        common.log("Select Any brand");
        common.waitUntilSpecificTitle("Dashboard");
        common.assertTwoValuesAreEqual(driver.getTitle(), "Dashboard");
        common.log("Verify that Dashboard page is open ");
    }

    public void verifyWhitelabelSetting() {
//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.waitUntilSpecificTitle("Dashboard");
        common.log("Click on publish brand community");
        common.click(PUBLISH_BRAND_COMMUNITY);
        common.log("Click on label settings");
        common.click(WHITE_LABEL_SETTINGS);

        common.log("Verify white domain label title");
        common.assertElementPresent(SET_WHITE_DOMAIN_LABEL);
        common.assertElementPresent(PRODUCTION_ENV_TITLE);
        common.assertElementPresent(WHITE_LABEL_URL_TITLE);
        common.assertElementPresent(SKIP_FOR_NOW_BUTTON);
        common.assertElementPresent(CONTINUE_BUTTON);

    }

    public void verifyWhitelabelSettingURL() {
//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.waitUntilSpecificTitle("Dashboard");
        common.log("Click on publish brand community");
        common.click(PUBLISH_BRAND_COMMUNITY);
        common.log("Click on label settings");
        common.click(WHITE_LABEL_SETTINGS);
        common.log("enter the whilte label setting url");
        String emailIs = common.generateRandomChars(3) + "gmail.com";
        common.type(WHITE_LABEL_URL, emailIs);
        common.log("click on save button");
        common.click(SAVE_BUTTON);
        common.assertElementPresent(VERIFICATION_MESSAGE);

    }

    public void verifyWhitelabelSettingURLQAENVIRONMENT() {
//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.waitUntilSpecificTitle("Dashboard");
        common.log("Click on publish brand community");
        common.click(PUBLISH_BRAND_COMMUNITY);
        common.log("Click on label settings");
        common.click(WHITE_LABEL_SETTINGS);
        common.log("enter the whilte label setting url");
        String emailIs = common.generateRandomChars(3) + "gmail.com";
        common.type(WHITE_LABEL_URL_QA_ENVIRONMENT, emailIs);
        common.log("click on save button");
        common.click(SAVE_BUTTON);
        common.assertElementPresent(VERIFICATION_MESSAGE_QAENV);
    }
    public void verifyWhitelabelSettingWithLiveEnvironment() {
//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.waitUntilSpecificTitle("Dashboard");
        common.log("Click on publish brand community");
        common.click(PUBLISH_BRAND_COMMUNITY);
        common.log("Click on label settings");
        common.click(WHITE_LABEL_SETTINGS);
        common.log("enter the whilte label setting url");
        String emailIs = common.generateRandomChars(3) + "gmail.com";
        common.type(WHITE_LABEL_URL_QA_ENVIRONMENT, emailIs);
        common.log("click on save button");
        common.click(SAVE_BUTTON);
        common.log("verify the message for QA environment !!");
        common.assertElementPresent(VERIFICATION_MESSAGE_QAENV);

        common.log("click on the continue button");
        common.click(WHITELABEL_CONTINUE_BUTTON);

        common.log("Verifying the live environment option");
        common.assertElementPresent(LIVE_ENVIRONMENT_OPTION);

        common.log("Verifying the code element across the different platforms");
        common.assertElementPresent(LIVE_ANDROID);
        common.assertElementPresent(LIVE_IOS);
        common.assertElementPresent(LIVE_WEB_EMBED);
    }

}