package com.example.tp1.controller;

import com.example.tp1.model.Client;
import com.example.tp1.model.Location;
import com.example.tp1.model.Voiture;
import com.example.tp1.service.ClientService;
import com.example.tp1.service.LocationService;
import com.example.tp1.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class LocationController {

    private final LocationService locationService;

    private final ClientService clientService;

    private final VoitureService voitureService;

    @Autowired
    public LocationController(LocationService locationService, ClientService clientService, VoitureService voitureService) {
        this.locationService = locationService;
        this.clientService = clientService;
        this.voitureService = voitureService;
    }

    @RequestMapping("/location/addLocation")
    public String addLocation(Model model) {
        Location location = new Location();
        model.addAttribute("locationForm", location);
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        List<Voiture> voitures = voitureService.getAllVoitures();
        model.addAttribute("voitures", voitures);
        return "new_location";
    }

    @PostMapping("/location/save")
    public String saveLocation(@ModelAttribute("locationForm") Location location) {
        location.setPrix(location.getPrixJour() * (ChronoUnit.DAYS.between(location.getDateDebut(), location.getDateRetour())));
        locationService.saveLocation(location);
        return "redirect:/locations/all";
    }

    @RequestMapping("/locations/all")
    public String listLocation(Model model) {
        model.addAttribute("locations", locationService.getAllLocations());
        return "location_list";
    }

    @RequestMapping("/location/update/{id}")
    public String updateLocation(@PathVariable(value="id") Long id, Model model){
        Location location = locationService.getLocationById(id);
        model.addAttribute("locationForm", location);
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        List<Voiture> voitures = voitureService.getAllVoitures();
        model.addAttribute("voitures", voitures);
        return "update_location";
    }

    @RequestMapping("/location/delete/{id}")
    public String deleteLocation(@PathVariable("id") Long id, Model model) {
        locationService.deleteLocation(id);
        return "redirect:/locations/all";
    }
}
