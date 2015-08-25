package ua.com.goit.homyak.dao;


/**
 * Created by Viktor on 01.08.2015.
 */
public class PostgreSQLDAOFactory extends DAOFactory {

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryPostgreSQLDAO();
    }

    @Override
    public ProjectDAO getProjectDAO() {
        return new ProjectPostgreSQLDAO();
    }
}
