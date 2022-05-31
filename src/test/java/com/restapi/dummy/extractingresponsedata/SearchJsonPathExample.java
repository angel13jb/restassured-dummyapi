package com.restapi.dummy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.List;

import static io.restassured.RestAssured.given;


public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://dummy.restapiexample.com";
       response= given()
                .when()
                .get("/api/v1/employees")
                .then().statusCode(200);

    }


    // 1)  Get total records are 24
    @Test
    public void test001() {
        List<Integer> totalRecord=response.extract().path("data");
        System.out.println("Total records are : "+totalRecord.size() );

    }

    // 2) Extract data[23].id = 24
    @Test
    public void test002() {
       int id = response.extract().path("data[23].id");
        System.out.println("The id for employee 23 is : "+id);

    }

    // 3) Extract data[23].employee_name= “Doris Wilder”
    @Test
    public void test003() {
        String employeeName=response.extract().path("data[23].employee_name");
         System.out.println("The employee id-24 has name  : "+employeeName);

    }

    // 4) Get message = “Successfully! All records has been fetched.”
    @Test
    public void test004() {
       String message= response.extract().path("message");
        System.out.println("The message is : "+message);

    }

    // 5) Get status = success
    @Test
    public void test005() {
        String status= response.extract().path("status");
        System.out.println("The status is : "+status);

    }

    // 6) Get id = 3 has employee_salary = 86000
    @Test
    public void test006() {
        int employeeSalary= response.extract().path("data[2].employee_salary");
        System.out.println("The employee id-3 has salary  : "+employeeSalary);

    }

    // 7) Get id = 6 has employee_age = 61
    @Test
    public void test007() {
        int employeeAge= response.extract().path("data[5].employee_age");
        System.out.println("The employee id-6 has age  : "+employeeAge);

    }

    // 8) Get id = 11 has employee_name = Jena Gaines
    @Test
    public void test008() {
        String employeeName= response.extract().path("data[10].employee_name");
        System.out.println("The employee id-11 has name : "+employeeName);

    }
}
