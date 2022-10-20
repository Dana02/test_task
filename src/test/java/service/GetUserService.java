package service;

import io.restassured.response.Response;

import java.util.HashMap;

import static data.Endpoint.USER_BY_ID;
import static io.restassured.RestAssured.given;
import static java.lang.System.getProperties;

public class GetUserService {

    /**
     * Get user by id.
     *
     * @param userId the id of user
     * @return response
     */
    public static Response getUserById(String userId) {
        return given()
                //.spec(getRequestSpecification()) // as Login is not valid, this line is commented
                .pathParam("user_id", userId)
                .when()
                .get(USER_BY_ID.getValue())
                .then()
                .extract()
                .response();
    }

    /**
     * Get request specification.
     *
     * @return the request specification
     */
   /* private static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + makeAuth()) //Ths will work only if after logging in we get access token
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }*/

    /**
     * Make authentication.
     *
     * @return the access token
     */
    /*private static String makeAuth() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(getAuthPayload())
                .post("https://ws-test.keepit.com")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .path("access_token"); //This will work only if after logging in we get access token
    }*/

    /**
     * Get authentication payload.
     *
     * @return the authentication payload
     */
   /* private static HashMap<String, String> getAuthPayload() {
        HashMap<String, String> authPayload = new HashMap<>();
        authPayload.put("username", getProperties().getProperty("USERNAME"));
        authPayload.put("password", getProperties().getProperty("PASSWORD"));
        return authPayload;
    }*/
}
