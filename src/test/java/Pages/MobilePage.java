package Pages;

import Utils.MobileCommon;
import Utils.MobileBasePage;
import Utils.UserAction;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
//

import static Utils.UserAction.generateRandomNumberInteger;
import static Utils.UserAction.swipeFromLeftToRight;

public class MobilePage extends MobileBasePage {
    public MobileDriver driver;
    UserAction action = new UserAction();
    MobileCommon common = new MobileCommon();
    private Thread time;

    public MobilePage(MobileDriver driver) {
        this.driver = driver;
    }


    String LOGIN = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/go_login\"]";
    String ENTERPHONENUMBERFIELD = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/etMobileNo\"]";
    String SENDMECODEBUTTON = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnContinue\"]";
    String ENTERCODEFIELD = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/otpView\"]";
    String PHONEOPTION = "//android.widget.TextView[@text=\"Phone\"]";
    String EMAILOPTION = "//android.widget.TextView[@text=\"Email\"]";
    String ENTEREMAIL = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/etEmail\"]";
    String SENDMECODEBTNDISABLE = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnContinue\"]";
    String TERMSANDPOLICIES = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/txt_terms_privacy\"]";
    String GUIDLINETEXT = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvAgree\"]";
    String AGREERADIOBUTTON = "//android.widget.CheckBox[@resource-id=\"com.begenuin.begenuin.qa:id/checkboxAgree\"]";
    String HOMETEXT = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvFeedType\"]";
    String HOMEICON = "//android.widget.RelativeLayout[@resource-id=\"com.begenuin.begenuin.qa:id/navigation_first\"]";
    String EXPLOREICON = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/space_text\" and @text=\"Explore\"]";
    String CREATEICON = "//android.widget.RelativeLayout[@resource-id=\"com.begenuin.begenuin.qa:id/space\"]/android.widget.RelativeLayout[3]";
    String COMMUNITYICON = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/space_text\" and @text=\"Community\"]";
    String PROFILEICON = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/space_text\" and @text=\"You\"]";
    String EXPLORETEXT = "(//android.widget.TextView[@text=\"Explore\"])[1]";
    String CREATETEXT = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvMemberName\"]";
    String COMMUNITYTEXT = "//android.widget.TextView[@text=\"Your community\"]";
    String PROFILETEXT = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvFullName\"]";
    String GETSTARTEDBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/button_get_started\"]";
    String NEXTBTN = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/txt_next\"]";
    String DONEBTN = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/txt_next\"]";
    String LOGINORSIGNUPTEXT = "//android.widget.TextView[@text=\"Log in or sign up\"]";
    String ENTERYOURBIRTHDAYPAGE = "//android.widget.TextView[@text=\"Enter your birthday\"]";
    String DDMMYY = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/etDDDate\"]";
    String YEARLIST = "//android.widget.TextView[@text='2001']";
    String YEAR = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"1994\"]";
    String OKBTN = "//android.widget.Button[@resource-id=\"android:id/button1\"]";
    String USERNAME = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/etUserName\"]";
    String HUMBERGERMENU = "//android.widget.ImageView[@resource-id=\"com.begenuin.begenuin.qa:id/ivHamburgerMenu\"]";
    String SETTINGTEXT = "//android.widget.TextView[@text=\"Settings\"]";
    String LOGOUT = "//android.widget.TextView[@text=\"Log out\"]";
    String LOGOUTBTN = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/dialog_btn_yes\"]";
    String BIRTHYEAR = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"2001\"]";
    String CONTINUEBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnDOBContinue\"]";
    String USERNAMECONTINUEBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnUserNameContinue\"]";
    String NAMEFIELDFORPROFILE = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\"]";
    String BIOFIELD = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\" and @text=\"Bio\"]";
    String CONTINUEBTNFORPROFILE = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnProfileContinue\"]";
    String CREATEACOMMUNITYBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btn_create_community\"]";
    String COMMUNITYNAMEFIELD = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\"]";
    String COMMUNITYHANDLEFIELD = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvGenerate\"]";
    String CREATECOMMUNITY = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnPublish\"]";
    String COMMUNITYCREATEDTEXT = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvLoadingMessage\"]";
    String CONTINUEBTNFORMAIL = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnContinue\"]";
    String SKIPFORNOW = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/btnSocialDoItLater\"]";
    String NEWCOMMUNITY = "//android.widget.TextView[@text=\"Discuss ideas, grow your audience and engage with them closely.\"]";
    String CREATECOMMUNITYMANUALLY = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnCreateManually\"]";
    String AUTOCREATECOMMUNITY = "//android.widget.TextView[@text=\"Auto Create Community\"]";
    String EXPANDICONFORCOMMUNITY = "//android.widget.LinearLayout[@resource-id=\"com.begenuin.begenuin.qa:id/llBrand\"]/android.widget.ImageView[2]";
    String SELECTANKPALBRAND = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvBrandName\" and @text=\"ankpal\"]";
    String SELECTCATEGORY = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvCommunityCategory\" and @text=\"Digital Advertising and Targeting\"]";
    String CLICKNEXTBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnNext\"]";
    String SKIPBUTTON = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvSkip\"]";
    String CREATEAUTOCOMMUNITYBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnPublish\"]";
    String COMMUNITYCREATED = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvLoadingMessage\"]";
    String CREATELOOPBTN = "//androidx.cardview.widget.CardView[@resource-id=\"com.begenuin.begenuin.qa:id/cardMain\"]/android.widget.LinearLayout";
    String CREATELOOPMANUALLY = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnCreateManually\"]";
    String LOOPNAMEFIELD = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\" and @text=\"Try a topic, theme, or idea.\"]";
    String DESCRIPTIONFORLOOP = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\" and @text=\"Tell your viewers what your conversation will be about.\"]";
    String RECORDAPOSTBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnRecordAVideo\"]";
    String BACKCAMERA = "//android.widget.ImageView[@resource-id=\"com.begenuin.begenuin.qa:id/img_switch_camera\"]";
    String VIDEOSTARTBTN = "//android.widget.FrameLayout[@resource-id=\"com.begenuin.begenuin.qa:id/flRecordButton\"]";
    String VIDEOENDBTN = "//android.widget.ImageView[@resource-id=\"com.begenuin.begenuin.qa:id/img_circle2\"]";
    String RIGHTCHECKBUTTON = "//android.widget.ImageView[@resource-id=\"com.begenuin.begenuin.qa:id/ivRecordDone\"]";
    String NEXTBUTTONFORLOOP = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnPublish\"]";
    String POSTBUTTON = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnRecordAVideo\"]";
    String LOOPCREATED = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvLoopCreated\"]"; //Loop created!
    String SELECTANYCOMMUNITY = "(//androidx.cardview.widget.CardView[@resource-id=\"com.begenuin.begenuin.qa:id/cardCommunity\"])[1]/android.widget.LinearLayout";
    String DONEBUTTON = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnRecordAVideo\"]";
    String AUTOCREATELOOPBUTTON = "//android.widget.LinearLayout[@resource-id=\"com.begenuin.begenuin.qa:id/btnAutoCreate\"]";
    String TOPICFORAUTOLOOPCREATE = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvCommunityCategory\" and @text=\"Programmatic Advertising Efficiency\"]";
    String NEXTBTNFORAUTOLOOP = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnNext\"]";
    String DONEBUTTONFORAUTOLOOP = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btn_create_group\"]";
    String RECORDAPOSTBTNFORAUTOLOOP = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnRecordAVideo\"]";
    String ADDLINKTOLOOP = "//android.widget.TextView[@text=\"Add link\"]";
    String URLBOX = "(//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\"])[1]";
    String DONEBUTTONFORADDLINK = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvDone\"]";
    String SELECTPERTICULARCOMMUNITY = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvCommunityHandle\" and @text=\"Ahmedabad\"]";
    String SELECTOPTIONINBUSSINESS = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvSubCategory\" and @text=\"Startups\"]"; //Select Startups
    String SELECTOPTIONINFINANCE = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvSubCategory\" and @text=\"Crypto\"]"; //Select crypto
    String SELCECTOPTIONINBOOKS = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvSubCategory\" and @text=\"Self help books\"]";//select self help book
    String CONTINUEBTNTOJOINCOMMUNITY = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnContinue\"]";
    String NOTNOWBUTTON = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvNotNow\"]";
    String AGREEBUTTON = "//android.widget.CheckBox[@resource-id=\"com.begenuin.begenuin.qa:id/checkboxAgree\"]";
    String CONTINUETOGUIDLINEBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnContinue\"]";
    String CREATELOOP1 = "(//androidx.cardview.widget.CardView[@resource-id=\"com.begenuin.begenuin.qa:id/cardMain\"])[1]/android.widget.LinearLayout/android.widget.ImageView";
    //String RECENTLYCREATEDCOMMUNITY = "//androidx.cardview.widget.CardView[@resource-id=\"com.begenuin.begenuin.qa:id/cardCommunity\"]/android.widget.LinearLayout";
    String LOOPSFIELD = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/tvTabTitle\" and @text=\"Loops\"]";
    String RECENTLYCREATEDLOOP = "//android.widget.RelativeLayout[@resource-id=\"com.begenuin.begenuin.qa:id/rlLoopTile\"]";
    String VIDEOICONPOSTBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/fabPost\"]";
    String CREATEYOURAVATAR = "//android.widget.LinearLayout[@resource-id=\"com.begenuin.begenuin.qa:id/llCreateAvatar\"]";
    String PERSONADETAILS = "(//androidx.cardview.widget.CardView[@resource-id=\"com.begenuin.begenuin.qa:id/cvMain\"])[1]";
    String AVATARNAME = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\" and @text=\"Enter Avatar Name\"]";
    String HEADLINES = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\" and @text=\"The Maestro at Genuin Inc, Steering the Ship of Data Innovation\"]";
    String EXPERTISE = "//android.widget.EditText[@resource-id=\"com.begenuin.begenuin.qa:id/edit_text\" and @text=\"Data science, Machine learning, EdTech, AdTech, Data Product Officer, leadership\"]";
    String PERSONATRAITS = "(//androidx.cardview.widget.CardView[@resource-id=\"com.begenuin.begenuin.qa:id/cvMain\"])[3]";
    String SAVEBUTTON = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnContinue\"]";
    String UPLOADBUTTON = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnUpload\"]";
    String UPLOADPHOTOOPTION = "//android.widget.TextView[@text=\"Upload your Photo\"]";
    String UPLOADYOURPHOTOTEXT = "//android.widget.TextView[@text=\"Upload your Photo\"]";
    String UPLOAD = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnUpload\"]";
    String FAVOURITEIMAGESFOLDER = "(//android.widget.ImageView[@resource-id=\"com.sec.android.gallery3d:id/smart_album_image\"])[2]";
    String IMAGE = "//android.widget.ImageView[@resource-id=\"com.sec.android.gallery3d:id/thumbnail\"]";
    String SELECTBUTTONFORVOICE = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnSelect\"]";
    String AVATARVOICE = "(//android.widget.LinearLayout[@resource-id=\"com.begenuin.begenuin.qa:id/llMain\"])[2]";
    String CONTINUETOVOICEBTN = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnContinue\"]";
    String AUTOCREATEVIDEO = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnAutoCreate\"]";
    String KEYWORDSELECT = "(//android.widget.LinearLayout[@resource-id=\"com.begenuin.begenuin.qa:id/llMain\"])[3]/android.widget.LinearLayout";
    String GENERATEBUTTON = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnGenerate\"]";
    String CREATINGYOURVIDEOTEXT = "//android.widget.TextView[@text=\"Creating your AI video…\"]";
    String DONEBUTTONFORAVATAR = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnDone\"]";
    String CONTINUEBTNFORJOINFIRSTCOMMUNITY = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btnContinue\"]";
    String JOINACOMMUNITY = "//android.widget.Button[@resource-id=\"com.begenuin.begenuin.qa:id/btn_join_community\"]";
    String STARTYOURCOMMUNITYTEXT = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/introTitle\"]"; //Start your own community
    String DETAILEDINSTRUCTIONFORSTARTYOURCOMMUNITY = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/introSubtitle\"]"; //The best of communities plus the best of social media: start your own, or join communities created by your favorite creators and experts.
    String INSTRUCTION2 = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/introTitle\"]"; //Learn from & with each other
    String DETAILEDINSTRUCTION = "//android.widget.TextView[@resource-id=\"com.begenuin.begenuin.qa:id/introSubtitle\"]"; //We believe in the power of collective learning, through engaging in conversations with like-minded people.

