package cl.patrones.taller.u2.tienda.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.patrones.taller.u2.bodegaje.service.BodegajeService;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.catalogo.repository.ClasificacionRepository;
import cl.patrones.taller.u2.tienda.adapter.ProductoAdapter;

@Controller
public class TiendaController {

    private final BodegajeService bodegajeService;
    private final ClasificacionRepository clasificacionRepository;
    private final CategoriaService categoriaService;

    public TiendaController(BodegajeService bodegajeService, ClasificacionRepository clasificacionRepository, CategoriaService categoriaService) {
        this.bodegajeService = bodegajeService;
        this.clasificacionRepository = clasificacionRepository;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        var productos = bodegajeService.getProductos();

        List<Aviso> avisos = productos.stream()
            .map(producto -> new ProductoAdapter(producto, clasificacionRepository, bodegajeService))
            .map(ProductoAdapter::toAviso)
            .collect(Collectors.toList());

        model.addAttribute("avisos", avisos);

        return "inicio";
    }

    @GetMapping("/categoria/{categoriaId}/{slug}")
    public String categoria(@PathVariable(name = "categoriaId") Long categoriaId,
                             @PathVariable(name = "slug") String slug,
                             Model model) {

        var productos = bodegajeService.getProductos();

        List<Aviso> avisos = productos.stream()
            .map(producto -> new ProductoAdapter(producto, clasificacionRepository, bodegajeService))
            .filter(adapter -> adapter.getCategoria()
                .map(categoria -> categoria.getId().equals(categoriaId))
                .orElse(false))
            .map(ProductoAdapter::toAviso)
            .collect(Collectors.toList());

        model.addAttribute("avisos", avisos);

        Optional<String> categoriaNombre = categoriaService.getCategoriaPorId(categoriaId)
            .map(categoria -> categoria.getNombre());

        categoriaNombre.ifPresent(nombre -> model.addAttribute("categoria", nombre));

        return "categoria";
    }

    @GetMapping("/ingresar")
    public String login() {
        return "login";
    }

    @GetMapping("/ubicacion")
    public String ubicacion() {
        return "ubicacion";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }
}
