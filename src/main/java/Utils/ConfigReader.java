package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Veri okuma işleri yapıldı.
    private static Properties properties;

    public static Properties initializeProperties(){
        properties=new Properties();
        try {
            FileInputStream fileInputStream=new FileInputStream("src/test/resources/Config.properties");
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return getProperties();
    }

    public static Properties getProperties() {
        return properties;
    }
}
