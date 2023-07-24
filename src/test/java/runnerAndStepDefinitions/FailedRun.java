package runnerAndStepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "@target/failedTestCases.txt",
    glue = {"runnerAndStepDefinitions"},
    plugin = {"pretty", "rerun:target/failedTestCases.txt"},
    monochrome = true
)
public class FailedRun extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }

}
