package com.steven.majek.repo;

import com.steven.majek.bean.Producto;
import com.steven.majek.bean.Usuario;
import com.steven.majek.bean.resultBean.AllProducts;
import com.steven.majek.bean.resultBean.TopRating;
import com.steven.majek.bean.resultBean.TopUsers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long> {

      @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario) FROM Producto p JOIN Usuario u ON p.venderProducto.id = u.id JOIN Categoria c on p.categoria.id = c.id JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id where a.forma = 'Activo' and u.id <> ?1")
      public List<AllProducts> articulosEnVenta(Long idUsuario);

    @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario) FROM Producto p JOIN Usuario u ON p.venderProducto.id = u.id JOIN Categoria c on p.categoria.id = c.id JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id where a.forma = 'Activo' and u.id= ?1")
    public List<AllProducts> articulosTopUsers(Long idUsuario);

        //@Query(value = "select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,u.nombreUsuario,c.tipoCategoria,e.tipoEstado) FROM Producto p LEFT OUTER JOIN ActivoVendido a ON p.id = a.id LEFT OUTER JOIN Usuario u on p.id = u.id LEFT OUTER JOIN Categoria c ON p.categoria = c.tipoCategoria LEFT OUTER JOIN Estado e ON p.estado = e.tipoEstado WHERE a.forma = 'Activo' and u.id = ?1")
        @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario) FROM Producto p JOIN Usuario u ON p.venderProducto.id = u.id JOIN Categoria c on p.categoria.id = c.id JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id where a.forma = 'Activo' and u.id = ?1")
        public List<AllProducts> misArticulosEnVenta(Long idUsuario);

     @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario) FROM Producto p JOIN Usuario u ON p.venderProducto.id = u.id JOIN Categoria c on p.categoria.id = c.id JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id where p.compraProducto = ?1")
     public List<AllProducts> misArticulosComprados(Long idUsuario);

        @Query("select NEW com.steven.majek.bean.Producto(p.id,p.nombre,p.descripcion,p.precio,p.puntos,p.categoria,p.created,p.estado,p.imagen,p.intercambio)from Producto p left outer join ActivoVendido a on p.id = a.id left outer join Usuario u on p.id = u.id where u.id<> ?1")
        public List<Producto> productosPorUserId(Long idUsuario);

        @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario) FROM Producto p JOIN Usuario u ON p.venderProducto.id = u.id JOIN Categoria c on p.categoria.id = c.id JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id where p.compraProducto.id = ?1")
        public List<AllProducts> productosComprados(Long idUsuario);

    @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario,p.compraProducto.nombreUsuario,a.forma) FROM Producto p JOIN Usuario u ON p.venderProducto.id = u.id JOIN Categoria c on p.categoria.id = c.id JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id where p.venderProducto.id = ?1 and a.forma = 'Vendido'")
    public List<AllProducts> productosVendidos(Long idUsuario);

    @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario) FROM Producto p JOIN Usuario u ON p.venderProducto.id = u.id JOIN Categoria c on p.categoria.id = c.id JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id where p.venderProducto.id = ?1 and a.forma = 'Retirado'")
    public List<AllProducts> productosRetirados(Long idUsuario);

    @Query("select NEW com.steven.majek.bean.resultBean.TopRating(p,u.nombreUsuario,u.id,MAX(p.puntos))FROM Producto p join Usuario u on p.venderProducto.id = u.id JOIN Categoria c on p.categoria.id = c.id JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id where p.puntos > 0 group by p.id order by  p.puntos desc ")
    public List<TopRating> topProductRating(PageRequest pageRequest);

    @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario,a.forma) FROM Producto p " +
            "JOIN Usuario u ON p.venderProducto.id = u.id " +
            "JOIN Categoria c on p.categoria.id = c.id " +
            "JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id " +
            "where a.id = 1 and (c.tipoCategoria = :tipoCategoria or e.tipoEstado = :tipoEstado or p.intercambio = :intercambio or p.nombre " +
            "like %:wildCard% or p.descripcion like %:wildCard% or u.nombreUsuario like %:wildCard% or u.nombre like %:wildCard% or u.apellido like %:wildCard%)")
    public List<AllProducts>  buscarProductos(@Param("tipoCategoria") String tipoCategoria,@Param("tipoEstado") String tipoEstado, @Param("intercambio") boolean intercambio, @Param("wildCard") String wildCard);

    @Query("select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.intercambio,p.nombre, p.precio,p.puntos,c.tipoCategoria,e.tipoEstado,u.nombreUsuario,a.forma) FROM Producto p " +
            "JOIN Usuario u ON p.venderProducto.id = u.id " +
            "JOIN Categoria c on p.categoria.id = c.id " +
            "JOIN Estado e on p.estado.id = e.id JOIN ActivoVendido a on p.activoVendido.id = a.id " +
            "where a.id = 1 and (c.tipoCategoria = :tipoCategoria or e.tipoEstado = :tipoEstado or p.nombre " +
            "like %:wildCard% or p.descripcion like %:wildCard% or u.nombreUsuario like %:wildCard% or u.nombre like %:wildCard% or u.apellido like %:wildCard%)")
    public List<AllProducts>  buscarProductosFalse(@Param("tipoCategoria") String tipoCategoria,@Param("tipoEstado") String tipoEstado, @Param("wildCard") String wildCard);

}
