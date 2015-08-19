package ua.com.goit.homyak.servlet;

import ua.com.goit.homyak.QuoteGenerator;
import ua.com.goit.homyak.dao.DAOFactory;

import javax.servlet.*;



public  class ContextListener implements ServletContextListener {
    private ServletContext context = null;
    private DAOFactory daoFactory;
    public void contextInitialized(ServletContextEvent event) {

         this.daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

    }

    public void contextDestroyed(ServletContextEvent event) {

    }

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }
}