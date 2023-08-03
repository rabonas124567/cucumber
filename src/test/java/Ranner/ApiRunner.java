package Ranner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/APIfeatures/Token.feature",
        glue= "API",
        monochrome=true,
        dryRun=false,
        tags="@getemployee",
        plugin ={"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}

)
public class ApiRunner {


}
