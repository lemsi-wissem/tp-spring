package com.example.tp1.repository;

import com.example.tp1.model.Voiture;

import java.util.List;

public interface VoitureRepositoryCustom {
    List<Voiture> listeVoitureByModel(Long idModel);
}
