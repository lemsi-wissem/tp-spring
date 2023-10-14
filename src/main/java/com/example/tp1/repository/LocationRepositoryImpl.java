package com.example.tp1.repository;

import com.example.tp1.model.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class LocationRepositoryImpl implements LocationRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Location> listeLocationByClient(Long idClient) {
        return entityManager.createQuery("select l from Location l where l.client.id = :idClient", Location.class)
                .setParameter("idClient", idClient)
                .getResultList();
    }

    @Override
    public List<Location> listeLocationByVoiture(Long idVoiture) {
        return entityManager.createQuery("select l from Location l where l.voiture.id = :idVoiture", Location.class)
                .setParameter("idVoiture", idVoiture)
                .getResultList();
    }
}
