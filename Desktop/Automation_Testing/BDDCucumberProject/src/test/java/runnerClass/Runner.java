package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions ( features = {"Features/Login.feature"},
                   glue = {"stepDefinations"},
                   plugin = { "pretty","html:target/htmlReports", 
                		         "json:target/jsonReports/cucumber.json"   
                            },
                   monochrome = true
		         )
public class Runner extends AbstractTestNGCucumberTests{

}
