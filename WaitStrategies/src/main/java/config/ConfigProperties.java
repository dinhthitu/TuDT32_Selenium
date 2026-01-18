package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    public static Properties properties = new Properties();
    public static String configPath = "config.properties";
    public static String browser;
    public static String url;

    static{
        try( InputStream fileInputStream = new FileInputStream(configPath)){
            properties.load(fileInputStream);
            browser = properties.getProperty("browser");
            url = properties.getProperty("URL");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
