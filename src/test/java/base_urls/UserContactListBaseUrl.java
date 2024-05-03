package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import Homework.H13.R01_CreateUser;

public class UserContactListBaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp(){
        String Token = R01_CreateUser.Token;
        System.out.println("token= " +Token);
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer " + Token)
                .setContentType(ContentType.JSON)
                .build();

    }
}
