package ClassesForLMS;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilis.CommenMethods;

public class Hooks extends CommenMethods {
    @Before
    public  void start(){
        openBrowserAndLaunchAplication();

    }
    @After
    public void close(Scenario scenario){
         byte[] pic;
         if(scenario.isFailed()){
             pic=screenshot("failed/"+scenario.getName());
         }else{
             pic=screenshot("passed/"+scenario.getName());
         }

       scenario.attach(pic,"image/png",scenario.getName());

         closeBrowser();}
}

