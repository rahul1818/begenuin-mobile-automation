package Pages;

import Utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;


public class EngageEnginePage extends Locators{
    WebCommon common = new WebCommon(driver);

    public EngageEnginePage(WebDriver driver) {
        super(driver);
    }
    public void selectBrand() {
        common.click(SELECT_ANY_BRAND);
        common.log("Select Any brand");
        common.waitUntilSpecificTitle("Dashboard");
        common.assertTwoValuesAreEqual(driver.getTitle(), "Dashboard");
        common.log("Verify that Dashboard page is open ");
    }

    public void ClickOnImportVideo(){
        common.logPrint("Click on import video");
        common.click(importVideoButton);
    }

    public void ClickonEngageEngineButton(){
        common.click(engageEngineButton);
        common.logPrint("Click on engage engine button");
    }

    public void ClickOnUploadFolderButton(){
        common.click(uploadFolderButton);
        common.logPrint("Click on Upload Folder");
    }

//    public  void ClickONFileUploadButton(){
//        File filePath=null;
//        String osName = System.getProperty("os.name");
//        if (osName.contains("Window")) {
//            filePath = new File("videosuploadinffails.mp4");
//        } else {
//            filePath = new File("uploads/OneView.png");
//        }
//        String absolutePath = filePath.getAbsolutePath();
//        common.log("Upload file on attachment One View Field");
//        fileInputPath.sendKeys(absolutePath);
//        }

    public void ClickONFileUploadButton() {
        // Initialize file path variable
        File filePath = null;

        // Get OS name
        String osName = System.getProperty("os.name");

        // Set file path based on OS
        if (osName.contains("Windows")) {
            filePath = new File("videosuploadinffails.mp4"); // Update path accordingly
        } else {
            filePath = new File(""); // Update path accordingly
        }

        // Get the absolute path of the file
        String absolutePath = filePath.getAbsolutePath();

        // Log the action (ensure your common.log works as expected)
        common.log("Uploading file to the attachment field");

        // Locate the file input element using XPath (ensure XPath matches the file input)
        WebElement fileInputPath = driver.findElement(By.xpath("//label[@for='file']/input[@type='file']"));

        // Upload the file using sendKeys()
        fileInputPath.sendKeys(absolutePath); // This is the correct way to upload a file
    }

    public void ClickOnImportButton() {
        common.click(importButton);
        common.logPrint("Click on import Button");
    }

    public void VerifyMessage() {
        String messgae = common.getText(verifyMessage);
        common.logPrint("Message:"+ messgae);

        String expectedMessage = "Your videos are being imported from your uploads.";

        common.assertTwoValuesAreEqual(messgae, expectedMessage);
    }


}