    public void setFieldValue(MobileDriver driver, MobileElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '" + value + "';", element);
    }


    public void logInWithPhoneNumber() throws Exception {
        common.logStepMessage("Verify Login with Phone number  -----Test execution Started.");
        common.pause(10);

        action.click(driver, LOGIN, "Log In");
        common.pause(10);
        action.enter_text(driver, ENTERPHONENUMBERFIELD, "8238262730");
        common.pause(7);
        driver.hideKeyboard();
        action.waitForElement(driver, SENDMECODEBUTTON);

        action.click(driver, SENDMECODEBUTTON, "Send me a code");
        action.waitForElement(driver, ENTERCODEFIELD);
        action.enter_text(driver, ENTERCODEFIELD, "123456");

        common.logStepMessage("Verify Login with Phone number  -----Test execution end.");

    }
    public void welcomePageInstruction(){
        common.pause(10);
        action.click(driver, GETSTARTEDBTN, "Get Started");

        action.waitForElement(driver, STARTYOURCOMMUNITYTEXT);
        String StartYourCommunityText = action.findElementByXpath(driver, STARTYOURCOMMUNITYTEXT).getText();
        Assert.assertEquals(StartYourCommunityText , "Start your own community");

        action.waitForElement(driver,DETAILEDINSTRUCTIONFORSTARTYOURCOMMUNITY);
        String Informatrion = action.findElementByXpath(driver, DETAILEDINSTRUCTIONFORSTARTYOURCOMMUNITY).getText();
        Assert.assertEquals(Informatrion, "The best of communities plus the best of social media: start your own, or join communities created by your favorite creators and experts.");

        action.waitForElement(driver,NEXTBTN);
        action.click(driver, NEXTBTN, "Next");

        action.waitForElement(driver, INSTRUCTION2);
        String InstructionHeading = action.findElementByXpath(driver, INSTRUCTION2).getText();
        Assert.assertEquals(InstructionHeading, "Learn from & with each other");

        action.waitForElement(driver, DETAILEDINSTRUCTION);
        String DetailedInstruction = action.findElementByXpath(driver,DETAILEDINSTRUCTION).getText();
        Assert.assertEquals(DetailedInstruction, "We believe in the power of collective learning, through engaging in conversations with like-minded people.");

        action.waitForElement(driver, DONEBTN);
        action.click(driver, DONEBTN, "Done");

    }



