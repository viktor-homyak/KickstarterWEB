package ua.com.goit.homyak.dao;


import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.CategoryModel;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by viktor on 02.08.2015.
 */
public class CategoryInMemoryDAO implements CategoryDAO {

    private Map<Integer, ArrayList<ProjectModel>> categories;

    @Override
    public  Map<Integer, ArrayList<ProjectModel>> getCategories() {
        return categories;
    }

    @Override
    public CategoryModel getCategoryByID(int id) {
        return null;
    }
    @Override
    public  void registerCategories(Map<Integer, ArrayList<ProjectModel>> categories) {
        this.categories = categories;
    }
}
