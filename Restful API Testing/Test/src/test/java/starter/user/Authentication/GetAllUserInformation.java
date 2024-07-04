package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllUserInformation {

    // Define the URL endpoint
    final private String URL = "https://your-api-endpoint/api/users/";

    // Method to set the API endpoint
    @Step
    public String SetGetAllUSerInformationApiEndPoint() {
        return URL;
    }

    // Method to send GET request to the API endpoint
    @Step
    public void SendToServerAllUserInformationGetRequest() {
        SerenityRest.given().get(SetGetAllUSerInformationApiEndPoint());
    }

    // Method to validate the response and schema
    @Step
    public void ReceiveAllUserInformation() {
        // Create JSON Schema Helper object
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JSON_Schema.GET_ALL_USER_INFORMATION_SCHEMA);

        // Validate that the response fields are not null
        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Fullname", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Email", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Password", Matchers.notNullValue()));

        // Validate that the response matches the JSON schema
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