    public void verifyLoginPageElementsArePresent() throws Exception {
        common.logStepMessage("Verify login page elements are present -----Test execution Started.");

        common.pause(8);
        action.click(driver, LOGIN, "Log In");
        action.waitForElement(driver, PHONEOPTION);
        action.click(driver, PHONEOPTION, "Phone");

        action.waitForElement(driver,ENTERPHONENUMBERFIELD);
        String containTextPhoneNumber = action.findElementByXpath(driver, ENTERPHONENUMBERFIELD).getText();
        Assert.assertEquals(containTextPhoneNumber, "Enter your phone");
        action.click(driver, EMAILOPTION, "Email Address");

        action.waitForElement(driver,ENTEREMAIL);
        String containTextEmailField = action.findElementByXpath(driver, ENTEREMAIL).getText();
        Assert.assertEquals(containTextEmailField, "Enter your email");

        action.waitForElement(driver,SENDMECODEBTNDISABLE);
        boolean btnDisable = action.findElementByXpath(driver, SENDMECODEBTNDISABLE).isEnabled();
        Assert.assertFalse(btnDisable);
        driver.hideKeyboard();

        action.waitForElement(driver,TERMSANDPOLICIES);
        String termsAndprivacy = action.findElementByXpath(driver, TERMSANDPOLICIES).getText();
        Assert.assertTrue(termsAndprivacy.contains("Terms"));
        Assert.assertTrue(termsAndprivacy.contains("Privacy Policy"));
        common.logStepMessage("Footer text is :" + termsAndprivacy);

        common.logStepMessage("Verify login page elements are present -----Test execution end.");

    }

