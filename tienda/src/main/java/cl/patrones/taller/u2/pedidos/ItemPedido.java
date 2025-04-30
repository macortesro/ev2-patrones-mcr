package cl.patrones.taller.u2.pedidos;

import java.util.Objects;

import cl.patrones.taller.u2.bodegaje.domain.Producto;

public class ItemPedido {

	private int cantidad;
	private Producto producto;
	private Long precio;
		
	public ItemPedido() {
		super();
	}
	public ItemPedido(int cantidad, Producto producto, Long precio) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.precio = precio;
	}
	public Long subtotal() {
		return precio * cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(producto.getSku());
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return producto.getSku() == other.getProducto().getSku();
	}
	
	
}
