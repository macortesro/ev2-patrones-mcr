package cl.patrones.taller.u2.bodegaje.domain;

import java.util.ArrayList;
import java.util.List;

public class Producto {

	private Long id;
	private String sku;
	private String nombre;
	private String imagen;
	private Long costo;	  
	private List<Stock> stocks = new ArrayList<>();
	
	public Producto(String sku, String nombre, Long costo, String imagen) {
		super();
		this.sku = sku;
		this.nombre = nombre;
		this.costo = costo;
		this.imagen = imagen;
	}
	public Producto() {
		super();
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
	public Long getCosto() {
		return costo;
	}
	public void setCosto(Long costo) {
		this.costo = costo;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", stocks=" + stocks.stream().mapToInt(Stock::getCantidad).sum() + "]";
	}

	
}
