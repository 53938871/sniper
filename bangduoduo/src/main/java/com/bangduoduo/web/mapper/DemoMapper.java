package com.bangduoduo.web.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public interface DemoMapper {
    @Results({
            @Result(property = "vid", column = "id"),
            @Result(property = "villageName", column = "name"),
            @Result(property = "district", column = "district")
    })
    @Select("SELECT id, name, district from village WHERE id = #{id}")
    Village selectVillage(int id);

    @Insert("INSERT into village(name,district) VALUES(#{villageName}, #{district})")
    void insertVillage(Village village);

    @Update("UPDATE village SET name=#{villageName}, district =#{district} WHERE id =#{vid}")
    void updateVillage(Village village);

    @Delete("DELETE FROM village WHERE id =#{id}")
    void deleteVillage(int id);
}
class Village {
    private Integer vid;
    private String villageName;
    private String district;
    public Integer getVid() {
        return vid;
    }
    public void setVid(Integer vid) {
        this.vid = vid;
    }
    public String getVillageName() {
        return villageName;
    }
    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
}
