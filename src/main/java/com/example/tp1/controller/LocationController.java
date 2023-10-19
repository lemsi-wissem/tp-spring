package com.example.tp1.controller;

import com.example.tp1.model.Location;
import com.example.tp1.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/location/addLocation")
    public String addLocation(Model model) {
        Location location = new Location();
        model.addAttribute("locationForm", location);
        return "new_location";
    }

    @PostMapping("/location/save")
    public String saveLocation(@ModelAttribute("locationForm") Location location) {
        locationService.saveLocation(location);
        return "redirect:/";
    }
}
