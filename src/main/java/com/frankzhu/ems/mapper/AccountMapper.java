package com.frankzhu.ems.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AccountMapper {

    // 搜索用户密码是否匹配
    @Select("select * from account where no=#{no} and password=#{pwd} and identity=#{ident}")
    Map<String, Object> findAccount(@Param("no") String no, @Param("pwd") String pwd, @Param("ident") String ident);

    // 重置密码
    @Update("update account set password=#{pwd} where no=#{no} and identity=#{ident}")
    Integer updateAccount(@Param("no") String no, @Param("pwd") String pwd, @Param("ident") String ident);

    // 新增账号
    @Insert("insert into account(no, password, identity) VALUES (#{no}, #{pwd}, #{ident})")
    Integer addAccount(@Param("no") String no, @Param("pwd") String pwd, @Param("ident") String ident);

}
