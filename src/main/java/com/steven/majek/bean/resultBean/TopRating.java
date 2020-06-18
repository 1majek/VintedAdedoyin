package com.steven.majek.bean.resultBean;

import com.steven.majek.bean.Producto;
import com.steven.majek.bean.Usuario;

public class TopRating {
    Producto producto;
    String nombreUsuario;
    long idUsuario;
    double top;

    public TopRating() {
    }


    public TopRating(Producto producto, String nombreUsuario, long idUsuario, double top) {
        this.producto = producto;
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        this.top = top;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getTop() {
        return top;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setTop(double top) {
        this.top = top;
    }
}
