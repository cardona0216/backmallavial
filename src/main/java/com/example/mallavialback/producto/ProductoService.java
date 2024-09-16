package com.example.mallavialback.producto;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	HashMap <String, Object> datos;
	private  final ProductoRepository productoRepository;

	@Autowired
	public ProductoService(ProductoRepository productoRepository){
		this.productoRepository = productoRepository;
	}

    public List<Producto> getProducto(){
		return this.productoRepository.findAll();

	}


    public ResponseEntity<Object> newProducto(Producto producto) {
     Optional<Producto> res = productoRepository.findProductoByName(producto.getName());
	 datos = new HashMap<>();

	 if (res.isPresent() && producto.getId() ==null) {
		 datos.put("error", true);
		 datos.put("mensaje", "ya existe un producto con ese nombre");
        return new ResponseEntity<>(
				datos,
				HttpStatus.CONFLICT
		);
     }
     datos.put("mensaje", "se guardo con exito");
		 if (producto.getId()!= null) {
			datos.put("mensaje", "se actualizo con exito");
		 }
     productoRepository.save(producto);
		datos.put("data", producto);
		
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
		);
    }


    public ResponseEntity<Object> deleteproducto(Long id){
		datos = new HashMap<>();
		boolean existe = this.productoRepository.existsById(id);
			if (!existe){
			datos.put("error", true);
			datos.put("mensaje", "no existe un producto con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
				);
			}
        productoRepository.deleteById(id);
		datos.put("mensaje", "producto eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
		);
	}
}
