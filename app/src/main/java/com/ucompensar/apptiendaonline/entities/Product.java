package com.ucompensar.apptiendaonline.entities;

import android.database.Cursor;

public class Product {
    private long id;
    private String name;
    private String price;
    private String state;
    private int image;

    public  Product(){
    }

    public Product(long id, String nombre, String valor, String estado, int imagenId) {
        this.id = id;
        this.name = nombre;
        this.price = valor;
        this.state = estado;
        this.image = imagenId;
    }

    public Product(Cursor item) {
        this.id = item.getLong(0);
        this.name = item.getString(1);
        this.price = item.getString(2);
        this.state = item.getString(3);
        this.image = item.getInt(4);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
