package Utils;

import Config.ReadProperties;
import Pages.*;
import Pages.WebFrontEndPage.FEhomePage;
import Tests.WebTest.DashBoardTest;
import Tests.WebTest.WhitelabelSettingTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.Response;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class WebBasePage implements ITestListener {
    static Properties configProperties = null;
    protected static WebDriver driver;

    public LoginPage loginPage;
    public WebCommon common;
    public DashBoardTest dashBoardTest;
    public ReadProperties readProperties;
    public DashBoardPage dashBoardPage;
    public ManagePage managePage;
    public EmbedPage embedPage;
    public WhitelabelSettingPage whitelabelSettingPage;
    public static String currentTest; // current running test
    protected static String environmentName = "";
    protected static String environmentNameForExcel = "";
    protected static String test_data_folder_path = null;
    public static ThreadLocal<Integer> steps = new ThreadLocal<Integer>();
    private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
    protected static String screenshot_folder_path = null;
    public FEhomePage fEhomePage;
    public EngageEnginePage emgageEnginePage;

    // public AttachScreenshot attachScreenshot = new AttachScreenshot();
    Logger logger = Logger.getLogger(String.valueOf(WebBasePage.class));

//	private WebDriver getWebDriver(String browserOption, String headless, ChromeOptions options) {
//	//	WebDriver webDriver = null;
//		if (browserOption.equals(BrowserOption.CHROME.toString())) {
//
//			if (headless.equals("true")) {
//				//	options.addArguments("--headless");
//				options.addArguments("--headless", "--window-size=1920,1200");
//			}
//			driver = new ChromeDriver(options);
//		}
//		return driver;
//	}
    public static int step = 0;
    @BeforeSuite(alwaysRun = true)
    public void setUp(ITestContext context, XmlTest test) {
        // This will cause the error because only one of ITestContext or XmlTest can be injected.
    }

    // @Parameters("browserOption")
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

//        currentTest = method.getName(); // get Name of current test.
//        String SCREENSHOT_FOLDER_NAME = "screenshots";
//        String TESTDATA_FOLDER_NAME = "test_data";
//
//        test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
//        screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();

//      String driverPath = getPropertyValue("driverPath");
        String browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("−−incognito"); // open browser in InCognito mode

        options.addArguments("start-maximized"); // open Browser in maximized mode

        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems

        options.addArguments("--no-sandbox"); // Bypass OS security model

        options.addArguments("--remote-allow-origins=*");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
        prefs.put("download.default_directory", new File("downloads").getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);
//            if (headless.equals("true")) {
//                options.addArguments("--headless", "--window-size=1920,1200");
////                options.addArguments("--headless");
//            }
//        WebDriverManager.chromedriver().clearResolutionCache().setup();
            WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        threadLocalDriver.set(driver);

        driver.manage().window().maximize();
        common = new WebCommon(driver);
        readProperties = new ReadProperties();
        dashBoardPage = new DashBoardPage(driver);
        loginPage = new LoginPage(driver);
        managePage = new ManagePage(driver);
        embedPage = new EmbedPage(driver);
        whitelabelSettingPage = new WhitelabelSettingPage(driver);
        fEhomePage = new FEhomePage(driver);
        emgageEnginePage = new EngageEnginePage(driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        steps.set(1);
    }

    protected Properties getConfigProperties() {
        if (configProperties == null) {
            configProperties = this.loadProperties(Paths.get("").toAbsolutePath().normalize().toString()
                    + "/src/test/java/Config/runConfig.properties");
        }
        return configProperties;
    }

    protected Properties getConfigPropertiesForEnvironment(String propertyFilePath) {
        configProperties = this
                .loadProperties(Paths.get("").toAbsolutePath().normalize().toString() + propertyFilePath);
        return configProperties;
    }

    protected String getPropertyValue(String value) {
        Properties properties = getConfigProperties();
        return properties.getProperty(value);
    }

    public String current_Date_Time() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        // System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }

    private Properties loadProperties(String filePath) {
        File file = new File(filePath);
        FileInputStream fileInput = null;

        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();

        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    /**
     * After Method {TearDown}
     *
     * @param testResult
     * @throws IOException
     * @throws FileNotFoundException
     */

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) throws Exception {
        String testName = testResult.getName();
        Reporter.setCurrentTestResult(testResult);
        String endTime = current_Date_Time();
        Reporter.log("<br><b>Script end time: " + endTime + "</b></br>");

        File img = new File("target" + File.separator + "test-output" + File.separator + testName + ".png");
        if (testResult.getStatus() == 1) {
            log("<font color = 'green'><b><i><u><br>Pass :: " + testResult.getName() + "</u></i></b></font>");
            testResult.getThrowable();
//            attachmentReportApi(tc_ID);
        }
        if (testResult.getStatus() == 2) {
            log("<font color = 'red'><b><i><u><br>Fail :: " + testResult.getName() + "</u></i></b></font>");
            String strException = testResult.getThrowable().getMessage();

            Thread.sleep(10000);
            makeScreenshot(driver, testName);
//            Thread.sleep(50000);
//            attachmentSnapApi(tc_ID);
        }
//        driver.manage().deleteAllCookies();
//        driver.quit();

        // MyScreenRecorder.stopRecording();
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
        }
    }

    public void makeScreenshot(WebDriver driver, String screenshotName) {

        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";
        try {
            String reportFolder = "target" + File.separator + "test-output" + File.separator + "screenshots";
            File screenshotFolder = new File(reportFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            File destFile = new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile();
            FileUtils.copyFile(screenshot, destFile);
            Reporter.log("<a href='" + "https://app.testreport.io/qa-java-api/api/v1/user/getImage/SCREENSHOT/"
                    + destFile.getName() + "'> <img src='"
                    + "https://app.testreport.io/qa-java-api/api/v1/user/getImage/SCREENSHOT/" + destFile.getName()
                    + "' height='250' width='500'/> </a>");
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    /**
     * Jira Issue Creation
     */
//    public void jiraIssueCreator(String summary, String description) {
//        String jiraUrl = "https://prospectasoftware.atlassian.net/";
//        String username = "rahul.sharma@prospecta.com";
//        String password = "ATATT3xFfGF0xx-R6uMJW55HbevxE09_yBb-urOx5tCDLToOHF__xtaaU9cO5cw4ZqZwdZ7yCRyToev0dvNAh9fvrDKogloelKBPJcErCF49hQHLI_I1n086MLzVL9Q4WbKcCv8GjaqRsbIsY-QNghHyMss81CWil-bEGcgGRHNj_zikWm2zTEU=E7A9C94F";
//        String projectKey = "QAA";
//        String issueType = "Defect";
//        String assignee = "Rishabh Grover";
//
//        String apiUrl = jiraUrl + "/rest/api/2/issue/";
//        System.out.println("URL... " + apiUrl);
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpPost httpPost = new HttpPost(apiUrl);
//
//            String credentials = username + ":" + password;
//            String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
//            httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + base64Credentials);
//
//            String jsonBody = "{" + "\"fields\": {" + "\"project\": {\"key\": \"" + projectKey + "\"},"
//                    + "\"summary\": \"" + summary + "\"," + "\"description\": \"" + description + "\","
//                    + "\"assignee\": {"
//                    + "\"self\": \"https://prospectasoftware.atlassian.net/rest/api/2/user?accountId=611b9bb99ee2e4006982105a\","
//                    + "\"accountId\": \"611b9bb99ee2e4006982105a\"," + "\"avatarUrls\": {"
//                    + "\"48x48\": \"https://secure.gravatar.com/avatar/fe21acba7257433409d84b41dca56733?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FRG-3.png\","
//                    + "\"24x24\": \"https://secure.gravatar.com/avatar/fe21acba7257433409d84b41dca56733?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FRG-3.png\","
//                    + "\"16x16\": \"https://secure.gravatar.com/avatar/fe21acba7257433409d84b41dca56733?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FRG-3.png\","
//                    + "\"32x32\": \"https://secure.gravatar.com/avatar/fe21acba7257433409d84b41dca56733?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FRG-3.png\""
//                    + "}," + "\"displayName\": \"" + assignee + "\"," + "\"active\": true,"
//                    + "\"timeZone\": \"Asia/Kolkata\"," + "\"accountType\": \"atlassian\"" + "},"
//                    + "\"customfield_10360\": {"
//                    + "\"self\": \"https://prospectasoftware.atlassian.net/rest/api/2/customFieldOption/10766\","
//                    + "\"value\": \"DAXE\"," + "\"id\": \"10766\"" + "}," + "\"issuetype\": {\"name\": \"" + issueType
//                    + "\"}" + "}" + "}";
//            System.out.println("Request JSON... " + jsonBody + "\n");
//            StringEntity entity = new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
//            httpPost.setEntity(entity);
//
//            HttpResponse response = httpClient.execute(httpPost);
//            HttpEntity responseEntity = response.getEntity();
//
//            if (responseEntity != null) {
//                String responseJson = EntityUtils.toString(responseEntity);
//                System.out.println("Jira Response: " + responseJson);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public void attachmentSnapApi(String tc_ID) throws Exception {
//
//        String strCycleID = getPropertyValue("cycleID");
//
//        String jiraUrl = "https://tcms.aiojiraapps.com/aio-tcms/api/v1/project/10234/testcycle/" + strCycleID
//                + "/testcase/" + tc_ID + "/attachment";
//        String username = "rahul.sharma@prospecta.com";
//        String password = "AioAuth NzMzZjY3NmEtYTZjNy0zNGEzLWEwM2QtMTFlNGE4MjRlZWVhLmNkY2M5ODI2LTFlMzItNDQxNy05ZGY0LTg2ZDEyNDY1YzNhMg==";
//        String projectKey = "QAA";
//
////		String errorPayload = new String(Files.readAllBytes(Paths.get("payloads/PayloadErrorAndSuccess.json").toAbsolutePath()));
//
//        String filePath = "target/test-output/screenshots/" + currentTest + ".png";
//        log("Screenshot path: " + filePath);
//
//        Response response = (Response) RestAssured.given().log().all()
//                .header("accept", "application/json;charset=utf-8").header("Authorization", password)
//                .contentType("multipart/form-data").multiPart("file", new File(filePath), "image/png").post(jiraUrl);
//        int statusCode = response.getStatus();
//
//        if (statusCode == 200) {
//            log("Cycle ID: " + strCycleID);
//            System.out.println("Screenshot updated successfully on TestCase ");
//        } else {
//            System.out.println("Failed to update screenshot on TC. Status code: " + statusCode);
////            System.out.println("Response body: " + response.ge.asString());
//        }
//    }

//    public void attachmentReportApi(String tc_ID) throws Exception {
//
//        String strCycleID = getPropertyValue("cycleID");
//
//        String jiraUrl = "https://tcms.aiojiraapps.com/aio-tcms/api/v1/project/10234/testcycle/" + strCycleID
//                + "/testcase/" + tc_ID + "/attachment";
//        String username = "rahul.sharma@prospecta.com";
//        String password = "AioAuth NzMzZjY3NmEtYTZjNy0zNGEzLWEwM2QtMTFlNGE4MjRlZWVhLmNkY2M5ODI2LTFlMzItNDQxNy05ZGY0LTg2ZDEyNDY1YzNhMg==";
//        String projectKey = "QAA";
//
////		String errorPayload = new String(Files.readAllBytes(Paths.get("payloads/PayloadErrorAndSuccess.json").toAbsolutePath()));
//
//        String str = "index";
//        String filePath = "target/test-output/html/" + str + ".html";
//        log("Screenshot path: " + filePath);
//
//        Response response = (Response) RestAssured.given().log().all()
//                .header("accept", "application/json;charset=utf-8").header("Authorization", password)
//                .contentType("multipart/form-data").multiPart("file", new File(filePath), "text/html").post(jiraUrl);
//
//        int statusCode = response.getStatus();
//
//        if (statusCode == 200) {
//            System.out.println("Report updated successfully on TestCase.");
//        } else {
//            System.out.println("Failed to update Report on TC. Status code: " + statusCode);
////                System.out.println("Response body: " + response.getBody().asString());
//        }
//
//    }

//    public void commentsFailedApi(String tc_ID, String comment) throws Exception {
//
//        String strCycleID = getPropertyValue("cycleID");
//
//        String jiraUrl = "https://tcms.aiojiraapps.com/aio-tcms/api/v1/project/10234/testcycle/" + strCycleID
//                + "/testcase/" + tc_ID + "/testrun";
//        String username = "rahul.sharma@prospecta.com";
//        String password = "AioAuth NzMzZjY3NmEtYTZjNy0zNGEzLWEwM2QtMTFlNGE4MjRlZWVhLmNkY2M5ODI2LTFlMzItNDQxNy05ZGY0LTg2ZDEyNDY1YzNhMg==";
//        String projectKey = "QAA";
//
//        String jsonBody = "{" + "    \"testRunStatus\": \"Failed\"," + "    \"comments\": [" + "        \"" + comment
//                + "\"" + "    ]" + "}";
//        Response response = (Response) RestAssured.given().header("Content-Type", "application/json")
//                .header("Authorization", password).body(jsonBody).post(jiraUrl);
//
//        int statusCode = response.getStatus();
//        if (statusCode == 200) {
//            System.out.println("Comment updated successfully on TestCase.");
//        } else {
//            System.out.println("Failed to update comment on TC. Status code: " + statusCode);
////            System.out.println("Response body: " + response.getBody().asString());
//        }
//
////			HttpResponse response = httpClient.execute(httpPost);
////			HttpEntity responseEntity = response.getEntity();
////
////			if (responseEntity != null) {
////				String responseJson = EntityUtils.toString(responseEntity);
////				System.out.println("Jira Response: " + responseJson);
////			}
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//    }

//    public void createCycleAPI(String tc_ID) throws Exception {
//
//        String jiraUrl = "https://tcms.aiojiraapps.com/aio-tcms/api/v1/project/10234/testcycle/detail";
//        String username = "rahul.sharma@prospecta.com";
//        String password = "AioAuth NzMzZjY3NmEtYTZjNy0zNGEzLWEwM2QtMTFlNGE4MjRlZWVhLmNkY2M5ODI2LTFlMzItNDQxNy05ZGY0LTg2ZDEyNDY1YzNhMg==";
//        String projectKey = "QAA";
//
////		String errorPayload = new String(Files.readAllBytes(Paths.get("payloads/PayloadErrorAndSuccess.json").toAbsolutePath()));
//
////		String filePath = "target/test-output/FailedScreenshot/"+currentTest+".png";
////		log("Screenshot path: "+filePath);
//
//        RestAssured.given().log().all().header("accept", "application/json;charset=utf-8")
//                .header("Authorization", password).contentType("application/json").when().post(jiraUrl).then().log()
//                .all().statusCode(200);
//
////
////			if (responseEntity != null) {
////				String responseJson = EntityUtils.toString(responseEntity);
////				System.out.println("Jira Response: " + responseJson);
////			}
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//    }

    /**
     * For Logger
     */
    public void log(String log) {
        Reporter.log("<font color = 'blue'><b><u><br>" + log + "</u></b></font>", true);
    }
}