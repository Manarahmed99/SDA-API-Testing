package Homework.H11petstore_user;

import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingResponsePojo;
import pojos.PetStorePojo_User;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class H11_ReadUser extends SwaggerBaseUrl {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the
    // "https://petstore.swagger.io/" document. (Create a classes for each request.)




    @Test
    public void readUserTest() {
        // Set the URL
        spec.pathParams("first", "v2", "second", "user");

        //Set the expected data

        // Send the request to read user details
        Response response = given(spec)
                .get("{first}/{second}/" + H11_CreateUser.username);

        response.prettyPrint();
        //Do assertion
        response
                .then()
                .statusCode(200);

    }

}
