//package com.steven.majek.bean;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.steven.majek.EnumEstado;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import javax.validation.constraints.Null;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Entity
//public class UsuarioProductos{
//
//    @EmbeddedId
//    private UsuarioProductosId id = new UsuarioProductosId();
//
//    @ManyToOne
//    @MapsId("usuarioId")
//    @JsonBackReference(value = "usuario_productos")
//    private Usuario usuario;
//
//    @ManyToOne
//    @MapsId("productoId")
//    @JsonBackReference(value = "productos_usuarios")
//    private Producto producto;
//
//    @Enumerated(EnumType.STRING)
//    private EnumEstado estado_producto;
//
//    private LocalDateTime created;
//
//    @JsonProperty("id")
//    private void unpackNested(Long ids) {
//        this.id = new UsuarioProductosId();
//        id.setUsuarioId(ids);
//    }
//
//    @JsonProperty("idProducto")
//    private void unpackNestedIdProducto(Long ids) {
//        this.id = new UsuarioProductosId();
//        id.setProductoId(ids);
//    }
//
//
//
//    public UsuarioProductos(UsuarioProductosId id,Usuario usuario, Producto producto, EnumEstado estado_producto, LocalDateTime created) {
//
//        this.id = id;
//        this.usuario = usuario;
//        this.producto = producto;
//        this.estado_producto = estado_producto;
//        this.created = created;
//
//    }
//
//
//    public UsuarioProductos() {
//
//    }
//
//    public UsuarioProductosId getId() {
//        return id;
//    }
//
//    public void setId(UsuarioProductosId id) {
//        this.id = id;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    public Producto getProducto() {
//        return producto;
//    }
//
//    public void setProducto(Producto producto) {
//        this.producto = producto;
//    }
//
//    public EnumEstado getEstado_producto() {
//        return estado_producto;
//    }
//
//    public void setEstado_producto(EnumEstado estado_producto) {
//        this.estado_producto = estado_producto;
//    }
//
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDateTime created) {
//        this.created = created;
//    }
//
//
//    @Embeddable
//    public static class UsuarioProductosId implements Serializable {
//
//        private Long productoId;
//        private Long usuarioId;
//
//        public UsuarioProductosId() {
//
//        }
//
//        public UsuarioProductosId(Long productoId, Long usuarioId) {
//            super();
//            this.productoId = productoId;
//            this.usuarioId = usuarioId;
//
//        }
//
//        public Long getProductoId() {
//            return productoId;
//        }
//
//        public void setProductoId(Long productoId) {
//            this.productoId = productoId;
//        }
//
//        public Long getUsuarioId() {
//            return usuarioId;
//        }
//
//        public void setUsuarioId(Long usuarioId) {
//            this.usuarioId = usuarioId;
//        }
//    }
//
//    @ManyToOne(optional = false)
//    private Usuario usuarios;
//
//    public Usuario getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(Usuario usuarios) {
//        this.usuarios = usuarios;
//    }
//}
//
