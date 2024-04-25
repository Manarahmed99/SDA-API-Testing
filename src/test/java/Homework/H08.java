package Homework;


import base_urls.SwaggerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class H08 extends SwaggerBaseUrl {

    /*
    Using the https://petstore.swagger.io/ document, write an automation test
    that finds the number of "pets" with the status "available" and asserts that there are more than 100.
    */


    @Test
    public void NumberOfPetsStore_available_Test (){

        //Set the Url
        spec.pathParams("first", "v2", "second", "pet", "third", "findByStatus");
        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).queryParam("status", "available").get("/{first}/{second}/{third}");
        response.prettyPrint();

        //Do assertion
        response.then().body("", hasSize(greaterThan(100)));


    }

}
