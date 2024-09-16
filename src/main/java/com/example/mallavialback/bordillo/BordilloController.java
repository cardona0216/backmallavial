package com.example.mallavialback.bordillo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bordillo")
public class BordilloController {

    private final BordilloService bordilloService;

    @Autowired
    public BordilloController(BordilloService bordilloService) {
        this.bordilloService = bordilloService;
    }

    @GetMapping
    public List<Bordillo> getBordillos() {
        return bordilloService.getBordillos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarBordillo(@RequestBody Bordillo bordillo) {
        return bordilloService.saveBordillo(bordillo);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> actualizarBordillo(@PathVariable("id") Long id, @RequestBody Bordillo bordillo) {
        return bordilloService.updateBordillo(id, bordillo);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> eliminarBordillo(@PathVariable("id") Long id) {
        return bordilloService.deleteBordillo(id);
    }
}
