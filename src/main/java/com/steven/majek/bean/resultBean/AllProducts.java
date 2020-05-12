package com.steven.majek.bean.resultBean;

import com.steven.majek.bean.Producto;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

@Projection(name = "deadline", types = { Producto.class })
public class AllProducts {
    //select p.id as id_producto, p.created as fecha_producto,p.descripcion as desc_producto,p.imagen as imagen_producto,p.nombre as nombre_producto,p.precio as precio_producto,p.puntos as punto_producto,p.intercambio as intercambio_producto, u.nombre as nombre_usuario,e.tipo_estado as estado,c.tipo_categoria as categoria " +

    private long id_producto;
    private Instant fecha_producto;
    private String  desc_producto;
    private String imagen_producto;
    private String nombre_producto;
    private double precio_producto;
    private double punto_producto;
    private boolean intercambio_producto;
    private String nombre_usuario;
    private String estado;
    private String categoria;

    public AllProducts(long id_producto, Instant fecha_producto, String desc_producto, String imagen_producto, String nombre_producto, double precio_producto, double punto_producto, boolean intercambio_producto, String nombre_usuario, String estado, String categoria) {
        this.id_producto = id_producto;
        this.fecha_producto = fecha_producto;
        this.desc_producto = desc_producto;
        this.imagen_producto = imagen_producto;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.punto_producto = punto_producto;
        this.intercambio_producto = intercambio_producto;
        this.nombre_usuario = nombre_usuario;
        this.estado = estado;
        this.categoria = categoria;
    }


    public AllProducts(long id_producto, Instant fecha_producto, String desc_producto, String imagen_producto, String nombre_producto, double precio_producto, double punto_producto, boolean intercambio_producto, String estado, String categoria) {
        this.id_producto = id_producto;
        this.fecha_producto = fecha_producto;
        this.desc_producto = desc_producto;
        this.imagen_producto = imagen_producto;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.punto_producto = punto_producto;
        this.intercambio_producto = intercambio_producto;
        this.estado = estado;
        this.categoria = categoria;
    }

    public AllProducts(long id_producto, Instant fecha_producto, String desc_producto, String imagen_producto, String nombre_producto, double precio_producto, double punto_producto, boolean intercambio_producto, String nombre_usuario) {
        this.id_producto = id_producto;
        this.fecha_producto = fecha_producto;
        this.desc_producto = desc_producto;
        this.imagen_producto = imagen_producto;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.punto_producto = punto_producto;
        this.intercambio_producto = intercambio_producto;
        this.nombre_usuario = nombre_usuario;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public Instant getFecha_producto() {
        return fecha_producto;
    }

    public void setFecha_producto(Instant fecha_producto) {
        this.fecha_producto = fecha_producto;
    }

    public String getDesc_producto() {
        return desc_producto;
    }

    public void setDesc_producto(String desc_producto) {
        this.desc_producto = desc_producto;
    }

    public String getImagen_producto() {
        return imagen_producto;
    }

    public void setImagen_producto(String imagen_producto) {
        this.imagen_producto = imagen_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public double getPunto_producto() {
        return punto_producto;
    }

    public void setPunto_producto(double punto_producto) {
        this.punto_producto = punto_producto;
    }

    public boolean isIntercambio_producto() {
        return intercambio_producto;
    }

    public void setIntercambio_producto(boolean intercambio_producto) {
        this.intercambio_producto = intercambio_producto;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
