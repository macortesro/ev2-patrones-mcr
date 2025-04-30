package cl.patrones.taller.u2.bodegaje.service;

import java.util.List;
import java.util.Optional;

import cl.patrones.taller.u2.bodegaje.domain.Producto;

public interface BodegajeService {
	
	public List<Producto> getProductos();

	public List<Producto> getProductosBySku(String... skus);
	
	public Optional<Producto> getProductoBySku(String sku);

}
