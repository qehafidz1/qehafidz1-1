package starter.user.Product;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AssignAProductRating {

    final private String VALID_URL = "https://altashop-api.fly.dev/api/products/89594/ratings";
    final private String INVALID_URL = "https://altashop-api.fly.dev/api/products/invalid/ratings";

    String validToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

    @Step("Set valid API endpoint for rating creation")
    public String setValidAPIEndpoint() {
        return VALID_URL;
    }

    @Step("Set invalid API endpoint for rating creation")
    public String setInvalidAPIEndpoint() {
        return INVALID_URL;
    }

    @Step("Send POST request to create rating with valid data")
    public void sendPostRequestToCreateRating() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("rating", 5);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + validToken)
                .body(requestBody.toString())
                .post(setValidAPIEndpoint());
    }

    @Step("Send POST request to create rating with invalid URL")
    public void sendPostRequestToInvalidURL() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("rating", 5);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + validToken)
                .body(requestBody.toString())
                .post(setInvalidAPIEndpoint());
    }

    @Step("Receive valid status code and data for created rating")
    public void receiveValidStatusCodeAndData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JSON_Schema.ASSIGN_A_RATING);

        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("Receive error status code and message for invalid URL")
    public void receiveErrorStatusCodeAndMessage() {
        restAssuredThat(response -> response.statusCode(400));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("record not found")));
    }
}
