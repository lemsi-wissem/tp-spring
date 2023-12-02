package com.example.tp1.controller;

import com.example.tp1.model.Voiture;
import com.example.tp1.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voiture")
public class VoitureRestController {

    private final VoitureService voitureService;

    @Autowired
    public VoitureRestController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @PostMapping("/save")
    public ResponseEntity<Voiture> saveVoiture(@RequestBody Voiture voiture) {
        try {
            return ResponseEntity.ok(voitureService.saveVoiture(voiture));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(voitureService.getVoitureById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Voiture>> getAllVoitures() {
        try {
            return ResponseEntity.ok(voitureService.getAllVoitures());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Voiture> updateVoiture(@RequestBody Voiture voiture) {
        try {
            return ResponseEntity.ok(voitureService.updateVoiture(voiture));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listeVoitureByModel/{idModel}")
    public ResponseEntity<Iterable<Voiture>> listeVoitureByModel(@PathVariable("idModel") Long idModel) {
        try {
            return ResponseEntity.ok(voitureService.listeVoitureByModel(idModel));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Resource> deleteVoiture(@PathVariable("id") Long id) {
        try {
            voitureService.deleteVoiture(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
