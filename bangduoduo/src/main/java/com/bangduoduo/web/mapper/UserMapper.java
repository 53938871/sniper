package com.bangduoduo.web.mapper;

import com.bangduoduo.web.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from User where id= #{id}")
    public User getUserById(@Param("id")long id);
}
