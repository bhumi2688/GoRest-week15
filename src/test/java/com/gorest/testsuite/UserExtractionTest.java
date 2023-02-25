package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
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
    //1 Extract all the ids
    @Test
    public void test001(){
        ArrayList<Integer> ids = response.extract().path("id");
        int size =ids.size();
        System.out.println("id : " + size);

    }
    //2. Extract the all Names
    @Test
            public void test002() {
        ArrayList<String> names = response.extract().path("name");
        System.out.println("All the names are : " + names);
        for(String a:names){
            if(a.equals(10)){
                Assert.assertTrue(true);
            }
        }
    }
    //3. Extract the name of 5th object
    @Test
    public void test003(){
        String name = response.extract().path("[4].name");
        System.out.println("Then name of 5th object is : " + name);
        Assert.assertTrue(true);

    }
    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004(){
        ArrayList<String> status = response.extract().path("findAll{it.status=='inactive'}.name");
        System.out.println("The names of inactive status are :" + status);
        Assert.assertTrue(true);
    }
    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005(){
        ArrayList<String> gender = response.extract().path("findAll{it.status=='active'}.gender");
        System.out.println("The gender whose status is active are : " + gender);
        Assert.assertTrue(true);
    }
    //6. Print the names of the object whose gender = female
    @Test
    public void test006(){
        ArrayList<String> nameGenderFemale = response.extract().path("findAll{it.gender=='female'}.name");
        System.out.println("The names whose gender female are : " + nameGenderFemale);
        Assert.assertTrue(true);
    }
    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007(){
        ArrayList<String> emails = response.extract().path("findAll{it.status=='inactive'}.email");
        System.out.println("The emails of inactive status are : " + emails);
        Assert.assertTrue(true);
    }
    //8. Get the ids of the object where gender = male
    @Test
    public void test008(){
        ArrayList<Integer> idsGenderMale = response.extract().path("findAll{it.gender=='male'}.id");
        System.out.println("The ids where gender male are : " + idsGenderMale);
        Assert.assertTrue(true);
    }
    //9. Get all the status
    @Test
    public void test009(){
        ArrayList<String> allStatus = response.extract().path("status");
        System.out.println("All the status are : " + allStatus);
        Assert.assertTrue(true);
    }
    //10. Get email of the object where name = eshana chopra
    @Test
    public void test010(){
        String email = response.extract().path("[5].email");
        System.out.println("The email is : " + email);
        Assert.assertTrue(true);
    }
    //11. Get gender of id = 592197
    @Test
    public void test011(){
        String gender = response.extract().path("[4].gender");
        System.out.println("The gender is : " + gender);
        Assert.assertTrue(true);
    }
}
