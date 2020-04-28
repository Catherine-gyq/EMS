package com.frankzhu.ems.mapper;

import com.frankzhu.ems.model.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {

    // search all
    @Select("select * from course")
    List<Course> findAllCourse();

    // search one
    @Select("select * from course where no = #{no}")
    Course findCourseByNo(@Param("no") String no);

    // add
    @Insert("insert into course (no, name, redit, department, teacher) VALUES" +
            "(#{no}, #{name}, #{redit}, #{department}, #{teacher})")
    Integer insertCourse(Course course);

    // update
    @Update("update course set name=#{name}, redit=#{redit}, department=#{department}, " +
            "teacher=#{teacher} where no=#{no}")
    Integer updateCourse(Course course);

    // delete
    @Delete("delete from course where no=#{no}")
    Integer deleteCourseByNo(@Param("no") String no);

}
