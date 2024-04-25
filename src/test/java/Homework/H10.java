package Homework;

import base_urls.SwaggerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojos.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class H10 extends SwaggerBaseUrl {
    /*
        //Write an automation test that will create, read, update, delete a 'create' using the "https://petstore.swagger.io/" document
        (All actions must be done on same pet)
        (Use Pojo)

    */
    private PetStorePojo pet;


    @BeforeMethod
    public void setPathParams() {
        //Set the Url
        spec.pathParams("first", "v2", "second", "pet");
    }

    @Test
    public void createPet() {
        //Set the expected data
        PetStorePojo_Category category = new PetStorePojo_Category(2, "Cat");
        PetStorePojo_Tag tag = new PetStorePojo_Tag(3, "Kitten");
        pet = new PetStorePojo(1, category, "Kitten0" , List.of(tag), "available");

       //Send the request and get the response
        Response response = given(spec)
                .body(pet)
                .post("{first}/{second}");
        response.prettyPrint();

        //Do assertion

        assertEquals(response.statusCode(), 200);
    }

    @Test(dependsOnMethods = "createPet")
    public void readPet() {
        //Send the request and get the response
        Response response = given(spec)
                .get("{first}/{second}/{petId}", pet.getId());
        //Do assertion
        assertEquals(response.statusCode(), 200);

    }

    @Test(dependsOnMethods = "readPet")
    public void updatePet() {

        //Send the request and get the response
        Response response = given(spec)
                .body(pet)
                .put("{first}/{second}");
        //Do assertion
        assertEquals(response.statusCode(), 200);
    }

    @Test(dependsOnMethods = "updatePet")
    public void deletePet() {
        //Send the request and get the response
        Response response = given(spec)
                .delete("{first}/{second}/{petId}", pet.getId());
        //Do assertion
        assertEquals(response.statusCode(), 200);
    }

}
