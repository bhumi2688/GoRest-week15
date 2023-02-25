package com.gorest.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/";
       // RestAssured.port = 3030;
        RestAssured.basePath = "/users";
    }
}
