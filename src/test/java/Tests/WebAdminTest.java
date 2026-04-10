//package Tests;
//
//import Pages.LoginPage;
//import Utils.WebBasePage;
//import Utils.WebCommon;
//import org.testng.annotations.Test;
//
//import static Utils.Locators.*;
//
//public class WebAdminTest extends WebBasePage {
//   // WebCommon common = new WebCommon(driver);
//
//
//    @Test
//    public void verify_create_brand_Persona() throws Exception {
//
//        String URL = getPropertyValue("webURL");
//        String username = getPropertyValue("userName");
//        String password = getPropertyValue("password");
//        common.logPrint("Login on Dashboard and create your Brand Persona and verify it");
//        common.logPrint("username : " + username);
//        common.logPrint("password : " + password);
//        driver.get(URL);
//
//
//        webPage.loginToAdmin(username,password);
//        common.assertTwoValuesAreEqual(driver.getTitle(), "Log In");
//
//        webPage.selectBrand();
//        common.waitUntilSpecificTitle("Dashboard");
//        common.assertTwoValuesAreEqual(driver.getTitle(), "Dashboard");
//
//        webPage.createBrandPersona();
//        common.assertElementPresent(MISSION_BRANDPERSONA, "Mission is not visible");
//        common.assertElementPresent(VISION_BRANDPERSONA, "Vision is not present");
//        common.assertElementPresent(VALUE_BRANDPERSONA);
//        common.assertElementPresent(POLICIES_BRANDPERSONA);
//        common.assertElementPresent(PROCEDURES_BRANDPERSONA);
//        common.assertElementPresent(WORKING_CONDITIONS_BRANDPERSONA);
//        common.assertElementPresent(CODE_OF_CONDUCT_BRANDPERSONA);
//        common.assertElementPresent(DO_AS_BRANDPERSONA);
//        common.assertElementPresent(DONT_AS_BRANDPERSONA);
//        common.assertElementPresent(DOCUMENT_BRANDPERSONA);
//
//        //char limit
//        common.assertElementPresent(CHARLIMIT_FOR_MISSION, "Char limit is not 300");
//        common.assertElementPresent(CHARLIMIT_FOR_VISION, "Char limit is not 300");
//        // webPage.test();
//    }
//    public void verify_character_limit_on_mission()throws Exception{
//        String URL = getPropertyValue("webURL");
//        String username = getPropertyValue("userName");
//        String password = getPropertyValue("password");
//        common.logPrint("username : " + username);
//        common.logPrint("password : " + password);
//        driver.get(URL);
//        webPage.loginToAdmin(username,password);
//        common.assertTwoValuesAreEqual(driver.getTitle(), "Log In");
//
//        webPage.selectBrand();
//        common.waitUntilSpecificTitle("Dashboard");
//        common.assertTwoValuesAreEqual(driver.getTitle(), "Dashboard");
//
//        webPage.createBrandPersona();
//        common.assertElementPresent(MISSION_BRANDPERSONA, "Mission is not visible");
//        common.assertElementPresent(CHARLIMIT_FOR_MISSION,"Character limit is not 300");
//
//
//    }
//}
