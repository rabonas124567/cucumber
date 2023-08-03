package utilis;

import io.restassured.RestAssured;

public class ApiConstant {
    public static final String BASEURL= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_EMPLOYEE_URL=BASEURL+"/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URL=BASEURL+"/getOneEmployee.php";
    public static final String UPTADE_EMPLOYEE_URL=BASEURL+"/updateEmployee.php";
    public static final String GET_ALL_EMPLOYEE_URL=BASEURL+"/getAllEmployees.php";
    public static final String DELETE_EMPLOYEE_URL=BASEURL+"deleteEmployee";
    public static final String GENERATE_TOKEN_URL=BASEURL+"generateToken";


    public static final String Header_Content_Type="Content-Type";
    public static final String Content_Type="application/json";
    public static final String Header_Autherization="Authorization";
}
