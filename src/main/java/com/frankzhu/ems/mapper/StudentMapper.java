package com.frankzhu.ems.mapper;

import com.frankzhu.ems.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    // search all
    @Select("select * from student")
    List<Student> findAllStudent();

    // search one
    @Select("select * from student where no = #{no}")
    Student findStudentByNo(@Param("no") String no);

    // add
    @Insert("insert into student (no, name, sex, age, department, loginname, password) VALUES" +
            "(#{no}, #{name}, #{sex}, #{age}, #{department}, #{loginname}, #{password})")
    Integer insertStudent(Student student);

    // update
    @Update("update student set name=#{name}, sex=#{sex}, age=#{age}, department=#{department}," +
            "loginname=#{loginname}, password=#{password} where no=#{no}")
    Integer updateStudent(Student student);

    // delete
    @Delete("delete from student where no=#{no}")
    Integer deleteStudentByNo(@Param("no") String no);

}
