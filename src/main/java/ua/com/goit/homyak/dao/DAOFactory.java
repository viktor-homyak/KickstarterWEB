package ua.com.goit.homyak.dao;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Component;

/**
 * Created by Viktor on 01.08.2015.
 */
@Component
public abstract class DAOFactory {


    public static final int POSTGRESQL = 1;
    public static final int INMEMORY = 3;

    public abstract CategoryDAO getCategoryDAO();

    public abstract ProjectDAO getProjectDAO();


    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case POSTGRESQL:
                try {
                    PGConnectionPool pgConnectionPool = new PGConnectionPool();
                    pgConnectionPool.init();

                } catch (SQLException e) {
                    throw new RuntimeException("Can't initialize database", e);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new PostgreSQLDAOFactory();

            case INMEMORY:
                return new InMemoryDAOFactory();
            default:
                return null;
        }
    }
}