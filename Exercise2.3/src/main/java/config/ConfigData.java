package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigData {

    private static final Properties PROPERTIES = new Properties();
    private static final String CONFIG_PATH = "config.properties";

    public static String appUrl;
    public static String username;
    public static String password;
    public static String browser;
    public static String message;
    public static String invalidUsername;
    public static String invalidPassword;
    public static String successUrl;

    static {
        try (InputStream input = new FileInputStream(CONFIG_PATH)) {
            PROPERTIES.load(input);
            browser = PROPERTIES.getProperty("browser");
            appUrl = PROPERTIES.getProperty("URL");
            username = PROPERTIES.getProperty("username");
            password = PROPERTIES.getProperty("password");
            message = PROPERTIES.getProperty("message");
            invalidUsername = PROPERTIES.getProperty("invalidUsername");
            invalidPassword = PROPERTIES.getProperty("invalidPassword");
            successUrl = PROPERTIES.getProperty("successURL");
        } catch (IOException e) {
            throw new RuntimeException("Cannot load config", e);
        }
    }
}

