package com.restapi.dummy.employeeinfo;

import com.restapi.dummy.model.EmployeePojo;
import com.restapi.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutEmployeeTest extends TestBase {

    @Test
    public void updateEmployeeData(){
        EmployeePojo employeePojo=new EmployeePojo();
        employeePojo.setName("testing");
        employeePojo.setSalary(30000);

        Response response=given()

                .header("Content-Type", "application/json")
                .pathParams("id","9307")
                .body(employeePojo)
                .when()
                .put("/update/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
