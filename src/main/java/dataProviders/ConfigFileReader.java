package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "src/test/resources/configs/Configuration.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try{
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configurations.properties file not found at: "+propertyFilePath);
        }
    }

    public String getApplicationURL(){
        String AUT_URL = properties.getProperty("aut_URL");
        if (AUT_URL != null) return AUT_URL;
        else throw new RuntimeException("aut_URL key not specified in " +
                "Configuration.properties located at: "+propertyFilePath);
    }

    public long getImplicitWaitTime(){
        String implicitlyWait = properties.getProperty("implicitWaitTime");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitWaitTime key not specified in " +
                "Configuration.properties located at: "+propertyFilePath);
    }
}
