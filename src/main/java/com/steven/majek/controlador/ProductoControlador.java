package com.steven.majek.controlador;

import com.steven.majek.bean.Categoria;
import com.steven.majek.bean.Estado;
import com.steven.majek.bean.Producto;
import com.steven.majek.bean.Usuario;
import com.steven.majek.bean.resultBean.AllProducts;
import com.steven.majek.repo.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController()
public class ProductoControlador {

    @Autowired
    ProductoRepo productoRepo;

    @GetMapping("test")
    public List<Producto> getP() {
        List<Producto> productos = productoRepo.findAll();

        return productos;
    }
    @GetMapping(value = "getProducts",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public String getProducts() {
        /*try {
            return new ResponseEntity<String>(Producto.toArrayJson(productoRepo.findAll()), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }*/

        ArrayList<AllProducts> productos = productoRepo.productosEnVenta();


        return Producto.toArrayJson(productos);
        //return null;

    }

    @GetMapping(value = "test",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public Object[] test() {
        /*try {
            return new ResponseEntity<String>(Producto.toArrayJson(productoRepo.findAll()), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }*/

        //Object[] productos = productoRepo.test();

        return null;

    }

    @GetMapping(value = "totalPrice",produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> total() {
        try {
            return new ResponseEntity<String>(String.valueOf(productoRepo.total()), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

   /* @PostMapping(value = "addProducto",produces = MimeTypeUtils.APPLICATION_JSON_VALUE,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto) {
        try {
            return new ResponseEntity<Producto>(productoRepo.save(producto), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "updateProducto",produces = MimeTypeUtils.APPLICATION_JSON_VALUE,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
        try {
            return new ResponseEntity<Producto>(productoRepo.save(producto), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "deleteProducto",produces = MimeTypeUtils.APPLICATION_JSON_VALUE,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProducto(@RequestBody Producto producto) {
        try {
            productoRepo.delete(producto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    */


}
