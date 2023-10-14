package com.example.tp1.repository;

import com.example.tp1.model.Location;

import java.util.List;

public interface LocationRepositoryCustom {
    List<Location> listeLocationByClient(Long idClient);

    List<Location> listeLocationByVoiture(Long idVoiture);

}
