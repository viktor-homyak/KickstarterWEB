package ua.com.goit.homyak.dao;


import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.CategoryModel;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by Viktor on 01.08.2015.
 */
public class CategoryPostgreSQLDAO implements CategoryDAO {


    @Override
    public ArrayList<CategoryModel> getCategories() {
        String sql = "SELECT * FROM categories";

        ArrayList<CategoryModel> categories = new ArrayList<>();
        try (Connection connection = PGConnectionPool.getConnection()) {
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    categories.add(new CategoryModel(rs.getString("name"), rs.getInt("id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public ArrayList<ProjectModel> getCategoryByID(int categoryID) {
        String sql = "SELECT * FROM project ORDER BY parentid";
        ArrayList<ProjectModel> category = new ArrayList<>();
        try (Connection connection = PGConnectionPool.getConnection()) {
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {

                    if (rs.getInt("parentid") == categoryID) {
                        category.add(new ProjectModel(rs.getString("name"), rs.getString("shortdescription"),
                                rs.getInt("sumtoraise"), rs.getInt("currentsum"), rs.getDate("enddate"),
                                rs.getString("projecthistory"), rs.getString("faq"), rs.getString("demourl"),
                                rs.getString("parentname"), rs.getInt("parentid")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void registerCategories(ArrayList<CategoryModel> categories) {

        String sql = "INSERT INTO categories (id, name)" +
                "VALUES " +
                "(1,'Sport')," +
                "(2,'Table games')," +
                "(3,'Ecology projects'";
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


}
