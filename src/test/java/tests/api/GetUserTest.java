package tests.api;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import service.GetUserService;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public class GetUserTest {

    @Test
    @Description("This test verifies getting user by id")
    public void getUserTest() {
        GetUserService.getUserById("zhc4v6-5ev7di-9hhhlm")
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .body("user.enabled", equalTo("true"))
                .body("user.created", equalTo("2019-02-28T13:07:49Z"))
                .body("user.product", equalTo("7dwqnq-5cvrcm-1z3ehj"))
                .body("user.parent", equalTo("80ltks-yhfls5-24zyf2"))
                .body("user.subscribed", equalTo("true"));
    }
}

