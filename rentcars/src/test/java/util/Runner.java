package util;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions"},
        tags = {"@Behavior1"})

//AND tags = {"@Behavior1", "@Behavior2", "@Behavior3"}
//OR tags = {"@Behavior1, @Behavior2, @Behavior3"}
//NOT tags = {"~@Behavior1"}
public class Runner {

}
