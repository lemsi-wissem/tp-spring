package com.example.tp1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serie;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="DD-MM-YYYY")
    private LocalDate dateMiseEnMarche;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

    @ManyToOne
    @JoinColumn(name = "models_id", nullable = false)
    private Models models;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public LocalDate getDateMiseEnMarche() {
        return dateMiseEnMarche;
    }

    public void setDateMiseEnMarche(LocalDate dateMiseEnMarche) {
        this.dateMiseEnMarche = dateMiseEnMarche;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Models getModels() {
        return models;
    }

    public void setModels(Models models) {
        this.models = models;
    }
}
