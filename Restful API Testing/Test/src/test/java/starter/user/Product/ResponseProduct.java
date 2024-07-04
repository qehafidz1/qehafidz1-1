package starter.user.Product;
import net.serenitybdd.annotations.Step;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class ResponseProduct {

    // Response
    @Step
    public void responseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step
    public void responseCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step
    public void responseCode204() {
        restAssuredThat(response -> response.statusCode(204));
    }

    @Step
    public void responseCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step
    public void responseCode401() {
        restAssuredThat(response -> response.statusCode(401));
    }


    @Step
    public void responseCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step
    public void responseCode500() {
        restAssuredThat(response -> response.statusCode(500));

    }
}