package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BasicFinding {
    String baseurl= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTA3Mjk2NTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MDc3Mjg1MCwidXNlcklkIjoiNTY4MiJ9.N0cp2JKfiwWCPk6cQPMj-wjyt--vhN_0ip1NmZWSIoo";
    static String employee_id;

    @Test
    public void bgetOneemployee(){


        RequestSpecification requestSpecification= given().header("Content-Type","application/json").
                header("Authorization",token)
                .queryParam("employee_id",employee_id);

        Response response= requestSpecification.when().get("/getOneEmployee.php");
        System.out.println(response.asString());
        response.then().assertThat().statusCode(200);


        String empid=response.jsonPath().getString("employee.employee_id");
        boolean compareids=empid.contentEquals(employee_id);

        Assert.assertTrue(compareids);

        String middlename=response.jsonPath().getString("employee.emp_middle_name");
        Assert.assertTrue(middlename.contentEquals("Suga"));

    }

        @Test
    public void acreateemployee(){

        RequestSpecification requestSpecification=given().header("Content-Type","application/json").
                header("Authorization",token)
                 .body("{\n" +
                         "    \"emp_firstname\":\"Snobar\",\n" +
                         "    \"emp_lastname\":\"Rabonas\",\n" +
                         "    \"emp_middle_name\":\"Suga\",\n" +
                         "    \"emp_gender\":\"F\",\n" +
                         "    \"emp_birthday\":\"2003-08-14\",\n" +
                         "    \"emp_status\":\"Employee\",\n" +
                         "    \"emp_job_title\":\"Tester\"\n" +
                         "\n" +
                         "}");
            Response response=requestSpecification.when().post("/createEmployee.php");
          //  System.out.println(response.asString());
            response.prettyPrint();

            employee_id=response.jsonPath().getString("Employee.employee_id");
            System.out.println(employee_id);

            response.then().assertThat().statusCode(201);
            response.then().assertThat().body("Employee.emp_middle_name",equalTo("Suga"));
            response.then().assertThat().body("Message",equalTo("Employee Created"));
            response.then().assertThat().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");
            response.then().assertThat().body("Employee.emp_job_title",equalTo("Tester"));
        }
    @Test
    public void cupdateemployee() {

        RequestSpecification requestSpecification = given().header("Content-Type", "application/json")
                .header("Authorization", token)
                .body("{\n" +
                        "    \"employee_id\":\""+employee_id+"\",\n" +
                        "    \"emp_firstname\":\"Snow\",\n" +
                        "    \"emp_lastname\":\"Rabonas\",\n" +
                        "    \"emp_middle_name\":\"agus\",\n" +
                        "    \"emp_gender\":\"F\",\n" +
                        "    \"emp_birthday\":\"2003-08-14\",\n" +
                        "    \"emp_status\":\"Employee\",\n" +
                        "    \"emp_job_title\":\"Tester\"\n" +
                        "\n" +
                        "}");
        Response response = requestSpecification.when().put("/updateEmployee.php");
        //  System.out.println(response.asString());
        response.prettyPrint();

      /*  employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

       */
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }
    @Test
    public void dgetuptatedemployee(){


        RequestSpecification requestSpecification= given().header("Content-Type","application/json").
                header("Authorization",token)
                .queryParam("employee_id",employee_id);

        Response response= requestSpecification.when().get("/getOneEmployee.php");
        System.out.println(response.asString());
        response.then().assertThat().statusCode(200);


        String middlename=response.jsonPath().getString("employee.emp_middle_name");
        Assert.assertTrue(middlename.contentEquals("agus"));

    }
    @Test
    public void zgetstatus() {


        RequestSpecification requestSpecification = given().header("Authorization", token);

        Response response = requestSpecification.when().get("/employeementStatus.php");
        System.out.println(response.asString());

        response.then().assertThat().statusCode(200);
    }
     @Test
     public void xgettitle(){


        RequestSpecification requestSpecification=given().header("Authorization", token);
        Response response=requestSpecification.when().get("/jobTitle.php");
         System.out.println(response.asString());

         response.then().assertThat().statusCode(200);

        }

    @Test
   public void getAllEmployees (){
        RequestSpecification requestSpecification=given().header("Authorization", token)
                .header("Content-Type","application/json");

        Response response=requestSpecification.when().get("/getAllEmployees.php");
        String allEmployees=response.prettyPrint();

        JsonPath js=new JsonPath(allEmployees);

        int count=js.getInt("Employees.size()");
        System.out.println(count);

        for (int i = 0; i < count; i++) {
            String allemployee=js.getString("Employees"+i+"employee_id");
            System.out.println(allemployee);
        }








    }








}
