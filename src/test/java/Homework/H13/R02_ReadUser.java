package Homework.H13;

import base_urls.UserContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Homework.H13.R01_CreateUser.expectedData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
;


public class R02_ReadUser extends UserContactListBaseUrl {


    @Test
    public void ReadUserTest(){

        //Set the Url
        spec.pathParams("first", "users","second", "me");

        //Set the expected data


        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .body(
                        "firstName", equalTo(expectedData.getFirstName()),
                        "lastName", equalTo(expectedData.getLastName()),
                        "email", equalTo(expectedData.getEmail())
                );



    }}

