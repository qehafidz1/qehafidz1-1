package starter.user.Authentication;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Login {

    private String URL = "https://altashop-api.fly.dev/api/auth/login";

    public String IsetOnTheLoginPoint(){
        return URL;
    }

    @Step
    public void ISendToServerLoginPostWithValidPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())

                .post(IsetOnTheLoginPoint());

    }

    @Step
    public void CheckThatMyLoginSuccedSoIgetAuthenticationCode(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.LOGIN_SCHEMA);
        restAssuredThat(response -> response.body("'data'", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));

    }

    @Step
    public void ISendToServerLoginPostWithInvalidPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "AAA");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetOnTheLoginPoint());
    }

    @Step
    public void CheckThatMyAccountAreNotLogged(){
        restAssuredThat(response -> response.body("'data'", Matchers.nullValue()));
    }

}
