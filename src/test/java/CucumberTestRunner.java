import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@Demo"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
