package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

  TestContext testContext;

  public Hooks(TestContext context) {
    testContext = context;
  }

  @Before
  public void updatePropertiesfile() throws IOException {
    Properties extProperties = new Properties();
    String pathValue = "src/test/resources/extent.properties";
    FileInputStream inputStream = new FileInputStream(pathValue);
    extProperties.load(inputStream);
    inputStream.close();

    String oldVal1 = extProperties.getProperty("systeminfo.OStype");
    String oldVal2 = extProperties.getProperty("systeminfo.userDirectory");

    extProperties.setProperty("systeminfo.OStype",System.getProperty("os.name"));
    extProperties.setProperty("systeminfo.userDirectory",System.getProperty("user.dir"));

    FileOutputStream outputStream = new FileOutputStream(pathValue);
    extProperties.store(outputStream, null);
    outputStream.close();
  }

  @After
  public void AfterSteps() {
    testContext.getWebDriverManager().closeDriver();
  }
}
