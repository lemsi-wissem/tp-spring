package com.example.tp1.controller;

import com.example.tp1.model.Models;
import com.example.tp1.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "redirect:/";
    }
}
