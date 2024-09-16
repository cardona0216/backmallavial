package com.example.mallavialback.calzada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CalzadaService {

    private final CalzadaRepository calzadaRepository;

    @Autowired
    public CalzadaService(CalzadaRepository calzadaRepository) {
        this.calzadaRepository = calzadaRepository;
    }

    public List<Calzada> getCalzadas() {
        return this.calzadaRepository.findAll();
    }

    public ResponseEntity<Object> saveCalzada(Calzada calzada) {
        HashMap<String, Object> datos = new HashMap<>();
        calzadaRepository.save(calzada);
        datos.put("mensaje", "Se guardó con éxito");
        datos.put("data", calzada);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateCalzada(Long id, Calzada calzada) {
        if (calzadaRepository.existsById(id)) {
            calzada.setId(id);  // Asegúrate de que el ID sea el correcto en la entidad
            Calzada updatedCalzada = calzadaRepository.save(calzada);
            return ResponseEntity.ok(updatedCalzada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Calzada not found");
        }
    }

    public ResponseEntity<Object> deleteCalzada(Long id) {
        HashMap<String, Object> datos = new HashMap<>();
        if (!calzadaRepository.existsById(id)) {
            datos.put("error", true);
            datos.put("mensaje", "No existe una calzada con ese id");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }
        calzadaRepository.deleteById(id);
        datos.put("mensaje", "Calzada eliminada");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }
}
