package cl.patrones.taller.u2.clientes;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

public interface ClienteRepository extends ListCrudRepository<Cliente, Long> {
	public Optional<Cliente> findByEmail(String email);
}
