package com.steven.majek.repo;

import com.steven.majek.bean.Usuario;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    //@Transactional @Modifying

    //public final static String product_ordered ="Select p from Product p Join p.orderDetail od Where od.id = :id";

    //@Query(product_ordered)
    //public List<Product> findById(@Param("id") int id);

    //public final static String TopTenSellers = "select u.nombre,count(*)  as total from producto_usuario pu, producto p, usuario u where pu.usuario_id = u.id and pu.productos_id = p.id group by u.nombre order by total desc limit 10";

    //@Query(nativeQuery = true,value = "select u.nombre,count(*)  as total from producto_usuario pu, producto p, usuario u where pu.usuario_id = u.id and pu.productos_id = p.id group by u.nombre order by total desc limit 10")


    public ArrayList<Usuario> findTopByProductosContaining(String nombre);

    String test = "from Usuario where nombre= ?1 ";
    @Query(test)
    public Usuario findByNombre(String nombre);

    @Query("from Usuario")
    public List<Usuario> buscaTodo();
    //select * from usuario where email = 'majek1@hotmail.com' and pass = 'majekodunmi';
    //@Query(value = "select u.id,u.nombre,u.apellido,u.email,u.pass,u.direccion,u.url_foto from Usuario u where u.email= ?1 and u.pass = ?2",nativeQuery = true)
    //public ArrayList<Usuario> Login(String email,String pass);

    ArrayList<Usuario>  findByEmailOrNombreUsuarioAndPass(String email, String NombreUsuario, String pass);
}
