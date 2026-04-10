package Tests.WebTest;

import Config.ReadProperties;
import Pages.DashBoardPage;
import Pages.LoginPage;
import Utils.WebBasePage;
import Utils.WebCommon;
import org.testng.annotations.Test;

import static Utils.Locators.*;
import static Utils.Locators.CHARLIMIT_FOR_MISSION;

public class DashBoardTest extends WebBasePage {
	ReadProperties readProperties = new ReadProperties();
	String adminCredentials[] = readProperties.getAdminCredentials();
	String username = adminCredentials[0];
	String password = adminCredentials[1];

	private void openWebURLandLogin() {
		String urlToOpen = readProperties.getWebUrl();
		common.log("Open the browser and enter URL : " + urlToOpen);
		driver.get(urlToOpen);
		String xpath= "//span[@title='Shivani Kada']";

		if(!common.existsElement(xpath)) {
			loginPage.loginAsAdmin(username, password);
			dashBoardPage.selectBrand();
//			dashBoardPage.createBrandPersona();
		}
	}

	@Test
	public void AllBrandElementsPresent() {
		common.logPrint("(TC-1, GEN-1017(BCC), Verify the 'Create your brand persona' tab )");
		openWebURLandLogin();
//		dashBoardPage.selectBrand();
		dashBoardPage.createBrandPersona();
		dashBoardPage.checkAllElementPresent();
	}