    public void logInWithEmail() throws Exception {
        common.logStepMessage("Verify login with Email -----Test execution Started.");

        common.pause(10);
        action.waitForElement(driver, LOGIN);
        action.click(driver, LOGIN, "Log In");
        action.waitForElement(driver, EMAILOPTION);
        action.click(driver, EMAILOPTION, "Email Address");

        action.waitForElement(driver, ENTEREMAIL);
        action.enter_text(driver, ENTEREMAIL, "lc@yopmail.com");
        common.pause(5);
        driver.hideKeyboard();
        action.waitForElement(driver, SENDMECODEBUTTON);

        boolean btnEnable = action.findElementByXpath(driver, SENDMECODEBTNDISABLE).isEnabled();
        Assert.assertTrue(btnEnable, "Button is Enable");
        action.click(driver, SENDMECODEBUTTON, "Send me a code");
        action.waitForElement(driver, ENTERCODEFIELD);

        action.enter_text(driver, ENTERCODEFIELD, "123456");

        action.waitForElement(driver, HOMETEXT);
        String containTextHome = action.findElementByXpath(driver, HOMETEXT).getText();
        Assert.assertEquals(containTextHome, "Home");
        common.logStepMessage("Verify Login with email -----Test execution end.");
    }

    public void loginWithEmail_LogOut() {
        common.pause(10);
        action.click(driver, PROFILEICON, "User profile");

        action.waitForElement(driver,HUMBERGERMENU);
        action.click(driver, HUMBERGERMENU, "Humberger menu");
        action.waitForElement(driver,SETTINGTEXT);
        action.click(driver, SETTINGTEXT, "Setting");

        action.waitForElement(driver,LOGOUT);
        action.click(driver, LOGOUT, "Log Out");
        action.waitForElement(driver,LOGOUTBTN);
        action.click(driver, LOGOUTBTN, "Log out button press");
        //common.step("Logout successfully");
    }

