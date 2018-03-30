package com.tsingyun.model;

import java.io.Serializable;

/**
 * Created by chen on 17/8/18.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Person() {

    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
