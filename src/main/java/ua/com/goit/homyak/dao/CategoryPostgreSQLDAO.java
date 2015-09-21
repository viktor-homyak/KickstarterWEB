package ua.com.goit.homyak.dao;


import org.hibernate.SessionFactory;
import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.CategoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 * Created by Viktor on 01.08.2015.
 */
public class CategoryPostgreSQLDAO  {



    private SessionFactory sessionFactory;

    public CategoryPostgreSQLDAO() {
    }


    public List<CategoryModel> getCategories() {
//        String sql = "SELECT * FROM categories";
//
//        ArrayList<CategoryModel> categories = new ArrayList<>();
//        try (Connection connection = PGConnectionPool.getConnection()) {
//            try (PreparedStatement stm = connection.prepareStatement(sql)) {
//                ResultSet rs = stm.executeQuery();
//                while (rs.next()) {
//                    categories.add(new CategoryModel(rs.getString("name"), rs.getInt("id")));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from categories");
        List<CategoryModel> categories = query.list();
        return categories;

    }


    public List<ProjectModel> getCategoryByID(int categoryID) {
//        String sql = "SELECT * FROM project WHERE parentid = "+categoryID+"";
//        ArrayList<ProjectModel> category = new ArrayList<>();
//        try (Connection connection = PGConnectionPool.getConnection()) {
//            try (PreparedStatement stm = connection.prepareStatement(sql)) {
//                ResultSet rs = stm.executeQuery();
//                while (rs.next()) {
//                        category.add(new ProjectModel(rs.getInt("id"),rs.getString("name"), rs.getString("shortdescription"),
//                                rs.getInt("sumtoraise"), rs.getInt("currentsum"), rs.getDate("enddate"),
//                                rs.getString("projecthistory"), rs.getString("faq"), rs.getString("demourl"),
//                                rs.getString("parentname"), rs.getInt("parentid")));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT * FROM project WHERE parentid = "+categoryID+"");
        List<ProjectModel> category = query.list();
        return category;
    }


    public void registerCategories() {

        String sql = "INSERT INTO categories (id, name)" +
                "VALUES " +
                "(1,'Sport')," +
                "(2,'Table games')," +
                "(3,'Ecology projects')";
        try (Connection connection = PGConnectionPool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
                     connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
