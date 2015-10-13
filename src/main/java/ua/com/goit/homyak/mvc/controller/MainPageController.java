package ua.com.goit.homyak.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.goit.homyak.dao.CategoryPostgreSQLDAO;
import ua.com.goit.homyak.dao.QuoteGenerator;



/**
 * Created by Viktor on 07.10.2015.
 */
@Controller
public class MainPageController {
    @Autowired
    private QuoteGenerator quote;
   @Autowired
   private CategoryPostgreSQLDAO categoryDAO;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String getMainJsp(ModelMap modelMap) {
        modelMap.addAttribute("quote", quote.getQuote());
        modelMap.addAttribute("categories", categoryDAO.getCategories());
        return "main";
    }



    public void setQuote(QuoteGenerator quote) {
        this.quote = quote;
    }
    public void setCategoryDAO(CategoryPostgreSQLDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
}
