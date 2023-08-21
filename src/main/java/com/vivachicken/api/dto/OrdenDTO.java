package com.vivachicken.api.dto;

import com.vivachicken.api.model.Cliente;
import com.vivachicken.api.model.DetalleOrden;

import java.util.List;

public class OrdenDTO {

    private Cliente cliente;
    private List<DetalleOrden> detalles;

    public OrdenDTO() {
    }

    public OrdenDTO(Cliente cliente, List<DetalleOrden> detalles) {
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleOrden> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleOrden> detalles) {
        this.detalles = detalles;
    }
}
