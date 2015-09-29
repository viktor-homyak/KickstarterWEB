package ua.com.goit.homyak.mvc.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 * Created by Viktor on 14.07.2015.
 */

@Entity
@Table(name ="project")
public class ProjectModel {

    private int id;
    @Id
    private String name;
    @Column(name = "shortdescription")
    private String shortDescription;
    @Column(name = "sumtoraise")
    private int sumToRaise;
    @Column(name = "currentsum")
    private int currentSum;
    @Column(name = "enddate")
    private Date endDate;
    @Column(name = "projecthistory")
    private String projectHistory;
   // @Column(name = "faq")
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
   @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.REMOVE })
    private String fAQ;
    @Column(name = "demourl")
    private String demoURL;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parentname")
    @Column(name = "parentname")
    private String parentName;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parentid")
    @Column(name = "parentid")
    private int parentId;
public ProjectModel(){}
    public ProjectModel(int id, String name, String shortDescription, int sumToRaise, int currentSum, Date endDate,
                        String projectHistory, String demoURL, String parentName, int parentId) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.sumToRaise = sumToRaise;
        this.currentSum = currentSum;
        this.endDate = endDate;
        this.projectHistory = projectHistory;
        this.fAQ = new ArrayList<>();
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

