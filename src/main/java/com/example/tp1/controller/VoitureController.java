package com.example.tp1.controller;

import com.example.tp1.model.Voiture;
import com.example.tp1.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoitureController {

    private final VoitureService voitureService;
    @Autowired
    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @RequestMapping("/voiture/addVoiture")
    public String addVoiture(Model model) {
        Voiture voiture = new Voiture();
        model.addAttribute("voitureForm", voiture);
        return "new_voiture";
    }

    @PostMapping("/save")
    public String saveVoiture(@ModelAttribute("voitureForm") Voiture voiture) {
        voitureService.saveVoiture(voiture);
        return "redirect:/";
    }
}
