package cl.patrones.taller.u2.tienda.menu;

import java.util.Collections;
import java.util.List;

public class EnlaceItemMenu implements ItemMenu {

    private String texto;
    private String enlace;
    private String slug;

    public EnlaceItemMenu(String texto, String enlace, String slug) {
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
        return false;
    }

    @Override
    public List<ItemMenu> getHijos() {
        return Collections.emptyList();
    }
}
