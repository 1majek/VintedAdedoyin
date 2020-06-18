package com.steven.majek.repo;


import com.steven.majek.bean.ActivoVendido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivoVendidoRepo extends JpaRepository<ActivoVendido, Long> {

    //getActivoVendidoByForma

//    @Query("SELECT a from ActivoVendido  a where a.forma = 'Activo' ")
//    public ActivoVendido buscarActivo();

    public ActivoVendido findByForma(String forma);
}