    public void verifyElementsArePresent() throws Exception {
        common.logStepMessage("Verify all elements are present -----Test execution Started.");
        common.pause(30);
        action.click(driver, EXPLOREICON, "Explore");

        action.waitForElement(driver, EXPLORETEXT);
        String containTextExplore = action.findElementByXpath(driver, EXPLORETEXT).getText();
        Assert.assertEquals(containTextExplore, "Explore");

        action.waitForElement(driver, CREATEICON);

        action.click(driver, CREATEICON, "Create");

        action.waitForElement(driver, CREATETEXT);
        String containTextCreate = action.findElementByXpath(driver, CREATETEXT).getText();
        Assert.assertEquals(containTextCreate, "Create");
        driver.navigate().back();

        action.waitForElement(driver, COMMUNITYICON);
        action.click(driver, COMMUNITYICON, "Community");

        action.waitForElement(driver, COMMUNITYTEXT);
        String containTextCommunity = action.findElementByXpath(driver, COMMUNITYTEXT).getText();
        Assert.assertEquals(containTextCommunity, "Your community");


        action.waitForElement(driver, PROFILEICON);
        action.click(driver, PROFILEICON, "Profile");

        action.waitForElement(driver, PROFILETEXT);
        String containTextProfile = action.findElementByXpath(driver, PROFILETEXT).getText();
        Assert.assertEquals(containTextProfile, "@tester");

        common.logStepMessage("Verify All Elements are present -----Test execution end.");

    }

    public void signUpFlow() throws InterruptedException {
        common.logStepMessage("Verify SignUp Flow -----Test execution Started.");

        common.pause(10);
        action.click(driver, GETSTARTEDBTN, "Get Started");
        action.waitForElement(driver, NEXTBTN);

        action.click(driver, NEXTBTN, "Next");
        action.waitForElement(driver, DONEBTN);
        action.click(driver, DONEBTN, "Done");

        action.waitForElement(driver, LOGINORSIGNUPTEXT);
        String loginOrSignUpText = action.findElementByXpath(driver, LOGINORSIGNUPTEXT).getText();
        Assert.assertEquals(loginOrSignUpText, "Log in or sign up");

        action.waitForElement(driver,PHONEOPTION);
        action.click(driver, PHONEOPTION, "Phone");

        action.waitForElement(driver,ENTERPHONENUMBERFIELD);
        String no = common.GenerateRandomNumber(10);
        action.enter_text(driver, ENTERPHONENUMBERFIELD, no);
        common.pause(2);
        driver.hideKeyboard();

        action.waitForElement(driver, SENDMECODEBUTTON);
        action.click(driver, SENDMECODEBUTTON, "send me a code");
        action.waitForElement(driver,ENTERCODEFIELD);
        action.enter_text(driver, ENTERCODEFIELD, "123456");

        action.waitForElement(driver,ENTERYOURBIRTHDAYPAGE);
        String YourBirthday = action.findElementByXpath(driver, ENTERYOURBIRTHDAYPAGE).getText();
        Assert.assertEquals(YourBirthday, "Enter your birthday");

        action.waitForElement(driver,DDMMYY);
        action.click(driver, DDMMYY, "date Picker");

        action.waitForElement(driver,OKBTN);
        action.click(driver, OKBTN, "Ok");

        action.waitForElement(driver,CONTINUEBTN);
        action.click(driver, CONTINUEBTN, "Continue");

        action.waitForElement(driver,USERNAME);
        action.click(driver, USERNAME, "user name");
        common.pause(5);
        action.clear(driver, USERNAME, "user name");
        String Username = action.generateRandomChars(6);
        MobileElement element = (MobileElement) driver.findElementByXPath(USERNAME);
        common.pause(5);
        Actions actions = new Actions(driver);
        actions.sendKeys(Username).perform();
        common.logStepMessage("Character Added :: " + Username + "\n");

        action.waitForElement(driver,USERNAMECONTINUEBTN);
        action.click(driver, USERNAMECONTINUEBTN, "Continue to user");

        action.waitForElement(driver, NAMEFIELDFORPROFILE);
        String name = action.generateRandomChars(8);
        action.enter_text(driver, NAMEFIELDFORPROFILE, name);
        common.pause(2);
        driver.hideKeyboard();

        action.waitForElement(driver, BIOFIELD);
        String bio = action.generateRandomChars(60);
        action.enter_text(driver, BIOFIELD, bio);
        common.pause(2);
        driver.hideKeyboard();

        action.waitForElement(driver, CONTINUEBTNFORPROFILE);
        action.click(driver, CONTINUEBTNFORPROFILE, "Continue ");

        action.waitForElement(driver, ENTEREMAIL);
        String email = action.generateRandomChars(4);
        action.enter_text(driver, ENTEREMAIL, email + "@gmail.com");
        common.pause(5);
        driver.hideKeyboard();
        action.waitForElement(driver, SENDMECODEBUTTON);
        action.click(driver, SENDMECODEBUTTON, "Send me a code");

        action.waitForElement(driver, ENTERCODEFIELD);
        action.enter_text(driver, ENTERCODEFIELD, "123456");

        action.waitForElement(driver, SKIPFORNOW);
        action.click(driver, SKIPFORNOW, "Skip for now");

        action.waitForElement(driver, CREATEACOMMUNITYBTN);
        action.click(driver, CREATEACOMMUNITYBTN, "Create Community");

        action.waitForElement(driver, COMMUNITYNAMEFIELD);
        String CommunityName = action.generateRandomChars(7);
        action.enter_text(driver, COMMUNITYNAMEFIELD, CommunityName);

        action.waitForElement(driver, COMMUNITYHANDLEFIELD);
        action.click(driver, COMMUNITYHANDLEFIELD, "Generate");
        common.pause(10);
        driver.hideKeyboard();
        action.waitForElement(driver, CREATECOMMUNITY);
        action.click(driver, CREATECOMMUNITY, "Create Community...");

        action.waitForElement(driver, COMMUNITYCREATEDTEXT);
        String communityCreated = action.findElementByXpath(driver, COMMUNITYCREATEDTEXT).getText();
        Assert.assertEquals(communityCreated, "Community created!");

        common.logStepMessage("Verify SignUp Flow -----Test execution end.");

    }

