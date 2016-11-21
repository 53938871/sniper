package com.bangduoduo.orm;

import com.bangduoduo.orm.annotation.Column;

public class BaseEntity {
    @Column("id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toJson() {
        return null;
    }

    //todo
    public String toXml() {
        return null;
    }
}
