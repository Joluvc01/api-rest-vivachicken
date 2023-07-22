package com.vivachicken.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordenes")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fecha;
	private double subtotal;
	private double igv;
	private double totalFinal;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToOne(mappedBy = "orden")
	private DetalleOrden detalle;
 
	public Orden() {
		// TODO Auto-generated constructor stub
	}

	public Orden(Integer id, Date fecha, double subtotal, double igv, double totalFinal, Cliente cliente,
			DetalleOrden detalle) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.igv = igv;
		this.totalFinal = totalFinal;
		this.cliente = cliente;
		this.detalle = detalle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotalFinal() {
		return totalFinal;
	}

	public void setTotalFinal(double totalFinal) {
		this.totalFinal = totalFinal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DetalleOrden getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleOrden detalle) {
		this.detalle = detalle;
	}
	
}
