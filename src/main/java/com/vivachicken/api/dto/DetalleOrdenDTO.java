package com.vivachicken.api.dto;

import com.vivachicken.api.model.Producto;

public class DetalleOrdenDTO {
    private Producto producto;
    private int cantidad;

    public DetalleOrdenDTO() {
    }

    public DetalleOrdenDTO(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
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
}
