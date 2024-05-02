package com.ucompensar.apptiendaonline.ui.productos;

public class Producto {
    public String nombre;
    public String valor;
    public String estado;
    public int imagenId;

    public Producto(String nombre, String valor, String estado, int imagenId) {
        this.nombre = nombre;
        this.valor = valor;
        this.estado = estado;
        this.imagenId = imagenId;
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
