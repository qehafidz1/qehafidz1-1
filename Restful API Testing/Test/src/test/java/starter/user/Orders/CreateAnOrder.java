package starter.user.Orders;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;

import java.util.ArrayList;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateAnOrder {

    final private String URL = "https://altashop-api.fly.dev/api/orders";
    String validToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

    @Step
    public String setValidAPIOnPoint() {
        return URL;
    }

    @Step
    public void sendValidOrderToServer() {
        JSONObject requestBody = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        // Populate the request body with valid order details
        JSONObject orderData = new JSONObject();
        orderData.put("product_id", 2);
        orderData.put("quantity", 1);
        jsonArray.put(orderData);

        // Masukkan data order ke dalam body permintaan
        requestBody.put("data", jsonArray);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + validToken)
                .body(jsonArray.toString()) // Gunakan requestBody yang telah dibuat
                .post(setValidAPIOnPoint());
    }


    @Step
    public void verifyOrderCreatedSuccessfully() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.CreateAnOder_USER_SCHEMA);

        restAssuredThat(response -> response.body("data[0].ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data[0].User.ID", Matchers.equalTo(31506)));
        restAssuredThat(response -> response.body("data[0].User.Fullname", Matchers.equalTo("Firstname Lastname")));
        restAssuredThat(response -> response.body("data[0].User.Email", Matchers.equalTo("someone@mail.com")));
        restAssuredThat(response -> response.body("data[0].User.Password", Matchers.equalTo("123123")));
        restAssuredThat(response -> response.body("data[0].Product", Matchers.nullValue()));
        restAssuredThat(response -> response.body("data[0].Quantity", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }


    // Negative Test

    @Step
    public void sendInvalidOrderToServer() {
        JSONObject requestBody = new JSONObject();

        // Populate the request body with invalid order details
        JSONObject invalidOrderData = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        invalidOrderData.put("ID", "Invalid");

        requestBody.put("data", new JSONObject[]{invalidOrderData});

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + validToken)
                .body(jsonArray.toString())
                .post(setValidAPIOnPoint());
    }

    @Step
    public void verifyInvalidOrderNotCreated() {
        // Implement verification that invalid order is not created
        restAssuredThat(response -> response.body("error", Matchers.equalTo("Invalid order data")));
    }
}
