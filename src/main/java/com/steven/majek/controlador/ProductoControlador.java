package com.steven.majek.controlador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.steven.majek.EnumEstado;
import com.steven.majek.bean.*;
import com.steven.majek.bean.resultBean.AllProducts;
import com.steven.majek.bean.resultBean.TopRating;
import com.steven.majek.bean.resultBean.TopUsers;
import com.steven.majek.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController()
public class ProductoControlador {

    private ActivoVendido activoVendidoActivo = new ActivoVendido();
    private ActivoVendido activoVendidoVendido = new ActivoVendido();
    private ActivoVendido activoVendidoRetirado = new ActivoVendido();

    private Producto producto = new Producto();
    private Producto productoSteven2;
    private Producto productoSami;

    private Usuario usuario = new Usuario();
    private Usuario usuarioSami;

    private Estado estadoNuevo = new Estado();
    private Estado estadosemiNuevo = new Estado();
    private Estado estadoUsado = new Estado();

    private Categoria categoriaMujer = new Categoria();
    private Categoria categoriaHombre = new Categoria();
    private Categoria categoriaNinos = new Categoria();
    private Categoria categoriaHogar = new Categoria();


    //activo
    private static final int ACTIVO = 1;
    private static final int VENDIDO = 2;
    private static final int RETIRADO = 3;

    //categoria
    private static final int MUJER = 4;
    private static final int HOMBRE = 5;
    private static final int NINOS = 6;
    private static final int HOGAR = 7;

    //estado
    private static final int NUEVO = 8;
    private static final int SEMINUEVO = 9;
    private static final int USADO = 10;


    @Autowired
    ActivoVendidoRepo activoVendidoRepo;

    @Autowired
    CategoriaRepo categoriaRepo;

    @Autowired
    EstadoRepo estadoRepo;

    @Autowired
    ProductoRepo productoRepo;

    @Autowired
    UsuarioRepo usuarioRepo;

