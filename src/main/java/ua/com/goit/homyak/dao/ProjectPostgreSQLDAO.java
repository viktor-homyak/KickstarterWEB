package ua.com.goit.homyak.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.QuestionsModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Viktor on 19.08.2015.
 */
@Repository
@Transactional(readOnly = true)
public class ProjectPostgreSQLDAO {



    private SessionFactory sessionFactory;

    public ProjectPostgreSQLDAO() {
    }


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
//        try (Connection connection = PGConnectionPool.getConnection()) {
//            try (Statement statement = connection.createStatement()) {
//                statement.executeUpdate(sql);
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }


    public ProjectModel getProjectByID(int index, int categoryId) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM ProjectModel WHERE parentId = :categoryID and id = :index");
        query.setParameter("categoryID", categoryId);
        query.setParameter("index", index);

        return (ProjectModel) query.uniqueResult();


    }


    public void updateProjectCurrentSum(int categoryId, int projectId, int ammount) {
        String sql = "UPDATE project SET currentsum =" + ammount + " WHERE parentid =" + categoryId + " AND id =" + projectId + "";
        try (Connection connection = PGConnectionPool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Query query = session.createQuery("update Stock set stockName = :stockName" +
                " where stockCode = :stockCode");
        query.setParameter("stockName", "DIALOG1");
        query.setParameter("stockCode", "7277");
        int result = query.executeUpdate();

    }



    public List<QuestionsModel> getQuestionByProjectName(String projectName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM QuestionsModel WHERE projectname = :projectName");
        query.setParameter("projectName", projectName);

        List<QuestionsModel> questions = query.list();
        return questions;

    }

    public void updateQuestions(String question, String projectname) {
        String sql = "INSERT INTO questions (name, projectname) VALUES ('" + question + "','" + projectname + "')";

        try (Connection connection = PGConnectionPool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Query query = session.createQuery("insert into QuestionsModel(name, projectname) select stock_code, stock_name from backup_stock");
        int result = query.executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
