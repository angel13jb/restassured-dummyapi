package com.restapi.dummy.employeeinfo;

import com.restapi.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteEmployeeTest extends TestBase {

    @Test
    public void deleteEmployeeData(){
        Response response=given()
                .pathParam("id","22")
                .when()
                .delete("/delete/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
