package com.steven.majek.controlador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.steven.majek.bean.Usuario;
import com.steven.majek.bean.resultBean.TopUsers;
import com.steven.majek.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControlador {

    @Autowired
    UsuarioRepo usuarioRepo;

    ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping(value = "login")
    public String login(@RequestBody Usuario user) {

        String emailNombreU = user.getEmail();
        String pass = user.getPass();


        Usuario usuario = usuarioRepo.findByEmailOrNombreUsuarioAndPass(emailNombreU,emailNombreU,pass);

//        objectMapper.findAndRegisterModules();
//        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        objectMapper.setDateFormat(dataFormat);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String valor = null;
        try {
             valor = objectMapper.writeValueAsString(usuario);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
         return valor;
        //return Usuario.toArrayJson(usuario);
        //return usuario;
    }


    @PostMapping("registrame")
    public String registrame(@RequestBody Usuario usuario) throws JsonProcessingException{

        String valor = null;
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        //comprobar si ya existe
        List<Usuario> usuarioList = usuarioRepo.findAll();

        boolean check = false;

        for (Usuario user : usuarioList) {

            if ((user.getEmail().equals(usuario.getEmail()) || (user.getNombreUsuario().equals(usuario.getNombreUsuario()) ))) {
                check = true;

            }

        }

        if (check) {
                //valor = Usuario.toArrayJson(usuario);
                return objectMapper.writeValueAsString(usuario);
                //valor = "Ya existe un usuario con "+usuario.getEmail()+" o con el nombre usuario "+usuario.getNombreUsuario();
               //return valor;
        }else{
               Usuario enviar = usuarioRepo.save(usuario);
               return objectMapper.writeValueAsString(enviar);

               //return   Usuario.toArrayJson(enviar);

        }

        //return valor;


        //return Usuario.toArrayJsonAl(lista);
    }

    @GetMapping("topUsers")
    public String topUsers() {


        List<TopUsers> lstProducts = usuarioRepo.findUsuarioByTopVentas(PageRequest.of(0,10));

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String valor = null;
        try {
            valor = objectMapper.writeValueAsString(lstProducts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valor;
    }

//    @GetMapping("findTop")
//    public ArrayList<Usuario> findTopByProductos() {
//
//        return usuarioRepo.findTopByProductosContaining("cama");
//    }


}
