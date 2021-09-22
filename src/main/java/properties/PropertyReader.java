package properties;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader(String name) {
        this.properties = getProperties(name);
    }

    public Properties getProperties() {
        return properties;
    }

    public Properties getProperties(String name) {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}