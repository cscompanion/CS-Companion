package com.itp.myapplication;

import java.util.Date;

public class remindersDatabase {
    String rCategory, rDescription, rUrgency;
    Integer id;
    Date rDateDue;

    public remindersDatabase() {
    }

    public remindersDatabase(String rCategory, String rDescription, String rUrgency, Integer id, Date rDateDue) {
        this.rCategory = rCategory;
        this.rDescription = rDescription;
        this.rUrgency = rUrgency;
        this.id = id;
        this.rDateDue = rDateDue;
    }

    public String getrCategory() {
        return rCategory;
    }

    public void setrCategory(String rCategory) {
        this.rCategory = rCategory;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }

    public String getrUrgency() {
        return rUrgency;
    }

    public void setrUrgency(String rUrgency) {
        this.rUrgency = rUrgency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getrDateDue() {
        return rDateDue;
    }

    public void setrDateDue(Date rDateDue) {
        this.rDateDue = rDateDue;
    }
}
