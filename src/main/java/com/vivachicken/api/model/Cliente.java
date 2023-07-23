package com.vivachicken.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String telefono;
	private String direccion;
	private String dni;
	private String ruc;
	private Boolean estado;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Orden> ordenes = new HashSet<>();;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id, String nombre, String apellido, String email, String password, String telefono,
			String direccion, String dni, String ruc, Boolean estado, Set<Orden> ordenes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
		this.dni = dni;
		this.ruc = ruc;
		this.estado = estado;
		this.ordenes = ordenes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Set<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(Set<Orden> ordenes) {
		this.ordenes = ordenes;
		for(Orden orden : ordenes) {
			orden.setCliente(this);
		}
	}
	
}
