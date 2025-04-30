package cl.patrones.taller.u2.tienda.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.clientes.ClienteService;
import cl.patrones.taller.u2.tienda.adapter.Usuario;

@Service
public class AuthService implements UserDetailsService {

	private ClienteService clienteService;
		
	public AuthService(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var clienteOp = clienteService.getClientePorEmail(username);
		if( clienteOp.isPresent() ) {
			return new Usuario(clienteOp.get());
		}
		throw new UsernameNotFoundException( String.format("Usuario %s no encontrado!!1", username) );
	}

}
