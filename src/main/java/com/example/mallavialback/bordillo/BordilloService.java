package com.example.mallavialback.bordillo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BordilloService {

    private final BordilloRepository bordilloRepository;

    @Autowired
    public BordilloService(BordilloRepository bordilloRepository) {
        this.bordilloRepository = bordilloRepository;
    }

    public List<Bordillo> getBordillos() {
        return this.bordilloRepository.findAll();
    }

    public ResponseEntity<Object> saveBordillo(Bordillo bordillo) {
        HashMap<String, Object> datos = new HashMap<>();
        bordilloRepository.save(bordillo);
        datos.put("mensaje", "Se guardó con éxito");
        datos.put("data", bordillo);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateBordillo(Long id, Bordillo bordillo) {
        if (bordilloRepository.existsById(id)) {
            bordillo.setId(id);  // Asegúrate de que el ID sea el correcto en la entidad
            Bordillo updatedBordillo = bordilloRepository.save(bordillo);
            return ResponseEntity.ok(updatedBordillo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bordillo not found");
        }
    }

    public ResponseEntity<Object> deleteBordillo(Long id) {
        HashMap<String, Object> datos = new HashMap<>();
        if (!bordilloRepository.existsById(id)) {
            datos.put("error", true);
            datos.put("mensaje", "No existe un bordillo con ese id");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }
        bordilloRepository.deleteById(id);
        datos.put("mensaje", "Bordillo eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }
}

