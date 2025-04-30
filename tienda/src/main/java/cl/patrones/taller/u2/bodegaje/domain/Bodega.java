package cl.patrones.taller.u2.bodegaje.domain;

import java.util.List;

public class Bodega {

	private Long id;
	private String nombre;
	private String direccion;
	private List<Stock> inventario;
	
	public Bodega() {
		super();
	}
	public Bodega(String nombre, String direccion) {
		super();		
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Stock> getInventario() {
		return inventario;
	}
	public void setInventario(List<Stock> inventario) {
		this.inventario = inventario;
	}
	@Override
	public String toString() {
		return "Bodega [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
}
