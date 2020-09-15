package com.huangjn.blogbackstage.modules.account.dao;

import com.huangjn.blogbackstage.modules.account.pojo.User;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    @Select("<script>"+
            "select uid,userName,password,school from user" +
            "<where> " +
            "<if test='keyWord != \"\" and keyWord != null'>" +
            " and (userName like '%${keyWord}%') " +
            "</if>" +
            "</where>" +
            "<choose>" +
            "<when test='orderBy != \"\" and orderBy != null'>" +
            " order by ${orderBy} ${sort}" +
            "</when>" +
            "<otherwise>" +
            " order by uid desc" +
            "</otherwise>" +
            "</choose>"+
            "</script>"
    )
    List<User> getUsersBySearchVo(SearchVo searchVo);


    @Delete("delete from user where uid=#{uid}")
    void deleteUserById(int uid);

}
