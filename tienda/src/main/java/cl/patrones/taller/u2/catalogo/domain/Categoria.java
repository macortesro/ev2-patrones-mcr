package cl.patrones.taller.u2.catalogo.domain;

public class Categoria {

	private Long id;
	private String nombre;
	private Categoria padre;
		
	public Categoria(String nombre, Categoria padre) {
		super();
		this.nombre = nombre;
		this.padre = padre;
	}
	public Categoria() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getPadre() {
		return padre;
	}
	public void setPadre(Categoria padre) {
		this.padre = padre;
	}
		
}