    public void createCommunityWithLoginFlow() throws Exception {
        common.logStepMessage("Verify Create Community with Login -----Test execution Started.");
        common.pause(10);
        logInWithPhoneNumber();

        action.waitForElement(driver, CREATEICON);
        action.click(driver, CREATEICON, "Create");
        action.waitForElement(driver, NEWCOMMUNITY);
        action.click(driver, NEWCOMMUNITY, "New Community");
        action.waitForElement(driver, CREATECOMMUNITYMANUALLY);
        action.click(driver, CREATECOMMUNITYMANUALLY, "Create Community manually");

        action.waitForElement(driver, COMMUNITYNAMEFIELD);
        String CommunityNameManually = action.generateRandomChars(7);
        action.enter_text(driver, COMMUNITYNAMEFIELD, CommunityNameManually);
        common.pause(5);
        driver.hideKeyboard();

        action.waitForElement(driver, COMMUNITYHANDLEFIELD);
        action.click(driver, COMMUNITYHANDLEFIELD, "Generate");
        action.waitForElement(driver, CREATECOMMUNITY);
        action.click(driver, CREATECOMMUNITY, "Create Community...");

        action.waitForElement(driver, COMMUNITYCREATEDTEXT);
        String communityCreated = action.findElementByXpath(driver, COMMUNITYCREATEDTEXT).getText();
        Assert.assertEquals(communityCreated, "Community created!");

        common.logStepMessage("Verify Create Community with Login -----Test execution end.");
    }

    public void createCommunityAutomatically() throws Exception {
        common.pause(10);
        logInWithPhoneNumber();
        action.waitForElement(driver, CREATEICON);
        action.click(driver, CREATEICON, "Create");
        action.waitForElement(driver, NEWCOMMUNITY);
        action.click(driver, NEWCOMMUNITY, "New Community");

        action.waitForElement(driver, AUTOCREATECOMMUNITY);
        action.click(driver, AUTOCREATECOMMUNITY, "Auto Create Community");
        action.waitForElement(driver, EXPANDICONFORCOMMUNITY);
        action.click(driver, EXPANDICONFORCOMMUNITY, "Expand");

        action.waitForElement(driver, SELECTANKPALBRAND);
        action.click(driver, SELECTANKPALBRAND, "Ankpal");
        action.waitForElement(driver, SELECTCATEGORY);
        action.click(driver, SELECTCATEGORY, "Select category");
        action.waitForElement(driver, CLICKNEXTBTN);
        action.click(driver, CLICKNEXTBTN, "Next");

        action.waitForElement(driver, SKIPBUTTON);
        action.click(driver, SKIPBUTTON, "Skip");
        common.pause(7);
        action.waitForElement(driver, CREATEAUTOCOMMUNITYBTN);
        action.click(driver, CREATEAUTOCOMMUNITYBTN, "Create Auto community");
        action.waitForElement(driver, COMMUNITYCREATED);
        String autoCommunityCreated = action.findElementByXpath(driver, COMMUNITYCREATED).getText();
        Assert.assertEquals(autoCommunityCreated, "Community created!");
    }

    public void createLoop() {
        common.pause(10);
        // action.waitForElement(driver,CREATELOOP1);
        action.click(driver, CREATELOOP1, "Create Loop");
        action.waitForElement(driver, CREATELOOPMANUALLY);
        action.click(driver, CREATELOOPMANUALLY, "Create Loop manually");

        action.waitForElement(driver, LOOPNAMEFIELD);
        String LoopName = action.generateRandomChars(7);
        action.enter_text(driver, LOOPNAMEFIELD, LoopName);
        common.pause(7);
        driver.hideKeyboard();

        action.waitForElement(driver, DESCRIPTIONFORLOOP);
        String Description = action.generateRandomChars(45);
        action.enter_text(driver, DESCRIPTIONFORLOOP, Description);
        action.waitForElement(driver, RECORDAPOSTBTN);
        action.click(driver, RECORDAPOSTBTN, "Record a post");

        action.waitForElement(driver, BACKCAMERA);
        action.click(driver, BACKCAMERA, "Back camera icon");
        action.waitForElement(driver, VIDEOSTARTBTN);
        action.click(driver, VIDEOSTARTBTN, "start");
        action.waitForElement(driver, VIDEOENDBTN);
        action.click(driver, VIDEOENDBTN, "END");

        action.waitForElement(driver, RIGHTCHECKBUTTON);
        action.click(driver, RIGHTCHECKBUTTON, "Check it ok");
        action.waitForElement(driver, NEXTBUTTONFORLOOP);
        action.click(driver, NEXTBUTTONFORLOOP, "Next ");
        action.waitForElement(driver, POSTBUTTON);
        action.click(driver, POSTBUTTON, "Post video");

        action.waitForElement(driver, LOOPCREATED);
        String LoopCreatedMessage = action.findElementByXpath(driver, LOOPCREATED).getText();
        Assert.assertEquals(LoopCreatedMessage, "Loop created!");
        action.waitForElement(driver, DONEBUTTON);
        action.click(driver, DONEBUTTON, "DONE");

    }

