package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

  int idNumber;
    //1 post
    @Test
    public void test001(){
        UserPojo pojo = new UserPojo();
        pojo.setName("daisy ");
        pojo.setGender("female");
        //pojo.setEmail("tenali101.ramakrishna@18ce.com");
        pojo.setEmail("daisypatel12@gmail.com");
        pojo.setStatus("inactive");

        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization","Bearer 4cb7dd48c76d4979a654c0af989863315e91314c0db86cef3207311e6abd7144")
                .header("Content-Type","application/json")
                .body(pojo)
                .when()
                .post();
                response.then().statusCode(200);
                        int idNumber =response.then().extract().path("id");
        System.out.println(idNumber);

    }
    //2 update id
    @Test
    public void test002(){
        UserPojo pojo = new UserPojo();
        pojo.setName("Prince");
        pojo.setGender("male");

        Response response = given()
                .basePath("/v2/users")
                .header("Authorization","Bearer 4cb7dd48c76d4979a654c0af989863315e91314c0db86cef3207311e6abd7144")
                .header("Content-Type", "application/json")
                .pathParam("id", "627997")
                .when()
                .body(pojo)
                .patch("/{id}");
        response.then().log().all().statusCode(201);
        response.prettyPrint();
    }
    //3 delete id
    @Test
    public void test003(){
        Response resposne= given()
                .basePath("/v2/users")
                .header("Authorization","Bearer 4cb7dd48c76d4979a654c0af989863315e91314c0db86cef3207311e6abd7144")
                .header("Content-Type", "application/json")
                .pathParam("id","627997")
                .when()
                .delete("/{id}");
        resposne.then().statusCode(204);
        resposne.prettyPrint();
    }
    //4 retrieve id
    @Test
    public void test004(){
        Response response = given()
                .basePath("/v2/users")
                .header("Authorization","Bearer 4cb7dd48c76d4979a654c0af989863315e91314c0db86cef3207311e6abd7144")
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "627997")
                .when()
                .get("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }
}
