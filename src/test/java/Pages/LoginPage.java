package Pages;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilis.CommenMethods;
import utilis.ConfigReader;

public class LoginPage extends CommenMethods {

    @FindBy(id="txtStudentID")
    public WebElement StudentId;

    @FindBy(id="txtPassword")
    public WebElement Password;

    @FindBy(id="ibtnLogin")
    public WebElement SignIn;

    @FindBy(xpath="findone")
    public WebElement dropdown;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void login(String studentid,String password){
       /* StudentId.sendKeys(studentid);
        Password.sendKeys(password);

        */
        sendText(StudentId,ConfigReader.getPropertyValue("username"));
        sendText(Password,ConfigReader.getPropertyValue("password"));

        finallyclick(SignIn);

    }

}
