package Ranner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/LMSfeatures/Login.feature",
        glue= "ClassesForLMS",
        monochrome=true,
        dryRun = false,
        tags="@login",
        plugin ={"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}

)
public class Runner2 {
}
