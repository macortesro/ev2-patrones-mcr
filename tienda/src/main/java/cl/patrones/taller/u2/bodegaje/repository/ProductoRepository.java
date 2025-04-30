package cl.patrones.taller.u2.bodegaje.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import cl.patrones.taller.u2.bodegaje.domain.Producto;

public interface ProductoRepository extends ListCrudRepository<Producto, Long> {

	Optional<Producto> findBySku(String sku);
	
	List<Producto> findBySkuIn(Collection<String> skus);
	
}
