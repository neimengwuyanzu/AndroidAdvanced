package com.example.dbdemo.bean;

import java.util.List;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/6
 */
public class User {

    private int id;
    private String name;
    private List<Address> addresses;

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
