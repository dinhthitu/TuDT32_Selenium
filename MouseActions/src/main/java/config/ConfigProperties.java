package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    public static final Properties PROPERTIES = new Properties();
    public static final String CONFIG_PATH = "config.properties";

    public static String url;
    public static String browser;
    public static String doubleClickMsg;
    public static String rightClickMsg;
    public static String clickMsg;

    static {
        try (InputStream input = new FileInputStream(CONFIG_PATH)) {
            PROPERTIES.load(input);
            browser = PROPERTIES.getProperty("browser");
            url = PROPERTIES.getProperty("url");
            doubleClickMsg = PROPERTIES.getProperty("doubleClickMsg");
            rightClickMsg = PROPERTIES.getProperty("rightClickMsg");
            clickMsg = PROPERTIES.getProperty("clickMsg");

        } catch (IOException e) {
            throw new RuntimeException("Cannot load config", e);
        }
    }
}
