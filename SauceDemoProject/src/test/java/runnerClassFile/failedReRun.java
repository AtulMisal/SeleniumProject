package runnerClassFile;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = {"@target/failedReRun.txt"},
                  glue =     {"stepDefinations"},
                  plugin =   {"pretty","html:target/cucumber-reports",
                              "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                              "rerun:target/failedReRun.txt"},        	
                  monochrome = true )

public class failedReRun extends AbstractTestNGCucumberTests{

}