	@Test
	public void verifyCharacterLimitOnMission() throws Exception {
		common.logPrint("TC-6, GEN-1017(BCC), Verify the Character limits on the 'Mission' field. ");
		openWebURLandLogin();
//		dashBoardPage.selectBrand();
		dashBoardPage.createBrandPersona();
		dashBoardPage.charLimitMission();

	}

//	@Test
//	public void verifyCharacterLimitOnVision() throws Exception {
//		common.logPrint("TC-7, GEN-1017(BCC), Verify the Character limits on the 'Vision' field. ");
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.createBrandPersona();
//		dashBoardPage.charLimitVision();
//	}
//
//	@Test
//	public void verifyCharacterLimitOnPolicies() throws Exception {
//		common.logPrint("TC-8, GEN-1017(BCC), Verify the Character limits on the 'Policies' field. ");
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.createBrandPersona();
//		dashBoardPage.charLimitPolicies();
//	}
//
//	@Test
//	public void verifyCharacterLimitOnWorkingConditions() throws Exception {
//		common.logPrint("TC-9, GEN-1017(BCC), Verify the Character limits on the 'Working Conditions' field. ");
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.createBrandPersona();
//		dashBoardPage.charLimitWorkingConditions();
//	}
//
//	@Test
//	public void verifyCharacterLimitOfConduct() throws Exception {
//		common.logPrint("TC-10, GEN-1017(BCC), Verify the Character limits on the 'Code of Conduct' field. ");
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.createBrandPersona();
//		dashBoardPage.charLimitCodeOfConduct();
//	}
//
//	@Test
//	public void verifyCharacterLimitOfDoAs() throws Exception {
//		common.logPrint("TC-11, GEN-1017(BCC), Verify the Character limits on the 'Do as' field. ");
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.createBrandPersona();
//		dashBoardPage.charLimitDoAs();
//	}
//
//	@Test
//	public void verifyCharacterLimitOfDontAs() throws Exception {
//		common.logPrint("TC-11, GEN-1017(BCC), Verify the Character limits on the 'Do as' field. ");
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.createBrandPersona();
//		dashBoardPage.charLimitDontAs();
//
//	}
//
//	@Test
//	public void verifyRetailNetworkFunctionality() throws Exception {
//		common.logPrint(
//				("TC-1, GEN-1018(BCC), Verify the Functionality of Brand Type Selection - Retail Network/Marketplace"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.retailNetworkOrmarketPlace();
//		dashBoardPage.verifyOptionsAreDisplayed();
//		dashBoardPage.verifyElementisNotDisabled();
//		// dashBoardPage.verifyRedirectionOnPublishBrandCommunitySection();
//		// common.assertElementPresent(PUBLISH_YOUR_COMMUNITY_TEXT);
//	}
//
//	@Test
//	public void verifyMediaBrandFunctionality() throws Exception {
//		common.logPrint(("TC-2, GEN-1018(BCC), Verify the Functionality of Brand Type Selection - Media"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.verifyOptionsAreDisplayed();
//		dashBoardPage.verifyAlertMessageOnMediaIsDisplayed();
//	}
//
//	@Test
//	public void verifyConsumerBrandFunctionality() throws Exception {
//
//		common.logPrint(("TC-3, GEN-1018(BCC), Verify the Functionality of Brand Type Selection - Consumer"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.verifyOptionsAreDisplayed();
//		dashBoardPage.verifyAlertMessageOnConsumerIsDisplay();
//		// common.assertTwoValuesAreEqual(common.getText(ALERT_MESSAGE),"Sorry, the
//		// Community Media Network for Consumer Brand is still in development. Stay
//		// tuned!");
//	}
//
//	@Test
//	public void verifyFunctionalityOfRetailNetworkTrafficRangeSectionUnder1M() throws Exception {
//
//		common.logPrint(("TC-4, GEN-1018(BCC), Verify the Functionality of Traffic Range Selection - Under 1M"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.retailNetworkOrmarketPlace();
//		dashBoardPage.verifyOptionsAreDisplayed();
//		dashBoardPage.selectUnder1MTrafficRangeOption();
//		// test will be fail due to bug
//		dashBoardPage.verifyTermSheetAndConsumerBrandIsDisabled();
//		dashBoardPage.alertMessageOnRetailNetworkTrafficRangeUnder1M();
//		dashBoardPage.verifyRedirectionOnPublishBrandCommunitySection();
//
//	}
//
//	@Test
//	public void verifyTheFunctionalityOfRetailNetworkTrafficRangeSelection1M_5M() throws Exception {
//
//		common.logPrint(("TC-5, GEN-1018(BCC), Verify the Functionality of Traffic Range Selection - 1M - 5M"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.retailNetworkOrmarketPlace();
//		dashBoardPage.verifyOptionsAreDisplayed();
//		dashBoardPage.select1M_5MTrafficRangeOption();
//		dashBoardPage.verifyElementisNotDisabled();
//		dashBoardPage.verifyContinueButtonEnabled();
//	}
//
//	@Test
//	public void verifyTheFunctionalityOfretailNetworkTrafficrangeSelection5M_10m() throws Exception {
//
//		common.logPrint(("TC-6, GEN-1018(BCC), Verify the Functionality of Traffic Range Selection : 5M - 10M"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.retailNetworkOrmarketPlace();
//		dashBoardPage.verifyOptionsAreDisplayed();
//		dashBoardPage.select5M_10mTrafficRangeOption();
//		dashBoardPage.verifyElementisNotDisabled();
//		dashBoardPage.verifyContinueButtonEnabled();
//	}
//
//	@Test
//	public void verifyTheFunctionalityOfRetailNetworkTrafficRangeSelectionMoreThan10M() {
//
//		common.logPrint(("TC-7, GEN-1018(BCC), Verify the Functionality of Traffic Range Selection More than 10M"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.retailNetworkOrmarketPlace();
//		dashBoardPage.verifyOptionsAreDisplayed();
//		dashBoardPage.selectMoreThan10MTrafficRangeOption();
//		dashBoardPage.verifyElementisNotDisabled();
//		dashBoardPage.verifyContinueButtonEnabled();
//	}
//
//	@Test
//	public void nextSectionRedirection() {
//
//		common.logPrint(("TC-8, GEN-1018(BCC), Verify the Functionality of Switching to Next Section"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.retailNetworkOrmarketPlace();
//		dashBoardPage.verifyOptionsAreDisplayed();
//		dashBoardPage.selectUnder1MTrafficRangeOption();
//		dashBoardPage.verifyTermSheetAndConsumerBrandIsDisabled();
//		dashBoardPage.verifyNextSectionRedirection();
//	}
//
//	@Test
//	public void addConsumerBrandVerification() {
//
//		common.logPrint(("TC-8, GEN-1019(BCC)"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.addConsumerBrand();
//	}
//
//	@Test
//	public void verifyTermSheetElement() {
//		common.logPrint(("TC-1, GEN-1020(BCC), Verify all element present"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.termSheetVerification();
//	}
//
//	@Test
//	public void verifyAddPersonForReview() {
//
//		common.logPrint(("TC-9.1, GEN-1020(BCC), Verify the '+Add Person' button in Add Legal Team for review section "));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.addPersonButtonDisableForReview();
//	}
//
//	@Test
//	public void verifyAddPersonForNotice() {
//
//		common.logPrint(("TC -9.2, GEN-1020(BCC), Verify the '+Add Person' button in Add Notice Team for review section "));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.addPersonButtonDisableForNotice();
//	}
//	@Test
//	public void verifyAddPersonFunctionalityForLegalReview() {
//		common.logPrint(("TC-10, GEN-1020(BCC), Verify the '+Add Person' button functionality for Legal review"));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.addNewFieldForLegalReview();
//	}
//
//	@Test
//	public void VerifyNoticeTeamSection() {
//		common.logPrint(("TC-10, GEN-1020(BCC), Verify the '+Add Person' button functionality for Notice "));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.addTeamMembertoNotice();
//	}
//
//	@Test
//	public void VerifyContactName() {
//		common.logPrint(("TC-2 & 4, GEN-1020(BCC), Verify the \"Contact Name\" in the Primary Contact Details section."));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.verifyContactNameFieldIsRequire();
//	}
//
//	@Test
//	public void VerifyContactEmail() {
//		common.logPrint(("TC-3 & 5, GEN-1020(BCC), Verify the enter the invalid date in the \"Contact Email\" field "));
//		openWebURLandLogin();
////		dashBoardPage.selectBrand();
//		dashBoardPage.launchCommunityMedia();
//		dashBoardPage.verifyContactEmailFieldRequire();
//	}

}
