package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigData {

    public static final Properties PROPERTIES = new Properties();
    public static final String CONFIG_PATH = "src/main/resources/config.properties";
    public static String url;
    public static String fileName;
    static {
        try (InputStream input = new FileInputStream(CONFIG_PATH)) {
            PROPERTIES.load(input);
            url = PROPERTIES.getProperty("url");
            fileName = PROPERTIES.getProperty("upload.file");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
