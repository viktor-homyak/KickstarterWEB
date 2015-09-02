package ua.com.goit.homyak.dao;

import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Viktor on 13.08.2015.
 */
public class PGConnectionPool {
    private static PGPoolingDataSource dataSource;

    public PGConnectionPool() {
    }

    public static Connection getConnection() {

        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public   void init(String userName, String userPassword) throws SQLException {
        dataSource = new PGPoolingDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("kickstarter");
        dataSource.setUser(userName);
        dataSource.setPassword(userPassword);
        dataSource.setMaxConnections(10);

    }
}
