package ua.com.goit.homyak.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.goit.homyak.dao.CategoryPostgreSQLDAO;
import ua.com.goit.homyak.dao.ProjectPostgreSQLDAO;
import ua.com.goit.homyak.mvc.model.ProjectModel;
import ua.com.goit.homyak.mvc.model.QuestionsModel;

import java.util.List;

/**
 * Created by Viktor on 07.10.2015.
 */
@Controller
public class ProjectController {

    @Autowired
    private CategoryPostgreSQLDAO categoryDAO;

    @Autowired
    private ProjectPostgreSQLDAO projectDAO;


    @RequestMapping(value = "categoryId/{categoryID}/projectId/{projectID}/", method = RequestMethod.GET)
    private String getCategoryJsp(@PathVariable int categoryID, @PathVariable int projectID, ModelMap modelMap) {
        ProjectModel project = projectDAO.getProjectByID(projectID, categoryDAO.getCategoryByID(categoryID).get(0).getParentId());
        List<QuestionsModel> questions = projectDAO.getQuestionByProjectName(project.getName());

        modelMap.addAttribute("categoryId", project.getParentId());
        modelMap.addAttribute("categoryName", project.getParentName());
        modelMap.addAttribute("project", project);
        modelMap.addAttribute("questions", questions);

        return "project";
    }

    @RequestMapping(value = "categoryId/{categoryID}/projectId/{projectID}/addmoney", method = RequestMethod.POST)
    public String updateCurrentSum(@PathVariable("projectID") int projectID, @PathVariable("categoryID") int categoryID,
                                   @RequestParam int addedAmount) {

        projectDAO.updateProjectCurrentSum(categoryID, projectID, addedAmount);

        return "redirect:/categoryId/" + categoryID + "/projectId/" + projectID + "/";
    }

    @RequestMapping(value = "categoryId/{categoryID}/projectId/{projectID}/faq", method = RequestMethod.POST)
    public String addQuestion(@PathVariable("projectID") int projectID, @PathVariable("categoryID") int categoryID,
                              @RequestParam String addedQuestion, @RequestParam String projectname) {
        projectDAO.updateQuestions(addedQuestion, projectname);

        return "redirect:/categoryId/" + categoryID + "/projectId/" + projectID + "/";
    }

    public void setCategoryDAO(CategoryPostgreSQLDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void setProjectDAO(ProjectPostgreSQLDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

}
