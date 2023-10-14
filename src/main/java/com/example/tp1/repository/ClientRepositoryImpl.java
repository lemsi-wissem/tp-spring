package com.example.tp1.repository;

import com.example.tp1.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class ClientRepositoryImpl implements ClientRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public Client getClientByNom(String nom) {
        return entityManager.createQuery("select c from Client c where c.nom = :nom", Client.class)
                .setParameter("nom", nom)
                .getSingleResult();
    }
}
