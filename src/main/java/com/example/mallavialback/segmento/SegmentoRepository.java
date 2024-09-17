package com.example.mallavialback.segmento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SegmentoRepository extends JpaRepository<Segmento, Long> {
    // No es necesario añadir métodos personalizados a menos que sea necesario
}

