package com.bangduoduo.monkey.repository;

import com.bangduoduo.monkey.model.ShortLink;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

/**
 * Created by cpeng2 on 11/21/2016.
 */
@Mapper
public interface ShortLinkMapper {
    @Select("SELECT * FROM SHORT_LINK WHERE ID = #{id}")
    ShortLink findById(@Param("name") Long id);

    @Results({
        @Result(property = "shortUrl", column = "SHORT_LINK"),
        @Result(property = "originalUrl", column = "ORIGINAL_URL")
    })
    @Select("SELECT * FROM SHORT_LINK WHERE SHORT_URL = #{shortUrl}")
    ShortLink findByShortUri(@Param("shortUrl") String shortUrl);

    @Insert("INSERT INTO SHORT_LINK(ORIGINAL_URL, SHORT_URL) VALUES(#{originalUrl}, #{shortUrl})")
    int createShortLink(ShortLink shortLink);

    /*
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    @Insert("INSERT INTO user(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);
    */
}
