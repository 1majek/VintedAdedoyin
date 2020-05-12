package com.steven.majek.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.steven.majek.bean.resultBean.AllProducts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@SqlResultSetMapping(name = "p")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @NotNull
    private Instant created;

    @Column(nullable = true,length = 100)
    private String imagen;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn()
    @JsonBackReference
    private ActivoVendido activoVendido; //active, sold, redraw, reserved

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn()
    @JsonBackReference
    private Estado estado; //new, semiNew, used, old

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    @JsonBackReference
    private Categoria categoria;

    @ManyToMany(cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonIgnore
    private Set<Usuario> usuarios;

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

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @JsonBackReference(value = "activo_product")
    public ActivoVendido getActivoVendido() {
        return activoVendido;
    }

    public void setActivoVendido(ActivoVendido activoVendido) {
        this.activoVendido = activoVendido;
    }

    @JsonBackReference(value = "estado_product")
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @JsonBackReference(value = "category_product")
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //@JsonManagedReference(value = "user_product")
    public Set<Usuario> getUsuario() {
        return usuarios;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuarios = usuario;
    }

    public boolean isIntercambio() {
        return intercambio;
    }

    public void setIntercambio(boolean intercambio) {
        this.intercambio = intercambio;
    }

    public static String toArrayJson(ArrayList<AllProducts> producto) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(producto);

        return resp;
    }


    // 1. add into product table
    // 2. show my products on sale
    // 3. show 10 users with more products on sale
    // 4. show 10 products with more rating
    // 5. show product categorized by men, women and kids
    // 6. search by anything the user types
    // 7. show in filtered option (4 and 5)
    // 8. show products description with characteristics
    // 9. confirm buy
    // 10. show buy history
    // 11. rate a product
    // 12. send an email confirmation to the bought item and description
    // 13. notification of a bought item
}
