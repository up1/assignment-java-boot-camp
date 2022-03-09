package com.example.week02.redis;


import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Mydata")
public class MyData implements Serializable {

    private int id;
    private String name;

    public MyData() {
    }

    public MyData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
