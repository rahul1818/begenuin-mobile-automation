package Tests.WebTest;

import Config.ReadProperties;
import Pages.ManagePage;
import Utils.WebBasePage;
import Utils.WebCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ManageTest extends WebBasePage {
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
	public void verifyMangePage() {
		common.logPrint("(TC-1, GEN-1451(BCC), verify the manage page");
		openWebURLandLogin();
		managePage.verifyMangePage();
	}
	@Test
	public void createNewCommunity() {
		common.logPrint("(TC-2, GEN-1451(BCC), To verify the community records by mouse hovering on the created record");
		openWebURLandLogin();
		managePage.communityCreation();
	}
	@Test
	public void updateCommunity() {
		common.logPrint("GEN-1451(BCC), To verify the update community functionality");
		openWebURLandLogin();
		managePage.updateCommnunity();
	}
	@Test
	public void verifyCommunityDetails() {
		common.logPrint("GEN-1451(BCC), Community details section verificaion");
		openWebURLandLogin();
		managePage.communityDetailsSection();
	}
	@Test
	public void verifyUsersTest() {
		common.logPrint("(TC-01, GEN-1454(BCC), verify the users test");
		openWebURLandLogin();
		managePage.checkUsersTab();
	}
	@Test
	public void verifyAllUsersPageTest() {
		common.logPrint("(TC-02, GEN-1454(BCC), verify the all users page test");
		openWebURLandLogin();
		managePage.checkAllUsersTab();
	}
	@Test
	public void columnDetailsTest() {
		common.logPrint("(TC-03, GEN-1454(BCC), To verify all column details");
		openWebURLandLogin();
		managePage.checkAllTableDetails();
	}
	@Test
	public void verifyViewShareFunctionality() {
		common.logPrint("(TC-04, GEN-1454(BCC), To verify View/Share functionality");
		openWebURLandLogin();
		managePage.checkViewandShareOptions();
	}
}
