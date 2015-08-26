package ua.com.goit.homyak.mvc.model;


import java.util.Date;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectModel {

    private int id;
    private String name;
    private String shortDescription;
    private int sumToRaise;
    private int currentSum;
    private Date endDate;
    private String projectHistory;
    private String fAQ;
    private String demoURL;
    private String parentName;
    private int parentId;

    public ProjectModel(int id, String name, String shortDescription, int sumToRaise, int currentSum, Date endDate,
                        String projectHistory, String fAQ, String demoURL, String parentName, int parentId) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.sumToRaise = sumToRaise;
        this.currentSum = currentSum;
        this.endDate = endDate;
        this.projectHistory = projectHistory;
        this.fAQ = fAQ;
        this.demoURL = demoURL;
        this.parentName = parentName;
        this.parentId = parentId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getSumToRaise() {
        return sumToRaise;
    }

    public int getCurrentSum() {
        return currentSum;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getProjectHistory() {
        return projectHistory;
    }

    public String getfAQ() {
        return fAQ;
    }

    public String getDemoURL() {
        return demoURL;
    }

    public String getName() {
        return name;
    }

    public String getParentName() {
        return parentName;
    }

    public int getParentId() {
        return parentId;
    }

    public int getId() {
        return id;
    }


}

