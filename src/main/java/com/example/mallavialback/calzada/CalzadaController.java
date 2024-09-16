package com.example.mallavialback.calzada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/calzada")
public class CalzadaController {

    private final CalzadaService calzadaService;

    @Autowired
    public CalzadaController(CalzadaService calzadaService) {
        this.calzadaService = calzadaService;
    }

    @GetMapping
    public List<Calzada> getCalzadas() {
        return calzadaService.getCalzadas();
    }

    @PostMapping
    public ResponseEntity<Object> registrarCalzada(@RequestBody Calzada calzada) {
        return calzadaService.saveCalzada(calzada);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> actualizarCalzada(@PathVariable("id") Long id, @RequestBody Calzada calzada) {
        return calzadaService.updateCalzada(id, calzada);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> eliminarCalzada(@PathVariable("id") Long id) {
        return calzadaService.deleteCalzada(id);
    }
}

