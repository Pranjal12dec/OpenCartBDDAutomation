package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class WebDriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    public WebDriver getDriver() {
        return (driver == null) ? driver = createDriver() : driver;
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
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
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
