package com.czy.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by jacky on 2017/7/17.
 */
public class Goods {

    @JSONField(label = "id")
    private int id;

    @JSONField(label = "name")
    private String name;

    @JSONField(label = "price")
    private float price;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
