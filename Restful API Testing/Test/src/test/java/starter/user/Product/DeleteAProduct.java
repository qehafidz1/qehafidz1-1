package starter.user.Product;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class DeleteAProduct {

   private final String URL = "https://altashop-api.fly.dev/api/products/88710";

    @Step
    public String ISetOnTheEndpointToDeleteTheproduct() {
       return URL;
    }

    @Step
    public void ISendDELETERequestToServerWithValidId() {
        SerenityRest.given().delete(ISetOnTheEndpointToDeleteTheproduct());
    }




}
