package ua.com.goit.homyak.dao;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Viktor on 13.08.2015.
 */

public class PGConnectionPool {

    private static DataSource dataSource;

    public static Connection getConnection() {

        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void init() throws SQLException, IOException {


        Properties dbProps = getDBProperties();
        dataSource = new DataSource();
        dataSource.setDriverClassName(dbProps.getProperty("driver"));
        dataSource.setUrl(dbProps.getProperty("url"));
        dataSource.setUsername(dbProps.getProperty("user"));
        dataSource.setPassword(dbProps.getProperty("password"));
        dataSource.setDefaultAutoCommit(false);

        try {
            checkConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Problem with DB connectivity!", e);
        }
    }

    private void checkConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();

        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    private Properties getDBProperties() throws IOException {

        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("config.properties");
        prop.load(stream);

        return prop;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
