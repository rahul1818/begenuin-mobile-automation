package Pages;

import Utils.Locators;
import Utils.WebCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class ManagePage extends Locators {
    WebCommon common = new WebCommon(driver);

    String MANAGE_PAGELEFTNAV = "//span[contains(text(),'Manage')]";
    String COMMUNITY_TAB = "//span[contains(text(),'Communities')]";
    String LOOPS_TAB = "//span[contains(text(),'Loops')]";
    String POSTS_TAB = "//span[contains(text(),'Posts')]";
    String COMMUNITIES_TAB = "//span[contains(text(),'Comments')]";
    String USERS_TAB = "//span[contains(text(),'Users')]";
    String SEARCH_INPUT = "//input[@id='search-input']";
    String COMMUNITY_TBL_HEADER = "//div[normalize-space()='Community']";
    String LEADER_TBL_HEADER = "//div[normalize-space()='Owner']";
    String DATE_TBL_CREATED = "//div[normalize-space()='Date Created']";
    String MEMBERS_TBL_HEADER = "//div[normalize-space()='Members']";
    String MODERATORS_TBL_HEADER = "//div[normalize-space()='Admins']";
    String LOOPS_TBL_HEADER = "//div[normalize-space()='Groups']";
    String POSTS_TBL_HEADER = "//div[normalize-space()='Posts']";
    String NEW_COMMUNITY_BUTTON = "//button[normalize-space()='New Community']";
    String RECORDER_BUTTON = "//button[normalize-space()='Reorder']";
    String PIN_ICON = "//tbody/tr[1]/td[8]/div[1]/button[1]";
    String THREE_DOT_ICON = "//tbody/tr[1]/td[8]/div[1]/button[2]/div[1]/button[1]";
    String SORTING_ICON = "//div[normalize-space()='Posts']//*[name()='svg']";
    String FORWARD_BUTTON = "//li[@class='page-item']//span[@aria-label='null page']";
    String BACKWARD_BUTTON = "//main[@class='content']//li[1]";
    String PAGE_COUNT = "//select[@aria-label='Per']";
    String CREATE_NEWCOMMUNITY = "//button[normalize-space()='New Community']";
    String COMMUNITY_NAME = "//input[@id='name']";
    String GENERATE_BUTTOIN = "//button[normalize-space()='Generate']";
    String CREATE_BUTTON = "//button[normalize-space()='Create']";
    String CREATED_COMPANY_NAME = "//input[@id='name']";
    String SAVE_BUTTON = "//button[@type='submit']";
    String UPDATED_MESSAGE = "//*[contains(text(),'Community has been updated successfully.')]";

    // community_update locators
    String FIRST_THREE_DOT_ICON = "//button[@class='btn px-2 border-radius-12 border-0 action-button']//*[name()='svg']";
    String NAME_FIELD = "//input[@id='name']";
    String EDIT_COMMUNITY = "//small[normalize-space()='Edit Community']";

    String UPDATE_CONFIRM_MESSAGEIS = "//*[contains(text(),'Community has been updated successfully.')]";
    String COMMUNITY_SAVE_BUTTON = "//*[contains(text(),'Save')]";

    // COMMINITY DETAILS PAGE TITLE
    String DETAIL_TITLE = "//h4[normalize-space()='Details']";
    String LABEL_TITLE = "//div[contains(text(),'Upload image')]";
    String LABEL_UPLOAD_BANNER_TITLE = "//div[contains(text(),'Upload Banner')]";

    String UPLOAD_LOGO_SECTION = "(//input[@title='upload image'])[1]";
    String UPLOAD_IAMGE_BANNER = "(//input[@title='upload image'])[2]";
    String LOGO_SAVE_BUTTON = "//button[@type='button'][normalize-space()='Save']";
    String BANNER_SAVE_BUTTON = "//button[@type='button'][normalize-space()='Save']";
    String LINK_MESSAGE = "//*[contains(text(),'Link copied!')]";
    String LINK_ICON = "//button[@class='btn btn-outline-info rounded-1 btn-only-icon']";
    String GENERAL_TAB = "//button[normalize-space()='General']";
    String GENERAL_LABEL_TEXT = "//h4[normalize-space()='General']";
    String COMMUNITY_DESCRIPTION = "//textarea[@id='description']";
    String LOOP_TAB = "//button[normalize-space()='Loops']";
    String ABOUT_TAB = "//button[normalize-space()='About']";
    String ABOUT_LABEL_TEXT = "//h4[normalize-space()='About']";
    String MEMBERS_TAB = "//button[normalize-space()='Members (1)']";
    String LABEL_TEXT_MEMBERS = "//h5[normalize-space()='Members (1)']";

    // all users tab verification
    String ALL_USERS_SEARCHBOX = "//input[@id='searchInput']";
    String COLUMN_NAME = "//div[normalize-space()='Name']";
    String COLUMN_TYPE = "//div[normalize-space()='Type']";
    String COLUMN_CONTACT = "//div[normalize-space()='Contact']";
    String COLUMN_COMMUNITIES = "//div[normalize-space()='Communities']";
    String COLUMN_LOOPS = "//div[normalize-space()='Loops']";
    String THREE_DOT_ICON_FROM_TABLE = "//tbody/tr[1]/td[7]/div[1]/button[1]";
    String THREE_DOT_ICON_FROM_TABLE1 = "//tbody/tr[1]/td[7]/div[1]/button[1]";
    String SHARE_ICON = "//button[normalize-space()='Share']";
    String VERIFICATION_MESSAGE = "//*[contains(text(),'Profile URL copied!')]";

    public ManagePage(WebDriver driver) {
        super(driver);
    }

    public void selectBrand() {
        common.click(SELECT_ANY_BRAND);
        common.log("Select Any brand");
        common.waitUntilSpecificTitle("Dashboard");
        common.assertTwoValuesAreEqual(driver.getTitle(), "Dashboard");
        common.log("Verify that Dashboard page is open ");
    }

    public void verifyMangePage() {
//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.log("Click on mange page");
        common.pause(8);
        common.log("Click on page left nav");
        common.click(MANAGE_PAGELEFTNAV);
        common.pause(5);
        common.log("Verifying the manage page tab");
        common.log("click on the community tab");
        common.click(COMMUNITY_TAB);
        common.assertElementPresent(SEARCH_INPUT);
        common.log("verifying th column headers in the communities module");
        common.assertElementPresent(COMMUNITY_TBL_HEADER);
        common.assertElementPresent(LEADER_TBL_HEADER);
        common.assertElementPresent(DATE_TBL_CREATED);
        common.assertElementPresent(MEMBERS_TBL_HEADER);
        common.assertElementPresent(MODERATORS_TBL_HEADER);
        common.assertElementPresent(LOOPS_TBL_HEADER);
        common.assertElementPresent(POSTS_TBL_HEADER);
        common.log("verifying the items in the table content format");
        common.assertElementPresent(NEW_COMMUNITY_BUTTON);
        common.assertElementPresent(RECORDER_BUTTON);
        common.assertElementPresent(PIN_ICON);
        common.assertElementPresent(THREE_DOT_ICON);
        common.log("verifying the sorting icon in the table header icon");
        common.assertElementPresent(SORTING_ICON);
        common.log("verifying the pagination buttons");
        common.assertElementPresent(FORWARD_BUTTON);
        common.assertElementPresent(BACKWARD_BUTTON);
        common.log("verifying the page count dropdown");
        common.assertElementPresent(PAGE_COUNT);
        int previousPageCount = -1;

        for (int i = 1; i < 5; i++) {
            String PAGE_COUNT_LIST = driver.findElement(By.xpath("//select[@aria-label='Per']//option[" + i + "]")).getAttribute("value");
            int pageCount = Integer.parseInt(PAGE_COUNT_LIST);
            System.out.println("Page count in dropdown is => " + pageCount);
            if (i > 1) {
                assert pageCount == previousPageCount || pageCount > previousPageCount : "Assertion failed: The current page count is not identical or greater than the previous one.";
            }
            previousPageCount = pageCount;
        }

    }

    public void communityCreation() {
        System.out.println("create a new community test started !!");
//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.log("Click on mange page");
        common.pause(8);
        common.log("Click on page left nav");
        common.click(MANAGE_PAGELEFTNAV);
        common.pause(2);
        common.log("click on the community tab");
        common.click(COMMUNITY_TAB);
        common.click(CREATE_NEWCOMMUNITY);
        String communityName = common.generateRandomChars(3);
        common.log("community name is:" + communityName);
        common.type(COMMUNITY_NAME, communityName);
        common.scroll_To_Element(GENERATE_BUTTOIN);
        common.click(GENERATE_BUTTOIN);
        common.pause(2);
        String VERIFICATION_TEXT = driver.findElement(By.xpath("//div[@class='input-group has-validation']//div[@class='valid-feedback'][normalize-space()='Looks good!']")).getText();
        common.log("Verification text after clicking the generate button" + VERIFICATION_TEXT);
        common.type(COMMUNITY_DESCRIPTION, "TEST");
        common.click(CREATE_BUTTON);
        common.pause(5);
        String nameIs = driver.findElement(By.xpath(CREATED_COMPANY_NAME)).getAttribute("value");
        common.log("community name is :" + nameIs);
        common.assertTwoValuesAreEqual(nameIs, communityName);
        common.log("click on save button");
        common.click(SAVE_BUTTON);

        // failed this because of bug. It display message that "Something went wrong"
        common.log("verifying the updated message");
        common.assertElementPresent(UPDATED_MESSAGE);
        common.log("verifying the manage left navigation");
        common.click(MANAGE_PAGELEFTNAV);
        common.log("click on communities tab");
        common.click(COMMUNITY_TAB);
        common.log("enter the value in community name");
        common.type(SEARCH_INPUT, communityName);
        common.pause(8);
        String COMMUNITY_NAME_TBL = "//tbody/tr/td[1]/div[1]//a";
        String communityTableNameIs = driver.findElement(By.xpath(COMMUNITY_NAME_TBL)).getText();
        common.log("Community name in table is:" + communityTableNameIs);
        common.assertTwoValuesAreEqual(communityName, communityTableNameIs);
    }

    public void updateCommnunity() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        communityCreation();
        common.log("Click on three dot icon");
        common.click(FIRST_THREE_DOT_ICON);
        common.log("click on edit community");
        common.click(EDIT_COMMUNITY);
        common.log("Enter the value in the name field");
        String rand = common.generateRandomChars(3);
        common.log("Generated name to update the community name is :: " + rand);
        common.log("Enter the value in the name field");
        common.clear(NAME_FIELD);
        common.clear(NAME_FIELD);
        String existingCommunityName = driver.findElement(By.xpath(NAME_FIELD)).getAttribute("value");
        common.log("community name is:" + existingCommunityName);
        common.type(NAME_FIELD, rand);
        common.log("click on the save button");
        common.click(COMMUNITY_SAVE_BUTTON);
        common.log("verifying updated confirmation message");
        common.assertElementPresent(UPDATE_CONFIRM_MESSAGEIS);
        common.log("verifying the manage left navigation");
        common.click(MANAGE_PAGELEFTNAV);
        common.log("click on communities tab");
        common.click(COMMUNITY_TAB);
        common.log("enter the value in community name");
        common.type(SEARCH_INPUT, rand);
        String COMMUNITY_NAME_TBL = "//tbody/tr/td[1]/div[1]//a";
        String updatedcommunityFromTableNameIs = driver.findElement(By.xpath(COMMUNITY_NAME_TBL)).getText();
        common.log("updated community name from table is:" + updatedcommunityFromTableNameIs);
        common.log("actual community name  name is: " + existingCommunityName);
        common.assertTwoValuesAreEqual(existingCommunityName + rand, updatedcommunityFromTableNameIs);
    }

    public void communityDetailsSection() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        common.log("community details verification test has been started !!");
        communityCreation();
        common.log("Click on three dot icon");
        common.click(FIRST_THREE_DOT_ICON);
        common.log("click on edit community");
        common.click(EDIT_COMMUNITY);
        common.log("verify the details title");
        common.assertElementPresent(DETAIL_TITLE);
        common.log("verify the upload image label title");
        common.assertElementPresent(LABEL_TITLE);
        common.log("verify the upload banner title");
        common.assertElementPresent(LABEL_UPLOAD_BANNER_TITLE);
        try {
            driver.findElement(By.xpath(UPLOAD_LOGO_SECTION)).sendKeys("src/test/resources/logo.jpg");
            common.click(LOGO_SAVE_BUTTON);
            common.log("Logo image uploaded successfully !!");
            common.pause(25);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            driver.findElement(By.xpath(UPLOAD_IAMGE_BANNER)).sendKeys("src/test/resources/banner.png");
            common.click(BANNER_SAVE_BUTTON);
            common.log("Banner image uploaded successfully !!");
            common.pause(25);
        } catch (Exception e) {
            e.printStackTrace();
        }
        common.assertElementPresent(LINK_ICON);
        common.click(LINK_ICON);
        common.assertElementPresent(LINK_MESSAGE);
        common.log("verifying the general tab in the communities details");
        common.click(GENERAL_TAB);
        common.assertElementPresent(GENERAL_LABEL_TEXT);
        common.click(ABOUT_TAB);
        common.log("verifying the about us tab");
        common.assertElementPresent(ABOUT_LABEL_TEXT);
        common.click(MEMBERS_TAB);
        common.log("verifying the members tab");
        common.assertElementPresent(MEMBERS_TAB);
        common.assertElementPresent(LABEL_TEXT_MEMBERS);
        common.log("verifying the members title");
    }

    public void checkUsersTab() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        common.log("verification for the users tab test started!!");
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.log("Click on mange page");
        common.log("Click on page left nav");
        common.click(MANAGE_PAGELEFTNAV);
        String USERS_TAB = "//a[@href='/manage/users']";
        common.click(USERS_TAB);
        common.log("click on the users tab");
        String ALL_USER_TAB = "//*[contains(text(),'All Users')]";
        common.assertElementPresent(ALL_USER_TAB);
        common.log("verify the presence of all users tab");
        String COMMUNITY_BUILDER = "//*[contains(text(),'Community Builder')]";
        //  common.assertElementPresent(COMMUNITY_BUILDER);
        //   common.log("verify the presence of the community builder");

