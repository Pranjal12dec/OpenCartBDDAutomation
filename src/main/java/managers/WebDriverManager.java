package managers;

import enums.DriverType;
import enums.EnvironmentType;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManager {

  private static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();
  private static DriverType driverType;
  private static EnvironmentType environmentType;
  WebDriver driver = driverLocal.get();

  public WebDriverManager() {
    driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
  }

  public WebDriver getDriver() {
    if (driver == null) {
      driver = createDriver();
      driverLocal.set(driver);
    }
    return driver;
  }

  private WebDriver createDriver() {
    switch (environmentType) {
      case LOCAL -> {
        driver = createLocalDriver();
      }
      case REMOTE -> {
        driver = createRemoteDriver();
      }
    }
    return driver;
  }

  private WebDriver createRemoteDriver() {
    throw new RuntimeException(
        "RemoteWebDriver is not yet implemented. Please implement it in WebDriverManager Class");
  }

  private WebDriver createLocalDriver() {
    switch (driverType) {
      case CHROME -> {
        driver = new ChromeDriver();
      }
      case EDGE -> {
        driver = new EdgeDriver();
      }
      case FIREFOX -> {
        driver = new FirefoxDriver();
      }
      case SAFARI -> {
        driver = new SafariDriver();
      }
    }
    if (FileReaderManager.getInstance().getConfigFileReader().getWindowSize()) {
      driver.manage().window().maximize();
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
        FileReaderManager.getInstance().getConfigFileReader().getImplicitWaitTime()));
    return driver;
  }

  public void closeDriver() {
    driver.close();
    driver.quit();
  }
}
