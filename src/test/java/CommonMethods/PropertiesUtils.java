package CommonMethods;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {


    static Properties prop = new Properties();
    public static String propFilePath;

    public static String getPropertyValue(String key) {
        propFilePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "configData.properties";
        FileInputStream fis;
        try {
            fis = new FileInputStream(propFilePath);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String value = prop.get(key).toString();

        if (StringUtils.isEmpty(value)) {
            try {
                throw new Exception("Value is not specified for key: " + key + " in properties file.");
             } catch (Exception ignored) {
            }
        }

        if (value.startsWith("${") && value.endsWith("}")) {
            try {
                String lookupValue = value.substring(2, value.length()-1);
                value = System.getenv(lookupValue);
            } catch (Exception e) {
            }
        }

        return value;
    }


}
