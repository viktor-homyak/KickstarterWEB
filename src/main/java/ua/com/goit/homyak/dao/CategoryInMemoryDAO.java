package ua.com.goit.homyak.dao;


import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.CategoryModel;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by viktor on 02.08.2015.
 */
public class CategoryInMemoryDAO implements CategoryDAO {


    @Override
    public ArrayList<CategoryModel> getCategories() {
        return null;
    }

    @Override
    public void registerCategories(ArrayList<CategoryModel> categories) {

    }

    @Override
    public void registerCategories() {

    }

    @Override
    public ArrayList<ProjectModel> getCategoryByID(int index) {
        return null;
    }
}
