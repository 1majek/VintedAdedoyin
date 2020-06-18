package com.steven.majek.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 20, nullable = false)
    private String tipoCategoria; //hombre, mujeres, niños, tecnologia, juegos

    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    @Column(nullable = false)
    //@JsonBackReference
    @JsonManagedReference(value = "category_product")
    private Set<Producto> producto = new HashSet<Producto>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    //@JsonManagedReference(value = "category_product")

    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

    public static String toArrayJson(String[] categorias) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(categorias);

        return resp;
    }
}
