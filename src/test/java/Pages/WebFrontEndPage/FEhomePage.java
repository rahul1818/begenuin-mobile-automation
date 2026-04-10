package Pages.WebFrontEndPage;

import Utils.Locators;
import Utils.WebCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;  // Import the Actions class
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FEhomePage extends Locators {
    WebCommon common = new WebCommon(driver);
    private Actions actions;  // Declare the Actions object

    public FEhomePage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);  // Initialize the Actions object
    }

    public void clickOnPopular() {
        common.click(POPULAR_OPTION);
        common.log("Click on popular button");
    }

    public void verifyHeader() {
        // Use the HEADER_FRONTEND constant from Locators class
        By headerLocator = By.xpath(HEADER_FRONTEND);

        // Wait for the header to be visible using long for timeout (for Selenium 3.x)
        WebDriverWait wait = new WebDriverWait(driver, DRIVER_WAIT);  // DRIVER_WAIT is in seconds as a long
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));

        // Check if the header is displayed
        if (headerElement.isDisplayed()) {
            common.log("Header is visible on the page.");
        } else {
            common.log("Header is not visible on the page.");
        }
    }

    public void verifyPopupIsVisible() {
        // Initialize WebDriverWait with the correct syntax for Selenium 3.x (using long)
        WebDriverWait wait = new WebDriverWait(driver, 10); // Use long for timeout in seconds

        // Define the popup locator
        By popupLocator = By.xpath(POPUP_VISIABLE);

        try {
            // Wait for the popup to become visible
            WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));

            // Verify if the popup is displayed
            if (popupElement.isDisplayed()) {
                common.log("Popup is visible after clicking the Login button.");
            } else {
                common.log("Popup is NOT visible after clicking the Login button.");
            }
        } catch (Exception e) {
            common.log("Error occurred while checking popup visibility: " + e.getMessage());
        }
    }

    public void clickOnHomeButton() {
        common.click(HOME_OPTION);
        common.logPrint("Clicked on Download Button");
    }

    public void clickOnLogIn() {
        common.click((Log_In));
        common.logPrint("Click on login Button");
    }

    public void changeVideoFeedByArrowPress() {
        // Wait for the video feed element to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement videoFeedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_FEED)));

        // Loop to change the video feed 5 times
        for (int i = 0; i < 5; i++) {
            try {
                // Focus on the video feed element to make sure it's active
                actions.moveToElement(videoFeedElement).click().perform();  // Perform the click action
                common.logPrint("Focused on the video feed element.");

                // Simulate pressing the "Arrow Down" key to select the next video
                actions.sendKeys(Keys.ARROW_DOWN).perform();  // Perform the "Arrow Down" action
                common.logPrint("Pressed 'Arrow Down' to move to the next video feed.");

                // Wait for the video feed to change
                wait.until(ExpectedConditions.stalenessOf(videoFeedElement));  // Wait until the element is no longer in the DOM
                videoFeedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_FEED))); // Wait for the element to be updated

                common.log("Video feed updated after pressing Arrow Down.");

                // Optionally, add a delay between key presses to simulate user behavior
                common.pause(3);  // This could be a custom method that waits for 3 seconds

            } catch (Exception e) {
                common.logPrint("Error while changing video feed: " + e.getMessage());
            }
        }
    }

    public void enterEmailAndClickOnContinue(String frontendUserName){
        common.logPrint("Click on email field");
        common.click(EMAIL_FIELD);
        common.logPrint("Enter the email");
        common.type(EMAIL_FIELD, frontendUserName);
        common.logPrint("Enter email:" + frontendUserName);
        common.pause(3);
        common.click(CONTINUE_BUTTON);
        common.logPrint("Click on continue");
    }

    public void enterOTPAndVerify(String frontendPassWord) {
        common.logPrint("Enter in enter otp");
        common.click(ENTER_OTP);
        common.logPrint("Click on OTP");
        common.type(ENTER_OTP, frontendPassWord);
        common.logPrint("Fill otp" + frontendPassWord);
        common.pause(3);
        common.click(VERIFY_BUTTON);
        common.logPrint("Click on verify buttons");
    }

    public void approveBrandGuidelines(){
        common.logPrint("Go to brand guidelines");
        common.click(CheckboxBrandGuidelines);
        common.logPrint("Click on checkbox of brand guidelines");
        common.pause(2);
        common.click(VERIFY_BUTTON);
        common.logPrint("Click on continue button");
    }

    public void clickthreeTopic() {
        common.logPrint("Click three Topic");
        common.click(ClickFirstInterest);
        common.logPrint("Click first topic");
        common.pause(1);
    }

}

