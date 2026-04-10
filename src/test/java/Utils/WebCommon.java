package Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Define Common Webdriver
 *
 * @author Rahul
 */
public class WebCommon extends Locators {

	Date date = new Date();
	protected Wait<WebDriver> wait;
	DataFormatter formatter = new DataFormatter();
	public XSSFSheet ExcelWSheet;
	public XSSFWorkbook ExcelWBook;
	public XSSFCell Cell;
	public XSSFRow Row;
	long dataPage;
	private WebBasePage BasePage;

	public WebCommon(WebDriver driver) {

		super(driver);
	}

	public WebDriverWait getWait() {
		// Set time in second to wait for elements
		return new WebDriverWait(driver, 20);
	}

	public WebElement waitUntilElementToBeClickable(By by) {

		try {
			return getWait().ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(by));

		} catch (StaleElementReferenceException e) {
			return getWait().ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(by));
		}

	}

	public WebElement waitUntilElementToBeClickable(WebElement element) {
		try {
			return getWait().ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));
		} catch (StaleElementReferenceException e) {
			return getWait().ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));
		}
	}

	public WebElement waitUntilElementToBeVisible(WebElement element) {
		return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitUntilElementToBeVisible(By by) {

		try {
			return getWait().ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(by));

		} catch (StaleElementReferenceException e) {
			return getWait().ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}

	}

	public WebElement waitUntilPresenceOfElementLocated(By by) {
		return getWait().ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public List<WebElement> waitUntilElementsToBeVisible(By by) {
		return getWait().ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	public List<WebElement> waitUntilElementsToBeVisible(List<WebElement> elements) {
		return getWait().ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitUntilFrameToBeAvailableAndSwitchToIt(WebElement element) {
		getWait().ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void waitUntilFrameToBeAvailableAndSwitchToIt(String locator) {
		getWait().ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitUntilFrameToBeAvailableAndSwitchToIt(int index) {
		getWait().ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public void waitUntilAlertIsPresent() {
		getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.alertIsPresent());
	}

	public void takeSnapShot(WebDriver webdriver, String screenshotName) throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		// Copy file at destination
		String nameWithExtention = screenshotName + ".png";
		/* Copy screenshot to specific folder */
		try {
			String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator + "chrome"
					+ File.separator;
			String screenshotsFolder = "screenshots";
			File screenshotFolder = new File(reportFolder + screenshotsFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			File DestFile = new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile();
			FileUtils.copyFile(SrcFile, DestFile);
			Reporter.log("<a href='" + DestFile.getAbsolutePath() + "'> <img src='" + DestFile.getAbsolutePath()
					+ "' height='250' width='500'/> </a>");
//			FileUtils.copyFile(screenshot,
//					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			Reporter.log("Failed to capture screenshot: " + e.getMessage());
		}

	}

	/**
	 * Accept present alert.
	 *
	 * @return Text on alert
	 *
	 */
	public String acceptAlert() {
		String alerttext = null;
		waitUntilAlertIsPresent();
		Alert alert = this.driver.switchTo().alert();
		alerttext = alert.getText();
		alert.accept();
		pause(1);
		return alerttext;
	}

	/**
	 * Check alert is present or not and accept it if present.
	 *
	 * @return Text on alert if present, otherwise null
	 *
	 */
	public String handleAlert() {
		String strAltert = null;
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			strAltert = alert.getText();
			alert.accept();
			pause(1);
		}
		return strAltert;
	}

	/**
	 * Check alert is present or not.
	 *
	 * @return True if alert present, otherwise false
	 *
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	/**
	 * Dismiss present alert.
	 *
	 * @return Text on alert
	 *
	 */
	public String dismissAlert() {
		waitUntilAlertIsPresent();
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		alert.dismiss();
		return alerttext;
	}

	/**
	 * Get current date in MM/dd/yyyy format.
	 *
	 * @return Current date in MM/dd/yyyy format
	 * @throws ParseException
	 *
	 */
	public String currentDate() throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateformatMMddyyyy = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
		String currentdate = dateformatMMddyyyy.format(dateNow);
		return currentdate;
	}

	/**
	 * Get current time in hh:mm a format.
	 *
	 * @return Current time in hh:mm a format
	 * @throws ParseException
	 *
	 */
	public String currentTime() throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		String currenttime = dateFormat.format(dateNow).toString();
		return currenttime;
	}

	/**
	 * Get current time + 5 min in hh:mm a format.
	 *
	 * @return Current time in hh:mm a format
	 * @throws ParseException
	 *
	 */
	public String currentTimePlusSpecifiedMinustes(int minutes) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		Calendar cal = Calendar.getInstance(); // Get Calendar Instance
		cal.add(Calendar.MINUTE, minutes);
		String currenttime = dateFormat.format(cal.getTime()).toString();
		return currenttime;
	}

	/**
	 * Get tomorrow's date in MM/dd/yyyy format.
	 *
	 * @return tomorrow's date in MM/dd/yyyy format
	 * @throws ParseException
	 *
	 */
	public String tomorrowDate() throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateformatMMddyyyy = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
		String date_to_string = dateformatMMddyyyy.format(dateNow);
		String untildate = date_to_string;// Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance(); // Get Calendar Instance
		cal.setTime(dateFormat.parse(untildate));
		// Tomorrow's Date
		cal.add(Calendar.DATE, 1); // Date Increase by One
		String tomorrowdate = dateFormat.format(cal.getTime());
		return tomorrowdate;
	}

	/**
	 * Get future date in MM/dd/yyyy format as per argument.
	 *
	 * @param days the days to get future date
	 * @return Future date in MM/dd/yyyy format after given days from current date
	 * @throws ParseException
	 *
	 */
	public String FutureDate(int days) throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
		String date_to_string = dateformatyyyyMMdd.format(dateNow);
		String untildate = date_to_string;// Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance(); // Get Calendar Instance
		cal.setTime(dateFormat.parse(untildate));
		// Future Date
		cal.add(Calendar.DATE, days);
		String futuredate = dateFormat.format(cal.getTime());
		return futuredate;
	}

	/**
	 * Get past date in MM/dd/yyyy format as per argument.
	 *
	 * @param days the days to get past date
	 * @return Past date in MM/dd/yyyy format before given days from current date
	 * @throws ParseException
	 *
	 */
	public String PastDate(int days) throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
		String date_to_string = dateformatyyyyMMdd.format(dateNow);
		String untildate = date_to_string;// Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance(); // Get Calendar Instance
		cal.setTime(dateFormat.parse(untildate));
		// Past Date
		cal.add(Calendar.DATE, -days);
		String pastdate = dateFormat.format(cal.getTime());
		return pastdate;
	}

	/**
	 * Gets current time in the following format Month, Date, Hours, Minutes,
	 * Seconds, Millisecond.
	 *
	 * @return Current date.
	 */
	public String getCurrentTimeStampString() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sd = new SimpleDateFormat("MMddHHmmssSS");
		TimeZone timeZone = TimeZone.getDefault();
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
		sd.setCalendar(cal);
		return sd.format(date);
	}

	/**
	 * Takes screenshot and adds it to TestNG report.
	 *
	 * @param driver WebDriver instance.
	 */
	public void makeScreenshot(WebDriver driver, String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";

		/* Copy screenshot to specific folder */
		try {
			String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator + "chrome"
					+ File.separator;
			String screenshotsFolder = "screenshots";
			File screenshotFolder = new File(reportFolder + screenshotsFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			Reporter.log("Failed to capture screenshot: " + e.getMessage());
		}
		Reporter.log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
	}

	/**
	 * Assertion to check that given element is present and show message.
	 *
	 * @param locator the locator of element to be checked
	 *
	 * @param message the message to be printed
	 */
	public void assert_Element_Present_With_Message(String locator, String message) {
		pause(1);
		Assert.assertTrue(isElementPresent(locator), message);
	}

	/**
	 * Assertion to check that given element is not present and show message.
	 *
	 * @param locator the locator of element to be checked
	 *
	 * @param message the message to be printed
	 */
	public void assert_Element_Not_Present_With_Message(String locator, String message) {
		pause(1);
		Assert.assertFalse(isElementPresent(locator), message);
	}

	/**
	 * Generates link for TestNG report.
	 *
	 * @param screenshot_name Screenshot name.
	 * @param link_text       Link text.
	 * @return Formatted link for TestNG report.
	 */
	public String getScreenshotLink(String screenshot_name, String link_text) {
		Reporter.log("<Strong><font color=#FF0000>--Failed</font></strong>");
		return "<a href='../target/failsafe-reports/firefox/screenshots/" + screenshot_name + "'>" + link_text + "</a>";
	}

	/**
	 * Check that the element is displayed or not.
	 *
	 * @param element the element to be checked
	 *
	 * @return true if element displayed, otherwise false
	 */
	public boolean isElementDisplayed(WebElement element) {
		waitUntilElementToBeVisible(element);
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check that the element is displayed or not.
	 *
	 * @param locator the element to be checked
	 *
	 * @return true if element not displayed, otherwise false
	 */
	public boolean isElementNotDisplayed(String locator) {
		waitUntilElementToBeVisible(By.xpath(locator));
		WebElement element = this.findElement(locator);
		try {
			return !element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check that the element is displayed or not.
	 *
	 * @param element the element to be checked
	 *
	 * @return true if element not displayed, otherwise false
	 */
	public boolean isElementNotDisplayed(WebElement element) {
		waitUntilElementToBeVisible(element);
		try {
			return !element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Assertion to check that given element is not being displayed.
	 *
	 * @param locator the locator of element to be checked
	 */
	public void assertElementIsNotDisplayed(String locator) {
		pause(1);
		Assert.assertFalse(isElementDisplayed(locator));
	}

	/**
	 * Checks that given element is checked or not.
	 *
	 * @param locator the locator of element to be checked
	 *
	 * @return true if element checked,otherwise false
	 */
	public boolean isChecked(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		return element.isSelected();
	}

	/**
	 * Checks that given element is checked or not.
	 *
	 * @param element the element to be checked
	 *
	 * @return true if element checked,otherwise false
	 */
	public boolean isChecked(WebElement element) {
		waitUntilElementToBeVisible(element);
		return element.isSelected();
	}

	/**
	 * Checks whether the needed WebElement is displayed or not.
	 *
	 * @param elementLocator
	 * @return
	 */
	public boolean isElementDisplayed(By elementLocator) {
		waitUntilElementToBeVisible(elementLocator);
		try {
			return driver.findElement(elementLocator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled into
	 * view and its location is calculated using getClientRects.
	 *
	 * @param element the element to move to
	 *
	 */
	public void mouseOver(WebElement element) {

		waitUntilElementToBeVisible(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		highlightElement(element);
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled into
	 * view and its location is calculated using getClientRects.
	 *
	 * @param locator the locator of element to move to
	 *
	 */
	public void mouseOver(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		highlightElement(element);
	}

	/**
	 * Moves the mouse to the middle of the element and click on it. The element is
	 * scrolled into view and its location is calculated using getClientRects.
	 *
	 * @param element the element to move to
	 *
	 */
	public void mouseOverClick(WebElement element) {
		waitUntilElementToBeClickable(element);
		Actions actions = new Actions(driver);
		highlightElement(element);
		actions.moveToElement(element).click().perform();
	}

	/**
	 * Moves the mouse to the middle of the element and click on it. The element is
	 * scrolled into view and its location is calculated using getClientRects.
	 *
	 * @param locator the locator of element to move to
	 *
	 */
	public void mouseOverClick(String locator) {
		WebElement element = waitUntilElementToBeClickable(findBy(locator));
		Actions actions = new Actions(driver);
		highlightElement(element);
		actions.moveToElement(element).click().perform();

	}

	/**
	 * Get the value of the given attribute of the element. Will return the current
	 * value, even if this has been modified after the page has been loaded.
	 *
	 *
	 * @param locator The locator of element to get its attribute value
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getValue(String locator) {
		WebElement element = waitUntilPresenceOfElementLocated(findBy(locator));
		return element.getAttribute("value");
	}

	/**
	 * Assertion to check that two values are equal.
	 *
	 * @param value1 Value-1.
	 * @param value2 Value-2.
	 */
	public void assertTwoValuesAreEqual(Object value1, Object value2) {
		pause(1);
		Assert.assertEquals(value1, value2);
	}

	/**
	 * Assertion to check that two values are not equal.
	 *
	 * @param value1 Value-1.
	 * @param value2 Value-2.
	 */
	public void assertTwoValuesAreNotEqual(Object value1, Object value2) {
		pause(1);
		Assert.assertNotEquals(value1, value2);
	}

	/**
	 * Checks given element is being displayed or not on page.
	 *
	 * @param locator the locator of element to be checked present or not
	 *
	 * @return True if the element displayed, false otherwise
	 */
	public boolean isElementDisplayed(String locator) {
		try {

			WebElement element = waitUntilElementToBeVisible(findBy(locator));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementEnabled(String locator) {
		return true;
	}

	public boolean isElementDisabled(String locator) {

			WebElement element = waitUntilElementToBeVisible(By.xpath(locator));
			if (!element.isEnabled()) {
				return true;
			}
			return false;


	}

	/**
	 * Check that given element is present or not.
	 *
	 * @param locator the locator of element to be checked present or not
	 *
	 * @return True if the element present, false otherwise
	 */
	public boolean isElementPresent(String locator) {
		try {
			highlightElement(waitUntilElementToBeVisible(findBy(locator)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check that given element is present or not.
	 *
	 * @param xpath the xpath of element to be checked present or not
	 *
	 * @return True if the element present, false otherwise
	 */

	public boolean existsElement(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	/**
	 * Assertion to check that given element is not present.
	 *
	 * @param locator the locator of element
	 */
	public void assertElementNotPresent(String locator) {
		pause2Sec();
		Assert.assertFalse(isElementPresent(locator));
	}

	/**
	 * Assertion to check that given element is present.
	 *
	 * @param locator the locator of element
	 *
	 */
	public void assertElementPresent(String locator) {

		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Assertion to check that given element is present.
	 *
	 * @param locator the locator of element
	 *
	 */
	public void assertElementPresent(String locator, String message) {

		Assert.assertTrue(isElementPresent(locator), message);
	}

	/**
	 * Causes the currently executing thread to sleep (temporarily cease execution)
	 * for the specified number of seconds, subject to the precision and accuracy of
	 * system timers and schedulers. The thread does not lose ownership of any
	 * monitors.
	 *
	 * @param seconds the time in second to pause execution
	 */
	public void pause(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ie) {

		}
	}

	public String waitUntilElementTextChanged(String locator) {
		WebElement dynamicTextElement = driver.findElement(By.xpath(locator));
		String beforeText = dynamicTextElement.getText();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath(locator), beforeText)));
		WebElement dynamicTextElementAfter = driver.findElement(By.xpath(locator));
		return dynamicTextElementAfter.getText();
	}

	public void waitUntilSpecificTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * Wait till all ajax calls finish.
	 *
	 * @param num Number of ajax calls to finish
	 */
	public void waitForAjax(String num) {

		String ajax;

		ajax = this.ajaxFinised(num);

		for (int second = 0;; second++) {
			if (second >= 20) {
				break;
			} else if (ajax.equals("true")) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Wait till ajax call finish.
	 *
	 * @throws InterruptedException
	 */
	public void WaitForAjax() throws InterruptedException {

		String ajax;
		ajax = this.ajaxFinised("1");

		for (int second = 0;; second++) {
			if (second >= 15) {
				break;
			} else if (ajax.equals("true")) {
				break;
			}

		}
	}

	/**
	 * Checks that all ajax calls are completed on page.
	 *
	 * @param num Number of ajax calls to wait for completion.
	 *
	 * @return True if completed, false otherwise
	 */
	public String ajaxFinised(String num) {

		Object isAjaxFinished;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		isAjaxFinished = js.executeScript("return jQuery.active == " + num);

		return isAjaxFinished.toString();

	}

	/**
	 * Determine whether or not given string contains numeral.
	 *
	 * @return True if the string contains numeral, false otherwise
	 */
	public boolean isContainsNumeral(String string) {
		for (int i = 0; i < 9; i++) {
			if (string.contains("" + i + "")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Causes the currently executing thread to sleep (temporarily cease execution)
	 * for the specified number of milliseconds, subject to the precision and
	 * accuracy of system timers and schedulers. The thread does not lose ownership
	 * of any monitors.
	 *
	 */
	public void pause2Sec() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {

		}

	}

	// Save Screenshot for the Report

	public void makeScreenshotForReport(WebDriver driver, String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";
		/* Copy screenshot to specific folder */
		try {
			String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator;
			File screenshotFolder = new File(reportFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			logPrint("Failed to capture screenshot : " + e.getMessage());
		}
	}

	/**
	 * Upload file using robot class.
	 *
	 * @param file the path of file to be uploaded
	 * @throws AWTException
	 */
	public void upload_File_Using_Robot(String file) throws AWTException {

		String path_win = System.getProperty("user.dir") + file;
		StringSelection filepath = new StringSelection(path_win);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, filepath);
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		robot.delay(1000);
		pause(5);
	}

	/**
	 * Returns the number of elements in this list. If this list contains more than
	 * {@code Integer.MAX_VALUE} elements, returns {@code Integer.MAX_VALUE}.
	 *
	 * @param element the element to get size
	 * @return the number of elements in this list
	 */

	public int size(List<WebElement> element) {
		pause(1);
		return element.size();
	}

	/**
	 * Returns the number of elements in this list. If this list contains more than
	 * {@code Integer.MAX_VALUE} elements, returns {@code Integer.MAX_VALUE}.
	 *
	 * @param locator the locator of element to find list to get size
	 * @return the number of elements in this list
	 */

	public int size(String locator) {
		pause(1);
		List<WebElement> element = this.findElements(locator);
		return element.size();
	}

	/**
	 * <p>
	 * Log the passed string to the HTML reports.
	 * </p>
	 *
	 * <p>
	 * Print the passed string and then terminates the line.
	 * </p>
	 *
	 * @param print the message to log and to print
	 */
	public void logPrint(String print) {
		if (print.startsWith("Step")) {
			String[] msg = print.split("::");
			int stepCount = WebBasePage.steps.get();
			Reporter.log("<br></br>" + msg[0].trim() + " " + stepCount + " : " + msg[1].trim(), true);
			WebBasePage.steps.set(stepCount + 1);
		} else {
			Reporter.log("<br></br> Message : " + print, true);
		}
	}

	/**
	 * Select all options that have a value matching the argument.
	 *
	 * @param value   the value to match against
	 * @param locator the locator of element to be selected by value
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 *
	 */
	public void selectByValue(String value, String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);

	}

	/**
	 * Select all options that have a value matching the argument.
	 *
	 * @param value   the value to match against
	 * @param element the element to be selected by value
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 *
	 */
	public void selectByValue(String value, WebElement element) {
		waitUntilElementToBeVisible(element);
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);

	}

	/**
	 * Select the option at the given index. This is done by examining the "index"
	 * attribute of an element, and not merely by counting.
	 *
	 * @param index   the option at this index will be selected
	 * @param locator the locator of element to be selected by index.
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByIndex(int index, String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);

	}

	/**
	 * Select the option at the given index. This is done by examining the "index"
	 * attribute of an element, and not merely by counting.
	 *
	 * @param index   the option at this index will be selected
	 * @param element the element to be selected by index
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByIndex(int index, WebElement element) {
		waitUntilElementToBeVisible(element);
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);

	}

	/**
	 * Select the option of given element at random index. This is done by examining
	 * the "index" attribute of an element, and not merely by counting.
	 *
	 * @param locator the locator of element to be selected by random index
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByRandomIndex(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		Select dropdown = new Select(element);
		Random random = new Random();
		dropdown.selectByIndex(random.nextInt(dropdown.getOptions().size()));
		// pause(1);
		dismissAlertIfPresent();

	}

	/**
	 * Select the option of given element at random index. This is done by examining
	 * the "index" attribute of an element, and not merely by counting.
	 *
	 * @param element the element to be selected by random index.
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByRandomIndex(WebElement element) {
		waitUntilElementToBeVisible(element);
		highlightElement(element);
		Select dropdown = new Select(element);
		Random random = new Random();
		dropdown.selectByIndex(random.nextInt(dropdown.getOptions().size()));
		dismissAlertIfPresent();

	}

	/**
	 * Select all options of given element that display text matching the argument.
	 *
	 *
	 * @param text    the visible text to match against
	 * @param locator the locator of element to be selected by visible text.
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByVisibleText(String text, String locator) {

		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);

	}

	/**
	 * Select all options of given element that display text matching the argument.
	 *
	 *
	 * @param text    the visible text to match against
	 * @param element the element to be selected by visible text
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByVisibleText(String text, WebElement element) {
		pause(1);
		waitUntilElementToBeVisible(element);
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);

	}

	/**
	 * Get first selected option from dropdown.
	 *
	 *
	 * @param locator the locator of element to get first selected option text.
	 * @return The element's current visible text or null if the value is not set.
	 *
	 */
	public String getFirstSelectedOptionOfDropdown(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		Select dropdown = new Select(element);
		return dropdown.getFirstSelectedOption().getText();
	}

	/**
	 * Get first selected option from dropdown.
	 *
	 *
	 * @param element the element to get first selected option text.
	 * @return The element's current visible text or null if the value is not set.
	 *
	 */
	public String getFirstSelectedOptionOfDropdown(WebElement element) {
		waitUntilElementToBeVisible(element);
		highlightElement(element);
		Select dropdown = new Select(element);
		return dropdown.getFirstSelectedOption().getText();
	}

	/**
	 * Check the checkbox or toggle element.
	 *
	 * @param locator the locator of checkbox element to be checked
	 */
	public void checkChkBox(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (!isCheckBoxChecked) {
			try {
				element.click();
			} catch (Exception e) {
				jsClickWithoutWait(element);
			}
		}
	}

	/**
	 * Check the checkbox or toggle element.
	 *
	 * @param locator the locator of checkbox element to be checked
	 */
	public void checkChkBoxWithoutWait(String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (!isCheckBoxChecked) {
			try {
				element.click();
			} catch (Exception e) {
				jsClickWithoutWait(element);
			}
		}
	}

	/**
	 * Check the checkbox or toggle element.
	 *
	 * @param element The checkbox element to be checked
	 */
	public void checkChkBox(WebElement element) {
		waitUntilElementToBeVisible(element);
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (!isCheckBoxChecked) {
			try {
				element.click();
			} catch (Exception e) {
				jsClickWithoutWait(element);
			}
		}
	}

	/**
	 * Check the checkbox or toggle element.
	 *
	 * @param element The checkbox element to be checked
	 */
	public void checkChkBoxWithoutWait(WebElement element) {

		pause(1);
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (!isCheckBoxChecked) {
			try {
				element.click();
			} catch (Exception e) {
				jsClickWithoutWait(element);
			}
		}
	}

	/**
	 * Uncheck the checkbox or toggle element.
	 *
	 * @param locator the locator of checkbox element to be unchecked
	 */
	public void uncheckChkBox(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (isCheckBoxChecked) {
			try {
				element.click();
			} catch (Exception e) {
				jsClick(locator);
			}
		}
	}

	/**
	 * Uncheck the checkbox or toggle element.
	 *
	 * @param locator the locator of checkbox element to be unchecked
	 */
	public void uncheckChkBoxWithoutWait(String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (isCheckBoxChecked) {
			try {
				element.click();
			} catch (Exception e) {
				jsClickWithoutWait(element);
			}
		}
	}

	/**
	 * Uncheck the checkbox or toggle element.
	 *
	 * @param element The checkbox element to be unchecked
	 */
	public void uncheckChkBox(WebElement element) {
		waitUntilElementToBeVisible(element);
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (isCheckBoxChecked) {
			try {
				element.click();
			} catch (Exception e) {
				jsClickWithoutWait(element);
			}
		}
	}

	/**
	 * Uncheck the checkbox or toggle element.
	 *
	 * @param element The checkbox element to be unchecked
	 */
	public void uncheckChkBoxWithoutWait(WebElement element) {

		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (isCheckBoxChecked) {
			try {
				element.click();
			} catch (Exception e) {
				jsClickWithoutWait(element);
			}
		}
	}

	/**
	 * Scroll to bottom of the page.
	 *
	 *
	 */
	public void scroll_To_Bottom_Of_Page() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	/**
	 * Scroll page to element for given locator.
	 *
	 * @param locator the locator of element where to scroll
	 *
	 */
	public void scroll_To_Element(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * Scroll page to given x and y pixels position.
	 *
	 * @param x_pixels The x-pixels is the number at x-axis, it moves to the left if
	 *                 number is positive and it move to the right if number is
	 *                 negative
	 *
	 * @param y_pixels The y-pixels is the number at y-axis, it moves to the down if
	 *                 number is positive and it move to the up if number is in
	 *                 negative
	 *
	 **/
	public void scroll_By_Pixel(String x_pixels, String y_pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x_pixels + "," + y_pixels + ")", "");
	}

	/**
	 * <p>
	 * Creates a random character string whose length is the number of characters
	 * specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of alphabetic characters.
	 * </p>
	 *
	 * @param length the length of random character string to create
	 * @return The random character string in lower case
	 */
	public String generateRandomChars(int length) {
		return RandomStringUtils.randomAlphabetic(length).toLowerCase();
	}

	/**
	 * <p>
	 * Creates a random number integer whose length is the number of characters
	 * specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of numeric characters.
	 * </p>
	 *
	 * @param length the length of random number integer to create
	 * @return The random number integer
	 */
	public int generateRandomNumberInteger(int length) {
		String randomNumeric = RandomStringUtils.randomNumeric(length);
		return Integer.parseInt(randomNumeric);
	}

	/**
	 * <p>
	 * Creates a random number string whose length is the number of characters
	 * specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of numeric characters.
	 * </p>
	 *
	 * @param length the length of random number string to create
	 * @return The random number string
	 */
	public String generateRandomNumberString(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	/**
	 * Highlight given element
	 *
	 * @param locator the locator of element to be highlighted
	 *
	 */
	public void highlightElement(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
	}

	/**
	 * Highlight given element
	 *
	 * @param element the element to be highlighted
	 *
	 */
	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
	}

	/**
	 * Get a string representing the current URL that the browser is looking at.
	 *
	 * @return The URL of the page currently loaded in the browser
	 */
	public String installation_URL() {
		String installurl = driver.getCurrentUrl();
		logPrint("Installation URL :: " + installurl);
		return installurl;
	}

	/**
	 * Get the system OS name.
	 *
	 * @return The string value of the system OS name
	 */
	public String getOS() {
		String OS = System.getProperty("os.name").toLowerCase();
		logPrint("-----------------------------------------------------------------------------------");
		logPrint("System OS :: " + OS);
		logPrint("-----------------------------------------------------------------------------------");
		return OS;
	}

	public void log(String print) {
//		String message = "Step :: " + print;
//		if (message.startsWith("Step")) {
//			int stepcount = BasePage.steps.get();
//			String[] msg = message.split("::");
//			Reporter.log("<br>" + msg[0].trim() + " " + stepcount + " : " + msg[1].trim());
//			System.out.println(msg[0].trim() + " " + stepcount + " : " + msg[1].trim());
//			// logger.info(msg[0].trim() + " " + stepcount + " : " + msg[1].trim());
//			System.out.flush();
//			// Allure.step(msg[0].trim() + " " + stepcount + " : " + msg[1].trim());
//
//			BasePage.steps.set(stepcount + 1);
//		} else {
//			Reporter.log("<br>Message : " + message);
//			System.out.println("Message : " + message);
//			// logger.info("Message : " + message);
//			System.out.flush();
//		}
	}

	public By findBy(String locator) {
		if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
			locator = locator.substring(5); // remove "link=" from locator
			if (locator.contains(" "))
				return By.partialLinkText(locator);
			return By.linkText(locator);
		} else if (locator.startsWith("id=")) {
			locator = locator.substring(3); // remove "id=" from locator
			return By.id(locator);
		} else if (locator.startsWith("//")) {
			return By.xpath(locator);
		} else if (locator.startsWith("#")) {
			return By.cssSelector(locator);
		} else if (locator.startsWith("name=")) {
			locator = locator.substring(5); // remove "name=" from locator
			return By.name(locator);
		} else if (locator.startsWith("class=")) {
			locator = locator.substring(6); // remove "class=" from locator
			return By.className(locator);
		} else if (locator.equalsIgnoreCase("body")) {
			return By.cssSelector(locator);
		} else {
			return By.id(locator);
		}
	}

	/**
	 * Find the first {@link WebElement} using the given method. This method is
	 * affected by the 'implicit wait' times in force at the time of execution. The
	 * findElement(..) invocation will return a matching row, or try again
	 * repeatedly until the configured timeout is reached.
	 *
	 *
	 * @param locator the locator to be used by locating mechanism to find element
	 * @return The first matching element on the current page
	 * @throws NoSuchElementException If no matching elements are found
	 *
	 */
	public WebElement findElement(String locator) {
		if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
			locator = locator.substring(5); // remove "link=" from locator
			if (locator.contains(" "))
				return driver.findElement(By.partialLinkText(locator));
			return driver.findElement(By.linkText(locator));
		} else if (locator.startsWith("id=")) {
			locator = locator.substring(3); // remove "id=" from locator
			return driver.findElement(By.id(locator));
		} else if (locator.startsWith("//")) {
			return driver.findElement(By.xpath(locator));
		} else if (locator.startsWith("#")) {
			return driver.findElement(By.cssSelector(locator));
		} else if (locator.startsWith("name=")) {
			locator = locator.substring(5); // remove "name=" from locator
			return driver.findElement(By.name(locator));
		} else if (locator.startsWith("class=")) {
			locator = locator.substring(6); // remove "class=" from locator
			return driver.findElement(By.className(locator));
		} else if (locator.equalsIgnoreCase("body")) {
			return driver.findElement(By.cssSelector(locator));
		} else {
			return driver.findElement(By.id(locator));
		}
	}

	/**
	 * Find all elements within the current page using the given mechanism. This
	 * method is affected by the 'implicit wait' times in force at the time of
	 * execution. When implicitly waiting, this method will return as soon as there
	 * are more than 0 items in the found collection, or will return an empty list
	 * if the timeout is reached.
	 *
	 *
	 * @param locator the locator to be used by locating mechanism to find elements
	 * @return A list of all matching {@link WebElement}s, or an empty list if
	 *         nothing matches
	 *
	 */
	public List<WebElement> findElements(String locator) {
		if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
			locator = locator.substring(5); // remove "link=" from locator
			if (locator.contains(" "))
				return driver.findElements(By.partialLinkText(locator));
			return driver.findElements(By.linkText(locator));
		} else if (locator.startsWith("id=")) {
			locator = locator.substring(3); // remove "id=" from locator
			return driver.findElements(By.id(locator));
		} else if (locator.startsWith("//")) {
			return driver.findElements(By.xpath(locator));
		} else if (locator.startsWith("#")) {
			return driver.findElements(By.cssSelector(locator));
		} else if (locator.startsWith("name=")) {
			locator = locator.substring(5); // remove "name=" from locator
			return driver.findElements(By.name(locator));
		} else if (locator.startsWith("class=")) {
			locator = locator.substring(6); // remove "class=" from locator
			return driver.findElements(By.className(locator));
		} else if (locator.equalsIgnoreCase("body")) {
			return driver.findElements(By.cssSelector(locator));
		} else {
			return driver.findElements(By.id(locator));
		}
	}

	/**
	 * Refresh the current page
	 *
	 */
	public void refreshPage() {
		this.driver.navigate().refresh();

	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element, which may set its value.
	 *
	 *
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 *
	 */

	public void type(String locator, String keysToSend) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element, which may set its value.
	 *
	 *
	 * @param element    the element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 *
	 */
	public void type(WebElement element, String keysToSend) {
		waitUntilElementToBeClickable(element);
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
	}

	/**
	 * If given element is a form entry element, this will simulate typing into an
	 * element, which may set its value.
	 *
	 * @param locator
	 * @param keysToSend
	 */
	public void typeWithoutClear(String locator, String keysToSend) {

		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		element.sendKeys(keysToSend);
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element, which may set its value and press ENTER
	 * key.
	 *
	 *
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 *
	 */

	public void typeAndEnter(String locator, String keysToSend) {

		WebElement element = waitUntilElementToBeClickable(findBy(locator));
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		element.sendKeys(Keys.ENTER);

	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element, which may set its value and press ENTER
	 * key.
	 *
	 *
	 * @param element    the element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 *
	 */

	public void typeAndEnter(WebElement element, String keysToSend) {

		waitUntilElementToBeClickable(element);
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		element.sendKeys(Keys.ENTER);

	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select first option from list.
	 *
	 *
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 *
	 */
	public void typeAndSelectFirst(String locator, String keysToSend) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(2);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
		pause(1);
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select first option from list.
	 *
	 *
	 * @param element    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 *
	 */

	public void typeAndSelectFirst(WebElement element, String keysToSend) {
		waitUntilElementToBeClickable(element);
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();

	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select second option from list.
	 *
	 *
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 *
	 */

	public void typeFAndSelectSecond(String locator, String keysToSend) {

		WebElement element = waitUntilElementToBeClickable(findBy(locator));
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN).build().perform();

	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select second option from list.
	 *
	 *
	 * @param element    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 *
	 */

	public void typeAndSelectSecond(WebElement element, String keysToSend) {

		waitUntilElementToBeClickable(element);
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN).build().perform();

	}

	/**
	 * Click on given element. If this causes a new page to load, you should discard
	 * all references to given element and any further operations performed on given
	 * element will throw a StaleElementReferenceException.
	 *
	 * There are some preconditions for an element to be clicked. the element must
	 * be visible and it must have a height and width greater then 0.
	 *
	 * @param locator the locator of element to be clicked.
	 */
	public void click(String locator) {
		// pause(1);
		WebElement element = waitUntilElementToBeClickable(findBy(locator));
		highlightElement(element);
		try {
			element.click();
		} catch (Exception e) {
			jsClickWithoutWait(element);
		}
	}

	/**
	 * Click on given element. If this causes a new page to load, you should discard
	 * all references to given element and any further operations performed on given
	 * element will throw a StaleElementReferenceException.
	 *
	 * There are some preconditions for an element to be clicked. the element must
	 * be visible and it must have a height and width greater then 0.
	 *
	 * @param element the element to be clicked.
	 */

	public void click(WebElement element) {
		// pause(1);
		waitUntilElementToBeClickable(element);
		highlightElement(element);
		try {
			element.click();
		} catch (Exception e) {
			jsClickWithoutWait(element);
		}

	}

	/**
	 * Clicks on visible or not visible element through javascript.
	 *
	 * @param locator the locator of element to be clicked.
	 */
	public void jsClick(String locator) {
		// pause(1);
		WebElement element = waitUntilElementToBeClickable(findBy(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		js.executeScript("return arguments[0].click();", element);

	}

	/**
	 * Clicks on visible or not visible element through javascript.
	 *
	 * @param element the element to be clicked.
	 */
	public void jsClick(WebElement element) {
		// pause(1);
		highlightElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].click();", element);

	}

	/**
	 * Clicks on visible or not visible element through javascript.
	 *
	 * @param element the element to be clicked.
	 */
	public void jsClickWithoutWait(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].click();", element);

	}

	/**
	 * If given element is a form entry element, this will reset its value.
	 *
	 * @param locator the locator of element to be cleared
	 */
	public void clear(String locator) {
		WebElement element = waitUntilPresenceOfElementLocated(findBy(locator));
		highlightElement(element);
		element.clear();
	}

	/**
	 * If given element is a form entry element, this will reset its value.
	 *
	 * @param element the element to be cleared
	 */
	public void clear(WebElement element) {
		waitUntilElementToBeClickable(element);
		highlightElement(element);
		element.clear();
	}

	/**
	 * Get the value of the given attribute of the element. Will return the current
	 * value, even if this has been modified after the page has been loaded.
	 * <p>
	 * More exactly, this method will return the value of the property with the
	 * given name, if it exists. If it does not, then the value of the attribute
	 * with the given name is returned. If neither exists, null is returned.
	 * <p>
	 * To get tooltip you have to give attribute "title" as argument.
	 * <p>
	 * The "style" attribute is converted as best can be to a text representation
	 * with a trailing semi-colon.
	 * <p>
	 * The following are deemed to be "boolean" attributes, and will return either
	 * "true" or null:
	 * <p>
	 * async, autofocus, autoplay, checked, compact, complete, controls, declare,
	 * defaultchecked, defaultselected, defer, disabled, draggable, ended,
	 * formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope,
	 * loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open,
	 * paused, pubdate, readonly, required, reversed, scoped, seamless, seeking,
	 * selected, truespeed, willvalidate
	 * <p>
	 * Finally, the following commonly mis-capitalized attribute/property names are
	 * evaluated as expected:
	 * <ul>
	 * <li>If the given name is "class", the "className" property is returned.
	 * <li>If the given name is "readonly", the "readOnly" property is returned.
	 * </ul>
	 *
	 * @param locator       The locator of element to get its attribute value
	 * @param attributeName The name of the attribute
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getAttribute(String locator, String attributeName) {

		WebElement element = waitUntilPresenceOfElementLocated(findBy(locator));
		highlightElement(element);
		return element.getAttribute(attributeName);
	}

	/**
	 * Get the value of the given attribute of the element. Will return the current
	 * value, even if this has been modified after the page has been loaded.
	 * <p>
	 * More exactly, this method will return the value of the property with the
	 * given name, if it exists. If it does not, then the value of the attribute
	 * with the given name is returned. If neither exists, null is returned.
	 * <p>
	 * The "style" attribute is converted as best can be to a text representation
	 * with a trailing semi-colon.
	 * <p>
	 * The following are deemed to be "boolean" attributes, and will return either
	 * "true" or null:
	 * <p>
	 * async, autofocus, autoplay, checked, compact, complete, controls, declare,
	 * defaultchecked, defaultselected, defer, disabled, draggable, ended,
	 * formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope,
	 * loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open,
	 * paused, pubdate, readonly, required, reversed, scoped, seamless, seeking,
	 * selected, truespeed, willvalidate
	 * <p>
	 * Finally, the following commonly mis-capitalized attribute/property names are
	 * evaluated as expected:
	 * <ul>
	 * <li>If the given name is "class", the "className" property is returned.
	 * <li>If the given name is "readonly", the "readOnly" property is returned.
	 * </ul>
	 *
	 * @param element       the element to get its attribute value
	 * @param attributeName The name of the attribute
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getAttribute(WebElement element, String attributeName) {

		waitUntilElementToBeVisible(element);
		return element.getAttribute(attributeName);
	}

//    public String getProperty(String key, String defaultValue) {
//        String val = getProperty(key);
//        return (val == null) ? defaultValue : val;
//    }

//

	/**
	 * Get the visible (i.e. not hidden by CSS) text of given element, including
	 * sub-elements.
	 *
	 * @param locator the locator of element from where to get visible text
	 * @return The visible text of given element.
	 */

	public String getText(String locator) {
		pause(2);
		WebElement element = this.findElement(locator);
		highlightElement(element);
		return element.getText();
	}

	/**
	 * Get the visible (i.e. not hidden by CSS) text of given element, including
	 * sub-elements.
	 *
	 * @param element the element from where to get visible text
	 * @return The visible text of given element.
	 */
	public String getText(WebElement element) {
		pause(2);
		highlightElement(element);
		return element.getText();
	}

	/**
	 * Get the visible text of given element's tooltip.
	 *
	 * @param locator the locator of element from where to get tooltip text
	 * @return The tooltip text of given element.
	 */

	public String getToolTipText(String locator, String tooltipLocator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		WebElement toolTip = this.findElement(tooltipLocator);
		highlightElement(toolTip);
		return toolTip.getText();
	}

	/**
	 * Get the visible text of given element's tooltip.
	 *
	 * @param element the locator of element from where to get tooltip text
	 * @return The tooltip text of given element.
	 */

	public String getToolTipText(WebElement element, String tooltipLocator) {

		waitUntilElementToBeVisible(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		WebElement toolTip = this.findElement(tooltipLocator);
		highlightElement(toolTip);
		return toolTip.getText();
	}

	/**
	 * Select a frame using its previously located {@link WebElement}.
	 *
	 * @param locator The locator of frame element to switch to.
	 * @return This driver focused on the given frame.
	 *
	 */
	public void switchToFrame(String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		driver.switchTo().frame(element);
	}

	/**
	 * Select a frame using its previously located {@link WebElement}.
	 *
	 * @param element The frame element to switch to.
	 * @return This driver focused on the given frame.
	 *
	 */
	public void switchToFrame(WebElement element) {
		waitUntilElementToBeVisible(element);
		driver.switchTo().frame(element);
	}

	/**
	 * Select a frame by its (zero-based) index. Selecting a frame by index is
	 * equivalent to the JS expression window.frames[index] where "window" is the
	 * DOM window represented by the current context. Once the frame has been
	 * selected, all subsequent calls on the WebDriver interface are made to that
	 * frame.
	 *
	 * @param index (zero-based) index.
	 * @return This driver focused on the given frame.
	 *
	 */
	public void switchToFrame(int index) {
		// driver.switchTo().frame(index);
		waitUntilFrameToBeAvailableAndSwitchToIt(index);
	}

	/**
	 * Selects either the first frame on the page, or the main document when a page
	 * contains iframes.
	 *
	 * @return This driver focused on the top window/first frame.
	 *
	 */
	public void switchToFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Search the option in given element (Dropdown list). This is done by examining
	 * each and every options available in dropdown list.
	 *
	 * @param option  the option which you want to check presence in dropdown list
	 * @param locator the locator of element to be searched for option
	 * @return True if option present in dropdown list, otherwise false
	 *
	 */
	public Boolean isOptionPresentInDropdown(String option, String locator) {
		WebElement element = waitUntilElementToBeVisible(findBy(locator));
		highlightElement(element);
		Select dropdown = new Select(element);
		int totalOptions = dropdown.getOptions().size();
		for (int i = 0; i < totalOptions; i++) {
			if (dropdown.getOptions().get(i).getText().contains(option))
				return true;
		}
		return false;

	}

	/**
	 * Search the option in given element (Dropdown list). This is done by examining
	 * each and every options available in dropdown list.
	 *
	 * @param option  the option which you want to check presence in dropdown list
	 * @param element the element to be searched for option
	 * @return True if option present in dropdown list, otherwise false
	 *
	 */
	public Boolean isOptionPresentInDropdown(String option, WebElement element) {

		waitUntilElementToBeVisible(element);
		highlightElement(element);
		Select dropdown = new Select(element);
		int totalOptions = dropdown.getOptions().size();
		for (int i = 0; i < totalOptions; i++) {
			if (dropdown.getOptions().get(i).getText().contains(option))
				return true;
		}
		return false;
	}

	/**
	 * Assertion to check that given element is checked.
	 *
	 * @param locator the locator of element to be checked
	 *
	 */
	public void assertCheckboxChecked(String locator) {
		Assert.assertTrue(isChecked(locator));
	}

	/**
	 * Assertion to check that given element is checked.
	 *
	 * @param element the element to be checked
	 *
	 */

	public void assertCheckboxChecked(WebElement element) {
		Assert.assertTrue(isChecked(element));
	}

	/**
	 * Assertion to check that given element is not checked.
	 *
	 * @param locator the locator of element to be checked
	 *
	 */
	public void assertCheckboxNotChecked(String locator) {
		Assert.assertTrue(!isChecked(locator));
	}

	/**
	 * Assertion to check that given element is not checked.
	 *
	 * @param element the element to be checked
	 *
	 */
	public void assertCheckboxNotChecked(WebElement element) {
		Assert.assertTrue(!isChecked(element));

	}

	/**
	 *
	 * Check alert is present or not and dismiss it if present.
	 *
	 * @return Text on alert if present, otherwise null
	 */
	public String dismissAlertIfPresent() {
		String strAltert = null;
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			strAltert = alert.getText();
			alert.dismiss();
			// pause(2);
		}
		return strAltert;
	}

	public void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (js.executeScript("return document.redyState").equals("complete"));
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(pageLoadCondition);
	}

	public XSSFSheet getDataFromExcelSheet(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream("Test_data1.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		return sheet;
	}

	public XSSFSheet getRecordFromExcelSheet(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream("record_for_change_scenario.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		return sheet;
	}

	@SuppressWarnings("unused")
	public XSSFWorkbook readExcelFileFromSharePoint(String sharePointFileUrl) throws IOException {
		URL url = new URL(sharePointFileUrl);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		try (InputStream inputStream = connection.getInputStream()) {
			return new XSSFWorkbook(inputStream);
		}
	}

}
