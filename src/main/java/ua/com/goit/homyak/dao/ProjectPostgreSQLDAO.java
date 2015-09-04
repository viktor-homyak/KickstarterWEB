package ua.com.goit.homyak.dao;

import ua.com.goit.homyak.mvc.model.CategoryModel;
import ua.com.goit.homyak.mvc.model.ProjectModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Viktor on 19.08.2015.
 */
public class ProjectPostgreSQLDAO implements ProjectDAO {

    private PGConnectionPool pgConnectionPool;

    public ProjectPostgreSQLDAO(PGConnectionPool pgConnectionPool) {
        this.pgConnectionPool = pgConnectionPool;
    }

    public ProjectPostgreSQLDAO() {
    }

    @Override
    public void registerProjects(ArrayList<ProjectModel> projects) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 05, 9);
        String sql = "INSERT INTO  project (id, name, shortdescription, sumtoraise," +
                "currentsum, enddate, projecthistory,faq, demourl,parentname,parentid)" +
                "VALUES " +
                "(1,'Gluconazol', 'Brend new anabolics', 25000000, 7500000, '2019-09-25'," +
                " 'New MOC politics dictetes new requirements for pharmasy'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Sport', 1)," +
                "(1,'Warriors of eternity -', 'New game, clone of ''Game of thrones''', 10000, 1500, '2019-09-25'," +
                " 'Game of thrones was a very good game, but it starts to bore people, so new game is on!!'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Table games', 2)";

        try (Connection connection = PGConnectionPool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);

            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ProjectModel getProjectByID(int index, int categoryId) {

        String sql = "SELECT * FROM project WHERE parentid = " + categoryId + " AND id =" + index + "";
        try (Connection connection = PGConnectionPool.getConnection()) {
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery();
                 rs.next();
                return  new ProjectModel(rs.getInt("id"), rs.getString("name"), rs.getString("shortdescription"),
                        rs.getInt("sumtoraise"), rs.getInt("currentsum"), rs.getDate("enddate"),
                        rs.getString("projecthistory"), rs.getString("faq"), rs.getString("demourl"),
                        rs.getString("parentname"), rs.getInt("parentid"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setPGConnectionPool(PGConnectionPool PGConnectionPool) {
        pgConnectionPool = PGConnectionPool;
    }

    public PGConnectionPool getPGConnectionPool() {
        return pgConnectionPool;
    }
}
