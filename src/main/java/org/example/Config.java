package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static long FORM_REFRESH_PERIOD_IN_SECONDS;
    public static long TIMEOUT_FOR_INTERACTING_WITH_ELEMENT_IN_SECONDS;
    public static String ANTI_CAPTCHA_CLIENT_KEY;
    public static Boolean IS_TIMESLOT_SELECT_REVERSED;
    static InputStream inputStream;

    public static void getPropValues(){
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = Config.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            FORM_REFRESH_PERIOD_IN_SECONDS = Long.parseLong(prop.getProperty("FORM_REFRESH_PERIOD_IN_SECONDS"));
            TIMEOUT_FOR_INTERACTING_WITH_ELEMENT_IN_SECONDS = Long.parseLong(prop.getProperty("TIMEOUT_FOR_INTERACTING_WITH_ELEMENT_IN_SECONDS"));
            ANTI_CAPTCHA_CLIENT_KEY = prop.getProperty("ANTI_CAPTCHA_CLIENT_KEY");
            IS_TIMESLOT_SELECT_REVERSED = Boolean.valueOf(prop.getProperty("IS_TIMESLOT_SELECT_REVERSED"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