    public void createLoopManually() throws Exception {
        common.pause(10);
        logInWithPhoneNumber();
        action.waitForElement(driver, COMMUNITYICON);
        action.click(driver, COMMUNITYICON, "Community");
        action.waitForElement(driver, SELECTANYCOMMUNITY);
        action.click(driver, SELECTANYCOMMUNITY, "Select any one");

        action.scrollDownMobile(driver);
        createLoop();

    }

    public void createLoopAutomatically() throws Exception {
        common.pause(10);
        logInWithPhoneNumber();
        action.waitForElement(driver, COMMUNITYICON);
        action.click(driver, COMMUNITYICON, "Community");
        action.waitForElement(driver, SELECTPERTICULARCOMMUNITY);
        action.click(driver, SELECTPERTICULARCOMMUNITY, "Select any one");

        action.scrollDownMobile(driver);
        action.waitForElement(driver, CREATELOOPBTN);
        action.click(driver, CREATELOOPBTN, "Create Loop");
        action.waitForElement(driver, AUTOCREATELOOPBUTTON);
        action.click(driver, AUTOCREATELOOPBUTTON, "Auto create loop");

        action.waitForElement(driver, TOPICFORAUTOLOOPCREATE);
        action.click(driver, TOPICFORAUTOLOOPCREATE, "Topic");
        action.waitForElement(driver, NEXTBTNFORAUTOLOOP);
        action.click(driver, NEXTBTNFORAUTOLOOP, "Next......");
        action.waitForElement(driver, DONEBUTTONFORAUTOLOOP);
        action.click(driver, DONEBUTTONFORAUTOLOOP, "DONE....");

        // pause require for hide keyboard
        common.pause(5);
        driver.hideKeyboard();
        action.waitForElement(driver, RECORDAPOSTBTNFORAUTOLOOP);
        action.click(driver, RECORDAPOSTBTNFORAUTOLOOP, "Record a post");
        action.waitForElement(driver, BACKCAMERA);
        action.click(driver, BACKCAMERA, "Back camera icon");
        action.waitForElement(driver, VIDEOSTARTBTN);
        action.click(driver, VIDEOSTARTBTN, "start");

        action.waitForElement(driver, VIDEOENDBTN);
        action.click(driver, VIDEOENDBTN, "END");
        action.waitForElement(driver, RIGHTCHECKBUTTON);
        action.click(driver, RIGHTCHECKBUTTON, "Check it ok");

        action.waitForElement(driver, NEXTBUTTONFORLOOP);
        action.click(driver, NEXTBUTTONFORLOOP, "NEXT");
        action.waitForElement(driver, ADDLINKTOLOOP);
        action.click(driver, ADDLINKTOLOOP, "Add Link");

        driver.hideKeyboard();
        action.waitForElement(driver, URLBOX);
        action.enter_text(driver, URLBOX, "www.amazon.in");
        action.waitForElement(driver, DONEBUTTONFORADDLINK);
        action.click(driver, DONEBUTTONFORADDLINK, "Done");
        action.waitForElement(driver, RECORDAPOSTBTNFORAUTOLOOP);
        action.click(driver, RECORDAPOSTBTNFORAUTOLOOP, "POST");

        action.waitForElement(driver, LOOPCREATED);
        String LoopCreatedMessage = action.findElementByXpath(driver, LOOPCREATED).getText();
        Assert.assertEquals(LoopCreatedMessage, "Loop created!");
        action.waitForElement(driver, DONEBUTTON);
        action.click(driver, DONEBUTTON, "DONE");
        //wait for post the video

    }

