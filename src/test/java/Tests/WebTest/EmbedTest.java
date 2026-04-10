package Tests.WebTest;

import Config.ReadProperties;
import Pages.EmbedPage;
import Pages.WhitelabelSettingPage;
import Utils.WebBasePage;
import Utils.WebCommon;
import org.testng.annotations.Test;

public class EmbedTest extends WebBasePage {
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
	public void verifyEmbedPage() {
		common.logPrint("(TC-1, GEN-1457(BCC), verify the embed page");
		openWebURLandLogin();
		EmbedPage embedPage = new EmbedPage(driver);
		common.log("click on the manage page");
		embedPage.verifyEmbedPageElements();
	}

}
