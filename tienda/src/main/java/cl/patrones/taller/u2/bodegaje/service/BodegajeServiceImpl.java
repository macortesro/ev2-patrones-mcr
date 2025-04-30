package cl.patrones.taller.u2.bodegaje.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.repository.ProductoRepository;

@Service
public class BodegajeServiceImpl implements BodegajeService {
	
	private ProductoRepository productoRepository;
		
	public BodegajeServiceImpl(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	public List<Producto> getProductos() {
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> getProductosBySku(String... skus) {
		return productoRepository.findBySkuIn(List.of(skus));
	}

	@Override
	public Optional<Producto> getProductoBySku(String sku) {
		return productoRepository.findBySku(sku);
	}
	
}