    public void createAvtar() throws Exception {
        common.pause(10);
        signUpFlow();
        createLoop();
        action.waitForElement(driver, SELECTOPTIONINBUSSINESS);
        action.click(driver, SELECTOPTIONINBUSSINESS, "select option for bussiness");
        action.waitForElement(driver, SELECTOPTIONINFINANCE);
        action.click(driver, SELECTOPTIONINFINANCE, "Select option for finance");

        action.waitForElement(driver, SELCECTOPTIONINBOOKS);
        action.click(driver, SELCECTOPTIONINBOOKS, "select option for books");
        action.waitForElement(driver, CONTINUEBTNTOJOINCOMMUNITY);
        action.click(driver, CONTINUEBTNTOJOINCOMMUNITY, "Continue");
        //Pause due to it's take long time to load
        common.pause(30);

        if (driver.findElement(By.xpath(CONTINUEBTNTOJOINCOMMUNITY)).isEnabled()) {
            action.click(driver, CONTINUEBTNFORJOINFIRSTCOMMUNITY, "CONTINUE to JOIN COmmunity");
            common.logStepMessage("Clicking on Continue.....");
        } else {
            //  action.waitForElement(driver, NOTNOWBUTTON);
            action.click(driver, NOTNOWBUTTON, "Not now");
            common.logStepMessage("Clicking on Not now.....");
        }

        action.waitForElement(driver, AGREEBUTTON);
        action.click(driver, AGREEBUTTON, "Agree and continue");
        action.waitForElement(driver, CONTINUETOGUIDLINEBTN);
        action.click(driver, CONTINUETOGUIDLINEBTN, "Continue");

        action.waitForElement(driver, COMMUNITYICON);
        action.click(driver, COMMUNITYICON, "Community");
        action.waitForElement(driver, LOOPSFIELD);
        action.click(driver, LOOPSFIELD, "Loops");
        action.waitForElement(driver, RECENTLYCREATEDLOOP);
        action.click(driver, RECENTLYCREATEDLOOP, "loops");

        action.waitForElement(driver, VIDEOICONPOSTBTN);
        action.click(driver, VIDEOICONPOSTBTN, "Post");
        action.waitForElement(driver, CREATEYOURAVATAR);
        action.click(driver, CREATEYOURAVATAR, "Create Your Avatar");
        action.waitForElement(driver, PERSONADETAILS);
        action.click(driver, PERSONADETAILS, "Persona Details");

        action.waitForElement(driver, AVATARNAME);
        String AvatarName = action.generateRandomChars(7);
        action.enter_text(driver, AVATARNAME, AvatarName);
        action.waitForElement(driver, HEADLINES);
        String Headlines = action.generateRandomChars(40);

        action.enter_text(driver, HEADLINES, Headlines);
        action.waitForElement(driver, EXPERTISE);
        String Expertise = action.generateRandomChars(70);
        action.enter_text(driver, EXPERTISE, Expertise);

        action.waitForElement(driver, PERSONATRAITS);
        action.click(driver, PERSONATRAITS, "Persona Traits");
        action.waitForElement(driver, SAVEBUTTON);
        action.click(driver, SAVEBUTTON, "SAVE");

        action.waitForElement(driver, UPLOADBUTTON);
        action.click(driver, UPLOADBUTTON, "Upload your photo");

        action.waitForElement(driver, UPLOADYOURPHOTOTEXT);
        action.verifyElementIsDisplayed(driver, UPLOADYOURPHOTOTEXT);
        action.waitForElement(driver, UPLOAD);
        action.click(driver, UPLOAD, "Upload");
        action.waitForElement(driver, FAVOURITEIMAGESFOLDER);
        action.click(driver, FAVOURITEIMAGESFOLDER, "favourite image");

        action.waitForElement(driver, IMAGE);
        action.click(driver, IMAGE, "Image");
        action.scrollDownMobile(driver);

        action.waitForElement(driver, AVATARVOICE);
        action.click(driver, AVATARVOICE, "Avatar");
        action.waitForElement(driver, SELECTBUTTONFORVOICE);
        action.click(driver, SELECTBUTTONFORVOICE, "Select");
        action.waitForElement(driver, AVATARVOICE);
        action.click(driver, AVATARVOICE, "Voice");

        action.waitForElement(driver, CONTINUETOVOICEBTN);
        action.click(driver, CONTINUETOVOICEBTN, "Continue");
        action.waitForElement(driver, AUTOCREATEVIDEO);
        action.click(driver, AUTOCREATEVIDEO, "Auto create video");

        action.waitForElement(driver, KEYWORDSELECT);
        action.click(driver, KEYWORDSELECT, "Keyword");
        action.waitForElement(driver, GENERATEBUTTON);
        action.click(driver, GENERATEBUTTON, "Generate");
        action.waitForElement(driver, CREATINGYOURVIDEOTEXT);
        action.verifyElementIsDisplayed(driver, CREATINGYOURVIDEOTEXT);

        action.waitForElement(driver, DONEBUTTONFORAVATAR);
        action.click(driver, DONEBUTTONFORAVATAR, "DONE");
    }
}
