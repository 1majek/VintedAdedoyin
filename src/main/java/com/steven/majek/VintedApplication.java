package com.steven.majek;

import com.steven.majek.bean.*;
import com.steven.majek.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.steven.majek.bean")
@EnableJpaRepositories("com.steven.majek.repo")
public class VintedApplication implements CommandLineRunner {
//
//	@Autowired
//	private ProductoRepo productoRepo;
//
//	@Autowired
//	private UsuarioRepo usuarioRepo;

	@Autowired
	private ActivoVendidoRepo activoVendidoRepo;

	@Autowired
	private CategoriaRepo categoriaRepo;

	@Autowired
	private EstadoRepo estadoRepo;

	public static void main(String[] args) {
		SpringApplication.run(VintedApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

//		Usuario usuarioSteven = new Usuario();
//
//        usuarioSteven.setNombreUsuario("1majek");
//        usuarioSteven.setNombre("Steven");
//        usuarioSteven.setApellido("Majek");
//        usuarioSteven.setEmail("majek1@hotmail.com");
//        usuarioSteven.setPass("majek");
//        usuarioSteven.setDireccion("Calle Castell 1 1 b");
//        usuarioRepo.save(usuarioSteven);
//
//		Usuario usuarioSami = new Usuario();
//
//        usuarioSami.setNombreUsuario("kiriku");
//        usuarioSami.setNombre("Noemi Samantha");
//        usuarioSami.setApellido("Salazar Guerrero");
//        usuarioSami.setEmail("samantha4b@gmail.com");
//        usuarioSami.setPass("sami");
//        usuarioSami.setDireccion("Calle Greco numero 5");
//        usuarioRepo.save(usuarioSami);
//
//		ActivoVendido activoVendidoActivo = new ActivoVendido();
//        activoVendidoActivo.setForma("Activo");
//
//
//		ActivoVendido activoVendidoVendido = new ActivoVendido();
//        activoVendidoVendido.setForma("Vendido");
//
//
//		ActivoVendido activoVendidoRetirada = new ActivoVendido();
//        activoVendidoRetirada.setForma("Retirado");
//
//
//        activoVendidoRepo.save(activoVendidoActivo);
//        activoVendidoRepo.save(activoVendidoVendido);
//        activoVendidoRepo.save(activoVendidoRetirada);
//
//
//
//		Categoria categoriaMujer = new Categoria();
//		categoriaMujer.setTipoCategoria("Mujer");
//
//        Categoria categoriaHombre = new Categoria();
//        categoriaHombre.setTipoCategoria("Hombre");
//
//		Categoria categoriaNinos = new Categoria();
//        categoriaNinos.setTipoCategoria("Niños");
//
//		Categoria categoriaHogar = new Categoria();
//        categoriaHogar.setTipoCategoria("Hogar");
//
//        categoriaRepo.save(categoriaMujer);
//		categoriaRepo.save(categoriaHombre);
//		categoriaRepo.save(categoriaNinos);
//		categoriaRepo.save(categoriaHogar);
//
//		Estado estadoNuevo = new Estado();
//        estadoNuevo.setTipoEstado("Nuevo");
//
//        Estado estadosemiNuevo = new Estado();
//        estadosemiNuevo.setTipoEstado("Semi Nuevo");
//
//        Estado estadoUsado = new Estado();
//        estadoUsado.setTipoEstado("Usado");
//
//        estadoRepo.save(estadoNuevo);
//        estadoRepo.save(estadosemiNuevo);
//        estadoRepo.save(estadoUsado);

//		Producto productoSteven = new Producto();
//        productoSteven.setNombre("Camiseta de nike");
//        productoSteven.setDescripcion("Esta muy nuevo");
//        productoSteven.setPrecio(120.00);
//        productoSteven.setActivoVendido(activoVendidoActivo);
//        productoSteven.setEstado(estadoNuevo);
//        productoSteven.setCategoria(categoriaHombre);
//
//        productoRepo.save(productoSteven);
//
//		Producto productoSteven2 = new Producto();
//        productoSteven2.setNombre("Ordenador");
//        productoSteven2.setDescripcion("8 GB de ram y 64 de disco duro. Sin estrenar");
//        productoSteven2.setPrecio(800.00);
//        productoSteven2.setActivoVendido(activoVendidoActivo);
//        productoSteven2.setEstado(estadoNuevo);
//        productoSteven2.setCategoria(categoriaHogar);
//        productoRepo.save(productoSteven2);
//
//		Producto productoSami = new Producto();
//        productoSami.setNombre("Cama matrimoninal");
//        productoSami.setDescripcion("50 x 50 cm");
//        productoSami.setPrecio(150.00);
//        productoSami.setActivoVendido(activoVendidoActivo);
//        productoSami.setEstado(estadoUsado);
//        productoSami.setCategoria(categoriaHogar);
//        productoRepo.save(productoSami);
//
//
//        UsuarioProductos usuarioProductos = new UsuarioProductos();
//        usuarioProductos.setProducto(productoSami);
//        usuarioProductos.setProducto(productoSteven);
//        usuarioProductos.setProducto(productoSteven2);
//        usuarioProductos.setEstado_producto(EnumEstado.ACTIVO);
//
//        usuarioProductos.setUsuario(usuarioSami);
//        usuarioProductos.setUsuario(usuarioSteven);
//        usuarioProductos.setUsuario(usuarioSteven);
//        usuarioProductos.setEstado_producto(EnumEstado.ACTIVO);
//
//        //compra
//        usuarioSami.getUsuarioProductos().add(usuarioProductos);
//        usuarioSteven.getUsuarioProductos().add(usuarioProductos);






	}


}
