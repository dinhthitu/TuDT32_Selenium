package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigData {

    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = "config.properties";

    public static String appUrl;
    public static String username;
    public static String password;
    public static String browser;
    public static String message;
    public static String invalidUsername;
    public static String invalidPassword;

    static {
        try (InputStream input = new FileInputStream(CONFIG_PATH)) {
            properties.load(input);
            browser = properties.getProperty("browser");
            appUrl = properties.getProperty("URL");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            message = properties.getProperty("message");
            invalidUsername = properties.getProperty("invalidUsername");
            invalidPassword = properties.getProperty("invalidPassword");
        } catch (IOException e) {
            throw new RuntimeException("Cannot load config", e);
        }
    }
}

