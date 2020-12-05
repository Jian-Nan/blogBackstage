package com.huangjn.blogbackstage.modules.account.dao;

import com.huangjn.blogbackstage.modules.account.pojo.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PermissionRoleDao {

    @Insert("insert into role_permission(rid,pid) values(#{rid},#{pid})")
    void insertPermissionRole(int pid, int rid);

    @Delete("delete from role_permission where pid=#{pid}")
    void deletePermissionById(int pid);

    @Select("select role_permission.rid,roleName from role inner join role_permission on role.rid=role_permission.rid where role_permission.pid=#{pid}")
    List<Role> findPermissRoleionByPid(int pid);
}
