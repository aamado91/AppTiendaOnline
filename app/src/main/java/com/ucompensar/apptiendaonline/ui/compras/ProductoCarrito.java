package com.ucompensar.apptiendaonline.ui.compras;

import com.ucompensar.apptiendaonline.ui.productos.Producto;

public class ProductoCarrito {

    public Producto producto;
    public int cantidad;
    public int totalProducto;

    public ProductoCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.totalProducto = Integer.parseInt(producto.getValor()) * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
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
