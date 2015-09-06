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
    public void registerProjects() {
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
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Table games', 2), " +
                "(2,'Eczoskeleton', 'This thing upgrades muscle power', 4000000, 2500000, '2019-09-25'," +
                " 'Limites of human body was reached, but sport of big achievements  isn`t stopped'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Sport', 1)," +
                "(3,'Slow Ball', 'New game with a big, heavy ball', 4000000, 2500000, '2019-09-25'," +
                " 'Football, basketball is no longer attractive. People want to see something new'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Sport', 1)," +
                "(2,'Robo rally 2', 'Reincarnation of good old strategy',7500, 3000, '2019-09-25'," +
                " 'You will be able to construct factories in new version. The game map become twise bigger'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Table games', 2)," +
                "(3,'Slow Ball table game', 'New table game',12000, 10000, '2019-09-25'," +
                " 'Astoneshing gameplay, provided by Julius Beismann. We promise, You will sink in variety of game strategy'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Table games', 2), " +
                "(4,'Leprecons', 'The game based on old movie',3000, 2750, '2019-09-25'," +
                " 'Classical 2*2 game, which will be easy to play with friendsy'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Table games', 2)," +
                "(1,'Garbage collector', 'Tool for utilization of home garbage', 500000, 50000, '2019-09-25'," +
                " 'In partnership with norvegian ecological ministry we developing a revolutionary device for utilization'," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Ecology projects', 3)," +
                "(2,'Pioneers', 'New forest ecosystem ceepeng organization', 11000000, 3000000, '2019-09-25'," +
                " 'In times when forrest pollution grows, sosiety needs not only better culture, but people who will '," +
                "                'Is it legal?\\nno\\nWhat side effects?\\n85% brain cancer'," +
                "                'https://www.youtube.com/watch?v=tk7RUVJmLk0','Ecology projects', 3)";
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
