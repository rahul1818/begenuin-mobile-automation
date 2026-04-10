package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public abstract class Locators extends WebBasePage {

    public Locators(WebDriver driver)
    {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
        PageFactory.initElements(finder, this);
        this.driver = driver;
    }
    public int DRIVER_WAIT = 5;
    /*
     * Login Page Locators
     */
    @FindBy(xpath = "//p[@class='xsmall strong ng-star-inserted']//..//..//..//input")
    protected WebElement inputViewName;
    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    protected WebElement continueButton;
    @FindBy(xpath = "//input[@id='loginEmail']")
    protected WebElement username;
    @FindBy(xpath = "//input[@id='loginPassword']")
    protected WebElement password;
    @FindBy(xpath = "//div[@class='col-12 d-flex justify-content-center mb-4']")
    protected WebElement loginButton;
    @FindBy(xpath = "//div[@class='swiper-slide swiper-slide-active']//div[@class='absolute left-0 top-0 h-full w-full']//div[@class='relative h-full w-full']")
    protected WebElement videoFeed;


    public static String usernameLogin = "//input[@id='loginEmail']";
    public static String passLogin = "//input[@id='loginPassword']";
    public static String loginBtn =  "//div[@class='col-12 d-flex justify-content-center mb-4']";
    public static String SELECT_ANY_BRAND = "//div[@class='choose-brand-card d-flex align-items-center justify-content-between'][1]";
    public static String DASHBOARD_SCREEN = "//span[normalize-space()='Dashboard']";
    public static String ADD_BRAND_ELEMENT = "//div[@class='d-flex align-items-center'][.='Add Brand Elements']";
    public static String BRAND_PERSONA = "//button[contains(@class,'btn w-100 text-start rounded-1 mt-2 d-flex')][text()='Brand Persona']";
    public static String MISSION_BRANDPERSONA = "//label[@for='mission'][1]";
    public static String VISION_BRANDPERSONA = "//label[.='Vision*']";
    public static String VALUE_BRANDPERSONA = "//label[.='Values*']";
    public static String POLICIES_BRANDPERSONA = "//label[.='Policies*']";
    public static String PROCEDURES_BRANDPERSONA = "//label[.='Procedures*']";
    public static String WORKING_CONDITIONS_BRANDPERSONA = "//label[.='Working conditions*']";
    public static String CODE_OF_CONDUCT_BRANDPERSONA = "//label[.='Code of conduct/behavioral expectations*']";
    public static String DO_AS_BRANDPERSONA = "//label[.=\"Do's*\"]";
    public static String DONT_AS_BRANDPERSONA = "//label[.=\"Don't*\"]";
    public static String DOCUMENT_BRANDPERSONA = "//h5[text()='Upload docs']";
    public static String CHARLIMIT_FOR_MISSION = "//label[contains(normalize-space(),'300')][@for='mission']";
    public static String CHARLIMIT_FOR_VISION = "//label[contains(normalize-space(),'300')][@for='vision']";
    public static String CHARLIMIT_FOR_POLICIES = "//label[contains(normalize-space(),'1000')][@for='policies']";
    public static String CHARLIMIT_FOR_WORKING_CONDITIONS = "//label[contains(normalize-space(),'500')][@for='working_conditions']";
    public static String CHARLIMIT_FOR_CODE_OF_CONDUCT = "//label[contains(normalize-space(),'1000')][@for='code_of_conduct']";
    public static String CHARLIMIT_FOR_DO_AS = "//label[contains(normalize-space(),'1000')][@for='dos']";
    public static String CHARLIMIT_FOR_DONT_AS = "//label[contains(normalize-space(),'1000')][@for='donts']";
    public static String MISSION_FIELD = "//textarea[@id='mission']";
    public static String VISION_FIELD = "//textarea[@id='vision']";
    public static String VALUES_FIELD = "(//a[@class='react-tagsinput-remove'])";
    public static String POLICIES_FIELD = "//textarea[@id='policies']";
    public static String PROCEDURE_FIELD = "//textarea[@id='procedures']";
    public static String WORKING_CONDITIONS_FIELD = "//textarea[@id='working_conditions']";
    public static String CODE_OF_CONDUCT_FIELD = "//textarea[@id='code_of_conduct']";
    public static String DO_AS_FIELDS = "(//div[contains(@class,'react-tagsinput')])[4]";
    public static String DONT_AS_FIELD = "(//div[contains(@class,'react-tagsinput')])[6]";
    public static String DOCUMENT_FIELD = "//div[@class='d-flex align-items-center justify-content-between p-3 rounded-1 mt-2']";
    public static String REMOVE_BUTTON_BRANDPERSONA_DOCUMENT_FIELD = "//button[normalize-space()='Remove']";
    public static String CONTINUE_BUTTON_DISABLE_BRANDPERSONA = "//button[@class='btn btn-info disabled']";
    public static String LAUNCH_COMMUNITY_MEDIA_NETWORK = "//div[normalize-space()='Launch Community Media Network']";
    public static String BRAND_TYPE = "//button[normalize-space()='Brand type']";
    public static String RETAIL_NETWORK_OR_MARKET_PLACE = "//label[normalize-space()='Retail Network/ Marketplace']";
    public static String SELECT_BRAND_TRAFFIC_UNDER_1M = "//input[@id='trafficOne']";
    public static String CONSUMER_BRANDS = "//button[contains(.,'Consumer Brands')]";
    public static String TERMS_SHEET = "//button[normalize-space()='Term Sheet']";
    public static String NETWORK_OR_MARKET_PLACE_CONTINUE_BUTTON = "//button[normalize-space()='Continue']";
    public static String PUBLISH_YOUR_COMMUNITY_TEXT = "//h4[normalize-space()='Publish your community']";
    public static String OPTIONS_TRAFFIC_RANGE = "//div[@class='d-flex gap-3']/child::div";
    public static String BRAND_TYPE_MEDIA = "//div[@aria-labelledby='categoryTwoLabel']";
    public static String ALERT_MESSAGE = "//div[@role='alert']";
    public static String BRAND_TYPE_CONSUMER = "//label[normalize-space()='Consumer']";
    public static String CONSUMER_BRANDS_DISABLED = "(//div[contains(@class,'collapse show')])[2]";
    public static String TERM_SHEET_DISABLED = "(//div[contains(@class,'collapse show')])[3]";
    public static String SELECT_BRAND_TRAFFIC_1M_5M = "//label[normalize-space()='1M - 5M']";
    public static String SELECT_BRAND_TRAFFIC_5M_10M = "//label[normalize-space()='5M - 10M']";
    public static String SELECT_BRAND_TRAFFIC_MORE_THAN_10M = "//label[normalize-space()='More than 10M']";
    public static String NEXT_SECTION_CONSUMER_BRANDS = "//button[contains(.,'Consumer Brands')]";

    //Add Consumer Brand
    public static String TITLE_CONSUMER_BRAND = "//h4[normalize-space()='Add consumer brands to your network']";
    public static String ADD_CONSUMER_BRAND_BUTTON = "//button[normalize-space()='Add Brand to Earn']";
    public static String BRAND_USERNAME_CONSUMER_BRAND = "//input[@id='genuin_id']";
    public static String PUMA_SPORT_BRAND = "//div[@class='d-flex gap-2']//div";
    public static String CPM_FLOOR_PRICE = "//input[@id='cpm']";
    public static String YOUTUBE_HANDLE = "//input[@id='handles[0].inputValue']";
    public static String ADD_BUTTON = "//button[normalize-space()='Add']";

    //Term Sheet
    public static String PRIMARY_CONTACT_TERM_SHEET = "//legend[@class='h6 form-label mb-3 text-gray-800 fw-semibold']";
    public static String FULL_NAME = "//input[@name='msa.0.signerName']";
    public static String CONTACT_EMAIL = "//input[@name='msa.0.signerEmail']";
    public static String LEGAL_TEAM_ADD_PERSON_BUTTON = "//legend[contains(text(),'Legal Team for Review')]/descendant::button";
    public static String LEGAL_TEAM_FOR_REVIEW = "//legend[contains(text(),'Legal Team for Review')]";
    public static String PERSON_1_NAME_FOR_LEGAL_TEAM_REVIEW = "//input[@id='msa.0.legalTeamCC.0.name']";
    public static String PERSON_1_EMAIL_FOR_LEGAL_TEAM_REVIEW = "//input[@id='msa.0.legalTeamCC.0.email']";
    public static String TEAM_MEMBERS_FOR_NOTICE = "//legend[contains(.,'Team Members for Notice')]";
    public static String ADD_A_PERSON_BUTTON_TEAM_MEMBER = "//legend[contains(.,'Team Members for Notice')]/descendant::button";
    public static String PERSON_1_NAME_FOR_NOTICE_TEAM = "//input[@id='msa.0.legalNotificationCC.0.name']";
    public static String PERSON_1_EMAIL_FOR_NOTICE_TEAM = "//input[@id='msa.0.legalNotificationCC.0.email']";
    public static String SKIP_BUTTON = "//button[normalize-space()='Skip for now']";
    public static String CONTINUE_TERM_SHEET= "//button[normalize-space()='Skip for now']";
    public static String VALIDATION_TOASTER = "//div[@class='rnc__notification-title']";
    public static String LEGAL_TEAM_ADD_PERSON_BUTTON_CLICKBLE = "//button[normalize-space()='+ Add person']";
    public static String PERSON_2_LEGAL_TEAM = "//h6[normalize-space()='Person 2:']";
    public static String NOTICE_TEAM_ADD_PERSON_BUTTON_CLICKBLE = "//button[normalize-space()='+ Add a person']";
    public static String PERSON_2_NOTICE_TEAM = "//h6[normalize-space()='Person 2:']";
    public static String VALIDATIONMESSAGEFORCONTACTNAME = "//div[normalize-space()='Enter your name']";
    public static String VALIDATIONMESSAGEFORCONTACTEMAIL = "//div[normalize-space()='Enter your Email']";

    //FE Home page
    public static String POPULAR_OPTION = "//p[normalize-space()='Popular']";
    public  static String HEADER_FRONTEND = "//nav[contains(@class,'w-full items-center justify-between px-2 2xl:container xl:px-10 2xl:px-0')]";
    public  static  String DOWNLOAD_OPTION = "//p[@class='text-new-para-2 font-semibold text-tertiary-100']";
    public static String POPUP_VISIABLE = "//div[@id='radix-:rh:']";
    public static String HOME_OPTION = "//p[@class='hidden whitespace-nowrap !text-title-2-demi xl:block text-primary']";
    public static String VIDEO_FEED = "//div[@class='swiper-slide swiper-slide-active']//div[@class='absolute left-0 top-0 h-full w-full']//div[@class='relative h-full w-full']";
    public static String Log_In = "//p[@class='min-w-max text-title-3-demi text-monochrome-white']";
    public static String EMAIL_FIELD = "//input[@name='email']";
    public static String CONTINUE_BUTTON = "//button[@type='submit']";
    public static String ENTER_OTP = "//input[@name='otp']";
    public static String VERIFY_BUTTON = "//p[@class='text-title-3-demi']";
    public static String CheckboxBrandGuidelines = "//button[@role='checkbox' and @type='button']";
    public static String ClickFirstInterest = "//p[normalize-space()='Audience Segmentation in Healthcare']";
    public static String ClickSecondInterest = "//p[normalize-space()='Taxation on Crypto Currency']";
    public static String ClickThirdInterest = "//p[normalize-space()='Mandatory HSN For GST E Invoice']";


    //ENGAGE Engine
    public static String importVideoButton = "//span[contains(text(),'Import Videos')]";
    public static String engageEngineButton = "//span[normalize-space()='Engage Engine']";
    public static String uploadFolderButton = "//span[normalize-space()='Uploads']";
    public static String fileInputPath = "//input[@type='file']";
    public static String importButton = "//button[normalize-space()='Import']";
    public static String verifyMessage = "//div[@class='rnc__notification-message']";
}