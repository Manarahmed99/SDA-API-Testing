package Homework;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;



import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class H05 extends ReqresBaseUrl {

    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */


    @Test
    public void  unknownUserTest (){

        //Set the Url
        spec.pathParams("first", "unknown");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPath jsonPath = response.jsonPath();

        response
                .then()
                .statusCode(200);



        List<String> pantone_values = jsonPath.getList("data.pantone_value");
        System.out.println("pantone_values = " + pantone_values);

        List<Integer> idList = jsonPath.getList("data.findAll { it.id > 3 }.id");
        System.out.println("idList = " + idList);
        assertEquals(idList.size(), 3);

        List<String> names = jsonPath.getList("data.findAll { it.id < 3 }.name");
        System.out.println("names = " + names);
        assertEquals(names.size(), 2);





    }


}
