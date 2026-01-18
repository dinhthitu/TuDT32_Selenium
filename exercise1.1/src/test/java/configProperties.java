import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configProperties {
    public static Properties properties;
    public static String url;
    public static  String browser;
    private static String configPath = "src/test/config/config.properties";

    public static void initializeProperty () throws IOException {
        properties = new Properties();
        InputStream input = new FileInputStream(configPath);
        properties.load(input);
        browser = properties.getProperty("browser");
        url = properties.getProperty("appUrl");

    }
}
