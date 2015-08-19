package ua.com.goit.homyak.servlet;

import ua.com.goit.homyak.QuoteGenerator;
import ua.com.goit.homyak.dao.CategoryDAO;
import ua.com.goit.homyak.dao.DAOFactory;
import ua.com.goit.homyak.dao.PGConnectionPool;
import ua.com.goit.homyak.mvc.model.CategoryModel;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Viktor on 18.08.2015.
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quote = new QuoteGenerator().getQuote();
        req.setAttribute("quote", quote);
             CategoryModel category = (CategoryModel) getDaoFactory().getCategoryDAO();
        req.setAttribute("category",category);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }


    private DAOFactory getDaoFactory() {
        ServletContext servletContext = getServletContext();

        return (DAOFactory) servletContext.getAttribute("daoFactory");
    }
}