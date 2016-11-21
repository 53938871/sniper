package com.bangduoduo.monkey.model.mapper;

import com.bangduoduo.monkey.model.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from User where id= #{id}")
    public User getUserById(@Param("id")long id);
}
