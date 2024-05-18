package com.ucompensar.apptiendaonline.entities;

import android.database.Cursor;

public class Product {

    public long id;
    public String nombre;
    public String valor;
    public String estado;
    public int imagenId;

    public Product(long id, String nombre, String valor, String estado, int imagenId) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.estado = estado;
        this.imagenId = imagenId;
    }

    public Product(Cursor item) {
        this.id = item.getLong(0);
        this.nombre = item.getString(1);
        this.valor = item.getString(2);
        this.estado = item.getString(3);
        this.imagenId = item.getInt(4);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getImagen() {
        return imagenId;
    }

    public void setImagen(int imagenId) {
        this.imagenId = imagenId;
    }


}
