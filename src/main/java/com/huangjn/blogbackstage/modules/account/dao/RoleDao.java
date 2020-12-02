package com.huangjn.blogbackstage.modules.account.dao;

import com.huangjn.blogbackstage.modules.account.pojo.Role;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleDao {

    @Select("<script>"+
            "select rid,roleName from role" +
            "<where> " +
            "<if test='keyWord != \"\" and keyWord != null'>" +
            " and (roleName like '%${keyWord}%') " +
            "</if>" +
            "</where>" +
            "<choose>" +
            "<when test='orderBy != \"\" and orderBy != null'>" +
            " order by ${orderBy} ${sort}" +
            "</when>" +
            "<otherwise>" +
            " order by rid desc" +
            "</otherwise>" +
            "</choose>"+
            "</script>"
    )
    List<Role> findAllRoles(SearchVo searchVo);


    @Select("select rid,roleName from role")
    List<Role> getRoles();

    @Insert("insert into role(roleName) values(#{roleName}) ")
    void insertRole(String roleName);


    @Delete("delete from role where rid=#{rid}")
    void deleteRoleById(int rid);

    @Select("select rid,roleName from role where rid=#{rid}")
    Role findRoleByRid(int rid);
}
