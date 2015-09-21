package ua.com.goit.homyak.mvc.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
@Entity
@Table(name = "categories")
public class CategoryModel {

    private String name;
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int index;

    public CategoryModel(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

}