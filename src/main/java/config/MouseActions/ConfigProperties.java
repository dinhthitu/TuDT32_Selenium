package config.MouseActions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    public static final Properties PROPERTIES = new Properties();
    public static final String CONFIG_PATH = "config.properties";

    public static String browser;
    public static String doubleClickMsg;
    public static String rightClickMsg;
    public static String clickMsg;
    public static String currentAddress;

    static {
        try (InputStream input = new FileInputStream(CONFIG_PATH)) {
            PROPERTIES.load(input);
            browser = PROPERTIES.getProperty("browser");
            doubleClickMsg = PROPERTIES.getProperty("doubleClickMsg");
            rightClickMsg = PROPERTIES.getProperty("rightClickMsg");
            clickMsg = PROPERTIES.getProperty("clickMsg");
            currentAddress = PROPERTIES.getProperty("currentAddress");
        } catch (IOException e) {
            throw new RuntimeException("Cannot load config", e);
        }
    }
}