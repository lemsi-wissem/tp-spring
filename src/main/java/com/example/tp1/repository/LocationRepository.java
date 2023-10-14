package com.example.tp1.repository;

import com.example.tp1.model.Client;
import com.example.tp1.model.Location;
import com.example.tp1.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>, LocationRepositoryCustom {
}
