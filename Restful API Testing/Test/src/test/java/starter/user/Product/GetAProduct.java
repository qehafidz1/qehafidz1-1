package starter.user.Product;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;

import java.util.ArrayList;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAProduct {

    // Mendefinisikan URL
    final private String URL = "https://altashop-api.fly.dev/api/products/";

    // Memanggil end Point
    @Step
    public String ISetApiEndpointForRetrieveAProductWithValidId() {
        return URL + "88723";
    }

    @Step
    public void GetRequestToRetrieveAProductWithValidId() {
        SerenityRest.given().get(ISetApiEndpointForRetrieveAProductWithValidId());
    }

    @Step
    public void iReceiveTheProduct() {
        // Membuat Objek JSON Schema
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JSON_Schema.GET_A_PRODUCT_WITH_ID_SCHEMA);

        // Verifikasi response dengan skema JSON
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

        // Verifikasi nilai-nilai tertentu dalam respons
        restAssuredThat(response -> response.body("data.ID", Matchers.equalTo(88723)));
        restAssuredThat(response -> response.body("data.Name", Matchers.equalTo("Sony PS5")));
        restAssuredThat(response -> response.body("data.Description", Matchers.equalTo("play has no limits")));
        restAssuredThat(response -> response.body("data.Price", Matchers.equalTo(299)));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.equalTo(0)));
        restAssuredThat(response -> response.body("data.Categories", Matchers.equalTo(new ArrayList<>())));
    }

    @Step
    public String ISetApiEndpointForRetrieveAProductWithInvalidId(){
        return URL + "1";
    }
    @Step
    public void GetRequestToRetrieveAProductWithInvalidId() {
        SerenityRest.given().get(ISetApiEndpointForRetrieveAProductWithInvalidId());
    }
    @Step
    public void CheckThatIReceiveError() {
        restAssuredThat(response -> response.body("error", Matchers.containsString("record not found")));
    }



}
