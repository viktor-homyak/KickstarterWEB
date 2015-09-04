package ua.com.goit.homyak.dao;

import org.apache.tomcat.jdbc.pool.ConnectionPool;
import org.postgresql.ds.PGPoolingDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * Created by Viktor on 13.08.2015.
 */

public class PGConnectionPool {

    private static   DataSource dataSource;
//    private DataSource dataSource;


//    public PGConnectionPool() {
//
//    }

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
            dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Problem with DB connectivity!", e);
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
