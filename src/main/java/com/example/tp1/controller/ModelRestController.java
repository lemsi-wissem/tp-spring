package com.example.tp1.controller;

import com.example.tp1.model.Models;
import com.example.tp1.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/model")
public class ModelRestController {

    private final ModelService modelService;

    @Autowired
    public ModelRestController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/save")
    public ResponseEntity<Models> saveModel(@RequestBody Models model) {
        try {
            return ResponseEntity.ok(modelService.saveModel(model));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Models> updateModel(@RequestBody Models model) {
        try {
            return ResponseEntity.ok(modelService.updateModel(model));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Models> getModelById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(modelService.getModelById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Models>> getAllModels() {
        try {
            return ResponseEntity.ok(modelService.getAllModels());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Resource> deleteModel(@PathVariable("id") Long id) {
        try {
            modelService.deleteModel(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
