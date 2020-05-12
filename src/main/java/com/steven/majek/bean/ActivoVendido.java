package com.steven.majek.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class ActivoVendido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20, nullable = false)
    private String forma; //Activo,vendido,retirado o eliminado

    //@JsonBackReference(value = "activo_productss")
    @OneToMany(mappedBy = "activoVendido",cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonManagedReference(value = "activo_product")
    private Set<Producto> producto = new HashSet<Producto>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @JsonBackReference(value = "activo_product")
    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

}
