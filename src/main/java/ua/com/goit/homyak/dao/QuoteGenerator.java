package ua.com.goit.homyak.dao;

import org.hibernate.SessionFactory;

import java.util.Random;

public class QuoteGenerator {


  //  private SessionFactory sessionFactory;
    public String getQuote() {
        String[] ArrayOfQuotes = {"By giving, you receive!", "Maby you helping to start something BIG!",
                "If you liked an idea, the best you can help - send some money!"};
        int index = new Random().nextInt(ArrayOfQuotes.length);

        return ArrayOfQuotes[index];

    }

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
}
