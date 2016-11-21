package com.bangduoduo.web.mapper;

import com.bangduoduo.web.domain.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface ArticleMapper {
    @Insert("INSERT into Article(title,icon,desc,content,category,priority,source,status)VALUES(#{title},#{icon},#{desc},#{content},#{category},#{priority},#{source},#{status})")
    void addArticle(Article article);

    @Delete("DELETE Article WHERE id = #{id}")
    void deleteArticle(Long id);
}
