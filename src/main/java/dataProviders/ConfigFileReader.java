package dataProviders;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/configs/Configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configurations.properties file not found @: " + propertyFilePath);
        }
    }

    public String getApplicationURL() {
        String AUT_URL = properties.getProperty("aut_URL");
        if (AUT_URL != null) {
            return AUT_URL;
        } else {
            throw new RuntimeException("aut_URL key not specified in " +
                    "Configuration.properties located @: " + propertyFilePath);
        }
    }

    public long getImplicitWaitTime() {
        String implicitlyWait = properties.getProperty("implicitWaitTime");
        if (implicitlyWait != null) {
            return Long.parseLong(implicitlyWait);
        } else {
            throw new RuntimeException("implicitWaitTime key is not specified in" +
                    "Configuration.properties located @: " + propertyFilePath);
        }
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equalsIgnoreCase("chrome")) {
            return DriverType.CHROME;
        } else if (browserName.equalsIgnoreCase("firefox")) {
            return DriverType.FIREFOX;
        } else if (browserName.equalsIgnoreCase("edge")) {
            return DriverType.EDGE;
        } else if (browserName.equalsIgnoreCase("safari")) {
            return DriverType.SAFARI;
        } else {
            throw new RuntimeException(
                    "Browser Name Key is not specified in Configuration.properties file @ "
                            + propertyFilePath);
        }
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local")) {
            return EnvironmentType.LOCAL;
        } else if (environmentName.equalsIgnoreCase("remote")) {
            return EnvironmentType.REMOTE;
        } else {
            throw new RuntimeException(
                    "Environment Type Key is not specified in Configuration.properties file @ "
                            + propertyFilePath);
        }
    }

    public boolean getWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null) {
            return Boolean.parseBoolean(windowSize);
        } else {
            return true;
        }
    }

    public String getToEmailAddress() {
        String toEmail = properties.getProperty("to_email_address");
        if (toEmail != null) {
            return toEmail;
        } else {
            throw new RuntimeException(
                    "to_email_address key not specified in Configuration.properties file @ "
                            + propertyFilePath);
        }
    }

    public String getFromEmailAddress() {
        String fromEmail = properties.getProperty("from_email_address");
        if (fromEmail != null) {
            return fromEmail;
        } else {
            throw new RuntimeException(
                    "from_email_address key not specified in Configuration.properties file @ "
                            + propertyFilePath);
        }
    }

    public String getFromEmailAddressPWD() {
        String fromEmailPWD = properties.getProperty("from_email_address_password");
        if (fromEmailPWD != null) {
            return fromEmailPWD;
        } else {
            throw new RuntimeException(
                    "from_email_address_password key not specified in Configuration.properties file @ "
                            + propertyFilePath);
        }
    }
}