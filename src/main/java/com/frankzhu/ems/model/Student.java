package com.frankzhu.ems.model;

public class Student {

    private String no;
    private String name;
    private String sex;
    private String age;
    private String department;
    private String loginName;
    private String password;

    public Student(
            String no, String name, String sex, String age, String department, String loginName, String password){
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.department = department;
        this.loginName = loginName;
        this.password = password;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age = age == null ? null : age.trim();
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department == null ? null : department.trim();
    }
    public String getLoginname(){
        return loginName;
    }
    public void setLoginname(String loginName){
        this.loginName = loginName == null ? null : loginName.trim();
    }

}
