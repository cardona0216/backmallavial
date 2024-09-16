package com.example.mallavialback.calzada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalzadaRepository extends JpaRepository<Calzada, Long> {
}