    ObjectMapper objectMapper = new ObjectMapper();


//
//    @GetMapping("test")
//    public List<Producto> getP() {
//        List<Producto> productos = productoRepo.findAll();
//
//        return productos;
//    }
//    @GetMapping(value = "getProducts",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//    public String getProducts() {
//        /*try {
//            return new ResponseEntity<String>(Producto.toArrayJson(productoRepo.findAll()), HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//        }*/
//
//        ArrayList<AllProducts> productos = productoRepo.productosEnVenta();
//
//
//        return Producto.toArrayJson(productos);
//        //return null;
//
//    }
//
//    @GetMapping(value = "totalPrice",produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
//    public ResponseEntity<String> total() {
//        try {
//            return new ResponseEntity<String>(String.valueOf(productoRepo.total()), HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping(value = "addProducto")
    public String addProducto(@RequestBody Producto productoGuardar) {

        estadoNuevo.setId(NUEVO);
        estadoNuevo.setTipoEstado("Nuevo");

        estadosemiNuevo.setId(SEMINUEVO);
        estadosemiNuevo.setTipoEstado("Semi Nuevo");

        estadoUsado.setId(USADO);
        estadoUsado.setTipoEstado("Usado");

        categoriaMujer.setId(MUJER);
        categoriaMujer.setTipoCategoria("Mujer");

        categoriaHombre.setId(HOMBRE);
        categoriaHombre.setTipoCategoria("Hombre");

        categoriaNinos.setId(NINOS);
        categoriaNinos.setTipoCategoria("NIÑOS");

        categoriaHogar.setId(HOGAR);
        categoriaHogar.setTipoCategoria("Hogar");

        activoVendidoActivo.setId(ACTIVO);
        activoVendidoActivo.setForma("Activo");

        activoVendidoVendido.setId(VENDIDO);
        activoVendidoVendido.setForma("Vendido");

        activoVendidoRetirado.setId(RETIRADO);
        activoVendidoRetirado.setForma("Retirado");

        //para enviar
        List<AllProducts> productoList = new ArrayList();


        // para guardar
        if (productoGuardar.getEstado().getTipoEstado().equalsIgnoreCase("Nuevo")) {
            productoGuardar.setEstado(estadoNuevo);
        }else if (productoGuardar.getEstado().getTipoEstado().equalsIgnoreCase("Semi Nuevo")) {
            productoGuardar.setEstado(estadosemiNuevo);
        }else if (productoGuardar.getEstado().getTipoEstado().equalsIgnoreCase("Usado")) {
            productoGuardar.setEstado(estadoUsado);

        }

        if (productoGuardar.getCategoria().getTipoCategoria().equalsIgnoreCase("Mujer")) {
            productoGuardar.setCategoria(categoriaMujer);
        }else if (productoGuardar.getCategoria().getTipoCategoria().equalsIgnoreCase("Hombre")) {
            productoGuardar.setCategoria(categoriaHombre);
        }else if (productoGuardar.getCategoria().getTipoCategoria().equalsIgnoreCase("Niños")) {
            productoGuardar.setCategoria(categoriaNinos);
        }else if(productoGuardar.getCategoria().getTipoCategoria().equalsIgnoreCase("Hogar")) {
            productoGuardar.setCategoria(categoriaHogar);
        }

        productoGuardar.setActivoVendido(activoVendidoActivo);

        productoRepo.save(productoGuardar);

        List<AllProducts> allProducts = productoRepo.misArticulosEnVenta(productoGuardar.getVenderProducto().getId());

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(allProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;

        //return productoList;

    }

    @PostMapping("MisProductosActivos")
    public String MisProductosActivos(@RequestBody Usuario usuario) {

        List<AllProducts> allProducts = productoRepo.misArticulosEnVenta(usuario.getId());

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(allProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }


// list productos y list top users productos
    @PostMapping(value = "getProductos",produces = MimeTypeUtils.APPLICATION_JSON_VALUE,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public String getProductos (@RequestBody Usuario usuario) {

        // inicio all productos
        if (usuario.getNombreUsuario() == null) {
            long idUsuario = usuario.getId();

            List<AllProducts> allProducts = productoRepo.articulosEnVenta(idUsuario);

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String valor = null;
            try {
                valor = objectMapper.writeValueAsString(allProducts);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return valor;
            //topuser products
        }else{
            List<AllProducts> allProducts = productoRepo.articulosTopUsers(usuario.getId());
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String valor = null;
            try {
                valor = objectMapper.writeValueAsString(allProducts);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return valor;
        }


        //return Producto.toArrayJson(usuarioProductos);
    }

    @PostMapping(value = "compraProducto",produces = MimeTypeUtils.APPLICATION_JSON_VALUE,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public String comprarProducto (@RequestBody AllProducts allProducts) {

        Producto producto = new Producto();
        producto.setId(allProducts.getId_producto());
        producto.setCreated(allProducts.getFecha_producto());
        producto.setNombre(allProducts.getNombre_producto());
        producto.setIntercambio(allProducts.isIntercambio_producto());
        producto.setPrecio(allProducts.getPrecio_producto());
        producto.setDescripcion(allProducts.getDesc_producto());
        producto.setPuntos(allProducts.getPunto_producto());
        producto.setImagen(allProducts.getImagen_producto());


        Categoria categoria = categoriaRepo.findByTipoCategoria(allProducts.getCategoria());
        Estado estado = estadoRepo.findByTipoEstado(allProducts.getEstado());
        ActivoVendido activoVendido = activoVendidoRepo.findByForma("Vendido");
        Usuario usuarioVenta = usuarioRepo.findByNombreUsuario(allProducts.getNombreUsuarioVenta());
        Usuario usuarioCompra = usuarioRepo.findByNombreUsuario(allProducts.getNombreUsuarioCompra());

        producto.setCategoria(categoria);
        producto.setEstado(estado);
        producto.setActivoVendido(activoVendido);
        producto.setVenderProducto(usuarioVenta);
        producto.setCompraProducto(usuarioCompra);

        productoRepo.save(producto);

        List<AllProducts> lstProducts = productoRepo.productosComprados(usuario.getId());

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(lstProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

    @PostMapping("productosComprados")
    public String productosComprados(@RequestBody Usuario usuario) {

        List<AllProducts> lstProducts = productoRepo.productosComprados(usuario.getId());

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(lstProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

    @PostMapping("productosVendidos")
    public String productosVendidos(@RequestBody Usuario usuario) {

        List<AllProducts> lstProducts = productoRepo.productosVendidos(usuario.getId());

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(lstProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

    @PostMapping("productosRetirados")
    public String productosRetirados(@RequestBody Usuario usuario) {

        List<AllProducts> lstProducts = productoRepo.productosRetirados(usuario.getId());

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(lstProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

    @PostMapping("rate")
    public String rateProducto(@RequestBody AllProducts allProducts) {

        producto = new Producto();
        producto.setId(allProducts.getId_producto());
        producto.setCreated(allProducts.getFecha_producto());
        producto.setNombre(allProducts.getNombre_producto());
        producto.setIntercambio(allProducts.isIntercambio_producto());
        producto.setPrecio(allProducts.getPrecio_producto());
        producto.setDescripcion(allProducts.getDesc_producto());
        producto.setPuntos(allProducts.getPunto_producto());
        producto.setImagen(allProducts.getImagen_producto());


        Categoria categoria = categoriaRepo.findByTipoCategoria(allProducts.getCategoria());
        Estado estado = estadoRepo.findByTipoEstado(allProducts.getEstado());
        ActivoVendido activoVendido = activoVendidoRepo.findByForma("Vendido");
        Usuario usuarioVenta = usuarioRepo.findByNombreUsuario(allProducts.getNombreUsuarioVenta());
        Usuario usuarioCompra = usuarioRepo.findByNombreUsuario(allProducts.getNombreUsuarioCompra());

        producto.setCategoria(categoria);
        producto.setEstado(estado);
        producto.setActivoVendido(activoVendido);
        producto.setVenderProducto(usuarioVenta);
        producto.setCompraProducto(usuarioCompra);

        productoRepo.save(producto);



        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(producto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

    @PostMapping("activar")
    public String actovarProducto(@RequestBody AllProducts allProducts) {

        producto = new Producto();
        producto.setId(allProducts.getId_producto());
        producto.setCreated(allProducts.getFecha_producto());
        producto.setNombre(allProducts.getNombre_producto());
        producto.setIntercambio(allProducts.isIntercambio_producto());
        producto.setPrecio(allProducts.getPrecio_producto());
        producto.setDescripcion(allProducts.getDesc_producto());
        producto.setPuntos(allProducts.getPunto_producto());
        producto.setImagen(allProducts.getImagen_producto());


        Categoria categoria = categoriaRepo.findByTipoCategoria(allProducts.getCategoria());
        Estado estado = estadoRepo.findByTipoEstado(allProducts.getEstado());
        ActivoVendido activoVendido = activoVendidoRepo.findByForma("Activo");
        Usuario usuarioVenta = usuarioRepo.findByNombreUsuario(allProducts.getNombreUsuarioVenta());

        producto.setCategoria(categoria);
        producto.setEstado(estado);
        producto.setActivoVendido(activoVendido);
        producto.setVenderProducto(usuarioVenta);


        productoRepo.save(producto);



        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(producto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

    //retirar/eliminar
    @PostMapping("retirar")
    public String retirarProducto(@RequestBody AllProducts allProducts) {

        producto = new Producto();
        producto.setId(allProducts.getId_producto());
        producto.setCreated(allProducts.getFecha_producto());
        producto.setNombre(allProducts.getNombre_producto());
        producto.setIntercambio(allProducts.isIntercambio_producto());
        producto.setPrecio(allProducts.getPrecio_producto());
        producto.setDescripcion(allProducts.getDesc_producto());
        producto.setPuntos(allProducts.getPunto_producto());
        producto.setImagen(allProducts.getImagen_producto());


        Categoria categoria = categoriaRepo.findByTipoCategoria(allProducts.getCategoria());
        Estado estado = estadoRepo.findByTipoEstado(allProducts.getEstado());
        ActivoVendido activoVendido = activoVendidoRepo.findByForma("Retirado");
        Usuario usuarioVenta = usuarioRepo.findByNombreUsuario(allProducts.getNombreUsuarioVenta());

        producto.setCategoria(categoria);
        producto.setEstado(estado);
        producto.setActivoVendido(activoVendido);
        producto.setVenderProducto(usuarioVenta);

        //la señal de eliminar es si el nombrecomprador es nulo
        if (allProducts.getNombreUsuarioCompra() == null) {
            productoRepo.save(producto);
        }else if (allProducts.getNombreUsuarioCompra().equals("Eliminar")){
            productoRepo.delete(producto);
        }

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(producto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

    @GetMapping("topProductRating")
    public String topProductRating() {


        List<TopRating> lstProducts = productoRepo.topProductRating(PageRequest.of(0,10));

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(lstProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

    @PostMapping("buscarProductos")
    public String buscarProductos(@RequestBody Producto producto) {

        List<AllProducts> lstProducts = new ArrayList<>();

        String tipoCategoria = producto.getCategoria().getTipoCategoria();
        String tipoEstado = producto.getEstado().getTipoEstado();
        boolean intercambio = producto.isIntercambio();
        String wildCard = producto.getNombre();

        if (intercambio){
            lstProducts = productoRepo.buscarProductos(tipoCategoria,tipoEstado, intercambio, wildCard);
        }else{
            lstProducts = productoRepo.buscarProductosFalse(tipoCategoria,tipoEstado, wildCard);
        }



        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(lstProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }


//    @PutMapping(value = "updateProducto",produces = MimeTypeUtils.APPLICATION_JSON_VALUE,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
//        try {
//            return new ResponseEntity<Producto>(productoRepo.save(producto), HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping(value = "deleteProducto",produces = MimeTypeUtils.APPLICATION_JSON_VALUE,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> deleteProducto(@RequestBody Producto producto) {
//        try {
//            productoRepo.delete(producto);
//            return new ResponseEntity<Void>(HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//        }
//    }




}
