package cl.patrones.taller.u2.tienda.menu;

import java.util.ArrayList;
import java.util.List;

public class CategoriaItemMenu implements ItemMenu {

    private String texto;
    private String enlace;
    private String slug;
    private List<ItemMenu> hijos = new ArrayList<>();

    public CategoriaItemMenu(String texto, String enlace, String slug) {
        this.texto = texto;
        this.enlace = enlace;
        this.slug = slug;
    }

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public String getEnlace() {
        return enlace;
    }

    @Override
    public String getSlug() {
        return slug;
    }

    @Override
    public boolean tieneHijos() {
        return !hijos.isEmpty();
    }

    @Override
    public List<ItemMenu> getHijos() {
        return hijos;
    }

    public void agregarHijo(ItemMenu hijo) {
        hijos.add(hijo);
    }
}
