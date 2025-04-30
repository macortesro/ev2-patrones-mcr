package cl.patrones.taller.u2.catalogo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import cl.patrones.taller.u2.catalogo.domain.Clasificacion;

public interface ClasificacionRepository extends ListCrudRepository<Clasificacion, Long> {

	Optional<Clasificacion> findFirstBySku(String sku);
	List<Clasificacion> findByCategoriaId(Long id);
	
}
