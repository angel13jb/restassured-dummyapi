package com.restapi.dummy.employeeinfo;

import com.restapi.dummy.model.EmployeePojo;
import com.restapi.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostEmployeeTest extends TestBase {
@Test
    public void createEmployeeData(){

    EmployeePojo employeePojo=new EmployeePojo();
    employeePojo.setName("test");
    employeePojo.setSalary(40000);
    employeePojo.setAge(38);

    Response response=given()
            .header("Content-Type", "application/json")
            .body(employeePojo)
            .when()
            .post("/create");
    response.then().statusCode(200);
    response.prettyPrint();

}

}
