package com.example.tp1.service;

import com.example.tp1.model.Models;
import com.example.tp1.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Models> getAllModels() {
        return modelRepository.findAll();
    }

    public Models getModelById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

    public Models saveModel(Models models) {
        return modelRepository.save(models);
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }
}
