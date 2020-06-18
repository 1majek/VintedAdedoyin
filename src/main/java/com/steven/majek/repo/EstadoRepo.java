package com.steven.majek.repo;

import com.steven.majek.bean.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepo extends JpaRepository<Estado, Long> {

    public Estado findByTipoEstado(String tipoEstado);
}
