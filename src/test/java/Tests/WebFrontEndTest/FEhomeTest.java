package Tests.WebFrontEndTest;

import Config.ReadProperties;
import Pages.WebFrontEndPage.FEhomePage;
import Utils.WebBasePage;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FEhomeTest extends WebBasePage {
    ReadProperties readProperties = new ReadProperties();
    String frontendCredentials[] = readProperties.getAdminCredentials();
    String frontendUserName = frontendCredentials[0];
    String frontendPassWord = frontendCredentials[1];

    private void openWebFEURL() {
        String urlToOpen = readProperties.getFEUrl();
        common.log("Open the browser and enter URL : " + urlToOpen);
        driver.get(urlToOpen);
    }

    @Test
    public void loginOrSignup() {
        String urlToOpen = readProperties.getFEUrl();
        common.log("Open the browser and enter URL : " + urlToOpen);
        driver.get(urlToOpen);
        common.pause(3);
        fEhomePage.clickOnLogIn();
        fEhomePage.verifyPopupIsVisible();
        fEhomePage.enterEmailAndClickOnContinue(frontendUserName);
        fEhomePage.enterOTPAndVerify(frontendPassWord);
        fEhomePage.approveBrandGuidelines();
        fEhomePage.clickthreeTopic();
    }

    @Test
    public void homeFeedWith5Video() {
        String urlToOpen = readProperties.getFEUrl();
        common.log("Open the browser and enter URL : " + urlToOpen);
        driver.get(urlToOpen);
        fEhomePage.clickOnHomeButton();
        common.pause(10);
        fEhomePage.changeVideoFeedByArrowPress();
        common.pause(10);
    }

    @Test
    public void verifyPopular() {
        common.logPrint("popular click");
        openWebFEURL();
        fEhomePage.clickOnPopular();
    }

    @Test
    public void verifyHeader() {
        common.logPrint("Verify Header is visible");
        openWebFEURL();
        fEhomePage.verifyHeader();
    }

    @Test
    public void verifyDownloadPopup(){
        Reporter.log("Verify Download Popup");
        openWebFEURL();
        fEhomePage.clickOnLogIn();
        fEhomePage.verifyPopupIsVisible();
    }
}