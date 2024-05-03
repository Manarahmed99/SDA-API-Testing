package Homework.H14;

import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class R04_DeleteContact extends ContactListBaseUrl {

    @Test
    public void DeleteContactTest() {
        // Set the URL
        spec.pathParams("first", "contacts");

        // Send the DELETE request to delete the contact
        Response response = given(spec)
                .delete("{first}/{id}", R01_CreateContact.id);

        // Print the response body
        response.prettyPrint();

        // Do assertions
        response.then()
                .assertThat()
                .statusCode(200);

        given(spec)
                .get("{first}/{id}", R01_CreateContact.id)
                .then()
                .statusCode(404);
    }
}
