package API;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utilis.APIPlayLoadConstant;
import utilis.ApiConstant;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIWorkFlowSteps {
    RequestSpecification requestSpecification;
    Response response;
    public static  String employee_id;

    @Given("A request is prepared for creting an eployee")
    public void a_request_is_prepared_for_creting_an_eployee() {
        requestSpecification=given().header(ApiConstant.Header_Content_Type,ApiConstant.Content_Type)
                .header(ApiConstant.Header_Autherization,Token.token)
                .body(APIPlayLoadConstant.CreateEmployeePayLoad());

    }
    @When("a post call is made to dreate an employee")
    public void a_post_call_is_made_to_dreate_an_employee() {
        response=requestSpecification.when().post(ApiConstant.CREATE_EMPLOYEE_URL);
    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer statuscode) {
      response.then().assertThat().statusCode(statuscode);
    }
    @Then("the employee created contains the key {string} and the value {string}")
    public void the_employee_created_contains_the_key_and_the_value(String message, String contains) {
       response.then().assertThat().body(message,equalTo(contains));
    }
    @Then("the employee id {string} is stored as the global varible to be used for other call")
    public void the_employee_id_is_stored_as_the_global_varible_to_be_used_for_other_call(String id) {
        employee_id= response.jsonPath().getString(id);
        System.out.println(employee_id);

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////




    @Given("A request is prepared for getting the created  employee using api call")
    public void a_request_is_prepared_for_getting_the_created_employee_using_api_call() {
        requestSpecification=given().header(ApiConstant.Header_Content_Type,ApiConstant.Content_Type)
                .header(ApiConstant.Header_Autherization,Token.token)
                .queryParam("employee_id",employee_id);
    }

    @When("get call is prepared to get the created employee")
    public void get_call_is_prepared_to_get_the_created_employee() {
        response=requestSpecification.when().get(ApiConstant.GET_ONE_EMPLOYEE_URL);
    }

    @Then("the status code is {int}")
    public void the_status_code_is(Integer code) {
        response.then().assertThat().statusCode(code);
    }

    @Then("the  id {string}  must match the globally stored employee id")
    public void the_id_must_match_the_globally_stored_employee_id(String id) {
      String comingid= response.jsonPath().getString(id);
      Assert.assertEquals(comingid,employee_id);
    }

    @Then("the data  retried  at  {string} objects must match the data used to create the employee with  the id {string}")
    public void the_data_retried_at_objects_must_match_the_data_used_to_create_the_employee_with_the_id
            (String employeeObject, String employeeid, DataTable dataTable) {

              List<Map<String,String>> expecteddata=dataTable.asMaps(String.class,String.class);
              Map<String ,String> actualdata=response.jsonPath().get(employeeObject);

        for (Map<String,String > map:expecteddata
             ) {
           Set<String> keys= map.keySet();
            for (String key:keys
                 ) {
                String expectedvale=map.get(key);
                String actualvalue=actualdata.get(key);
                Assert.assertEquals(expectedvale,actualvalue);
            }
            
        }
        String empid=response.jsonPath().getString(employeeid);
        Assert.assertEquals(empid,employee_id);












    }
}
