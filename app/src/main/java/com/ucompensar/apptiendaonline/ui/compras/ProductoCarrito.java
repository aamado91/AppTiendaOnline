package com.ucompensar.apptiendaonline.ui.compras;

import com.ucompensar.apptiendaonline.entities.Product;

public class ProductoCarrito {

    public Product producto;
    public int cantidad;
    public int totalProducto;

    public ProductoCarrito(Product producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.totalProducto = Integer.parseInt(producto.getValor()) * cantidad;
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotalProducto() {
        return totalProducto;
    }
}
