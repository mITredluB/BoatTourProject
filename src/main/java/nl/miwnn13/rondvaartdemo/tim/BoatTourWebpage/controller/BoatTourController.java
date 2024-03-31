package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.controller;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.BoatTour;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.BoatTourRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: Tim Bulder
 * <p>
 * purpose for class
 **/

@Controller
public class BoatTourController {
    private final BoatTourRepository boatTourRepository;

    public BoatTourController(BoatTourRepository boatTourRepository) {
        this.boatTourRepository = boatTourRepository;
    }

    @GetMapping("/")
    private String showBoatTourOverview(Model model) {
        model.addAttribute("allBoatTours", boatTourRepository.findAll());

        return "boatTourOverview";
    }

    @GetMapping("/boattour/new")
    private String showBoatTourForm(Model model) {
        model.addAttribute("boatTour", new BoatTour());

        return "boatTourForm";
    }

    @PostMapping("/boattour/new")
    private String saveBoatTour(@ModelAttribute("boatTour") BoatTour boatTourToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            boatTourRepository.save(boatTourToBeSaved);
        }

        return "redirect:/";
    }
}
