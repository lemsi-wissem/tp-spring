package com.example.tp1.controller;

import com.example.tp1.model.Models;
import com.example.tp1.model.Voiture;
import com.example.tp1.service.ModelService;
import com.example.tp1.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class VoitureController {

    private final VoitureService voitureService;

    private final ModelService modelsService;
    @Autowired
    public VoitureController(VoitureService voitureService, ModelService modelsService) {
        this.voitureService = voitureService;
        this.modelsService = modelsService;
    }

    @RequestMapping("/voiture/addVoiture")
    public String addVoiture(Model model) {
        Voiture voiture = new Voiture();
        model.addAttribute("voitureForm", voiture);
        List<Models> models = modelsService.getAllModels();
        model.addAttribute("models", models);
        return "new_voiture";
    }

    @PostMapping("/voiture/save")
    public String saveVoiture(@ModelAttribute("voitureForm") Voiture voiture) {
        voitureService.saveVoiture(voiture);
        return "redirect:/voitures/all";
    }

    @GetMapping("/voitures/all")
    public String listVoiture(Model model) {
        model.addAttribute("voitures", voitureService.getAllVoitures());
        return "voiture_list";
    }

    @GetMapping("/voiture/update/{id}")
    public String updateVoiture(@PathVariable Long id, Model model) {
       Voiture voiture = voitureService.getVoitureById(id);
        model.addAttribute("voitureForm", voiture);
        List<Models> models = modelsService.getAllModels();
        model.addAttribute("models", models);
        return "new_voiture";
    }

    @GetMapping("/voiture/delete/{id}")
    public String deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoiture(id);
        return "redirect:/voiture/list";
    }
}
