package cl.patrones.taller.u2.clientes;

import java.util.Optional;

public interface ClienteService {
	
	public Optional<Cliente> getClientePorEmail(String email);
	public void guardar(Cliente cliente);
}
