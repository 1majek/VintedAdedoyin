package com.steven.majek.controlador;

import com.steven.majek.bean.Categoria;
import com.steven.majek.bean.resultBean.AllCategorias;
import com.steven.majek.repo.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CategoriaControlador {

    @Autowired
    CategoriaRepo categoriaRepo;

    @GetMapping(value = "getCategorias",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public String getCategorias() {

        String[] categoriaList = categoriaRepo.getCategorias();

        return Categoria.toArrayJson(categoriaList);

    }
}
