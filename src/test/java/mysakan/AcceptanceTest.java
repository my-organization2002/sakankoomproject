package mysakan;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "use_cases/provided/studenthousingdetails.feature",
    plugin = {"summary", "html:target/cucumber/wikipedia.html"},
    monochrome = true,
    snippets = SnippetType.CAMELCASE,
    glue = "mysakan"
)

public class AcceptanceTest {

}
