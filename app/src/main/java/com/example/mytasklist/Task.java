package com.example.mytasklist;

public class Task {
    protected String title;
    protected String description;
    protected String date;
    protected String duration;

    public Task(String title, String description, String date, String duration){
        this.title = title;
        this.description = description;
        this.date = date;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Intitulé" + title + "\n Description : " + description + "\n date:"+ date + "\n time:"+ duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }
}
