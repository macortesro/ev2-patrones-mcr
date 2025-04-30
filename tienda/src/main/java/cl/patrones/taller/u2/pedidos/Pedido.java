package cl.patrones.taller.u2.pedidos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.clientes.Cliente;

public class Pedido {

	protected Cliente cliente;
	protected final Set<ItemPedido> items = new HashSet<>();
	protected LocalDateTime fecha;
	
	public Pedido() {
		super();
	}
	
	public Long total() {		
		return items.stream().map(item -> item.subtotal()).reduce(0L, Long::sum);
	}
	
	public void agregarItem(Producto producto, int cantidad, Long precio) {
		items.add( new ItemPedido(cantidad, producto, precio) );
	}
	
	public void quitarItem(Producto producto) {
		quitarItem(producto.getSku());
	}
	
	public void quitarItem(String sku) {
		items.removeIf(i -> i.getProducto().getSku().equals(sku));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ItemPedido> getItems() {
		return items;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}	
}
