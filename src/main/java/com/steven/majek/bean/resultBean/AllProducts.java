package com.steven.majek.bean.resultBean;

import com.steven.majek.bean.Producto;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "deadline", types = { Producto.class })
public class AllProducts {
    //select p.id as id_producto, p.created as fecha_producto,p.descripcion as desc_producto,p.imagen as imagen_producto,p.nombre as nombre_producto,p.precio as precio_producto,p.puntos as punto_producto,p.intercambio as intercambio_producto, u.nombre as nombre_usuario,e.tipo_estado as estado,c.tipo_categoria as categoria " +

    private long id_producto;
    private LocalDateTime fecha_producto;
    private String  desc_producto;
    private String imagen_producto;
    private String nombre_producto;
    private double precio_producto;
    private double punto_producto;
    private boolean intercambio_producto;
    private String estado;
    private String categoria;
    private String nombreUsuarioVenta;
    private String nombreUsuarioCompra;
    private String activoVendido;

    public AllProducts() {
        super();
    }

    public AllProducts(long id_producto, LocalDateTime fecha_producto, String desc_producto, String imagen_producto, boolean intercambio_producto, String nombre_producto, double precio_producto, double punto_producto, String categoria, String estado, String nombreUsuarioVenta) {
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
        this.nombreUsuarioVenta = nombreUsuarioVenta;
    }

    //productos vendidos

    public AllProducts(long id_producto, LocalDateTime fecha_producto, String desc_producto, String imagen_producto, boolean intercambio_producto, String nombre_producto, double precio_producto, double punto_producto, String categoria, String estado, String nombreUsuarioVenta,String nombreUsuarioCompra,String activoVendido) {
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
        this.nombreUsuarioVenta = nombreUsuarioVenta;
        this.nombreUsuarioCompra = nombreUsuarioCompra;
        this.activoVendido = activoVendido;
    }
// buscar
    public AllProducts(long id_producto, LocalDateTime fecha_producto, String desc_producto, String imagen_producto, boolean intercambio_producto, String nombre_producto, double precio_producto, double punto_producto, String categoria, String estado, String nombreUsuarioVenta,String activoVendido) {
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
        this.nombreUsuarioVenta = nombreUsuarioVenta;
        this.nombreUsuarioCompra = nombreUsuarioCompra;
        this.activoVendido = activoVendido;
    }


    public AllProducts(long id_producto, LocalDateTime fecha_producto, String desc_producto, String imagen_producto, String nombre_producto, double precio_producto, double punto_producto, boolean intercambio_producto, String estado, String categoria) {
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

    public AllProducts(long id_producto, LocalDateTime fecha_producto, String desc_producto, String imagen_producto, String nombre_producto, double precio_producto, double punto_producto, boolean intercambio_producto, String nombre_usuario) {
        this.id_producto = id_producto;
        this.fecha_producto = fecha_producto;
        this.desc_producto = desc_producto;
        this.imagen_producto = imagen_producto;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.punto_producto = punto_producto;
        this.intercambio_producto = intercambio_producto;
    }

    public String getNombreUsuarioVenta() {
        return nombreUsuarioVenta;
    }

    public void setNombreUsuarioVenta(String nombreUsuarioVenta) {
        this.nombreUsuarioVenta = nombreUsuarioVenta;
    }

    public String getNombreUsuarioCompra() {
        return nombreUsuarioCompra;
    }

    public void setNombreUsuarioCompra(String nombreUsuarioCompra) {
        this.nombreUsuarioCompra = nombreUsuarioCompra;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public LocalDateTime getFecha_producto() {
        return fecha_producto;
    }

    public void setFecha_producto(LocalDateTime fecha_producto) {
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

    public String getActivoVendido() {
        return activoVendido;
    }

    public void setActivoVendido(String activoVendido) {
        this.activoVendido = activoVendido;
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
