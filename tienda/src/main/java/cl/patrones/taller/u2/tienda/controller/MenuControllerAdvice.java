package cl.patrones.taller.u2.tienda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.patrones.taller.u2.tienda.menu.CategoriaItemMenu;
import cl.patrones.taller.u2.tienda.menu.EnlaceItemMenu;
import cl.patrones.taller.u2.tienda.menu.ItemMenu;
import cl.patrones.taller.u2.tienda.menu.util.Slugger;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.catalogo.domain.Categoria;

@ControllerAdvice
public class MenuControllerAdvice {

    private CategoriaService categoriaService;

    public MenuControllerAdvice(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @ModelAttribute("menu")
    public List<ItemMenu> menu() {
        List<ItemMenu> menu = new ArrayList<>();

        // 1. Agregar enlaces fijos
        menu.add(new EnlaceItemMenu("Inicio", "/", ""));

		// 2. Crear el nodo de Categorías
        CategoriaItemMenu categoriasMenu = new CategoriaItemMenu("Categorías", "/categoria", "");

        // 3. Cargar todas las categorías
        List<Categoria> categorias = categoriaService.getCategorias();

        // 4. Separar categorías padre y subcategorías
        List<Categoria> categoriasPadre = new ArrayList<>();
        List<Categoria> subcategorias = new ArrayList<>();

        for (Categoria cat : categorias) {
            if (cat.getPadre() == null) {
                categoriasPadre.add(cat);
            } else {
                subcategorias.add(cat);
            }
        }

        // 5. Construir el menú
        for (Categoria catPadre : categoriasPadre) {
            CategoriaItemMenu categoriaMenu = new CategoriaItemMenu(
                catPadre.getNombre(),
                "/categoria/" + catPadre.getId() + "/" + Slugger.toSlug(catPadre.getNombre()),
                Slugger.toSlug(catPadre.getNombre())
            );

            for (Categoria subcat : subcategorias) {
                if (subcat.getPadre() != null && subcat.getPadre().getId().equals(catPadre.getId())) {
                    categoriaMenu.agregarHijo(
                        new EnlaceItemMenu(
                            subcat.getNombre(),
                            "/categoria/" + subcat.getId() + "/" + Slugger.toSlug(subcat.getNombre()),
                            Slugger.toSlug(subcat.getNombre())
                        )
                    );
                }
            }

            categoriasMenu.agregarHijo(categoriaMenu);
        }

        // 6. Agregar el menú de Categorías al menú principal
        menu.add(categoriasMenu);

        menu.add(new EnlaceItemMenu("Ubicación", "/ubicacion", ""));
        menu.add(new EnlaceItemMenu("Contacto", "/contacto", ""));

        
        return menu;
    }
}
