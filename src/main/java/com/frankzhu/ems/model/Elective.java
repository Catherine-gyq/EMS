package com.frankzhu.ems.model;

public class Elective {

    private Integer id;
    private Integer grade;
    private String student;
    private String open;

    public Elective(Integer id, Integer grade, String student, String open){
        this.id = id;
        this.grade = grade;
        this.student = student;
        this.open = open;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    public String getStudent() {
        return student;
    }
    public void setStudent(String student) {
        this.student = student == null ? null : student.trim();
    }
    public String getOpen() {
        return open;
    }
    public void setOpen(String open) {
        this.open = open == null ? null : open.trim();
    }

}
