package Tests;

import Pages.MobilePage;
import Utils.MobileBasePage;
import Utils.MobileCommon;
import org.testng.annotations.Test;


public class MobileTest extends MobileBasePage {
    MobileCommon common = new MobileCommon();

    @Test
    public void verifyLoginPageElement() throws Exception {
        common.pause(10);
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verifying Elements are present in Login page");
        mobilePage.verifyLoginPageElementsArePresent();
        common.pause(10);
    }
    @Test
    public void verifyWelcomePageInstruction()throws Exception{
        common.pause(10);
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verifying Elements are present on Welcome page");
        mobilePage.welcomePageInstruction();
        common.pause(10);
    }


    @Test
    public void verify_LoginScenariosWithNumber() throws Exception {
        common.pause(10);
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.logInWithPhoneNumber();
        //mobilePage.loginWithEmail_LogOut();
        common.pause(50);
    }

    @Test
    public void verifyLoginScenarioWithEmail() throws Exception{

        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.logInWithEmail();
       // mobilePage.loginWithEmail_LogOut();
        common.pause(50);
    }
    @Test
    public void verifyIconPresentOnHomeScreen() throws Exception {
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.logInWithPhoneNumber();
        mobilePage.verifyElementsArePresent();
       //mobilePage.loginWithEmail_LogOut();
        common.pause(50);
    }
    @Test
    public void verifySignUpScenario() throws Exception {
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.signUpFlow();
        common.pause(50);
    }
    @Test
    public void verifyCommunityCreateWithLoginScenario() throws Exception {
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.createCommunityWithLoginFlow();
    }
    @Test
    public void verifyCreateAutoCommunityScenario()throws Exception{
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.createCommunityAutomatically();
    }
    @Test
    public void verifyCreateLoopScenario()throws Exception{
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.createLoopManually();
    }
    @Test
    public void verifyCreateAutoLoopScenario()throws Exception{
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.createLoopAutomatically();
    }
    @Test
    public void verifyCreateAvatarScenario()throws Exception{
        common.logStepMessage("Application Launch Successfully");
        MobilePage mobilePage = new MobilePage(driver);
        common.logStepMessage("Verify Login page");
        mobilePage.createAvtar();

    }
}

