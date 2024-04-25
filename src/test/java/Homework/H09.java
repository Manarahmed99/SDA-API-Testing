package Homework;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class H09 extends AutomationExerciseBaseUrl {

/*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/

    @Test
    public void AutomationExerciseTest (){
        //Set the Url
        spec.pathParams("first", "api", "second", "productsList");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        int womenCount = response.jsonPath().getList("products.findAll { it.category.usertype.usertype == 'Women' }").size();
        assertEquals(womenCount, 12);


    }
}
