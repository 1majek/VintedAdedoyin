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
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20, nullable = false)
    private String tipoEstado; //nuevo, semiNuevo y usado

    //cascade = CascadeType.ALL
    @OneToMany(mappedBy = "estado",cascade = CascadeType.ALL)
    @Column(nullable = false)
    //@JsonBackReference
    @JsonManagedReference(value = "estado_product")
    private Set<Producto> producto = new HashSet<Producto>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    //@JsonManagedReference(value = "estado_product")
    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

}
