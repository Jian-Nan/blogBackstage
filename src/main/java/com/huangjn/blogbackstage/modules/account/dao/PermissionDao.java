package com.huangjn.blogbackstage.modules.account.dao;

import com.huangjn.blogbackstage.modules.account.pojo.Permission;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PermissionDao {

    @Select("<script>"+
            "select pid,permissionName ,permissionUrl,roleName from permission" +
            "<where> " +
            "<if test='keyWord != \"\" and keyWord != null'>" +
            " and (permissionName like '%${keyWord}%') or (permissionUrl like '%${keyWord}%') " +
            "</if>" +
            "</where>" +
            "<choose>" +
            "<when test='orderBy != \"\" and orderBy != null'>" +
            " order by ${orderBy} ${sort}" +
            "</when>" +
            "<otherwise>" +
            " order by pid desc" +
            "</otherwise>" +
            "</choose>"+
            "</script>"
    )
    List<Permission>  getPermissionBySearchVo(SearchVo searchVo);


    @Insert("insert into permission(permissionName,permissionUrl,roleName) values(#{permissionName},#{permissionUrl},#{roleName})")
    @Options(useGeneratedKeys = true, keyColumn = "pid", keyProperty = "pid")
    void insertPermission(Permission permission);


    @Delete("delete from permission where pid=#{pid}")
    void deletePermissionById(int pid);

    @Select("select pid,permissionName ,permissionUrl from permission where pid=#{pid}")
    Permission findPermissionByPid(int pid);

    @Update("update permission set roleName=#{roleName} where pid=#{pid}")
    void updatePermission(Permission permission);
}
