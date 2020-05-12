package com.steven.majek.bean.resultBean;

import com.steven.majek.bean.Categoria;

public class AllCategorias {

    private long idCategoria;
    private String tipoCategoria;

    public AllCategorias(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public AllCategorias(long idCategoria, String tipoCategoria) {
        this.idCategoria = idCategoria;
        this.tipoCategoria = tipoCategoria;
    }

    public AllCategorias() {
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }


    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }


    @Override
    public String toString() {
        return "AllCategorias{" +
                "idCategoria=" + idCategoria +
                ", tipoCategoria='" + tipoCategoria + '\'' +
                '}';
    }
}
