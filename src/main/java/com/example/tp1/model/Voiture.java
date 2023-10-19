package com.example.tp1.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serie;

    private Date dateMiseEnMarche;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

    @ManyToOne
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

    public Date getDateMiseEnMarche() {
        return dateMiseEnMarche;
    }

    public void setDateMiseEnMarche(Date dateMiseEnMarche) {
        this.dateMiseEnMarche = dateMiseEnMarche;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Models getModel() {
        return models;
    }

    public void setModel(Models models) {
        this.models = models;
    }
}
