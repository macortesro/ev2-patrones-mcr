package cl.patrones.taller.u2.tienda.adapter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.ClasificacionRepository;
import cl.patrones.taller.u2.bodegaje.service.BodegajeService;

public class ProductoAdapter {

    private Producto producto;
    private ClasificacionRepository clasificacionRepository;
    private BodegajeService bodegajeService;

    public ProductoAdapter(Producto producto, ClasificacionRepository clasificacionRepository, BodegajeService bodegajeService) {
        this.producto = producto;
        this.clasificacionRepository = clasificacionRepository;
        this.bodegajeService = bodegajeService;
    }

    public Aviso toAviso() {
        Aviso aviso = new Aviso();

        aviso.setId(producto.getId());
        aviso.setSku(producto.getSku());
        aviso.setTitulo(producto.getNombre());
        aviso.setImagen(producto.getImagen());
        aviso.setPrecio(calcularPrecioConUtilidad(producto.getCosto()));
        aviso.setStock(obtenerStockTotal(producto.getSku()));

        return aviso;
    }

    public Optional<Categoria> getCategoria() {
        return clasificacionRepository.findFirstBySku(producto.getSku()).map(clasificacion -> clasificacion.getCategoria());
    }

    private Long calcularPrecioConUtilidad(Long costo) {
        BigDecimal costoBD = new BigDecimal(costo);
        BigDecimal precio = costoBD.multiply(new BigDecimal("1.3"));
    
        // Redondear normalmente (HALF_UP) a 0 decimales
        return precio.setScale(0, RoundingMode.HALF_UP).longValue();
    }

    private int obtenerStockTotal(String sku) {
        return bodegajeService.getProductoBySku(sku)
            .map(producto -> producto.getStocks().stream()
                .mapToInt(stock -> stock.getCantidad())
                .sum())
            .orElse(0);
    }
    
}
