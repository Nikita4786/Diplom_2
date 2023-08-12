package diploma.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcConnector {

    private static JdbcTemplate jdbcTemplate;
    static final String DRIVER;
    static final String URL;
    static final String USERNAME = ConfProperties.getDbUsername();
    static final String PASSWORD = ConfProperties.getDbPassword();

    static {
        boolean isMysql = System.getProperty("dbt").equalsIgnoreCase("mysql");
        DRIVER = isMysql ? ConfProperties.getMysqlJdbcDriver() : ConfProperties.getPostgresqlJdbcDriver();
        URL = isMysql ? ConfProperties.getMysqlUrl() : ConfProperties.getPostgresqlUrl();
    }

    private JdbcConnector() {
        throw new IllegalStateException();
    }

    private static DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    private static JdbcTemplate getJdbcTemplate() {
        try {
            jdbcTemplate = new JdbcTemplate(mysqlDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jdbcTemplate;
    }

    public static String getLastAmountFromDB() {
        return getJdbcTemplate().queryForObject(SqlQueries.SELECT_LAST_AMOUNT.getSqlQuery(), String.class);
    }

    public static String getLastDebitStatusFromDB() {
        return getJdbcTemplate().queryForObject(SqlQueries.SELECT_LAST_STATUS_DEBIT.getSqlQuery(), String.class);
    }

    public static String getLastCreditStatusFromDB() {
        return getJdbcTemplate().queryForObject(SqlQueries.SELECT_LAST_STATUS_CREDIT.getSqlQuery(), String.class);
    }
}
