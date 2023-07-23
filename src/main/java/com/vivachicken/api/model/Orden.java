package com.vivachicken.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "ordenes")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, updatable = false)
	@CreatedDate
	private Date fecha;
	private double subtotal;
	private double igv;
	private double totalFinal;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
	private Set<DetalleOrden> detalles = new HashSet<>();
 
	public Orden() {
		// TODO Auto-generated constructor stub
	}

	public Orden(Integer id, Date fecha, double subtotal, double igv, double totalFinal, Cliente cliente,
			Set<DetalleOrden> detalles) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.igv = igv;
		this.totalFinal = totalFinal;
		this.cliente = cliente;
		this.detalles = detalles;
	}

	public Set<DetalleOrden> getDetalles() {
		return detalles;
	}


	public void setDetalles(Set<DetalleOrden> detalles) {
		this.detalles = detalles;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

}
