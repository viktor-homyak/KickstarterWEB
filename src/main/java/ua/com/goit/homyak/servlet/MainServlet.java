package ua.com.goit.homyak.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.goit.homyak.dao.QuoteGenerator;
import ua.com.goit.homyak.dao.*;
import ua.com.goit.homyak.mvc.model.ProjectModel;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Viktor on 18.08.2015.
 */
public class MainServlet extends HttpServlet {
    @Autowired
    private QuoteGenerator quote;
    @Autowired
    private CategoryPostgreSQLDAO categoryDAO;
    @Autowired
    private ProjectPostgreSQLDAO projectDAO;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
        categoryDAO.registerCategories();
        projectDAO.registerProjects();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int categoryId;
        if (req.getRequestURI().equals("returnToMainPage")) {
            getMainJsp(req, resp);
        } else if (req.getRequestURI().equals("/")) {
            getMainJsp(req, resp);
        } else if (req.getRequestURI().contains("categoryId") && !req.getRequestURI().contains("projectId")) {
            categoryId = Integer.parseInt(req.getRequestURI().substring(req.getRequestURI().lastIndexOf("=") + 1));
            getCategoryJsp(req, resp, categoryId);
        } else if (req.getRequestURI().contains("projectId")) {
            String[] adress = req.getRequestURI().split("/");

            categoryId = Integer.parseInt(adress[1].substring(adress[1].lastIndexOf("=") + 1));
            int projectId = Integer.parseInt(adress[2].substring(adress[2].lastIndexOf("=") + 1));
            getProjectJsp(req, resp, categoryId, projectId);

        }

    }

    public void getProjectJsp(HttpServletRequest req, HttpServletResponse resp, int categoryId, int projectId) throws ServletException, IOException {
        ProjectModel project = projectDAO.getProjectByID(projectId, categoryDAO.getCategoryByID(categoryId).get(0).getParentId());
        req.setAttribute("categoryId", project.getParentId());
        req.setAttribute("categoryName", project.getParentName());
        req.setAttribute("project", project);
        req.getRequestDispatcher("/project.jsp").forward(req, resp);

    }


    private void getCategoryJsp(HttpServletRequest req, HttpServletResponse resp, int categoryID) throws ServletException, IOException {
        ArrayList<ProjectModel> projectsOfCategory = categoryDAO.getCategoryByID(categoryID);
        req.setAttribute("categoryId", projectsOfCategory.get(0).getParentId());
        req.setAttribute("categoryName", projectsOfCategory.get(0).getParentName());
        req.setAttribute("projects", projectsOfCategory);
        req.getRequestDispatcher("category.jsp").forward(req, resp);

    }

    private void getMainJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quote = new QuoteGenerator().getQuote();
        req.setAttribute("quote", quote);
        req.setAttribute("category", categoryDAO.getCategories());
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void setQuote(QuoteGenerator quote) {
        this.quote = quote;
    }

    public QuoteGenerator getQuote() {
        return quote;
    }

    public void setCategoryDAO(CategoryPostgreSQLDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public CategoryPostgreSQLDAO getCategoryDAO() {
        return categoryDAO;
    }

    public ProjectPostgreSQLDAO getProjectDao() {
        return projectDAO;
    }

    public void setProjectDAO(ProjectPostgreSQLDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

}