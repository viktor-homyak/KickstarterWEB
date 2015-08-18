package ua.com.goit.homyak.dao;


import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.CategoryModel;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Viktor on 30.07.2015.
 */
public interface CategoryDAO {

      Map<Integer,ArrayList<ProjectModel>>  getCategories();

       void registerCategories(Map<Integer, ArrayList<ProjectModel>> categories);

      CategoryModel getCategoryByID(int id);

}
