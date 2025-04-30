package cl.patrones.taller.u2.catalogo.domain;

public class Clasificacion {

	private Long id;
	private String sku;
	private Categoria categoria;
	
	public Clasificacion() {
		super();
	}
	public Clasificacion(String sku, Categoria categoria) {
		super();
		this.sku = sku;
		this.categoria = categoria;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}		
}
