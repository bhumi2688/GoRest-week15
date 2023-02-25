package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostsAssertionTest {
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
    //1 verify the record total is 25
    @Test
    public void test001(){
        response.body("size", equalTo(25));

    }
    //2 Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto
    //centum.”
    @Test
    public void test002(){
        response.body("[3].title",equalTo("Odit degusto rerum officia quia vitae aperiam molestiae admoveo subiungo sint vigor ustilo communis degenero apparatus solitudo damno."));
    }
    //3 Check the single user_id in the Array list (5522)
    @Test
    public void test003(){
        Arrays.asList("[5].user_id",equalTo("20960"));
    }
    //4 Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test004(){
        response.body("[4].id",equalTo(20961));
        response.body("[5].id",equalTo(20960));
        response.body("[7].id",equalTo(20957));
    }
    //5 Verify the body of userid = 2678 is equal
    @Test
    public void test005(){
        response.body("[6].body",equalTo("Aiunt autem carcer. Balbus defaeco tempore. Caries amiculum cimentarius. Surculus vulnus quos. Comitatus collum ut. Certo decor et. Venustas volva tantum. Aliqua consequatur ventus. Bis tego vilis. Sustineo titulus vereor. Textor depulso collum. Vita virgo tenuis. Adiuvo caute defetiscor. Tandem ascisco torqueo. Crepusculum demonstro nam. Vos reprehenderit dolorem. Cresco aestas careo. Dens deporto somniculosus. Tolero distinctio caterva."));
    }
}
