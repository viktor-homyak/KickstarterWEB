package ua.com.goit.homyak.dao;



import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.CategoryModel;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Viktor on 30.07.2015.
 */

public interface CategoryDAO {

    ArrayList<CategoryModel> getCategories();

    void registerCategories();

    ArrayList<ProjectModel> getCategoryByID(int index);

}
