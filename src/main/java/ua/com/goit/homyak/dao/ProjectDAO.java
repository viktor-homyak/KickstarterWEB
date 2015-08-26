package ua.com.goit.homyak.dao;


import ua.com.goit.homyak.mvc.model.CategoryModel;
import ua.com.goit.homyak.mvc.model.ProjectModel;

import java.util.ArrayList;

/**
 * Created by Viktor on 01.08.2015.
 */
public interface ProjectDAO {

    void registerProjects(ArrayList<ProjectModel> projects);

    ProjectModel getProjectByID(int index, int categoryId);


}
