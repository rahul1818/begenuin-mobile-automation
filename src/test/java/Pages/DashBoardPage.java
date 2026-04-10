package Pages;

import Utils.Locators;
import Utils.WebCommon;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class DashBoardPage extends Locators {
	WebCommon common = new WebCommon(driver);

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}

	public void selectBrand() {
		common.click(SELECT_ANY_BRAND);
		common.log("Select Any brand");
		common.waitUntilSpecificTitle("Dashboard");
		common.assertTwoValuesAreEqual(driver.getTitle(), "Dashboard");
		common.log("Verify that Dashboard page is open ");
	}

	public void createBrandPersona() {
		common.click(DASHBOARD_SCREEN);
		common.log("Click on Dashboard");
		common.click(ADD_BRAND_ELEMENT);
		common.log("Click on Add Brand Elements");
		common.click(BRAND_PERSONA);
		common.log("Click on Brand Persona");
	}

	public void checkAllElementPresent() {
		common.pause(4);
		common.assertElementPresent(MISSION_BRANDPERSONA, "Mission is not visible");
		common.log(" Verify Mission Element is present");
		common.assertElementPresent(VISION_BRANDPERSONA, "Vision is not present");
		common.log(" Verify Vision Element is present");
		common.assertElementPresent(VALUE_BRANDPERSONA);
		common.log(" Verify Value element is present");
		common.assertElementPresent(POLICIES_BRANDPERSONA);
		common.log(" Verify Policies element is present");
		common.assertElementPresent(PROCEDURES_BRANDPERSONA);
		common.log(" Verify Procedures element is present");
		common.assertElementPresent(WORKING_CONDITIONS_BRANDPERSONA);
		common.log(" Verify Working conditions element is present");
		common.assertElementPresent(CODE_OF_CONDUCT_BRANDPERSONA);
		common.log(" Verify Code of conduct element is present");
		common.assertElementPresent(DO_AS_BRANDPERSONA);
		common.log(" Verify DO'S element is present");
		common.assertElementPresent(DONT_AS_BRANDPERSONA);
		common.log(" Verify Dont's element is present");
		common.assertElementPresent(DOCUMENT_BRANDPERSONA);
		common.log(" Verify Document element is present");
	}

	public void emptyAllFieldsBrandPersona() {
		common.clear(MISSION_FIELD);
		common.clear(VISION_FIELD);
		// common.click(VALUES_FIELD);
		common.clear(POLICIES_FIELD);
		common.clear(PROCEDURE_FIELD);
		common.clear(WORKING_CONDITIONS_FIELD);
		common.clear(CODE_OF_CONDUCT_FIELD);
		common.clear(DO_AS_FIELDS);
		common.clear(DONT_AS_FIELD);
		common.clear(DOCUMENT_FIELD);
	}

	public void clickOnRemoveTag() {
		common.pause(50);
		// common.waitUntilElementToBeClickable(By.xpath(VALUES_FIELD));
		common.click(VALUES_FIELD);
		common.log("click on Value");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.BACK_SPACE).perform();
		for (int i = 0; i < 7; i++) {
			common.clear(VALUES_FIELD);
		}
	}

	public void charLimitMission() {
		common.pause(3);
		common.assertElementPresent(CHARLIMIT_FOR_MISSION, "Character limit is not 300");
		common.log("verify Character limit of MISSION");
	}

	public void charLimitVision() {
		common.pause(3);
		common.assertElementPresent(CHARLIMIT_FOR_VISION, "Character limit is not 300");
		common.log("verify Character limit of VSION");
	}

	public void charLimitPolicies() {
		common.pause(5);
		common.assertElementPresent(CHARLIMIT_FOR_POLICIES, "Character limit is not 1000");
		common.log("verify Character limit of Policies");
	}

	public void charLimitWorkingConditions() {
		common.pause(3);
		common.assertElementPresent(CHARLIMIT_FOR_WORKING_CONDITIONS, "Character limit is not 500");
		common.log("verify Character limit of Working Conditions");
	}

	public void charLimitCodeOfConduct() {
		common.pause(3);
		common.assertElementPresent(CHARLIMIT_FOR_CODE_OF_CONDUCT, "Character limit is not 1000");
		common.log("verify Character limit of Code of Conduct");
	}

	public void charLimitDoAs() {
		common.pause(3);
		common.assertElementPresent(CHARLIMIT_FOR_DO_AS, "Character limit is not 1000");
		common.log("verify Character limit of Do's");
	}

	public void charLimitDontAs() {
		common.pause(5);
		common.assertElementPresent(CHARLIMIT_FOR_DONT_AS, "Character limit is not 1000");
		common.log("verify Character limit of Dont's");
	}

	public void launchCommunityMedia() {
		common.click(DASHBOARD_SCREEN);
		common.log("Click on Dashboard");
		common.click(LAUNCH_COMMUNITY_MEDIA_NETWORK);
		common.log("Click on community media network");
		common.click(BRAND_TYPE);
	}

	public void retailNetworkOrmarketPlace() {
		common.click(RETAIL_NETWORK_OR_MARKET_PLACE);
		common.log("Click on Retail Network/Market Place");
	}

	public void verifyElementisNotDisabled() {
		common.isElementEnabled(TERMS_SHEET);
		common.log("Term Sheet is enabled");
		common.isElementEnabled(CONSUMER_BRANDS);
		common.log("Consumer is enabled");
	}

	public void verifyOptionsAreDisplayed() {
		common.pause(3);
		common.isElementDisplayed(OPTIONS_TRAFFIC_RANGE);
		common.log("Option Traffic range is displayed");
	}

	public void verifyRedirectionOnPublishBrandCommunitySection() {
		common.pause(3);
		common.click(NETWORK_OR_MARKET_PLACE_CONTINUE_BUTTON);
		common.log("Click on Continue");
		common.log("Redirect on publish your community");

		common.assertTwoValuesAreEqual(common.getText(PUBLISH_YOUR_COMMUNITY_TEXT), "Publish your community");
		common.log("Verify Text: Publish your community");
	}

	public void alertMessageOnRetailNetworkTrafficRangeUnder1M() {
		common.pause(3);
		common.assertTwoValuesAreEqual(common.getText(ALERT_MESSAGE),
				"We're sorry, but you can't launch a Community Media Network due to traffic being under 1M. However, you can still create and publish your brand community.");
		common.log(
				"Verify Alert message : We're sorry, but you can't launch a Community Media Network due to traffic being under 1M. However, you can still create and publish your brand community.");
	}

	public void verifyAlertMessageOnMediaIsDisplayed() {
		common.pause(3);
		common.click(BRAND_TYPE_MEDIA);
		common.log("click on Media");
		common.click(SELECT_BRAND_TRAFFIC_UNDER_1M);
		common.log("Select traffic range option : Under_1M");

		common.assertTwoValuesAreEqual(common.getText(ALERT_MESSAGE),
				"Sorry, the Community Media Network for Media Brand is still in development. Stay tuned!");
		common.log(
				"Verify alert message is display : Sorry, the Community Media Network for Media Brand is still in development. Stay tuned!");
	}

	public void verifyAlertMessageOnConsumerIsDisplay() {
		common.pause(3);
		common.click(BRAND_TYPE_CONSUMER);
		common.log("Click on Consumer");
		common.click(SELECT_BRAND_TRAFFIC_UNDER_1M);
		common.log("Select Traffic range option : Under 1M");

		common.assertTwoValuesAreEqual(common.getText(ALERT_MESSAGE),
				"Sorry, the Community Media Network for Consumer Brand is still in development. Stay tuned!");
		common.log(
				"Verify alert message is display : Sorry, the Community Media Network for Consumer Brand is still in development. Stay tuned!");
	}

	public void verifyTermSheetAndConsumerBrandIsDisabled() {
		common.pause(3);
		common.isElementDisabled(TERM_SHEET_DISABLED);
		common.log("Verify that Term Sheet is Disabled");
		common.isElementDisabled(CONSUMER_BRANDS_DISABLED);
		common.log("Verify that Consumer Brand is Disabled");
	}

	public void selectUnder1MTrafficRangeOption() {
		common.pause(3);
		common.click(SELECT_BRAND_TRAFFIC_UNDER_1M);
		common.log("Select Traffic range option : Under 1M");
	}

	public void select1M_5MTrafficRangeOption() {
		common.pause(3);
		common.click(SELECT_BRAND_TRAFFIC_1M_5M);
		common.log("Select Traffic range option : 1M-5M");
	}

	public void verifyContinueButtonEnabled() {
		common.pause(3);
		common.isElementEnabled(NETWORK_OR_MARKET_PLACE_CONTINUE_BUTTON);
		common.log("Verify that Continue button is Enable");
	}

	public void select5M_10mTrafficRangeOption() {
		common.pause(3);
		common.click(SELECT_BRAND_TRAFFIC_5M_10M);
		common.log("Select traffic range option : 5M-10M");
	}

	public void selectMoreThan10MTrafficRangeOption() {
		common.pause(3);
		common.click(SELECT_BRAND_TRAFFIC_MORE_THAN_10M);
		common.log("Select traffic range option : More than 10M");
	}

	public void verifyNextSectionRedirection() {
		common.pause(3);
		common.click(NEXT_SECTION_CONSUMER_BRANDS);
		common.log("click on Consumer");
		common.assertTwoValuesAreEqual(common.getText(TITLE_CONSUMER_BRAND), "Add consumer brands to your network");
		common.log("Verify the title of Consumer : Add consumer brands to your network");
	}

	public void addConsumerBrand() {
		common.pause(3);
		common.click(CONSUMER_BRANDS);
		common.log("Click on Consumer");
		common.click(ADD_CONSUMER_BRAND_BUTTON);
		common.log("Click on Add Consumer button");
		common.type(BRAND_USERNAME_CONSUMER_BRAND, "Test");
		common.log("Enter a username : Test");
		common.pause(5);
		common.click(PUMA_SPORT_BRAND);
		common.log("Select brand from suggestion");
		common.pause(5);
		common.clear(CPM_FLOOR_PRICE);
		common.type(CPM_FLOOR_PRICE, "78");
		common.log("enter CPM price : 78");
		common.type(YOUTUBE_HANDLE, "youtube");
		common.log("Enter a handle name : youtube");
		common.pause(3);
		common.click(ADD_BUTTON);
		common.log("Click on Add button");
	}

	public void termSheetVerification() {
		common.pause(3);
		common.click(TERMS_SHEET);
		common.log("Click on Term Sheet");
		common.assertElementPresent(PRIMARY_CONTACT_TERM_SHEET);
		common.log("Verify that 'Primary Contact' is displayed");
		common.assertElementPresent(FULL_NAME);
		common.log("Verify that 'Full Name' is displayed");
		common.assertElementPresent(CONTACT_EMAIL);
		common.log("Verify that 'Contact Email' is displayed");
		common.assertElementPresent(LEGAL_TEAM_ADD_PERSON_BUTTON);
		common.log("Verify that 'Add Person button' is displayed in 'Legal term field'");
		common.assertElementPresent(LEGAL_TEAM_FOR_REVIEW);
		common.log("verify that 'Legal team for review' is displayed");
		common.assertElementPresent(PERSON_1_NAME_FOR_LEGAL_TEAM_REVIEW);
		common.log("verify that 'Person 1- Name' is displayed");
		common.assertElementPresent(PERSON_1_EMAIL_FOR_LEGAL_TEAM_REVIEW);
		common.log("verify that 'Person 1 - Email' is displayed");
		common.assertElementPresent(TEAM_MEMBERS_FOR_NOTICE);
		common.log("verify that 'Team Member for Notice' is displayed");
		common.assertElementPresent(ADD_A_PERSON_BUTTON_TEAM_MEMBER);
		common.log("verify that 'Add a Person button' is displayed");
		common.assertElementPresent(PERSON_1_NAME_FOR_NOTICE_TEAM);
		common.log("verify that 'Person 1 - Name for Notice Team' is displayed");
		common.assertElementPresent(PERSON_1_EMAIL_FOR_NOTICE_TEAM);
		common.log("verify that 'Person 1 - Email for Notice' is displayed");
		common.assertElementPresent(SKIP_BUTTON);
		common.log("verify that 'Skip Button' is displayed");
		common.assertElementPresent(CONTINUE_TERM_SHEET);
		common.log("verify that 'Continue' is displayed");
	}

	public void verifyValidationMessage() {
		common.click(TERMS_SHEET);
		common.log("Click on Term sheet");
		String s = common.generateRandomChars(6);
		common.type(FULL_NAME, s);
		common.log("Enter a Full Name" + s);
		String email = common.generateRandomChars(5) + "@" + common.generateRandomChars(4) + ".com";
		common.type(CONTACT_EMAIL, email);
		common.log("Type email address on email field" + email);
		common.click(CONTINUE_TERM_SHEET);
		common.log("Click on Term sheet");
		common.assertTwoValuesAreEqual(common.getText(TITLE_CONSUMER_BRAND), "Oops, something went wrong!");
		common.log("Verify message : Oops, something went wrong!");
	}

	public void addPersonButtonDisableForReview() {
		common.click(TERMS_SHEET);
		common.log("Click on terms Sheet");
		common.isElementDisabled(LEGAL_TEAM_ADD_PERSON_BUTTON);
		common.log("Verify Add person button is disabled");
	}

	public void addPersonButtonDisableForNotice() {
		common.click(TERMS_SHEET);
		common.log("Click on Terms sheet");
		common.isElementDisabled(ADD_A_PERSON_BUTTON_TEAM_MEMBER);
		common.log("Verify that Add person button is disabled");
	}

	public void addNewFieldForLegalReview() {
		common.click(TERMS_SHEET);
		common.log("Click on term sheet");
		String s = common.generateRandomChars(6);
		common.type(PERSON_1_NAME_FOR_LEGAL_TEAM_REVIEW, s);
		common.log("Enter Name for Person-1 : " + s);
		String email = common.generateRandomChars(5) + "@" + common.generateRandomChars(4) + ".com";
		common.type(PERSON_1_EMAIL_FOR_LEGAL_TEAM_REVIEW, email);
		common.log("Enter an Email address for Person 1 : " + email);
		common.pause(3);
		common.click(LEGAL_TEAM_ADD_PERSON_BUTTON);
		common.log("Click on Add person ");
		common.assertElementPresent(PERSON_2_LEGAL_TEAM);
		common.log("Verify that Person 2 is Present ");
	}

	public void addTeamMembertoNotice() {
		common.pause(3);
		common.click(TERMS_SHEET);
		common.log("Click on Terms Sheet");
		String s = common.generateRandomChars(6);
		common.type(PERSON_1_NAME_FOR_NOTICE_TEAM, s);
		common.log("Enter a name : " + s);
		String email = common.generateRandomChars(5) + "@" + common.generateRandomChars(4) + ".com";
		common.type(PERSON_1_EMAIL_FOR_NOTICE_TEAM, email);
		common.log("Enter an EMail address: " + email);
		common.pause(2);
		common.click(NOTICE_TEAM_ADD_PERSON_BUTTON_CLICKBLE);
		common.log("Click on Add Person");
		common.assertElementPresent(PERSON_2_NOTICE_TEAM);
		common.log("Verify that Person 2 is present");
	}

	public void verifyContactNameFieldIsRequire() {
		common.click(TERMS_SHEET);
		common.log("Click on Term Sheet");
		common.click(FULL_NAME);
		common.log("Click on Full Name");
		common.click(CONTACT_EMAIL);
		common.log("Click on Email");
		common.assertElementPresent(VALIDATIONMESSAGEFORCONTACTNAME, "Enter your name");
		common.log("Verify validation message is Displayed: Enter your name");
	}

	public void verifyContactEmailFieldRequire() {
		common.click(TERMS_SHEET);
		common.log("Click on Term sheet");
		common.click(CONTACT_EMAIL);
		common.log("Click on Email");
		common.click(FULL_NAME);
		common.log("Click on name");
		common.assertElementPresent(VALIDATIONMESSAGEFORCONTACTEMAIL, "Enter your Email");
		common.log("Verify validation message is Displayed: Enter your Email");
	}
}