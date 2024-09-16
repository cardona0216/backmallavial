package com.example.mallavialback.bordillo;

import com.example.mallavialback.segmento.Segmento;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bordillo")
public class Bordillo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String material;

    // Relación muchos a uno con Segmento
    @ManyToOne
    @JoinColumn(name = "segmento_id")
     @JsonBackReference
    private Segmento segmento;

    // Constructores
    public Bordillo() {
    }

    public Bordillo(String tipo, String material, Segmento segmento) {
        this.tipo = tipo;
        this.material = material;
        this.segmento = segmento;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }
}
