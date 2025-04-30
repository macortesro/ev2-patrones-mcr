package cl.patrones.taller.u2.tienda.adapter;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cl.patrones.taller.u2.clientes.Cliente;

public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 888480101808971843L;
	private Cliente cliente;

	public Usuario(Cliente cliente) {
		super();
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"));
	}

	@Override
	public String getPassword() {
		return cliente.getContrasena();
	}

	@Override
	public String getUsername() {
		return cliente.getEmail();
	}	
}
