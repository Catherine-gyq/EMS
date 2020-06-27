package com.frankzhu.ems.model;

public class Course {

    private String no;         // 课程号
    private String name;       // 课程名
    private Integer credit;    // 学分
    private String department; // 开课院系号

    public Course(String no, String name, Integer credit, String department){
        this.no = no;
        this.name = name;
        this.credit = credit;
        this.department = department;
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
    public Integer getCredit() {
        return credit;
    }
    public void setCredit(Integer credit) {
        this.credit = credit;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department == null ? null : department.trim();
    }

}