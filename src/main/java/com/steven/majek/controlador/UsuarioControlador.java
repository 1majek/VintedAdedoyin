package com.steven.majek.controlador;

import com.steven.majek.bean.Producto;
import com.steven.majek.bean.Usuario;
import com.steven.majek.repo.UsuarioRepo;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControlador {

    @Autowired
    UsuarioRepo usuarioRepo;


    @PostMapping(value = "login")
    public String login(@RequestBody Usuario user) {

        String emailNombreU = user.getEmail();
        String pass = user.getPass();

        ArrayList<Usuario> usuario = usuarioRepo.findByEmailOrNombreUsuarioAndPass(emailNombreU,emailNombreU,pass);

        Usuario toSend = new Usuario();
        ArrayList<Usuario> listToSend  = new ArrayList();

        if (usuario.size()>0) {

            toSend.setId(usuario.get(0).getId());
            toSend.setNombreUsuario(usuario.get(0).getNombreUsuario());
            toSend.setNombre(usuario.get(0).getNombre());
            toSend.setApellido(usuario.get(0).getApellido());
            toSend.setEmail(usuario.get(0).getEmail());
            toSend.setPass(usuario.get(0).getPass());
            toSend.setDireccion(usuario.get(0).getDireccion());
            toSend.setUrlFoto(usuario.get(0).getUrlFoto());
            toSend.setCreated(usuario.get(0).getCreated());


            listToSend.add(toSend);
        }else {
            toSend = new Usuario();
        }
        return Usuario.toArrayJson(listToSend);
    }

    @PostMapping(value = "testLogin")
    public String TestLogin(@RequestBody Usuario user) {
        String emailNombreU = user.getEmail();
        String pass = user.getPass();

        ArrayList<Usuario> lista =  usuarioRepo.findByEmailOrNombreUsuarioAndPass(emailNombreU,emailNombreU,pass);

        return Usuario.toArrayJson(lista) ;
    }

















    @GetMapping("findAll")
    public List<Usuario> getUsers() {
        List<Usuario> list = usuarioRepo.findAll();

        return list;
    }

    @PostMapping("registrame")
    public String registrame(@RequestBody Usuario usuario) {
        ArrayList<Usuario> lista = new ArrayList();
        lista.add(usuario);
        usuario.setCreated(Instant.now());
        if (usuario.getNombre() != "" || usuario.getEmail()!= "" || usuario.getPass()!="") {
            usuarioRepo.save(usuario);
        }


        return Usuario.toArrayJson(lista);
    }

    @GetMapping("findTop")
    public ArrayList<Usuario> findTopByProductos() {

        return usuarioRepo.findTopByProductosContaining("cama");
    }


}
