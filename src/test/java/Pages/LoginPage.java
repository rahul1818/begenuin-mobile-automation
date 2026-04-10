package Pages;

import Utils.*;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Locators {

	WebCommon common = new WebCommon(driver);

	public LoginPage(WebDriver driver) {
		super(driver);
		// dashBoardPage = new DashBoardPage(this.driver);
	}

	public void loginAsAdmin(String uName, String pWord) {
		common.log("Login on Dashboard");
		common.type(usernameLogin, uName);
		common.type(passLogin, pWord);
		common.click(loginBtn);
		common.assertTwoValuesAreEqual(driver.getTitle(), "Log In");
	}
}
