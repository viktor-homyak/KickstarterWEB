package ua.com.goit.homyak.dao;


import org.springframework.stereotype.Component;
import ua.com.goit.homyak.mvc.model.CategoryModel;
import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.QuestionsModel;

import java.util.ArrayList;

/**
 * Created by Viktor on 01.08.2015.
 */

public interface ProjectDAO {

    void registerProjects();

    ProjectModel getProjectByID(int index, int categoryId);

    void updateProjectCurrentSum(int categoryId, int projectId, int ammount);

    QuestionsModel getQuestionByProjectID(int index, int categoryId);

    void updateQuestions(String question, String projectname);
}