//        String COMMUNITY_MEMBERS = "//*[contains(text(),'Community Members')]";
//        common.assertElementPresent(COMMUNITY_MEMBERS);
//        common.log("verify the presence of the community members");

//        String LOOP_MEMBERS = "//*[contains(text(),'Loop Collaborators ')]";
//        common.assertElementPresent(LOOP_MEMBERS);
//        common.log("verify the presence of the community members");
        String TOTAL_NUMBERS_RECORD = "//span[@class='pagination__desc']";
        common.log("total numbers of record in the footer card");
        common.assertElementPresent(TOTAL_NUMBERS_RECORD);
    }

    public void checkAllUsersTab() {
        common.log("verification for the all users tab test started!!");

//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");

        common.log("Click on mange page");
        common.pause(8);

        common.log("Click on page left nav");
        common.click(MANAGE_PAGELEFTNAV);
        common.pause(3);
        String USERS_TAB = "//a[@href='/manage/users']";
        common.click(USERS_TAB);
        common.log("click on the users tab");

        common.log("Verification for the all users tab test started !! ");
        common.assertElementPresent(ALL_USERS_SEARCHBOX);

        String PLACE_HOLDER_VALUE = "//input[@placeholder='Search by username/handle or contact']";
        //String PLACE_HOLDER_TEXT = driver.findElement(By.xpath(PLACE_HOLDER_VALUE)).getText();
        //common.log("place holder text is:" + PLACE_HOLDER_TEXT);
        // common.assertTwoValuesAreEqual(PLACE_HOLDER_TEXT, "Search by username/handle or contact");

        common.log("first column name present");
        common.assertElementPresent(COLUMN_NAME);

        common.log("SECOND column name is present");
        common.assertElementPresent(COLUMN_TYPE);
        common.assertElementPresent(COLUMN_CONTACT);
        common.log("Third column name is present");

    }

    public void checkAllTableDetails() {
        common.log("column details verification test started!!");

//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");

        common.log("Click on mange page");
        common.pause(8);

        common.log("Click on page left nav");
        common.click(MANAGE_PAGELEFTNAV);
        common.pause(3);
        String USERS_TAB = "//a[@href='/manage/users']";
        common.click(USERS_TAB);
        common.log("click on the users tab");

        try {
            WebElement table = driver.findElement(By.tagName("table"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));

                if (columns.isEmpty()) {
                    continue;
                }

                for (WebElement column : columns) {
                    System.out.print(column.getText() + "\t");
                    // common.log(column.getText() + "\t");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void checkViewandShareOptions() {
        common.log("View and share option test started!! ");
//        common.pause(3);
//        common.click(SELECT_ANY_BRAND);
//        common.log("Select Any brand");
        common.log("Click on mange page");
        common.pause(8);

        common.log("Click on page left nav");
        common.click(MANAGE_PAGELEFTNAV);
        common.pause(3);

        common.click(USERS_TAB);
        common.log("click on the users tab");


        common.click(THREE_DOT_ICON_FROM_TABLE);
        common.log("click on three dot icon");

        String VIEW_PROFILE = "//button[normalize-space()='View Profile']";
        common.click(VIEW_PROFILE);
        common.log("click on view profile");
        common.pause(3);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.startsWith("https://") && currentUrl.contains("/profile")) {
            common.log("The URL is secure and contains the /profile endpoint.");
        } else {
            common.log("The URL does not meet the criteria.");
        }
        common.pause(3);
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        if (windowHandles.size() > 1) {
            driver.switchTo().window(windowHandles.get(0));
        }
        common.pause(3);
        common.click(THREE_DOT_ICON_FROM_TABLE1);
        common.log("click on three dot icon");
        for(int i=0; i < 5; i++) {
            if (common.isElementDisplayed(SHARE_ICON)) {
                common.click(SHARE_ICON);
                common.log("click on share icon");
                break;
            } else {
                common.click(THREE_DOT_ICON_FROM_TABLE1);
                common.pause(3);
            }
        }
        common.assertElementPresent(VERIFICATION_MESSAGE);
        common.log("verifying the link copied text is displaying");
    }

}