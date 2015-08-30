package ua.com.goit.homyak.servlet;

import ua.com.goit.homyak.QuoteGenerator;
import ua.com.goit.homyak.dao.DAOFactory;
import ua.com.goit.homyak.mvc.model.CategoryModel;
import ua.com.goit.homyak.mvc.model.ProjectModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.SocketPermission;
import java.util.ArrayList;

/**
 * Created by Viktor on 18.08.2015.
 */
public class MainServlet extends HttpServlet {
    private DAOFactory daoFactory;
    private ArrayList<CategoryModel> category;
    private ArrayList<ProjectModel> projects;
    private int categoryId;
    private int projectId;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getRequestURI().equals("returnToMainPage"))  {
            getMainJsp(req, resp);
        }
        else if (req.getRequestURI().equals("/"))  {
            getMainJsp(req, resp);
        }
        else if (req.getRequestURI().contains("categoryId")&& !req.getRequestURI().contains("projectId"))  {
             categoryId = Integer.parseInt(req.getRequestURI().substring(req.getRequestURI().lastIndexOf("=") + 1));
            getCategoryJsp(req, resp, categoryId);
        }
        else if (req.getRequestURI().contains("projectId")) {
            String[] adress = req.getRequestURI().split("/");

             categoryId = Integer.parseInt(adress[1].substring(adress[1].lastIndexOf("=") + 1));
            projectId = Integer.parseInt(adress[2].substring(adress[2].lastIndexOf("=") + 1));
            getProjectJsp(req, resp, categoryId, projectId);

        }
        else {
          //  req.getRequestDispatcher("error404.jsp").forward(req, resp);
        }
    }

    private void getProjectJsp(HttpServletRequest req, HttpServletResponse resp, int categoryId, int projectId)throws ServletException, IOException {
        ProjectModel project = daoFactory.getProjectDAO().getProjectByID(projectId,daoFactory.getCategoryDAO().getCategoryByID(categoryId).get(0).getParentId());
        req.setAttribute("categoryId", project.getParentId());
        req.setAttribute("categoryName", project.getParentName());
        req.setAttribute("project", project);
        req.getRequestDispatcher("project.jsp").forward(req, resp);

    }


    private void getCategoryJsp(HttpServletRequest req, HttpServletResponse resp, int categoryID) throws ServletException, IOException {
        ArrayList<ProjectModel> projectsOfCategory = daoFactory.getCategoryDAO().getCategoryByID(categoryID);
        req.setAttribute("categoryId", projectsOfCategory.get(0).getParentId());
        req.setAttribute("categoryName", projectsOfCategory.get(0).getParentName());
        req.setAttribute("projects", projectsOfCategory);
        req.getRequestDispatcher("category.jsp").forward(req, resp);

    }
    private void getMainJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quote = new QuoteGenerator().getQuote();
        req.setAttribute("quote", quote);
        req.setAttribute("category", daoFactory.getCategoryDAO().getCategories());
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }


    @Override
    public void init() throws ServletException {
        this.daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

        daoFactory.getCategoryDAO().registerCategories(category);
        daoFactory.getProjectDAO().registerProjects(projects);

    }
}