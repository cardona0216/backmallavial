package com.example.mallavialback.producto;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/producto")

public class ProductoController {

   
	private final ProductoService  productoServices;

	@Autowired
	public  ProductoController (ProductoService productoService){
		this.productoServices = productoService;
	}

	@GetMapping
	public List<Producto> getProductos(){
		return  productoServices.getProducto();
	}

    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Producto producto){
       return this.productoServices.newProducto(producto);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarProducto(@RequestBody Producto producto){
       
        return this.productoServices.newProducto(producto);
    }

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long id){
		return  this.productoServices.deleteproducto(id);

	}



    
}
