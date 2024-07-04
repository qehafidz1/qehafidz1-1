package starter.user.Product;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateAComment {

    final private String URL = "https://altashop-api.fly.dev/api/products/88701/comments";

    String Valid_Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

    @Step
    public String SetValidAPIOnPoint() {
        return URL;
    }

    @Step
    public void ISendCommentPostToServer() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Valid_Token)
                .body(requestBody.toString())
                .post(SetValidAPIOnPoint());
    }

    @Step
    public void IReceiveTheValidDataForCreatedComment() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.Create_A_Comment_For_A_Product_SCHEMA);

        restAssuredThat(response -> response.body("data.Content", Matchers.equalTo("the games are great including Gran Turismo 7 but sadly GT4 is much better")));
        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.User", Matchers.isEmptyOrNullString()));
        restAssuredThat(response -> response.body("data.Product", Matchers.isEmptyOrNullString()));
        restAssuredThat(response -> response.body("data.Comment", Matchers.isEmptyOrNullString()));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }

    // Negative Test


    @Step
    public void ISendCommentPostToServerWithWronginput() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "1");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Valid_Token)
                .body(requestBody.toString())
                .post(SetValidAPIOnPoint());
    }


    @Step
    public void CheckThatTheDataIsNotCreated() {
        restAssuredThat(response -> response.body("'error'",Matchers.equalTo("ERROR: new row for relation \"comments\" violates check constraint \"comments_content_check\" (SQLSTATE 23514)")));
    }
}
