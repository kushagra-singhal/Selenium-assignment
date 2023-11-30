package SeleniumAmazonAssignment.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static Properties getLoadedPropertiesObject() throws IOException {
        FileInputStream fis = new FileInputStream("ConfigReader/configReader.properties");
        Properties prop=new Properties();
        prop.load(fis);
        return prop;
    }
    public static String getUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("url");
    }
}
