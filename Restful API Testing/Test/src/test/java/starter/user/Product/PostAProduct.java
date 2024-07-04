package starter.user.Product;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PostAProduct {

    private String URL = "https://altashop-api.fly.dev/api/products/";

    // Memanggil End Point
    @Step
    public String ISetOnTheEndpointToPostARequest() {
        return URL;
    }

    // Melakukan POST request
    @Step
    public void ISendPostToServerWithValidRequirement() {

        // Membuat JSON Object

        JSONObject responbody = new JSONObject();
        responbody.put("name", "Sony PS5");
        responbody.put("description", "play has no limits");
        responbody.put("price", 299);
        JSONArray Categories = new JSONArray();
        Categories.put(1);
        responbody.put("categories", Categories);


        SerenityRest.
                given().
                header("Content-Type", "application/json")
                .body(responbody.toString())
                .post(ISetOnTheEndpointToPostARequest());
    }


    @Step
    public void IReceiveTheValidDataForCreatedProduct() {

        // Membuat Object bernama helper
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.CREATE_PRODUCT_SCHEMA);

//        restAssuredThat(response -> response.body("data.ID", Matchers.equalTo(89455)));
//        restAssuredThat(response -> response.body("data.Name", Matchers.equalTo("Sony PS5")));
//        restAssuredThat(response -> response.body("data.Description", Matchers.equalTo("play has no limits")));
//        restAssuredThat(response -> response.body("data.Price", Matchers.equalTo(299)));
//        restAssuredThat(response -> response.body("data.Ratings", Matchers.equalTo(0)));
//        restAssuredThat(response -> response.body("data.Categories", Matchers.empty()));

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Description", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Price", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Categories", Matchers.empty()));

        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }


    @Step
    public void ISendPostToServerWithoutName() {
        // Membuat JSON Object

        JSONObject responbody = new JSONObject();
        responbody.put("description", "play has no limits");
        responbody.put("price", 299);
        JSONArray Categories = new JSONArray();
        Categories.put(1);
        responbody.put("categories", Categories);


        SerenityRest.
                given().
                header("Content-Type", "application/json")
                .body(responbody.toString())
                .post(ISetOnTheEndpointToPostARequest());
    }


    @Step
    public void IReceiveErrorMessageForProductsNameCheck() {
        restAssuredThat(response -> response.body("error", Matchers.containsString("ERROR: new row for relation \"products\" violates check constraint \"products_name_check\" (SQLSTATE 23514)")));
    }

}


