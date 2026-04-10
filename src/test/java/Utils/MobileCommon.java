package Utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

public class MobileCommon {

    public MobileDriver driver;
    public static String path = System.getProperty("user.dir");
    public static String fileName = path + "/src/test/resources/testData.xlsx";
    String doneBtn = "//XCUIElementTypeButton[@name=\"Done\"]";

    public Properties readConfigFile(String configFile) {
        Properties prop = null;

        try (InputStream input = new FileInputStream(new File("src/test/java/Config/" + configFile + ".properties").getAbsolutePath())) {

            prop = new Properties();

            prop.load(input);


        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return prop;
    }


    public void pause(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
  public   String GenerateRandomNumber(int charLength) {
        return String.valueOf(charLength < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
                + (int) Math.pow(10, charLength - 1));
    }

    public void logStepMessage(String log) {
        System.out.println(log);
        Reporter.log(log + "<br>");
    }

    public void logStepResult(String result) {
        System.out.println("Result : " + result);
        if (result.equals("passed")) {
            Reporter.log("<h4 style=\"color:green;\">Passed</h4>");
        } else if (result.equals("failed"))
            Reporter.log("<h4 style=\"color:red;\">Failed</h4>");
        {

        }

    }

    public String getScreenshotLink(String screenshot_name, String link_text) {
        logStepMessage("<br><Strong><font color=#FF0000>--Failed</font></strong>");
        return "<a href='../target/failsafe-reports/failed/screenshots/" + screenshot_name + "'>" + link_text + "</a>";
    }

    public void makeScreenshot(MobileDriver driver, String screenshotName) {

        MobileDriver augmentedDriver = (MobileDriver) new Augmenter().augment(driver);

        /* Take a screenshot */
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";

        /* Copy screenshot to specific folder */
        try {
            String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator + "failed"
                    + File.separator;
            String screenshotsFolder = "screenshots";
            File screenshotFolder = new File(reportFolder + screenshotsFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            FileUtils.copyFile(screenshot,
                    new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
        } catch (IOException e) {
            logStepMessage("Failed to capture screenshot: " + e.getMessage());
        }
        logStepMessage(getScreenshotLink(nameWithExtention, nameWithExtention)); // add
// screenshot
// link
// to
// the
// report
    }


    public void relaunch_app(MobileDriver driver) {
        driver.launchApp();

    }

    public static String getCellDataFromLoginCredentialSheet(String colName, int rowNum) {
        String CellValue = null;

        try {
            FileInputStream fileInput = new FileInputStream(new File(fileName));
            Workbook wb = WorkbookFactory.create(fileInput);
            Sheet sheet = wb.getSheet("LoginCredential");
            Row row = sheet.getRow(0);
            short lastcolumnused = row.getLastCellNum();

            int columnNumber = 0;
            for (int i = 0; i < lastcolumnused; i++) {
                if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
                    columnNumber = i;
                    break;
                }
            }

            row = sheet.getRow(rowNum);
            Cell column = row.getCell(columnNumber);
            column.setCellType(CellType.STRING);

            CellValue = column.getStringCellValue();
        } catch (Exception e) {
            System.out.println("Exception Occur in getCellDataFromLoginCredentialSheet method is " + e);
        }
        return CellValue;

    }

    public void scrollToText(MobileDriver driver, String targetText) {
        while (true) {
            try {
                // Look for the target text in the current visible screen
                if (driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + targetText + "\")")).isDisplayed()) {
                    break; // Text found, exit the loop
                }
            } catch (WebDriverException e) {
                // Swipe to scroll down
                Dimension size = driver.manage().window().getSize();
                int startX = size.getWidth() / 2;
                int startY = (int) (size.getHeight() * 0.8);
                int endY = (int) (size.getHeight() * 0.2);

                TouchAction touchAction = new TouchAction(driver);
                touchAction.press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
            }
        }
    }

}
