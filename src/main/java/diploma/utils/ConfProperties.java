package diploma.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfProperties {

    private static Properties properties = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPortalUrl() {
        return properties.getProperty("base_url");
    }

    public static String getMysqlUrl() {
        return properties.getProperty("db_mysql_url");
    }

    public static String getPostgresqlUrl() {
        return properties.getProperty("db_postgresql_url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db_username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db_password");
    }

    public static String getDbType() {
        return properties.getProperty("db_type");
    }

    public static String getMysqlJdbcDriver() {
        return properties.getProperty("mysql_jdbc_driver");
    }

    public static String getPostgresqlJdbcDriver() {
        return properties.getProperty("postgresql_jdbc_driver");
    }

    public static String getValidCardNumber() {
        return properties.getProperty("valid_card");
    }

    public static String getInvalidCardNumber() {
        return properties.getProperty("invalid_card");
    }

    public static String getValidCardStatus() {
        return properties.getProperty("valid_status");
    }

    public static String getInValidCardStatus() {
        return properties.getProperty("invalid_status");
    }


}



