package com.example.tp1.controller;

import com.example.tp1.model.Models;
import com.example.tp1.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @RequestMapping("/model/addModel")
    public String addModel(Model model) {
        Models model1 = new Models();
        model.addAttribute("modelForm", model1);
        return "new_model";
    }

    @PostMapping("/model/save")
    public String saveModel(@ModelAttribute("modelForm") Models model1) {
        modelService.saveModel(model1);
        return "redirect:/models/all";
    }

    @GetMapping("/models/all")
    public String getAllModels(Model model) {
        model.addAttribute("models", modelService.getAllModels());
        return "models_list";
    }

    @RequestMapping("/model/update/{id}")
    public String updateModel(@PathVariable(value = "id") Long id, Model model) {
        Models model1 = modelService.getModelById(id);
        model.addAttribute("modelForm", model1);
        return "update_model";
    }

    @RequestMapping("/model/delete/{id}")
    public String deleteModel(@PathVariable(value = "id") Long id) {
        modelService.deleteModel(id);
        return "redirect:/models/all";
    }
}
