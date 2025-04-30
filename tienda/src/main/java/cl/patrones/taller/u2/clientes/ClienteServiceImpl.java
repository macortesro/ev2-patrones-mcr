package cl.patrones.taller.u2.clientes;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository repository;
	
	public ClienteServiceImpl(ClienteRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Optional<Cliente> getClientePorEmail(String email) {
		return repository.findByEmail(email);
		
	}

	@Override
	public void guardar(Cliente cliente) {
		repository.save(cliente);		
	}

}
