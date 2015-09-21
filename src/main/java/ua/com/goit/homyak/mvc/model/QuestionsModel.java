package ua.com.goit.homyak.mvc.model;


import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Viktor on 10.09.2015.
 */

public class QuestionsModel {

    private  String projectname;

    private String name;

    private int index;

    public QuestionsModel( int index,String name, String projectname) {
        this.name = name;
        this.index = index;
        this.projectname = projectname;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public String getProjectname() {
        return projectname;
    }
}
