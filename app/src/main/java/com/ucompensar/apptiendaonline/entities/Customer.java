package com.ucompensar.apptiendaonline.entities;

import android.database.Cursor;

public class Customer {
    private Long id;
    private String name;
    private int gender;
    private String email;
    private String phone;
    private String password;

    public Customer() {
    }

    public Customer(Cursor item) {
        setId(item.getLong(0));
        setName(item.getString(1));
        //setGender(item.getInt(2));
        setEmail(item.getString(2));
        setPhone(item.getString(3));
        setPassword(item.getString(4));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
