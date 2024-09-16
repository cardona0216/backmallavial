package com.example.mallavialback.bordillo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BordilloRepository extends JpaRepository<Bordillo, Long> {
}

