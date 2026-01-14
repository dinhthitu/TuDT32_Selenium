package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configProperties {
    public static Properties properties;
    public static String browser;
    public static String url;
    public static String username;
    public static String email;
    private static String configPath = "config.properties";

    public static void initializeProperty() throws IOException{
        properties = new Properties();
        InputStream inputFile = new FileInputStream(configPath);
        properties.load(inputFile);
        browser = properties.getProperty("browser");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        email =  properties.getProperty("email");
    }
}
