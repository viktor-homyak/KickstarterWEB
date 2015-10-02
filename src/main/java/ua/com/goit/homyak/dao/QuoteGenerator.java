package ua.com.goit.homyak.dao;

import org.springframework.stereotype.Repository;

import java.util.Random;
@Repository
public class QuoteGenerator {

    public String getQuote() {
        String[] ArrayOfQuotes = {"By giving, you receive!", "Maby you helping to start something BIG!",
                "If you liked an idea, the best you can help - send some money!"};
        int index = new Random().nextInt(ArrayOfQuotes.length);

        return ArrayOfQuotes[index];

    }
}
