package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigData {

    public static final String CONFIG_PATH = "src/main/resources/config.properties";
    public static final Properties PROPERTIES = new Properties();

    public static final String FIRST_NAME;
    public static final String LAST_NAME;
    public static final String EMAIL;
    public static final String GENDER;
    public static final String MOBILE;
    public static final String DATE_OF_BIRTH;
    public static final String SUBJECTS;
    public static final String HOBBIES;
    public static final String CURRENT_ADDRESS;
    public static final String STATE;
    public static final String CITY;
    public static final String MODEL_MESSAGE;

    static {
        try (InputStream input = new FileInputStream(CONFIG_PATH)) {
            PROPERTIES.load(input);
            FIRST_NAME = PROPERTIES.getProperty("firstname");
            LAST_NAME = PROPERTIES.getProperty("lastname");
            EMAIL = PROPERTIES.getProperty("email");
            GENDER = PROPERTIES.getProperty("gender");
            MOBILE = PROPERTIES.getProperty("mobile");
            DATE_OF_BIRTH = PROPERTIES.getProperty("dateOfBirth");
            SUBJECTS = PROPERTIES.getProperty("subjects");
            HOBBIES = PROPERTIES.getProperty("hobbies");
            CURRENT_ADDRESS = PROPERTIES.getProperty("currentAddress");
            STATE = PROPERTIES.getProperty("state");
            CITY = PROPERTIES.getProperty("city");
            MODEL_MESSAGE = PROPERTIES.getProperty("modelMsg");
        } catch (IOException e) {
            throw new RuntimeException("Cannot load config", e);
        }
    }
}