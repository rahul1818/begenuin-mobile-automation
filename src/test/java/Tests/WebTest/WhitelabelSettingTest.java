package Tests.WebTest;

import Config.ReadProperties;
import Pages.WhitelabelSettingPage;
import Utils.WebBasePage;
import Utils.WebCommon;
import org.testng.annotations.Test;

public class WhitelabelSettingTest extends WebBasePage {
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
		}
	}

	@Test
	public void verifyWhiteLabelSetting() {

		common.logPrint("(TC-1, GEN-1456(BCC), Verify white label setting page");
		openWebURLandLogin();
		whitelabelSettingPage.verifyWhitelabelSetting();

	}

	@Test
	public void verifyWhiteLabelSettingURL() {

		common.logPrint("(TC-2, GEN-1456(BCC), Verify white label setting URL functionality");
		openWebURLandLogin();
		whitelabelSettingPage.verifyWhitelabelSettingURL();

	}

	@Test
	public void verifyWhiteLabelSettingURLForQAEnvironment() {

		common.logPrint("(TC-3, GEN-1456(BCC), Verify the white label settings page after entering the URL in the 'White label URL for QA Environment' field");
		openWebURLandLogin();
		whitelabelSettingPage.verifyWhitelabelSettingURLQAENVIRONMENT();

	}

	@Test
	public void verifyWhiteLabelSettingWithLiveEnvironment() {

		common.logPrint("GEN-1456(BCC), Verify white label setting URL functionality for Live");
		openWebURLandLogin();
		whitelabelSettingPage.verifyWhitelabelSettingWithLiveEnvironment();
	}

}
