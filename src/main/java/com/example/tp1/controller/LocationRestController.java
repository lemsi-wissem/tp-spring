package com.example.tp1.controller;

import com.example.tp1.model.Location;
import com.example.tp1.service.LocationService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class LocationRestController {

    private final LocationService locationService;

    @Autowired
    public LocationRestController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/save")
    public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
        try {
            return ResponseEntity.ok(locationService.saveLocation(location));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
        try {
            return ResponseEntity.ok(locationService.updateLocation(location));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(locationService.getLocationById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Location>> getAllLocations() {
        try {
            return ResponseEntity.ok(locationService.getAllLocations());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Resource> deleteLocation(@PathVariable("id") Long id) {
        try {
            locationService.deleteLocation(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
