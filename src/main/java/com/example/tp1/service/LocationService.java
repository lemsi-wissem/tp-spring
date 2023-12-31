package com.example.tp1.service;

import com.example.tp1.model.Client;
import com.example.tp1.model.Location;
import com.example.tp1.model.Voiture;
import com.example.tp1.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> listeLocationByClient(Long idClient) {
        return locationRepository.listeLocationByClient(idClient);
    }

    public List<Location> listeLocationByVoiture(Long idVoiture) {
        return locationRepository.listeLocationByVoiture(idVoiture);
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location updateLocation(Location location) {
        Location existingLocation = locationRepository.findById(location.getId()).orElse(null);
        if (existingLocation == null) {
            return null;
        }
        existingLocation.setId(location.getId());
        existingLocation.setClient(location.getClient());
        existingLocation.setVoiture(location.getVoiture());
        existingLocation.setDateDebut(location.getDateDebut());
        existingLocation.setPrix(location.getPrix());
        existingLocation.setDateRetour(location.getDateRetour());
        existingLocation.setPrixJour(location.getPrixJour());
        return locationRepository.save(existingLocation);
    }
}
