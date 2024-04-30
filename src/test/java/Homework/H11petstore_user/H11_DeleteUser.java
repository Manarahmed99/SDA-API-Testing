package Homework.H11petstore_user;

import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStorePojo_User;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class H11_DeleteUser extends SwaggerBaseUrl {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the
    // "https://petstore.swagger.io/" document. (Create a classes for each request.)

    @Test
    public void deleteUserTest() {
        // Set the URL
        spec.pathParams("first", "v2", "second", "user");

        // Set the new user data

        // Send the request to update user details
        Response response = given(spec)
                .delete("{first}/{second}/" + H11_UpdateUser.New_username);
        response.prettyPrint();
        // Do assertion
        response
                .then()
                .statusCode(200);
    }

}
