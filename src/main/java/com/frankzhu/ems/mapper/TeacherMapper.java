package com.frankzhu.ems.mapper;

import com.frankzhu.ems.model.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherMapper {

    // 模糊查询教师
    @Select("select t.no, t.name as name, t.sex, t.birthday, t.education, d.name as department, d.no as departmentID " +
            "from teacher as t join department as d on t.department=d.no " +
            "where t.no like concat('%',#{no},'%') and t.name like concat('%',#{name},'%');")
    List<Map<String, Object>> findAllTeacher(@Param("no") String no, @Param("name") String name);

    // 根据院系查询教师
    @Select("select no, name from teacher where department=#{de}")
    List<Map<String, Object>> findTeacherByDe(@Param("de") String de);

    // 添加教师
    @Insert("insert into teacher (no, name, sex, birthday, education, department) VALUES" +
            "(#{no}, #{name}, #{sex}, #{birthday}, #{education}, #{department})")
    Integer insertTeacher(Teacher teacher);

    // 更新信息
    @Update("update teacher set name=#{name}, sex=#{sex}, birthday=#{birthday}, " +
            "department=#{department}, education=#{education} where no=#{no}")
    Integer updateTeacher(Teacher teacher);

    // 删除教师
    @Delete("delete from teacher where no=#{no}")
    Integer deleteTeacherByNo(@Param("no") String no);

}
