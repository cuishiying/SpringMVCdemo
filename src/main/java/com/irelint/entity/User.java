package com.irelint.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vincent on 2016-12-23.
 */
@Entity
@Table
public class User implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //必须
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String name;
    private String sex;

    @ManyToOne(cascade = CascadeType.ALL)
    private Remark remark;

    public Remark getRemark() {
        return remark;
    }

    public void setRemark(Remark others) {
        this.remark = others;
    }
}
