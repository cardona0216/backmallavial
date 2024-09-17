package com.example.mallavialback.segmento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/segmento")
public class SegmentoController {

    private final SegmentoService segmentoService;

    @Autowired
    public SegmentoController(SegmentoService segmentoService) {
        this.segmentoService = segmentoService;
    }

    @GetMapping
    public List<Segmento> getSegmentos() {
        return segmentoService.getSegmentos();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Segmento> getSegmentoById(@PathVariable("id") Long id) {
    Segmento segmento = segmentoService.getSegmentoById(id);
    return ResponseEntity.ok(segmento);
}

    @PostMapping
    public ResponseEntity<Object> registrarSegmento(@RequestBody Segmento segmento) {
        return segmentoService.saveSegmento(segmento);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> actualizarSegmento(@PathVariable("id") Long id, @RequestBody Segmento segmento) {
        return segmentoService.updateSegmento(id, segmento);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> eliminarSegmento(@PathVariable("id") Long id) {
        return segmentoService.deleteSegmento(id);
    }
}
