package ua.com.goit.homyak.dao;

import ua.com.goit.homyak.mvc.model.CategoryModel;
import ua.com.goit.homyak.mvc.model.ProjectModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Viktor on 19.08.2015.
 */
public class ProjectPostgreSQLDAO implements ProjectDAO{

    @Override
    public void registerProjects(ArrayList<ProjectModel> projects) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 05, 9);
        String sql = "INSERT INTO project (id, name, shortdescription, sumtoraise," +
                "currentsum, enddate, projecthistory,faq, demourl,parentname,parentid)" +
                "VALUES " +
                "(1,'Gluconazol -', 'Brend new anabolics;', 25000000, 7500000, '2019-09-25'," +
                " 'New MOC politics dictetes new requirements for pharmasy;'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Sport', 1)," +
                "(2,'Warriors of eternity -', 'New game, clone of ''Game of thrones'';', 10000, 1500, '2019-09-25'," +
                " 'Game of thrones was a very good game, but it starts to bore people, so new game is on!!;'," +
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
    public ProjectModel getProjectByID(int index, CategoryModel category){
        String sql = "SELECT * FROM project WHERE parentid = 'categoryID' AND id = 'index'";
        ProjectModel project = (ProjectModel) new Object();
        try (Connection connection = PGConnectionPool.getConnection()) {
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery();
                     project = new ProjectModel(rs.getString("name"), rs.getString("shortdescription"),
                            rs.getInt("sumtoraise"), rs.getInt("currentsum"), rs.getDate("enddate"),
                            rs.getString("projecthistory"), rs.getString("faq"), rs.getString("demourl"),
                            rs.getString("parentname"), rs.getInt("parentid"));
                return project;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }
}
