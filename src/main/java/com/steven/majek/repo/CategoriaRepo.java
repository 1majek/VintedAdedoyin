package com.steven.majek.repo;

import com.steven.majek.bean.Categoria;
import com.steven.majek.bean.resultBean.AllCategorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Long> {
    //@Query("select NEW com.steven.majek.bean.resultBean.AllCategorias(c.tipoCategoria,c.tipoCategoria,c.tipoCategoria,c.tipoCategoria)from Categoria c")
    //@Query("select NEW com.steven.majek.bean.resultBean.AllCategorias(c.tipoCategoria)from Categoria c")


    @Query("select NEW com.steven.majek.bean.resultBean.AllCategorias(c.id,c.tipoCategoria)from Categoria c")
    String[] getCategorias();
}
