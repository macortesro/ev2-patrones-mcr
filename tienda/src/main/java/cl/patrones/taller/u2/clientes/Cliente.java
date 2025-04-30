package cl.patrones.taller.u2.clientes;

public class Cliente {

	private Long id;
	private String email;
	private String contrasena;
	private String nombre;
	private String direccion;
	private String comuna;
	
	public Cliente() {
		super();
	}
	public Cliente(String email, String nombre, String direccion, String comuna) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.direccion = direccion;
		this.comuna = comuna;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	
		
}
