package ua.com.goit.homyak.mvc.model;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class CategoryModel {

    private String name;
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