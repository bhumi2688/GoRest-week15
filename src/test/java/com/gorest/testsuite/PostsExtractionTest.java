package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        // RestAssured.port = 3030;
        response = given()
                .when()
                .get("/public/v2/posts?page=1&per_page=25")
                .then().statusCode(200);
    }
    //1. Extract the title
    @Test
    public void test001(){
        ArrayList<String> title = response.extract().path("title");
        System.out.println("All the names are : " + title);
        for(String a:title){
            if(a.equals(25)){
                Assert.assertTrue(true);
            }
        }
    }
    //2. Extract the total number of record
    @Test
    public void test002(){
        ArrayList<Integer> records = response.extract().path("id");
        int size =records.size();
        System.out.println("id : " + size);
        Assert.assertTrue(true);

    }
    //3. Extract the body of 15th record
    @Test
    public void test003(){
        String body = response.extract().path("[14].body");
        System.out.println("The body of 15th record is : " + body);
        Assert.assertTrue(true);
    }
    //4. Extract the user_id of all the records
    @Test
    public void test004(){
        ArrayList<Integer> user_id = response.extract().path("user_id");
        System.out.println("All the userId records are : " + user_id);
        for(Integer a:user_id){
            if(a.equals(25)){
                Assert.assertTrue(true);
            }
        }
    }
    //5. Extract the title of all the records
    @Test
    public void test005(){
        ArrayList<String> title = response.extract().path("title");
        System.out.println("All the title of records are : " + title);
        for(String a:title){
            if(a.equals(25)){
                Assert.assertTrue(true);
            }
        }
    }
    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void test006(){
        ArrayList<String> records = response.extract().path("findAll{it.user_id='5456'}.title");
        System.out.println("The title of all records whose user_id  :" + records);
        Assert.assertTrue(true);

    }
    //7. Extract the body of all records whose id = 2671
    @Test
    public void test007(){
        ArrayList<String> body = response.extract().path("findAll{it.id='2671'}.body");
        System.out.println("The body of all records whose id  :" + body);
        Assert.assertTrue(true);

    }
}
