package com.example.mallavialback.segmento;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.mallavialback.bordillo.Bordillo;
import com.example.mallavialback.bordillo.BordilloRepository;
import com.example.mallavialback.calzada.Calzada;
import com.example.mallavialback.calzada.CalzadaRepository;

@Service
public class SegmentoService {

    private final SegmentoRepository segmentoRepository;
    private final CalzadaRepository calzadaRepository; // Añadir repositorio para Calzada
    private final BordilloRepository bordilloRepository; // Añadir repositorio para Bordillo

    @Autowired
    public SegmentoService(SegmentoRepository segmentoRepository, CalzadaRepository calzadaRepository, BordilloRepository bordilloRepository) {
        this.segmentoRepository = segmentoRepository;
        this.calzadaRepository = calzadaRepository;
        this.bordilloRepository = bordilloRepository;
    }

    public List<Segmento> getSegmentos() {
        return this.segmentoRepository.findAll();
    }

    public Segmento getSegmentoById(Long id) {
        return segmentoRepository.findById(id)
            .orElseThrow();
    }
    

    public ResponseEntity<Object> saveSegmento(Segmento segmento) {
        HashMap<String, Object> datos = new HashMap<>();
        
        // Guardar el segmento
        Segmento savedSegmento = segmentoRepository.save(segmento);

        // Guardar las calzadas asociadas
        for (Calzada calzada : savedSegmento.getCalzadas()) {
            calzada.setSegmento(savedSegmento); // Establecer la relación con el segmento guardado
            calzadaRepository.save(calzada);
        }

        // Guardar los bordillos asociados
        for (Bordillo bordillo : savedSegmento.getBordillos()) {
            bordillo.setSegmento(savedSegmento); // Establecer la relación con el segmento guardado
            bordilloRepository.save(bordillo);
        }

        datos.put("mensaje", "Se guardó con éxito");
        datos.put("data", savedSegmento);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateSegmento(Long id, Segmento segmento) {
        if (segmentoRepository.existsById(id)) {
            segmento.setId(id);  // Asegúrate de que el ID sea el correcto en la entidad
            Segmento updatedSegmento = segmentoRepository.save(segmento);
            return ResponseEntity.ok(updatedSegmento);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Segmento not found");
        }
    }

    public ResponseEntity<Object> deleteSegmento(Long id) {
        HashMap<String, Object> datos = new HashMap<>();
        if (!segmentoRepository.existsById(id)) {
            datos.put("error", true);
            datos.put("mensaje", "No existe un segmento con ese id");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }
        segmentoRepository.deleteById(id);
        datos.put("mensaje", "Segmento eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }
}
