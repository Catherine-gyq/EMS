package com.frankzhu.ems.mapper;

import com.frankzhu.ems.model.Open;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OpenMapper {

    // 模糊查询开课表
    @Select("select o.id, c.no as cid, c.name as cname, c.credit, t.name as tname, te.name as tename, o.time, o.location" +
            " from open as o join teacher as t join term as te join course as c on o.course=c.no and o.teacher=t.no and" +
            " o.term=te.no where c.no like concat('%',#{no},'%') and c.name like concat('%',#{name},'%')")
    List<Map<String, Object>> findAllOpen(@Param("no") String no, @Param("name") String name);

    // 按学期查询开课情况,多种搜索条件
    @Select("select o.id, c.no as cid, c.name as cname, c.credit, t.name as tname, o.time, o.location, o.studentNumber " +
            "from open as o join teacher as t join term as te join course as c on o.course=c.no and o.teacher=t.no " +
            "and o.term=te.no where te.no like concat('%',#{term},'%') and t.no like concat('%',#{tno},'%') " +
            "and t.name like concat('%',#{tname},'%') and c.no like concat('%',#{cno},'%') " +
            "and c.name like concat('%',#{cname},'%');")
    List<Map<String, Object>> findAllOpenByMu(
            @Param("term") String term,
            @Param("tno") String tno,
            @Param("tname") String tname,
            @Param("cno") String cno,
            @Param("cname") String cname
    );

    // 添加开课记录
    @Insert("insert into open(course, teacher, term, time, location) values" +
            "(#{course}, #{teacher}, #{term}, #{time}, #{location})")
    Integer insertOpen(Open open);

    // 更新选课状态
    @Update("update open set choice=#{choice} where term=#{term}")
    Integer updateOpen(@Param("term") String term, @Param("choice") boolean choice);

    // 删除开课记录
    @Delete("delete from open where id=#{id}")
    Integer deleteOpenByNo(@Param("id") int id);

}
