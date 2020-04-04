package com.steven.ssm.dao;

import com.steven.ssm.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface UserMapper {

    @Results(value={
            @Result(property = "userId",column = "user_id",id = true),
            @Result(property = "userName",column = "user_name")
    })
    @Select("select * from t_user")
    List<User> selectAll();

    // 通过xml进行配置
    List<User> selectAllXml();

    int updateUsername(@Param("id") String id, @Param("name")String name);
}