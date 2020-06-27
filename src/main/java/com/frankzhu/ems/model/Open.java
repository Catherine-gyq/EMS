package com.frankzhu.ems.model;

public class Open {

    private Integer id;
    private String course;
    private String teacher;
    private String term;
    private String time;
    private String location;

    public Open(Integer id, String course, String teacher, String term, String time, String location){
        this.id = id;
        this.course = course;
        this.teacher = teacher;
        this.term = term;
        this.time = time;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
