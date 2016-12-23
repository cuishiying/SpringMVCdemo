package com.irelint.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vincent on 2016-12-23.
 */
@Entity
@Table
public class Remark implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String info;
}
