package starter.user.Product;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;


public class GetAllProduct {

    // Mendefiniiskan URL
    final private String URL = "https://altashop-api.fly.dev/api/products/";

    // Memanggil end Point

    @Step
    public String SetApiEndpoint(){
        return URL;
    }

    @Step
    public void GetApiEndpoint(){
        SerenityRest.given().
                get(SetApiEndpoint());
    }

    @Step
    public void ReceiveAllProducts(){

        // Membuat Objek JSON Schema
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JSON_Schema.GET_ALL_PRODUCTS_SCHEMA);

        // Mengecek bahwa nilai yang dikeluarkan tidak null

        restAssuredThat(response -> response.body("data.Name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.content", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Price", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Categories", Matchers.notNullValue()));

        // Mengecek bahwa response sama dengan Schema
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
