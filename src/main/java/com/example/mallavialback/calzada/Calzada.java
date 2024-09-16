package com.example.mallavialback.calzada;

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
@Table(name = "calzada")
public class Calzada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String material;

    // Relación muchos a uno con Segmento
    @ManyToOne
    @JoinColumn(name = "segmento_id")
     @JsonBackReference
    private Segmento segmento;

    // Constructor por defecto
    public Calzada() {
    }

    // Constructor con argumentos
    public Calzada(Long id, String nombre, String material, Segmento segmento) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
