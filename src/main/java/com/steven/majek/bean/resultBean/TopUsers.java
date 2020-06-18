package com.steven.majek.bean.resultBean;

import com.steven.majek.bean.Producto;
import com.steven.majek.bean.Usuario;

public class TopUsers {
    Usuario usuario;
    Producto producto;
    long top;

    public TopUsers() {
    }

    public TopUsers(Usuario usuario, long top) {
        this.usuario = usuario;
        this.top = top;
    }

    public TopUsers(Usuario usuario, Producto producto, long top) {
        this.usuario = usuario;
        this.producto = producto;
        this.top = top;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public long getTop() {
        return top;
    }

    public void setTop(long top) {
        this.top = top;
    }
}
