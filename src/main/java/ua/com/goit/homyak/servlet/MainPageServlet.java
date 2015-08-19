package ua.com.goit.homyak.servlet;

import ua.com.goit.homyak.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Viktor on 18.08.2015.
 */
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);


}
}
