package com.frankzhu.ems.model;

public class Course {

    private String no;
    private String name;
    private Integer redit;
    private String department;
    private String teacher;

    public Course(String no, String name, Integer redit, String department, String teacher){
        this.no = no;
        this.name = name;
        this.redit = redit;
        this.department = department;
        this.teacher = teacher;
    }

    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public Integer getRedit() {
        return redit;
    }
    public void setRedit(Integer redit) {
        this.redit = redit;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department == null ? null : department.trim();
    }

}
