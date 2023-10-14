package com.example.tp1.repository;

import com.example.tp1.model.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class VoitureRepositoryImpl implements VoitureRepositoryCustom{

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Voiture> listeVoitureByModel(Long idModel) {
        return em.createQuery("select v from Voiture v where v.model.id = :idModel", Voiture.class)
                .setParameter("idModel", idModel)
                .getResultList();
    }
}
