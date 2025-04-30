package cl.patrones.taller.u2.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaRepository repository;
	
	public CategoriaServiceImpl(CategoriaRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<Categoria> getCategorias() {
		return repository.findAll();
	}

	@Override
	public Optional<Categoria> getCategoriaPorId(Long id) {
		return repository.findById(id);
	}
	
}
