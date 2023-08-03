package ClassesForLMS;

import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilis.CommenMethods;
import utilis.ConfigReader;
import utilis.Constants;
import utilis.ExcelReading;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StepsForLogIn extends CommenMethods {

    @Given("user navigate to LMS login page")
    public void user_navigate_to_lms_login_page() {
       openBrowserAndLaunchAplication();
    }

    @When("user enters the valid username and password")
    public void user_enters_the_valid_username_and_password() {
        WebElement StudentID=driver.findElement(By.id("txtStudentID"));
        StudentID.sendKeys(ConfigReader.getPropertyValue("username"));
        WebElement Password=driver.findElement(By.id("txtPassword"));
        Password.sendKeys(ConfigReader.getPropertyValue("password"));

    }

    @When("click on login button")
    public void click_on_login_button() {
        WebElement SignIn=driver.findElement(By.id("ibtnLogin"));
        SignIn.click();
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("Test is passed");
    }
    @When("user enters the Invalid username and password")
    public void user_enters_the_invalid_username_and_password() {
        WebElement StudentID=driver.findElement(By.id("txtStudentID"));
        StudentID.sendKeys("bc200416975");
        WebElement Password=driver.findElement(By.id("txtPassword"));
        Password.sendKeys("sysipus*1S");
    }

    @When("get a message print this message")
    public void get_a_message_print_this_message() {
       WebElement invalidtextbox=driver.findElement(By.id("divError"));
       String getText=invalidtextbox.getText();
       System.out.println(getText);
    }
    @Then("user is successfully not logged in")
    public void user_is_successfully_not_logged_in() {
        System.out.println("Above Text is text which is given when we entered the wrong password");
    }

                                              //class4





    //Class 41  First method for the parimetrization of the inputs like name and password

    @When("user enters the valid {string} and {string}")
    public void user_enters_the_valid_and(String studentid, String username) {
        WebElement StudentID=driver.findElement(By.id("txtStudentID"));
        StudentID.sendKeys(studentid);
        WebElement Password=driver.findElement(By.id("txtPassword"));
        Password.sendKeys(username);

    }


    // class 42 Second method for the parimetrization of the inputs like name and password

    @When("user enters the valid {string} and  {string}")
    public void user_enters_the_invalid_and(String ID, String PASSWORD) {
        WebElement StudentID=driver.findElement(By.id("txtStudentID"));
        StudentID.sendKeys(ID);
        WebElement Password=driver.findElement(By.id("txtPassword"));
        Password.sendKeys(PASSWORD);

    }
// class 43 Third method for the parimetrization of the inputs like name and password
    @When("user enters the Invalid {string}  {string} and  {string}")
    public void user_enters_the_Invalid_and(String ID, String PASSWORD , String ERROR) {
        WebElement StudentID=driver.findElement(By.id("txtStudentID"));
        StudentID.sendKeys(ID);
        WebElement Password=driver.findElement(By.id("txtPassword"));
        Password.sendKeys(PASSWORD);
        WebElement Error2=driver.findElement(By.id("lblError"));
        String geterror2= Error2.getText();
        Assert.assertEquals("value do not match",ERROR,geterror2);
       /* WebElement Error=driver.findElement(By.id("lblValidPassword"));
        String geterror= Error.getText();
        Assert.assertEquals("value do not match",ERROR,geterror);
        WebElement Error1=driver.findElement(By.id("lblValidStudentID"));
        String geterror1= Error1.getText();
        Assert.assertEquals("value do not match",ERROR,geterror1);

        */




    }
//class 44  forth  method for the parimetrization of the inputs like name and password
    @When("user enters the valid {string}  {string}")
    public void user_enters_the_valid(String ID, String PASSWORD) {
        WebElement StudentID=driver.findElement(By.id("txtStudentID"));
        StudentID.sendKeys(ID);
        WebElement Password=driver.findElement(By.id("txtPassword"));
        Password.sendKeys(PASSWORD);
    }


    @When("{string} IS DISPLYED")
    public void is_displyed(String TEXT) {
        WebElement invalidtextbox=driver.findElement(By.id("divError"));
        Assert.assertTrue(invalidtextbox.isDisplayed());

    }
    //class45
    @When("user enters the valid USERNAME  PASSWORD")
    public void user_enters_the_valid_username_password(DataTable dataTable) {
       List<Map <String,String>> credential=dataTable.asMaps();
       for(Map <String,String> emo:credential){
           String username=emo.get("Username");
           String password=emo.get("Password");
           WebElement StudentID=driver.findElement(By.id("txtStudentID"));
           StudentID.sendKeys(username);
           WebElement Password=driver.findElement(By.id("txtPassword"));
           Password.sendKeys(password);
       }

    }
//class46
    @Then("user varify all the dashboard option")
    public void user_varify_all_the_dashboard_option(DataTable dataTable) {
      List<String> expectedtabs=dataTable.asList();

      List<WebElement> gettabs= driver.findElements(By.xpath("get the location from the LMS"));
        List<String> actualtabs=new ArrayList<>();

        for (WebElement ele:gettabs
             ) {
            actualtabs.add(ele.getText());
        }

        System.out.println(expectedtabs);
        System.out.println(actualtabs);
        Assert.assertTrue(expectedtabs.equals(actualtabs));
        System.out.println("My test is passed");

    }

                                        //class5


   /* @When("user provide mutiple data from the excel file  using {string} sheet and logged in")
    public void user_provide_mutiple_data_from_the_excel_file_using_sheet_and_logged_in(String sheetname) {
      List <Map<String,String>>  newemploye= ExcelReading.excelintomap(Constants.ExcelForCucumber_FILEPATH,sheetname);


        Iterator<Map<String,String>> map2=newemploye.iterator();
        while(map2.hasNext()){
            Map<String,String> map3=map2.next();

            WebElement StudentID=driver.findElement(By.id("txtStudentID"));
            StudentID.sendKeys(map3.get("StudentId"));
            WebElement Password=driver.findElement(By.id("txtPassword"));
            Password.sendKeys(map3.get("Password"));
            WebElement SignIn=driver.findElement(By.id("ibtnLogin"));
            SignIn.click();
            WebElement photo=driver.findElement(By.id("findone"));
            photo.sendKeys(map3.get("Photograph"));

            WebElement checkbox= driver.findElement(By.id("findone"));
            if(!checkbox.isSelected()){
                checkbox.click();
            }


        } */
   @When("user provide mutiple data from the excel file  using {string} sheet and logged in")
   public void user_provide_mutiple_data_from_the_excel_file_using_sheet_and_logged_in(String EmployeData) {
       List <Map<String,String>>  newemploye= ExcelReading.excelintomap(Constants.ExcelForCucumber_FILEPATH,EmployeData);


       Iterator<Map<String,String>> map2=newemploye.iterator();
       while(map2.hasNext()) {
           Map<String, String> map3 = map2.next();

           WebElement StudentID = driver.findElement(By.id("txtStudentID"));
           StudentID.sendKeys(map3.get("StudentId"));
           WebElement Password = driver.findElement(By.id("txtPassword"));
           Password.sendKeys(map3.get("Password"));
           WebElement SignIn = driver.findElement(By.id("ibtnLogin"));
           SignIn.click();
       }
   }
                                                 //class6




    @When("Using methods from PageFactory")
    public void Using_methods_from_PageFactory() {
      // LoginPage login=new LoginPage();
     //  login.StudentId.sendKeys("just to show other way of using LoginPge fields");

        loginPage.StudentId.sendKeys(ConfigReader.getPropertyValue("username"));
        loginPage.Password.sendKeys("password");
        loginPage.SignIn.click();

    }
                                     //class7

    @When("user logged in")
    public void user_logged_in() {
      //  loginPage.StudentId.sendKeys(ConfigReader.getPropertyValue("username"));
        sendText( loginPage.StudentId,ConfigReader.getPropertyValue("username"));
       // loginPage.Password.sendKeys("password");
        sendText( loginPage.Password,ConfigReader.getPropertyValue("password"));
       //  loginPage.SignIn.click();
        finallyclick( loginPage.SignIn);

       loginPage.login(ConfigReader.getPropertyValue("username"),ConfigReader.getPropertyValue("password"));
        getjavascriptExecutorclick(loginPage.SignIn);

                                             //class 8

        dropdown(loginPage.dropdown,"Others");
        dropdown(loginPage.dropdown,"pakistan");








   }



}












