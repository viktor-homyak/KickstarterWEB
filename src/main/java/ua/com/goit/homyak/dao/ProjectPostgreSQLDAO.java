package ua.com.goit.homyak.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.QuestionsModel;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Viktor on 19.08.2015.
 */

public class ProjectPostgreSQLDAO {

    private SessionFactory sessionFactory;

    public ProjectPostgreSQLDAO() {}
//TODO move to script
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


    }
//TODO inject services
    @Transactional(readOnly = true)
    public ProjectModel getProjectByID(int index, int categoryId) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ProjectModel WHERE parentId = :categoryID and id = :index");
        query.setParameter("categoryID", categoryId);
        query.setParameter("index", index);
        ProjectModel projectModel = (ProjectModel) query.uniqueResult();
        return projectModel ;

    }

    @Transactional(readOnly = false)
    public void updateProjectCurrentSum(int categoryId, int projectId, int ammount) {

        try {
            Session session = sessionFactory.getCurrentSession();
            ProjectModel projectModel = getProjectByID(projectId,categoryId);
            projectModel.increaseCurrentSum(ammount);
            session.update(projectModel);
            session.merge(projectModel);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }


    @Transactional(readOnly = true)
    public List<QuestionsModel> getQuestionByProjectName(String projectName) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM QuestionsModel WHERE projectname = :projectName");
        query.setParameter("projectName", projectName);
        List<QuestionsModel> questions = query.list();
        return questions;

    }

    @Transactional(readOnly = true)
    public ProjectModel getProjectByName(String projectName) {

        ProjectModel projectModel = null;

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("FROM ProjectModel WHERE name = :projectName");
            query.setParameter("projectName", projectName);
            projectModel = (ProjectModel) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return projectModel;

    }

    @Transactional(readOnly = false)
    public void updateQuestions(String question, String projectname) {

        try {
            Session session = sessionFactory.getCurrentSession();
            ProjectModel project = getProjectByName(projectname);
            QuestionsModel faq = new QuestionsModel();
            faq.setName(question);
            faq.setProjectname(projectname);
            project.addFAQ(faq);
            session.merge(project);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
