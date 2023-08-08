package mysakan;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "use_cases/provided", // Set the path to your feature files
    plugin = {"summary", "html:target/cucumber/wikipedia.html"},
    snippets = SnippetType.CAMELCASE,
    glue = "mysakan"
)
public class AcceptanceTest {

}
