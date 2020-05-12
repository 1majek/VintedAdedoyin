package com.steven.majek.repo;

import com.steven.majek.bean.ActivoVendido;
import com.steven.majek.bean.Producto;
import com.steven.majek.bean.resultBean.AllProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long> {
    //@Query(value = "select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.nombre, p.precio,p.puntos,p.intercambio,u.nombre) from Producto p join p.usuarios u")
    //@Query(value = "select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.nombre, p.precio,p.puntos,p.intercambio,u.nombre,c.tipoCategoria) from Producto p join p.usuarios u left outer join p.activoVendido av left outer join p.categoria c where av.forma='Activo'")
    //@Query(value = "select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.nombre, p.precio,p.puntos,p.intercambio,u.nombreUsuario,e.tipoEstado,c.tipoCategoria) from Producto p join p.usuarios u left outer join p.estado e left outer join p.categoria c left outer join p.activoVendido av where av.forma ='Activo'")

    //List<Producto> lstProductos

    //@Query(value = "select p.id as id, p.nombre,p.descripcion,p.precio,p.puntos,p.imagen from Producto p where p.id = 10")
//    @Query(value = "from Producto")
    @Query("select sum (precio) from Producto ")
    public double total();

    @Query(value = "select NEW com.steven.majek.bean.resultBean.AllProducts(p.id,p.created,p.descripcion,p.imagen,p.nombre, p.precio,p.puntos,p.intercambio,u.nombreUsuario,e.tipoEstado,c.tipoCategoria) from Producto p join p.usuarios u left outer join p.estado e left outer join p.categoria c left outer join p.activoVendido av where av.forma ='Activo'")
    //@Query("select p from Producto p join p.usuarios u where u.id = 1")
    public ArrayList<AllProducts> productosEnVenta();
    //select  p.id, p.created,p.descripcion,p.imagen,p.nombre,p.precio,p.puntos,p.intercambio,e.tipo_estado,c.tipo_categoria  from producto p left outer join activo_vendido av on p.activo_vendido_id = av.id left outer join categoria c on p.categoria_id = c.id
    //left outer join estado e on p.estado_id = e.id;


   /* private BigInteger id_producto;
    private Timestamp fecha_producto;
    private String  desc_producto;
    private String imagen_producto;
    private String nombre_producto;
    private double precio_producto;
    private double punto_producto;
    private boolean intercambio_producto;
    private String nombre_usuario;
    private String estado;
    private String categoria;

    */

    @Query("select p.nombre,p.descripcion,p.puntos,p.created from Producto p")
    public ArrayList test();

    /*@Query("select o.customer.surname, sum(o.amount) as s from Order as o group by o.customer")

    @Query("select NEW com.mypackage.CustomerAmountResult(
            o.customer.surname, sum(o.amount))
    from Order as o
    group by o.customer.surname")

     */


}
