package com.example.tp1.service;

import com.example.tp1.model.Voiture;
import com.example.tp1.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {

    private final VoitureRepository voitureRepository;

    @Autowired
    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public List<Voiture> listeVoitureByModel(Long idModel) {
        return voitureRepository.listeVoitureByModel(idModel);
    }

    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }

    public Voiture getVoitureById(Long id) {
        return voitureRepository.findById(id).orElse(null);
    }

    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    public Voiture updateVoiture(Voiture voiture) {
        Voiture existingVoiture = voitureRepository.findById(voiture.getId()).orElse(null);
        if (existingVoiture == null) {
            return null;
        }
        existingVoiture.setId(voiture.getId());
        existingVoiture.setLocations(voiture.getLocations());
        existingVoiture.setSerie(voiture.getSerie());
        existingVoiture.setModels(voiture.getModels());
        existingVoiture.setDateMiseEnMarche(voiture.getDateMiseEnMarche());
        return voitureRepository.save(existingVoiture);
    }
}
