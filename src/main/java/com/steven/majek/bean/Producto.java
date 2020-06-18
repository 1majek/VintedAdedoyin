package com.steven.majek.bean;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.steven.majek.bean.resultBean.AllProducts;
import com.steven.majek.utils.GraphAdapterBuilder;
import com.steven.majek.utils.HibernateProxyTypeAdapter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false,length = 30)
    private String nombre;

    @Column(nullable = false,length = 100)
    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = true)
    private double puntos;

    @Column(nullable = true)
    private boolean intercambio;

    @CreationTimestamp
    private LocalDateTime created;

    @Column(nullable = true,length = 100)
    private String imagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "activo_product")
    //@JsonManagedReference(value = "activo_product")
    private ActivoVendido activoVendido; //active, sold, redraw, reserved

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "estado_product")
    //@JsonManagedReference(value = "estado_product")
    private Estado estado; //new, semiNew, used, old

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "category_product")
    //@JsonManagedReference(value = "category_product")
    private Categoria categoria;

    //@Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "compra_product")
    //@JsonSerialize(using = ToStringSerializer.class)
    private Usuario compraProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "vender_product")
    //@JsonManagedReference(value = "category_product")
    //@JsonSerialize(using = ToStringSerializer.class)
    private Usuario venderProducto;

    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, double precio, double puntos, Categoria categoria,LocalDateTime created, Estado estado, String imagen, boolean intercambio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.puntos = puntos;
        this.categoria = categoria;
        this.created = created;
        this.estado = estado;
        this.imagen = imagen;
        this.intercambio = intercambio;
    }

    public Producto(String nombre, String descripcion, double precio, double puntos, boolean intercambio, LocalDateTime created, String imagen, ActivoVendido activoVendido, Estado estado, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.puntos = puntos;
        this.intercambio = intercambio;
        this.created = created;
        this.imagen = imagen;
        this.activoVendido = activoVendido;
        this.estado = estado;
        this.categoria = categoria;

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    //@JsonBackReference(value = "activo_product")
    public ActivoVendido getActivoVendido() {
        return activoVendido;
    }

    public void setActivoVendido(ActivoVendido activoVendido) {
        this.activoVendido = activoVendido;
    }

    //@JsonBackReference(value = "estado_product")
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //@JsonBackReference(value = "category_product")
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public boolean isIntercambio() {
        return intercambio;
    }

    public void setIntercambio(boolean intercambio) {
        this.intercambio = intercambio;
    }

    public Usuario getCompraProducto() {
        return compraProducto;
    }

    public void setCompraProducto(Usuario compraProducto) {
        this.compraProducto = compraProducto;
    }

    public Usuario getVenderProducto() {
        return venderProducto;
    }

    public void setVenderProducto(Usuario venderProducto) {
        this.venderProducto = venderProducto;
    }

    public static String toArrayJson(List<AllProducts> producto) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);

        Gson gson = builder.create();
        String resp = gson.toJson(producto);

        return resp;
    }

    public static Gson testJson(List<Producto> usuarioProductos) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        new GraphAdapterBuilder().addType(Producto.class).registerOn(gsonBuilder);
        Gson gson = gsonBuilder.create();
        return gson;
    }


    // 1. add into product table x
    // 2. show my products on sale x
    // 3. show 10 users with more products on sale x
    // 4. show 10 products with more rating x
    // 5. show product categorized by men, women and kids x
    // 6. search by anything the user types x
    // 7. show in filtered option (4 and 5) x
    // 8. show products description with characteristics x
    // 9. confirm buy x
    // 10. show buy history x
    // 11. rate a product x
    // 12. send an email confirmation to the bought item and description 
    // 13. notification of a bought item x
}
