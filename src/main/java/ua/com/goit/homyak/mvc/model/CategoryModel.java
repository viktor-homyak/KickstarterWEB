package ua.com.goit.homyak.mvc.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
@Entity
@Table(name = "categories")
public class CategoryModel {
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    public  CategoryModel(){}

    public CategoryModel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}