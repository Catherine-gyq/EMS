package com.frankzhu.ems.model;

public class Elective {

    private Integer id;
    private Integer grade;
    private String studentNo;
    private String courseNo;

    public Elective(Integer id, Integer grade, String studentNo, String courseNo){
        this.id = id;
        this.grade = grade;
        this.studentNo = studentNo;
        this.courseNo = courseNo;
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
    public String getStudentNo() {
        return studentNo;
    }
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }
    public String getCourseNo() {
        return courseNo;
    }
    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
    }

}
