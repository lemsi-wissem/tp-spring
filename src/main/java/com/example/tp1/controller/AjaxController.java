package com.example.tp1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class AjaxController {
    @PostMapping("/calculatePrice")
    public Double calculatePrice(@RequestParam("dateDebut") LocalDate dateDebut,
                                 @RequestParam("dateRetour") LocalDate dateRetour,
                                 @RequestParam("prixJour") double prixJour) {
        // Parse the dates and calculate the price
        // Return the calculated price
        long daysBetween = ChronoUnit.DAYS.between(dateDebut, dateRetour);
       return daysBetween * prixJour;
    }
}
