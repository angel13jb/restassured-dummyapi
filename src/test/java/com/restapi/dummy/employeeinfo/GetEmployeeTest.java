package com.restapi.dummy.employeeinfo;

import com.restapi.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetEmployeeTest extends TestBase {

    @Test
    public void getAllEmployeesInfo() {
        Response response = given()
                .when()
                .get("/employees");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .when()
                .get("/employee/5");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
