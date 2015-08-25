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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.print(req.getRequestURI());
        String quote = new QuoteGenerator().getQuote();
        req.setAttribute("quote", quote);
        ArrayList<CategoryModel> category =  daoFactory.getCategoryDAO().getCategories();
        req.setAttribute("category", category);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }


    @Override
    public void init() throws ServletException {
        this.daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

        daoFactory.getCategoryDAO().registerCategories(category);
        daoFactory.getProjectDAO().registerProjects(projects);

    }
}