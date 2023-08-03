package ClassesForLMS;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilis.CommenMethods;

import java.util.Iterator;
import java.util.Set;

public class LogOut extends CommenMethods {
    public static String main1;

    @When("user click on the Student Services")
    public void user_click_on_the_student_services() {
        WebElement studentservice=driver.findElement(By.xpath("//span[contains(text(),'Student Services')]"));
        studentservice.click();
    }

    @When("go to make date sheet option")
    public void go_to_make_date_sheet_option() {
        WebElement makedatesheet=driver.findElement(By.xpath("//span[contains(text(),'Make your Date Sheet')]"));
        makedatesheet.click();


    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {

        main1=driver.getWindowHandle();
        Set<String> main=driver.getWindowHandles();
        Iterator<String> it=main.iterator();
      while(it.hasNext()) {
          String handle = it.next();
          if(!handle.equals(main1)){
              driver.switchTo().window(handle);
              WebElement logindatesheetbtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
              logindatesheetbtn.click();
              break;
          }
      }
    }

    @When("click on singin button")
    public void click_on_singin_button() {
        WebElement sheetStudentID=driver.findElement(By.id("txtSId"));
        sheetStudentID.sendKeys("bc200416975");
        WebElement sheetPassword=driver.findElement(By.id("txtP"));
        sheetPassword.sendKeys("sysipus*2S");
        WebElement signdatesheetbtn=driver.findElement(By.id("btnLogin"));
        signdatesheetbtn.click();

    }

    @When("click on logout button")
    public void click_on_logout_button() {
        WebElement signdatesheetLOGOUT=driver.findElement(By.id("btnLogout"));
        signdatesheetLOGOUT.click();

    }

    @When("move to main page")
    public void move_to_main_page() {
       // String mainwindow=driver.getWindowHandle();
        driver.switchTo().window(main1);
    }

    @When("click the right corner picture of user on application")
    public void click_the_right_corner_picture_of_user_on_application() {
       WebElement pic=driver.findElement(By.xpath("//img[@class='m--img-rounded m--marginless m--img-centered']")) ;
        pic.click();
    }

    @When("click on LogOut button")
    public void click_on_log_out_button() {
        WebElement logout2=driver.findElement(By.id("lnkLogout"));
        logout2.click();
    }

    @Then("user will be LogOut")
    public void user_will_be_log_out() {
        System.out.println("You have done a very great job");
    }


}
