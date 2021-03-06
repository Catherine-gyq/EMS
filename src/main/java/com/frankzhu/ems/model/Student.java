package com.frankzhu.ems.model;

public class Student {

    private String no;
    private String name;
    private String sex;
    private String birthday;
    private String department;

    public Student(String no, String name, String sex, String birthday, String department){
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday == null ? null : birthday.trim();
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department == null ? null : department.trim();
    }

}
