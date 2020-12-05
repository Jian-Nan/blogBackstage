package com.huangjn.blogbackstage.modules.account.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PermissionRoleDao {

    @Insert("insert into role_permission(rid,pid) values(#{rid},#{pid})")
    void insertPermissionRole(int pid, int rid);

    @Delete("delete from role_permission where pid=#{pid}")
    void deletePermissionById(int pid);
}
