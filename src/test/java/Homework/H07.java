package Homework;


import base_urls.SwaggerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;
import pojos.PetStorePojo_User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class H07  extends SwaggerBaseUrl {

    /*
        Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
    */




    @Test
    public void PetStoreTest (){

        //Set the Url
        spec.pathParams("first", "v2", "second", "user");

        //Set the expected data
        PetStorePojo_User expectedData = new PetStorePojo_User(1,"Test", "test", "test"
                , "test@gmail.com", "123456789","0123456789",12);
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .body(  "code", equalTo(200),
                        "type", equalTo("unknown"),
                        "message", equalTo("1")

                );




    }

}
