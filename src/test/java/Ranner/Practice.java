package Ranner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        /*                                      CLASS NO:3

        features="src/test/resources/LMSfeatures/Login.feature" ,
        //here we give the path for the feature file


        glue = "ClassesForLMS",
        // here we give the package name in which we have our java class for that feature file to execute


        dryRun = true,
        // Run the code without the actual execution

        monochrome=true,
        //Eliminate all the shit that we can not read from the console

        strict= true,
        //Do the same job which dry run do

        tags=" @smoke and  @Reggresion and @Run", //for this both tags have to be avaible
        tags ="@Run",
        tags="@Run or  @smoke", //for any tag avaible
        //Run the particular Scenario with the given tag

        plugin ={"pretty","html:target/cucumber.html"}
        //After creating this file run your code then select (reload from disk) option after right click on your project name
        // and do right click on your just created cucumber.html file and go to  Openin--> browser--> chrome

         */


        //                                      CLASS NO:4




        features="src/test/resources/LMSfeatures/Practice.feature" ,
        glue = "ClassesForLMS",
        dryRun = false,
        monochrome=true,
       // tags ="@class42",
        plugin ={"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}
)

public class Practice {
}
