package com.example.mallavialback.segmento;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import com.example.mallavialback.bordillo.Bordillo;
import com.example.mallavialback.calzada.Calzada;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "segmento")
public class Segmento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Relación uno a muchos con calzadas
    @OneToMany(mappedBy = "segmento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Calzada> calzadas;

    // Relación uno a muchos con bordillos
    @OneToMany(mappedBy = "segmento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Bordillo> bordillos;

    // Constructores
    public Segmento() {
    }

    public Segmento(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Segmento(String nombre) {
        this.nombre = nombre;
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

    public List<Calzada> getCalzadas() {
        return calzadas;
    }

    public void setCalzadas(List<Calzada> calzadas) {
        this.calzadas = calzadas;
    }

    public List<Bordillo> getBordillos() {
        return bordillos;
    }

    public void setBordillos(List<Bordillo> bordillos) {
        this.bordillos = bordillos;
    }
}
