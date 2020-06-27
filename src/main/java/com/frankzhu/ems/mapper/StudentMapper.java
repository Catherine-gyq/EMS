package com.frankzhu.ems.mapper;

import com.frankzhu.ems.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentMapper {

    // 模糊查询学生
    @Select("select s.no, s.name as name, s.sex, s.birthday, d.name as department, d.no as departmentID " +
            "from student as s join department as d on s.department=d.no " +
            "where s.no like concat('%',#{no},'%') and s.name like concat('%',#{name},'%')")
    List<Map<String, Object>> findAllStudent(@Param("no") String no, @Param("name") String name);

    // 添加学生
    @Insert("insert into student (no, name, sex, birthday, department) VALUES" +
            "(#{no}, #{name}, #{sex}, #{birthday}, #{department})")
    Integer insertStudent(Student student);

    // 更新信息
    @Update("update student set name=#{name}, sex=#{sex}, birthday=#{birthday}, department=#{department} where no=#{no}")
    Integer updateStudent(Student student);

    // 删除学生
    @Delete("delete from student where no=#{no}")
    Integer deleteStudentByNo(@Param("no") String no);

}
