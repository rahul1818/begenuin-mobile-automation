package Tests.WebTest;

import Config.ReadProperties;
import Utils.WebBasePage;
import org.testng.annotations.Test;

public class EngageEngineTest extends WebBasePage {
    ReadProperties readProperties = new ReadProperties();
    String adminCredentials[] = readProperties.getAdminCredentials();
    String username = adminCredentials[0];
    String password = adminCredentials[1];

    private void openWebURLandLogin() {
        String urlToOpen = readProperties.getWebUrl();
        common.log("Open the browser and enter URL : " + urlToOpen);
        driver.get(urlToOpen);
        String xpath = "//span[@title='Shivani Kada']";

        if(!common.existsElement(xpath)) {
            loginPage.loginAsAdmin(username, password);
            dashBoardPage.selectBrand();
//			dashBoardPage.createBrandPersona();
        }
    }

        @Test
        public void UploadVideo() {
            common.logPrint("Video Upload in Engage Engine folder");
            openWebURLandLogin();
            emgageEnginePage.ClickonEngageEngineButton();
            common.pause(2);
            emgageEnginePage.ClickOnImportVideo();
            common.pause(3);
            emgageEnginePage.ClickOnUploadFolderButton();
            common.pause(3);
            emgageEnginePage.ClickONFileUploadButton();
            common.pause(10);
            emgageEnginePage.ClickOnImportButton();
            common.pause(3);
            emgageEnginePage.VerifyMessage();
            common.pause(3);
        }
    }
