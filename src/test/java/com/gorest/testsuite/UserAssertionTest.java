package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasKey;

public class UserAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
       // RestAssured.port = 3030;
        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);
    }
    //1 verify if the total record is 10
    @Test
    public void test001(){
        response.body("size", equalTo(10));

    }
    //2 verify if the name of id = 582009 is equal to "Ashlesh Khan"
    @Test
    public void test002(){
        response.body("[0].name",equalTo("Ashlesh Khan"));
        //List<String> name1 = response.

    }
    //3 check the single name in arraylist(Ritesh Kakkar)
    @Test
    public void test003(){
        Arrays.asList("[8].name",equalTo("Ritesh Kakkar"));

    }
    //4 Check the multiple ‘Names’ in the ArrayList (Lai Rana DC, Miss manikya Deshpande,Kiran Pilla)
    @Test
    public void test004(){
        response.body("[1].name",equalTo("Lai Rana DC"));
        response.body("[3].name",equalTo("Miss Manikya Deshpande"));
        response.body("[6].name",equalTo("Kiran Pilla"));
    }
    //5 Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005(){
        response.body("[4].email",equalTo("karthik_kaniyar@mcglynn-corkery.info"));

    }
    //6 Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006(){
        response.body("[6].status",equalTo("active"));
    }
    //7 Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test007(){
        response.body("[2].gender",equalTo("male"));
    }



}
