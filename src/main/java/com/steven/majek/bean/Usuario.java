package com.steven.majek.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.*;
import com.steven.majek.LocalDatTimeFormatter.LocalDateTimeAdapterDeserializer;
import com.steven.majek.LocalDatTimeFormatter.LocalDateTimeAdapterSerializer;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
//@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, unique = true, length = 20)
    private String nombreUsuario;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String apellido;

    @Email
    @Column(nullable = false, length = 30,unique = true)
    private String email;

    @Column(nullable = false,length = 30)
    private String pass;

    @Column(nullable = true, length = 50)
    private String direccion;

    @Column(nullable = true, length = 100)
    private String urlFoto;

    @CreationTimestamp
    private LocalDateTime created;
//
//    @ManyToMany(mappedBy = "usuarios",cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
//    @JsonBackReference()
//    @Column(nullable = false)
//    private Set<Producto> productos = new HashSet<Producto>();

    @OneToMany(mappedBy = "compraProducto")
    @JsonManagedReference(value = "compra_product")
    @Column(nullable = true)
    //@JsonSerialize(using = ToStringSerializer.class)
    private Set<Producto> compraProducto = new HashSet<Producto>();

    @OneToMany(mappedBy = "venderProducto")
    @JsonManagedReference(value = "vender_product")
    @Column(nullable = false)
    //@JsonSerialize(using = ToStringSerializer.class)
    private Set<Producto>  vendeProducto = new HashSet<>();


    public Usuario() {
    }

    public Usuario(String nombreUsuario,String nombre,String apellido, String email, String pass, String direccion, String urlFoto, LocalDateTime created ) {

        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pass = pass;
        this.direccion = direccion;
        this.urlFoto = urlFoto;
        this.created = created;

//        for (UsuarioProductos usuarioProducto : usuarioProductos) usuarioProducto.setUsuario(this);
//        this.usuarioProductos = Stream.of(usuarioProductos).collect(Collectors.toSet());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        urlFoto = urlFoto;
    }

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    //@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Set<Producto> getVendeProducto() {
        return vendeProducto;
    }

    public void setVendeProducto(Set<Producto> vendeProducto) {
        this.vendeProducto = vendeProducto;
    }

    public Set<Producto> getCompraProducto() {
        return compraProducto;
    }

    public void setCompraProducto(Set<Producto> compraProducto) {
        this.compraProducto = compraProducto;
    }

    public static String toArrayJson(Usuario usuario) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();


        //Serializar
        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapterSerializer());

        //Deserializer
        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapterDeserializer());

        Gson gson = builder.setPrettyPrinting().create();
        String resp = gson.toJson(usuario);

        return resp;
    }

    public static String toArrayJsonAl(ArrayList<Usuario> usuario) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(usuario);

        return resp;
    }
    public static String cadena(String usuario) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(usuario);

        return resp;
    }


}
