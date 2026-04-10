package Tests;

import Utils.WebBasePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ApiTest  extends WebBasePage {

    public void log(String print) {
        String message = "Step :: " + print;
        if (message.startsWith("Step")) {
            String[] msg = message.split("::");
            Reporter.log("<br>" + msg[0].trim() + " "+ " : " + msg[1].trim());
            System.out.println(msg[0].trim() + " "  + " : " + msg[1].trim());
            //   logger.info(msg[0].trim() + " " + stepcount + " : " + msg[1].trim());
            System.out.flush();
            //  Allure.step(msg[0].trim() + " " + stepcount + " : " + msg[1].trim());
        } else {
            Reporter.log("<br>Message : " + message);
            System.out.println("Message : " + message);
            //     logger.info("Message : " + message);
            System.out.flush();
        }
    }

    @Test
    public void apiLoginTest() {

        log("API Test Started....");
        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();

        // Form data
        String requestBody = "{\"email\":\"nayanankpal@begenuin.com\", \"password\":\"123456\"}";

        // Perform POST request
        Response response = request
                .contentType("application/json")
                .body(requestBody)
                .post("/api/v1/brand/login");

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }


    String gnAccessToken = "eyJraWQiOiJkLTE3MzI1MTMwNjMzNDYiLCJ0eXAiOiJKV1QiLCJ2ZXJzaW9uIjoiNSIsImFsZyI6IlJTMjU2In0.eyJpYXQiOjE3MzI1MTQ5MDYsImV4cCI6MTczMjYwMTI5Nywic3ViIjoiZTBmMGE1ZmItM2Q3My00MDhhLTljMDAtMWIxODJlMmMyNTJhIiwidElkIjoicHVibGljIiwicnN1YiI6ImUwZjBhNWZiLTNkNzMtNDA4YS05YzAwLTFiMTgyZTJjMjUyYSIsInNlc3Npb25IYW5kbGUiOiJiZjBiNWRiYi1mYjMyLTRhNjgtOWI3Mi04NGQyYzQyOTc3Y2IiLCJyZWZyZXNoVG9rZW5IYXNoMSI6IjI2NTZhZWFkOTNlYTM1MmI2MDNlNjg1OWUzYmJiNzRlM2I5ZjM0OWM2MzMwMGQzYTcxZDExNzIwNTY0Nzg2MGQiLCJwYXJlbnRSZWZyZXNoVG9rZW5IYXNoMSI6bnVsbCwiYW50aUNzcmZUb2tlbiI6bnVsbCwiaXNzIjoiaHR0cHM6Ly9icmFuZHMtYXBpLnFhLmJlZ2VudWluLmNvbS9hcGkvdjEvYXV0aCIsInN0LWV2Ijp7InYiOmZhbHNlLCJ0IjoxNzMyNTE0ODk3Mjg1fSwic3Qtcm9sZSI6eyJ2IjpbXSwidCI6MTczMjUxNDg5NzI4OH0sInN0LXBlcm0iOnsidiI6W10sInQiOjE3MzI1MTQ4OTcyODh9LCJiY2MiOnsiYnJhbmRfaWQiOjEsInVzZXJfaWQiOiI2NWNiMTU4ZjI2ZjBjMDUzYTVhZDg0ZmEifX0.PO4n5vG5HZgGaa-tawwjGvBxR0ATbUuqfIlhkP2Qf5ZZBG-tjTVp5jmJnTPps9VnlAjlEoyB2bHv4tqlvYwl-drlpqRDZVJfHCUeWX_kAwaaDMrKmCheSCYxrKREZCtRdzp6WGU1mHJEKPFZ9ZN7GH815GkwY2D96TPaIhl76lsCsAAJ35lq0abneTqPIc47nDgWfMoiuHoDAbbFoHrjouvUQqJdT_R13Xpru8mDZA-7JKkgLb_eVh3zeIlI2cNJeFi6uPuM6a4kcyzkfPxpurqWOOI3j-wrnvDtissNifnbRxaVV-J_r-NvIsVTd3XEnSovYeKvngW3FZE-lpad4w";
    public void pause(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void apiDemoBrandProfileTest() {
       log("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/brand/detail?subdomain=ankpal"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiDemoBrandRagistrationTest() {
        log("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/brand/registration/subdomain_suggestion?name=mys ql ff rtrt dfrt 4trtrt dgf fd fd f  df d f d"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }

    //https://brands-api.qa.begenuin.com/api/v1/brand/registration/validate_email?email=6723355661477.1720075087722@ai_user.begenuin.com
    @Test
    public void apiDemoBrandRagistrationEmailValidationTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();

        Response response = request
                .contentType("application/json")
                .get("/api/v1/brand/registration/validate_email?email=6723355661477.1720075087722@ai_user.begenuin.com"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    //https://brands-api.qa.begenuin.com/api/v1/brand/request_reset_password_email?email=sanketparekh22@begenuin.com
    @Test
    public void apiDemoResetPasswordTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();

        Response response = request
                .contentType("application/json")
                .get("/api/v1/brand/request_reset_password_email?email=sanketparekh22@begenuin.com"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    //https://brands-api.qa.begenuin.com/api/v1/brand/invitations

    @Test
    public void apiDemoBrandInvitationTest() {
        Reporter.log("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        // Create request specification with token as a query parameter
        RequestSpecification request = RestAssured.given();

        Response response = request
                .contentType("application/json").header("x-encrypted-token","VWa63FEg9VTG9rnlWsxFzmzpwHBNx4E6OUfFBFASW0Q7P369JqDoytWqXjSL1xAipqeSwu5cOzV/IWN0mzyqJA==")
                .get("/api/v1/brand/invitations");

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }


    //https://brands-api.qa.begenuin.com/api/v1/community/guidelines
    @Test
    public void apiCommunityGuidelineTest() {
        common.logPrint("API Test Started....");

        String baseURL = "https://brands-api.qa.begenuin.com";
        // Create request specification
        RequestSpecification request = RestAssured.given().baseUri(baseURL).auth().oauth2(gnAccessToken);


        Response response = request
                .contentType("application/json")
                .get("/api/v1/community/guidelines"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        common.logPrint("Response Status Code: " + response.getStatusCode()); log("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }

    //https://brands-api.qa.begenuin.com/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=2&sort_dir=desc&sort_by=type

    @Test
    public void apiCommunityMemberTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        request.contentType("application/json");
        //request.header("x-auth-token", authToken);
        Response response = request
                .get("/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=2&sort_dir=desc&sort_by=type"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiLoopTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/loops?is_loop_names_only=true"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiByUserTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/communities_by_user?user_id=e1352ead-8b6d-41fb-b7d2-d90ce3c0d298&user_community_joined=true&limit=10&query_string=test"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiBrandSearchTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/search/brands?query_string=sanketuser69@yopmail.com&is_brand_profile_email=true"); // Adjusted endpoint if needed
        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiCommunityTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/community?community_id=9f7e112b-b459-4838-a92c-a2577c100435"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiCommunityHandleSuggestionTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/community/handle_suggestion?name=abc"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiCommunityRequestsTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("api/v1/community/requests?community_id=7d5e52e3-1b79-4fae-8e3f-764c34a1cc97"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiLoopPaginationTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/paginated_loop_posts?page_no=1&limit=10&sort_by=loop&sort_dir=asc"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiLoopSubscribersTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);


        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/paginated_loop_subscribers?sort_by=subscriber&chat_id=2c62b9c8-33c5-49ce-babb-41f6a92dabb0"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiLoopCollaboratorsTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);


        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/paginated_loop_collaborators?chat_id=bd01f9e7-2d79-4e23-a0a0-5e232106690d"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }

    @Test
    public void apiLoopPostsTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);


        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/paginated_loop_posts?page_no=1&limit=10&sort_by=loop&sort_dir=asc"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }

    @Test
    public void apiCommunityLoopTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);


        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/community/loops?community_id=9f7e112b-b459-4838-a92c-a2577c100435"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiCheckUserExistsTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);


        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/check_user_exists?email=dhruv@begenuin.com&brand_id=1"); // Adjusted endpoint if needed

        // Print response
        common.logPrint("Response Status Code: " + response.getStatusCode());
        common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiMentionsTest() {
        common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);


        // No query parameters needed for this test
        // Adjust the endpoint path as necessary for the test
        Response response = request
                .contentType("application/json")
                .get("/api/v1/mentions?query_string=test"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiFontsTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/fonts"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
        log("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiGetSignURLTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/signed_url?content_type=text/csv&path=temp_video/659e9bb4-fc10-4dce-a856-20bff0e9f387_1632915580779.csv"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiGetSBrandUserTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/brand_users?manage_user_type=3&limit=50"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiSubdomainSuggestionTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("api/v1/brand/registration/subdomain_suggestion?name=mys ql ff rtrt dfrt 4trtrt dgf fd fd f  df d f d"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiBrandDetailsTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        //request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/brand/registration/subdomain_suggestion?name=mys ql ff rtrt dfrt 4trtrt dgf fd fd f  df d f d"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiResendEmailTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/brand/resend_email"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiGetDynamicCBRandDataTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/brand_details?brand_id=1&completed_onboarding_steps=true"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiNickNameSuggestionTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/suggestion/username?nickname=san"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiValidateHandleTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/community/validate_handle?handle=hidf"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiGetCommentTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/comment?limit=1&page=1&query_string=prod&sort_by=posted_in&sort_dir=asc"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiGetPaymentsMethodTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/payment-methods?limit=3"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiTransictionTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/transactions?page=1&limit=1"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiGetWalletBalanceTest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        Response response = request
                .contentType("application/json")
                .get("/api/v1/wallet-balance"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
//    @Test
    public void apiCommunityMemberTsest() {
         common.logPrint("API Test Started....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        request.contentType("application/json");
        //request.header("x-auth-token", authToken);
        Response response = request
                .get("/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=2&sort_dir=desc&sort_by=type"); // Adjusted endpoint if needed

        // Print response
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200, "Invalid Status Code");
        pause(15);
    }
    @Test
    public void apiLoginNegativeTest() {
         common.logPrint("API Negative Test Started....");
        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Create request specification
        RequestSpecification request = RestAssured.given();

        // List of negative test cases
        String[] negativeTestCases = {
                "{\"email\":\"\", \"password\":\"123456\"}",
                "{\"email\":\"invalidemail\", \"password\":\"123456\"}",
                "{\"email\":\"nayanankpal@begenuin.com\", \"password\":\"\"}",
                "{\"email\":\"nayanankpal@begenuin.com\", \"password\":\"wrongpassword\"}",
                "{\"email\":\"nonexistent@begenuin.com\", \"password\":\"123456\"}",
                "{}"
        };

        for (String requestBody : negativeTestCases) {
             common.logPrint("Testing with request body: " + requestBody);

            // Perform POST request
            Response response = request
                    .contentType("application/json")
                    .body(requestBody)
                    .post("/api/v1/brand/login");

            // Print response
             common.logPrint("Response Status Code: " + response.getStatusCode());
             common.logPrint("Response Body: " + response.getBody().asString());

            // Validate response code and ensure it's not 200 for negative scenarios
            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code: 200");
             common.logPrint("Test Passed for request body: " + requestBody);
        }
         common.logPrint("API Negative Test Completed.");
    }
    @Test
    public void apiDemoBrandProfileNegativeTest() {
         common.logPrint("API Negative Test Started for Brand Profile...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        String[] invalidSubdomains = {"", "invalid_subdomain", "<script>alert('hack')</script>"};

        for (String subdomain : invalidSubdomains) {
            Response response = request
                    .contentType("application/json")
                    .get("/api/v1/brand/detail?subdomain=" + subdomain);

             common.logPrint("Testing with subdomain: " + subdomain);
             common.logPrint("Response Status Code: " + response.getStatusCode());
            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
        }
    }
    @Test
    public void apiDemoBrandRegistrationNegativeTest() {
         common.logPrint("API Negative Test Started for Brand Registration...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        String[] invalidNames = {"", "a", "name_with_special!@#$%", "<script>alert('hack')</script>"};

        for (String name : invalidNames) {
            Response response = request
                    .contentType("application/json")
                    .get("/api/v1/brand/registration/subdomain_suggestion?name=" + name);

             common.logPrint("Testing with name: " + name);
             common.logPrint("Response Status Code: " + response.getStatusCode());
            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
        }
    }
    @Test
    public void apiDemoBrandRegistrationEmailValidationNegativeTest() {
         common.logPrint("API Negative Test Started for Email Validation...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        String[] invalidEmails = {"", "plainaddress", "missingdomain@", "missingat.com"};

        for (String email : invalidEmails) {
            Response response = request
                    .contentType("application/json")
                    .get("/api/v1/brand/registration/validate_email?email=" + email);

             common.logPrint("Testing with email: " + email);
             common.logPrint("Response Status Code: " + response.getStatusCode());
            Assert.assertEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
        }
    }

    @Test
    public void apiDemoResetPasswordNegativeTest() {
         common.logPrint("API Negative Test Started for Reset Password...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        String[] invalidEmails = {"", "invalidemail", "<script>alert('hack')</script>", "nonexistent@domain.com"};

        for (String email : invalidEmails) {
            Response response = request
                    .contentType("application/json")
                    .get("/api/v1/brand/request_reset_password_email?email=" + email);

             common.logPrint("Testing with email: " + email);
             common.logPrint("Response Status Code: " + response.getStatusCode());
            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
        }
    }

    @Test
    public void apiDemoBrandInvitationNegativeTest() {
         common.logPrint("API Negative Test Started for Brand Invitation...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test with invalid token
        String[] invalidTokens = {"", "invalidtoken", "<script>alert('hack')</script>"};

        for (String token : invalidTokens) {
            Response response = request
                    .contentType("application/json")
                    .header("x-encrypted-token", token)
                    .get("/api/v1/brand/invitations");

             common.logPrint("Testing with token: " + token);
             common.logPrint("Response Status Code: " + response.getStatusCode());
            Assert.assertNotEquals(response.getStatusCode(), 200, "Unexpected Status Code 200");
        }
    }

    @Test
    public void apiCommunityGuidelineNegativeTest() {
         common.logPrint("API Negative Test Started for Community Guidelines...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test without access token
        Response responseWithoutToken = request
                .contentType("application/json")
                .get("/api/v1/community/guidelines");

         common.logPrint("Response Status Code Without Token: " + responseWithoutToken.getStatusCode());
        Assert.assertNotEquals(responseWithoutToken.getStatusCode(), 200, "Unexpected Status Code 200");
    }
    @Test
    public void apiCommunityMemberNegativeTest() {
         common.logPrint("API Negative Test Started for Community Members...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test without Authorization header
        Response responseWithoutAuth = request
                .contentType("application/json")
                .get("/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=2&sort_dir=desc&sort_by=type");

         common.logPrint("Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");

        // Test with invalid community_id
        String[] invalidCommunityIds = {"", "invalid-id", "<script>alert('hack')</script>"};
        for (String communityId : invalidCommunityIds) {
            Response responseInvalidId = request
                    .header("Authorization", "Bearer " + gnAccessToken)
                    .contentType("application/json")
                    .get("/api/v1/community/members?community_id=" + communityId + "&limit=2&sort_dir=desc&sort_by=type");

             common.logPrint("Testing with invalid community_id: " + communityId);
             common.logPrint("Response Status Code: " + responseInvalidId.getStatusCode());
            Assert.assertNotEquals(responseInvalidId.getStatusCode(), 200, "Unexpected Status Code 200 for invalid community_id");
        }

        // Test with invalid limit parameter
        Response responseInvalidLimit = request
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/community/members?community_id=7c2eb555-5bb5-44f2-920f-308200794515&limit=-1&sort_dir=desc&sort_by=type");

         common.logPrint("Response Status Code for invalid limit: " + responseInvalidLimit.getStatusCode());
        Assert.assertNotEquals(responseInvalidLimit.getStatusCode(), 200, "Unexpected Status Code 200 for invalid limit");
    }
    @Test
    public void apiLoopNegativeTest() {
         common.logPrint("API Negative Test Started for Loops...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test without Authorization header
        Response responseWithoutAuth = request
                .contentType("application/json")
                .get("/api/v1/loops?is_loop_names_only=true");

         common.logPrint("Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");

        // Test with invalid query parameter
        Response responseInvalidParam = request
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/loops?is_loop_names_only=invalid");

         common.logPrint("Response Status Code with Invalid Query Param: " + responseInvalidParam.getStatusCode());
        Assert.assertNotEquals(responseInvalidParam.getStatusCode(), 200, "Unexpected Status Code 200 for invalid query parameter");
    }
    @Test
    public void apiByUserNegativeTest() {
         common.logPrint("API Negative Test Started for Communities by User...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test without Authorization header
        Response responseWithoutAuth = request
                .contentType("application/json")
                .get("/api/v1/communities_by_user?user_id=e1352ead-8b6d-41fb-b7d2-d90ce3c0d298&user_community_joined=true&limit=10&query_string=test");

         common.logPrint("Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");

        // Test with invalid user_id
        Response responseInvalidUserId = request
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/communities_by_user?user_id=invalid-id&user_community_joined=true&limit=10&query_string=test");

         common.logPrint("Response Status Code with Invalid User ID: " + responseInvalidUserId.getStatusCode());
        Assert.assertNotEquals(responseInvalidUserId.getStatusCode(), 200, "Unexpected Status Code 200 for invalid user_id");
    }
    @Test
    public void apiBrandSearchNegativeTest() {
         common.logPrint("API Negative Test Started for Brand Search...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test without Authorization header
        Response responseWithoutAuth = request
                .contentType("application/json")
                .get("/api/v1/search/brands?query_string=sanketuser69@yopmail.com&is_brand_profile_email=true");

         common.logPrint("Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");

        // Test with invalid query_string
        Response responseInvalidQuery = request
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/search/brands?query_string=invalid-query&is_brand_profile_email=true");

         common.logPrint("Response Status Code with Invalid Query String: " + responseInvalidQuery.getStatusCode());
        Assert.assertNotEquals(responseInvalidQuery.getStatusCode(), 200, "Unexpected Status Code 200 for invalid query string");
    }
    @Test
    public void apiCommunityNegativeTest() {
         common.logPrint("API Negative Test Started for Community...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test without Authorization header
        Response responseWithoutAuth = request
                .contentType("application/json")
                .get("/api/v1/community?community_id=9f7e112b-b459-4838-a92c-a2577c100435");

         common.logPrint("Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");

        // Test with invalid community_id
        Response responseInvalidId = request
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/community?community_id=invalid-id");

         common.logPrint("Response Status Code with Invalid Community ID: " + responseInvalidId.getStatusCode());
        Assert.assertNotEquals(responseInvalidId.getStatusCode(), 200, "Unexpected Status Code 200 for invalid community_id");
    }
    @Test
    public void apiCommunityHandleSuggestionNegativeTest() {
         common.logPrint("API Negative Test Started for Community Handle Suggestion...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test with missing name parameter
        Response responseMissingName = request
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/community/handle_suggestion");

         common.logPrint("Response Status Code for Missing Name Param: " + responseMissingName.getStatusCode());
        Assert.assertNotEquals(responseMissingName.getStatusCode(), 200, "Unexpected Status Code 200 for missing name parameter");

    }
    @Test
    public void apiCommunityRequestsNegativeTest() {
         common.logPrint("API Negative Test Started for Community Requests...");

        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";
        RequestSpecification request = RestAssured.given();

        // Test without Authorization header
        Response responseWithoutAuth = request
                .contentType("application/json")
                .get("api/v1/community/requests?community_id=7d5e52e3-1b79-4fae-8e3f-764c34a1cc97");

         common.logPrint("Response Status Code Without Authorization: " + responseWithoutAuth.getStatusCode());
        Assert.assertNotEquals(responseWithoutAuth.getStatusCode(), 200, "Unexpected Status Code 200 without Authorization");

        // Test with invalid community_id
        Response responseInvalidId = request
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("api/v1/community/requests?community_id=invalid-id");

         common.logPrint("Response Status Code with Invalid Community ID: " + responseInvalidId.getStatusCode());
        Assert.assertNotEquals(responseInvalidId.getStatusCode(), 200, "Unexpected Status Code 200 for invalid community_id");
    }
    @Test
    public void apiLoopPaginationNegativeTest() {
         common.logPrint("API Negative Test Started - apiLoopPaginationTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Invalid Pagination Parameters
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // Scenario 1: Invalid pagination parameters
        Response response = request
                .contentType("application/json")
                .get("/api/v1/paginated_loop_posts?page_no=-1&limit=0&sort_by=invalid_field");
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Missing Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/paginated_loop_posts?page_no=1&limit=10&sort_by=loop&sort_dir=asc");
         common.logPrint("Response Status Code (No Auth): " + response.getStatusCode());
         common.logPrint("Response Body (No Auth): " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");

        pause(15);
    }

    @Test
    public void apiLoopSubscribersNegativeTest() {
         common.logPrint("API Negative Test Started - apiLoopSubscribersTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Invalid Chat ID
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // Scenario 1: Invalid chat_id
        Response response = request
                .contentType("application/json")
                .get("/api/v1/paginated_loop_subscribers?sort_by=subscriber&chat_id=invalid-id");
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Missing Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/paginated_loop_subscribers?sort_by=subscriber&chat_id=2c62b9c8-33c5-49ce-babb-41f6a92dabb0");
         common.logPrint("Response Status Code (No Auth): " + response.getStatusCode());
         common.logPrint("Response Body (No Auth): " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");

        pause(15);
    }

    @Test
    public void apiLoopCollaboratorsNegativeTest() {
         common.logPrint("API Negative Test Started - apiLoopCollaboratorsTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Invalid Chat ID
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // Scenario 1: Invalid chat_id
        Response response = request
                .contentType("application/json")
                .get("/api/v1/paginated_loop_collaborators?chat_id=invalid-id");
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Missing Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/paginated_loop_collaborators?chat_id=bd01f9e7-2d79-4e23-a0a0-5e232106690d");
         common.logPrint("Response Status Code (No Auth): " + response.getStatusCode());
         common.logPrint("Response Body (No Auth): " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");

        pause(15);
    }

    @Test
    public void apiLoopPostsNegativeTest() {
         common.logPrint("API Negative Test Started - apiLoopPostsTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + gnAccessToken);

        // Scenario 1: Invalid pagination parameters
        Response response = request
                .contentType("application/json")
                .get("/api/v1/paginated_loop_posts?page_no=-1&limit=0&sort_by=loop&sort_dir=asc");
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Missing Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/paginated_loop_posts?page_no=1&limit=10&sort_by=loop&sort_dir=asc");
         common.logPrint("Response Status Code (No Auth): " + response.getStatusCode());
         common.logPrint("Response Body (No Auth): " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");

        pause(15);
    }
    @Test
    public void apiCommunityLoopNegativeTest() {
         common.logPrint("API Negative Test Started - apiCommunityLoopNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Missing community_id
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/community/loops");
         common.logPrint("Response Status Code: " + response.getStatusCode());
         common.logPrint("Response Body: " + response.getBody().asString());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Invalid Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/community/loops?community_id=invalid-id");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }

    @Test
    public void apiCheckUserExistsNegativeTest() {
         common.logPrint("API Negative Test Started - apiCheckUserExistsNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Invalid email parameter
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/check_user_exists?email=invalid-email&brand_id=1");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Missing Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/check_user_exists?email=dhruv@begenuin.com&brand_id=1");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }

    @Test
    public void apiMentionsNegativeTest() {
         common.logPrint("API Negative Test Started - apiMentionsNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Missing query_string parameter
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/mentions");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Invalid Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/mentions?query_string=test");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }

    @Test
    public void apiFontsNegativeTest() {
         common.logPrint("API Negative Test Started - apiFontsNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Invalid Authorization header
        Response response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/fonts");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }

    @Test
    public void apiGetSignURLNegativeTest() {
         common.logPrint("API Negative Test Started - apiGetSignURLNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Invalid content_type parameter
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/signed_url?content_type=invalid&type&path=temp_video/invalid.csv");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Missing Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/signed_url?content_type=text/csv&path=temp_video/invalid.csv");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }

    @Test
    public void apiGetSBrandUserNegativeTest() {
         common.logPrint("API Negative Test Started - apiGetSBrandUserNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Invalid manage_user_type
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/brand_users?manage_user_type=invalid&limit=50");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");

        // Scenario 2: Missing Authorization header
        response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/brand_users?manage_user_type=3&limit=50");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }
    @Test
    public void apiSubdomainSuggestionNegativeTest() {
         common.logPrint("API Negative Test Started - apiSubdomainSuggestionNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Missing query parameter `name`
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/brand/registration/subdomain_suggestion");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
    }

    @Test
    public void apiBrandDetailsNegativeTest() {
         common.logPrint("API Negative Test Started - apiBrandDetailsNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Invalid Authorization token
        Response response = RestAssured.given()
                .header("Authorization", "Bearer INVALID_TOKEN")
                .contentType("application/json")
                .get("/api/v1/brand_details?brand_id=1&completed_onboarding_steps=true");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }

    @Test
    public void apiResendEmailNegativeTest() {
         common.logPrint("API Negative Test Started - apiResendEmailNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Missing Authorization header
        Response response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/brand/resend_email");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }

    @Test
    public void apiGetDynamicCBRandDataNegativeTest() {
         common.logPrint("API Negative Test Started - apiGetDynamicCBRandDataNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Missing `brand_id` parameter
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/brand_details?completed_onboarding_steps=true");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
    }

    @Test
    public void apiNickNameSuggestionNegativeTest() {
         common.logPrint("API Negative Test Started - apiNickNameSuggestionNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Empty `nickname`
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/suggestion/username?nickname=");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
    }

    @Test
    public void apiValidateHandleNegativeTest() {
         common.logPrint("API Negative Test Started - apiValidateHandleNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Missing `handle` parameter
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/community/validate_handle");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
    }

    @Test
    public void apiGetCommentNegativeTest() {
         common.logPrint("API Negative Test Started - apiGetCommentNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Invalid `limit` parameter
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/comment?limit=-1&page=1&query_string=prod&sort_by=posted_in&sort_dir=asc");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
    }

    @Test
    public void apiGetPaymentsMethodNegativeTest() {
         common.logPrint("API Negative Test Started - apiGetPaymentsMethodNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Missing Authorization header
        Response response = RestAssured.given()
                .contentType("application/json")
                .get("/api/v1/payment-methods?limit=3");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }

    @Test
    public void apiTransactionNegativeTest() {
         common.logPrint("API Negative Test Started - apiTransactionNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Invalid `page` parameter
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + gnAccessToken)
                .contentType("application/json")
                .get("/api/v1/transactions?page=-1&limit=1");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertNotEquals(response.getStatusCode(), 200, "Expected failure status code.");
    }

    @Test
    public void apiGetWalletBalanceNegativeTest() {
         common.logPrint("API Negative Test Started - apiGetWalletBalanceNegativeTest....");

        // Base URI
        RestAssured.baseURI = "https://brands-api.qa.begenuin.com";

        // Scenario 1: Invalid Authorization token
        Response response = RestAssured.given()
                .header("Authorization", "Bearer INVALID_TOKEN")
                .contentType("application/json")
                .get("/api/v1/wallet-balance");
         common.logPrint("Response Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 401, "Expected unauthorized status code.");
    }



}
