package com.steven.majek.repo;

import com.steven.majek.bean.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Long> {
    //@Query("select NEW com.steven.majek.bean.resultBean.AllCategorias(c.tipoCategoria,c.tipoCategoria,c.tipoCategoria,c.tipoCategoria)from Categoria c")
    //@Query("select NEW com.steven.majek.bean.resultBean.AllCategorias(c.tipoCategoria)from Categoria c")

//
//    @Query("select NEW com.steven.majek.entities.resultBean.AllCategorias(c.id,c.tipoCategoria)from Categoria c")
//    String[] getCategorias();
    public Categoria findByTipoCategoria(String tipoCategoria);
}
