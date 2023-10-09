package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/reports/htmlReports", "json:target/reports/Cucumber.json"},
        //código report Maven => mvn test -Dtest=**/*RunCucumberTest cluecumber-report:reporting
        features = "src/test/resources/features",
        //tags = "@login",
        glue = {"steps"}
)

public class RunCucumberTest extends RunBase {

    @AfterClass
    public static void stop() {
        driver.quit();
    }

}
