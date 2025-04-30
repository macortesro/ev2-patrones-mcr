package cl.patrones.taller.u2.catalogo.repository;

import org.springframework.data.repository.ListCrudRepository;

import cl.patrones.taller.u2.catalogo.domain.Categoria;

public interface CategoriaRepository extends ListCrudRepository<Categoria, Long> {

}
