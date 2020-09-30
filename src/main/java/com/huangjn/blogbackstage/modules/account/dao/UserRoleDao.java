package com.huangjn.blogbackstage.modules.account.dao;

import com.huangjn.blogbackstage.modules.account.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserRoleDao {
    @Delete("delete from user_role where uid=#{uid}")
    void deleteByUid(int uid);

    @Insert("insert into user_role(uid,rid) values(#{uid},#{rid})")
    void insertUserRole(int uid,int rid);

    @Select("select user_role.rid,roleName from role inner join user_role on role.rid=user_role.rid where user_role.uid=#{uid}")
    List<Role> findRoleByUid(int uid);
}
