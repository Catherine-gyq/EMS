package com.frankzhu.ems.mapper;

import com.frankzhu.ems.model.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseMapper {

    // 搜索课程,按课程名、课程号模糊查询
    @Select("select c.no, c.name as name, credit, d.name as department, d.no as departmentID " +
            "from course as c join department as d on c.department=d.no " +
            "where c.no like concat('%',#{no},'%') and c.name like concat('%',#{name},'%')")
    List<Map<String, Object>> findAllCourse(@Param("no") String no, @Param("name") String name);

    // 添加课程
    @Insert("insert into course (no, name, credit, department) VALUES" +
            "(#{no}, #{name}, #{credit}, #{department})")
    Integer insertCourse(Course course);

    // 更新课程
    @Update("update course set name=#{name}, credit=#{credit} where no=#{no}")
    Integer updateCourse(Course course);

    // 通过no删除课程
    @Delete("delete from course where no=#{no}")
    Integer deleteCourseByNo(@Param("no") String no);

}
