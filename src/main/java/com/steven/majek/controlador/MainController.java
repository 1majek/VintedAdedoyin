package com.steven.majek.controlador;

import com.steven.majek.bean.*;
import com.steven.majek.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Controller
public class MainController {

    private ActivoVendido activoVendidoActivo;
    private ActivoVendido activoVendidoVendido;
    private ActivoVendido activoVendidoRetirada;

    private Producto productoSteven;
    private Producto productoSteven2;
    private Producto productoSami;

    private Usuario usuarioSteven;
    private Usuario usuarioSami;

    private Estado estadoNuevo;
    private Estado estadosemiNuevo;
    private Estado estadoUsado;

    private Categoria categoriaRopa;
    private Categoria categoriaHogar;
    private Categoria categoriatecno;
    private Categoria categoriaOtros;


    //private ActivoVendido activoVendido;

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

    @PostMapping("addActivo")
    public String addActivo() {

        activoVendidoActivo = new ActivoVendido();
        activoVendidoActivo.setForma("Activo");


        activoVendidoVendido = new ActivoVendido();
        activoVendidoVendido.setForma("Vendido");


        activoVendidoRetirada = new ActivoVendido();
        activoVendidoRetirada.setForma("Retirada");


        activoVendidoRepo.save(activoVendidoActivo);
        activoVendidoRepo.save(activoVendidoVendido);
        activoVendidoRepo.save(activoVendidoRetirada);


        return "addActivo";
    }

    @PostMapping("addUsuario")
    public String addUsuario() {

        usuarioSteven = new Usuario();

        usuarioSteven.setNombreUsuario("1majek");
        usuarioSteven.setNombre("Steven");
        usuarioSteven.setApellido("Majek");
        usuarioSteven.setEmail("majek1@hotmail.com");
        usuarioSteven.setPass("majekodunmi");
        usuarioSteven.setDireccion("Calle Castell 1 1 b");
        usuarioSteven.setCreated(Instant.now());
        usuarioRepo.save(usuarioSteven);

        usuarioSami = new Usuario();

        usuarioSami.setNombreUsuario("kiriku");
        usuarioSami.setNombre("Noemi Samantha");
        usuarioSami.setApellido("Salazar Guerrero");
        usuarioSami.setEmail("samantha4b@gmail.com");
        usuarioSami.setPass("sami");
        usuarioSami.setDireccion("Calle Greco numero 5");
        usuarioSami.setCreated(Instant.now());
        usuarioRepo.save(usuarioSami);



        try {


        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (usuarioSteven !=null) {
            return "addUsuario";
        }else {
            return "Error";
        }


    }

    @PostMapping("addCategoria")
    public String addCategoria() {

        //hombre, mujeres, niños, tecnologia, juegos

        categoriaRopa = new Categoria();
        categoriaRopa.setTipoCategoria("Ropa");

        categoriaHogar = new Categoria();
        categoriaHogar.setTipoCategoria("Hogar");

        categoriatecno = new Categoria();
        categoriatecno.setTipoCategoria("Tecnologia");

        categoriaOtros = new Categoria();
        categoriaOtros.setTipoCategoria("Otros");

        categoriaRepo.save(categoriaRopa);
        categoriaRepo.save(categoriaHogar);
        categoriaRepo.save(categoriaOtros);
        categoriaRepo.save(categoriatecno);

        return "addCategoria";
    }

    @PostMapping("addEstado")
    public String addEstado() {

        //nuevo, semiNuevo y usado
        estadoNuevo = new Estado();
        estadoNuevo.setTipoEstado("Nuevo");

        estadosemiNuevo = new Estado();
        estadosemiNuevo.setTipoEstado("Semi Nuevo");

        estadoUsado = new Estado();
        estadoUsado.setTipoEstado("Usado");

        estadoRepo.save(estadoNuevo);
        estadoRepo.save(estadosemiNuevo);
        estadoRepo.save(estadoUsado);


        return "addEstado";
    }

    @PostMapping("addProducto")
    public String addProduto() {

        productoSteven = new Producto();
        productoSteven.setNombre("Camiseta de nike");
        productoSteven.setDescripcion("Esta muy nuevo");
        productoSteven.setPrecio(120.00);
        productoSteven.setCreated(Instant.now());
        productoSteven.setActivoVendido(activoVendidoActivo);
        productoSteven.setEstado(estadoNuevo);
        productoSteven.setCategoria(categoriaRopa);
        productoSteven.getUsuario().add(usuarioSteven);

        productoRepo.save(productoSteven);

        productoSteven2 = new Producto();
        productoSteven2.setNombre("Ordenador");
        productoSteven2.setDescripcion("8 GB de ram y 64 de disco duro. Sin estrenar");
        productoSteven2.setPrecio(800.00);
        productoSteven2.setCreated(Instant.now());
        productoSteven2.setActivoVendido(activoVendidoActivo);
        productoSteven2.setEstado(estadoNuevo);
        productoSteven2.setCategoria(categoriatecno);
        productoSteven2.getUsuario().add(usuarioSteven);

        productoRepo.save(productoSteven2);

        productoSami = new Producto();
        productoSami.setNombre("Cama matrimoninal");
        productoSami.setDescripcion("50 x 50 cm");
        productoSami.setPrecio(150.00);
        productoSami.setCreated(Instant.now());
        productoSami.setActivoVendido(activoVendidoActivo);
        productoSami.setEstado(estadoUsado);
        productoSami.setCategoria(categoriaHogar);
        productoSami.getUsuario().add(usuarioSami);

        productoRepo.save(productoSami);

        return "addProducto";
    }

    //public final static String TopTenSellers ="Select p from Product p Join p.orderDetail od Where od.id = :id";

    @GetMapping("findbyNombre")
    public Usuario findbyNombre(@RequestParam String nombre) {
        Usuario usuario = null;

        ModelAndView mv = new ModelAndView();

        try {

            usuario = usuarioRepo.findByNombre(nombre);

        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        mv.addObject(usuario);

        return usuario;

    }

    @GetMapping("buscaTodo")
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();

        ModelAndView mv = new ModelAndView();

        try {

            usuarios = usuarioRepo.buscaTodo();

        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        mv.addObject("usuarioList",usuarios);

        return usuarios;

    }

   /* @GetMapping("topTenUsers")
    public ArrayList topTenUsers() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();

        long total = 0;

        String nombre = null;

        ModelAndView mv = new ModelAndView();

        ListIterator list = null;

        ArrayList arrayList = null;

        try {

            arrayList = usuarioRepo.topTenUser();

            //System.out.println("Nombre: "+list.get(0)[0]);
            //System.out.println("Total: "+list.get(0)[1]);
            for(int i = 0; i< arrayList.size(); i++) {
                System.out.println(arrayList.lastIndexOf(i));
            }

        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        mv.addObject("arrayList",arrayList);

        return arrayList;

    }

    */





}
