package com.ucompensar.apptiendaonline.entities;

import android.database.Cursor;

public class Customer {
    private Long Id;
    private String Name;
    private String Email;
    private String Phone;
    private String Password;

    public Customer() {
    }

    public Customer(Cursor item) {
        setId(item.getLong(0));
        setName(item.getString(1));
        setEmail(item.getString(2));
        setPhone(item.getString(3));
        setPassword(item.getString(4));
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
