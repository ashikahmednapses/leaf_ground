package MyRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/java/Resources/Features/CheckBox.feature", 
        glue = { "stepDefinitions" },

        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }

)
public class TestCheckBoxRunner extends AbstractTestNGCucumberTests{
    
}
