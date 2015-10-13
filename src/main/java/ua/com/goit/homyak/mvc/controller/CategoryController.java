package ua.com.goit.homyak.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.goit.homyak.dao.CategoryPostgreSQLDAO;
import ua.com.goit.homyak.mvc.model.ProjectModel;


import java.util.List;

/**
 * Created by Viktor on 07.10.2015.
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryPostgreSQLDAO categoryDAO;

    @RequestMapping(value = "categoryId/{categoryID}/", method = RequestMethod.GET)
    private String getCategoryJsp(@PathVariable int categoryID, ModelMap modelMap) {
        List<ProjectModel> projectsOfCategory = categoryDAO.getCategoryByID(categoryID);
        modelMap.addAttribute("categoryId", projectsOfCategory.get(0).getParentId());
        modelMap.addAttribute("categoryName", projectsOfCategory.get(0).getParentName());
        modelMap.addAttribute("projects", projectsOfCategory);

        return "category";
    }

    public void setCategoryDAO(CategoryPostgreSQLDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

}
