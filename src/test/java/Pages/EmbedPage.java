package Pages;

import Utils.Locators;
import Utils.WebCommon;
import org.openqa.selenium.WebDriver;

public class
EmbedPage extends Locators {
    WebCommon common = new WebCommon(driver);

    public String PUBLISH_BRAND_COMMUNITY = "//*[contains(text(),'Publish Brand Community')]";
    public String EMBED_PAGE_MENU = "//a[@href='/grow/on-site']//span[@class='navigation-link-info']//*[name()='svg']";
    public String EMBED_IMPRESSIONS = "//a[contains(text(),'Embed Impressions')]";

    public EmbedPage(WebDriver driver) {
        super(driver);
    }

    public void selectBrand() {
        common.click(SELECT_ANY_BRAND);
        common.log("Select Any brand");
        common.waitUntilSpecificTitle("Dashboard");
        common.assertTwoValuesAreEqual(driver.getTitle(), "Dashboard");
        common.log("Verify that Dashboard page is open ");
    }


    public void verifyEmbedPageElements() {
        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.log("Click on embed page");
        common.click(EMBED_PAGE_MENU);
        common.pause(8);

    }

}