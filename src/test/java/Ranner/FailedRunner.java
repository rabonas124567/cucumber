package Ranner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

                                           // CLASS NO:8

        features="@target/failed.txt" ,
        glue = "ClassesForLMS",
        monochrome=true,
        plugin ={"pretty"}
)

public class FailedRunner {
}
