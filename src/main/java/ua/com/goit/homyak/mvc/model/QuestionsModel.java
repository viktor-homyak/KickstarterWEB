package ua.com.goit.homyak.mvc.model;


import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Viktor on 10.09.2015.
 */
@Entity
@Table(name ="questions")
public class QuestionsModel {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectname")
    private  String projectname;

    private String name;
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int index;
 public QuestionsModel(){

    }
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

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
}
