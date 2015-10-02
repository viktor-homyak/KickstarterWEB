package ua.com.goit.homyak.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.homyak.mvc.model.CategoryModel;
import ua.com.goit.homyak.mvc.model.ProjectModel;

import java.util.List;

/**
 * Created by Viktor on 01.08.2015.
 */

@Repository
public class CategoryPostgreSQLDAO {
    private SessionFactory sessionFactory;

    public CategoryPostgreSQLDAO() {
    }

    @Transactional(readOnly = true)
    public List<CategoryModel> getCategories() {
        Session session = sessionFactory.openSession();
        List<CategoryModel> categories =     session.createQuery("from CategoryModel").list();
        session.close();
        return categories;

    }

    @Transactional(readOnly = true)
    public List<ProjectModel> getCategoryByID(int categoryID) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM ProjectModel WHERE parentId = :categoryID");
        query.setParameter("categoryID", categoryID);
        List<ProjectModel> category = query.list();
        session.close();
        return category;
    }


    public void registerCategories() {
//               ArrayList<CategoryModel> categories = new ArrayList<>();
//        categories.add()
        String sql = "INSERT INTO categories (id, name)" +
                "VALUES " +
                "(1,'Sport')," +
                "(2,'Table games')," +
                "(3,'Ecology projects')";
//        try (Connection connection = PGConnectionPool.getConnection()) {
//            try (Statement statement = connection.createStatement()) {
//                statement.executeUpdate(sql);
//                     connection.commit();
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        tx.commit();
        session.close();


    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
