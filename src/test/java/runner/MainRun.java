package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Run with cucumber
@RunWith(Cucumber.class)

// Cucumber options - features and steps location
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepsDefinition",
        tags = "@All"
)

// Main class
public class MainRun {

}
