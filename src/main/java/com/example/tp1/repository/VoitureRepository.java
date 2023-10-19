package com.example.tp1.repository;

import com.example.tp1.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long>, VoitureRepositoryCustom {
}
