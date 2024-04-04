package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.controller;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Boat;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.BoatTour;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Guide;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.BoatRepository;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.BoatTourRepository;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.GuideRepository;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.SkipperRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * Author: Tim Bulder
 * <p>
 * purpose for class
 **/

@Controller
public class BoatTourController {
    private final BoatTourRepository boatTourRepository;
    private final SkipperRepository skipperRepository;
    private final GuideRepository guideRepository;
    private final BoatRepository boatRepository;

    public BoatTourController(BoatTourRepository boatTourRepository, SkipperRepository skipperRepository, GuideRepository guideRepository, BoatRepository boatRepository) {
        this.boatTourRepository = boatTourRepository;
        this.skipperRepository = skipperRepository;
        this.guideRepository = guideRepository;
        this.boatRepository = boatRepository;
    }

    @GetMapping("/")
    private String showBoatTourOverview(Model model) {
        model.addAttribute("allBoatTours", boatTourRepository.findAll());

        return "boatTourOverview";
    }

    @GetMapping("/boattour/new")
    private String showBoatTourForm(Model model) {
        model.addAttribute("boatTour", new BoatTour());
        model.addAttribute("allSkippers", skipperRepository.findAll());
        model.addAttribute("allGuides", guideRepository.findAll());
        model.addAttribute("allBoats", boatRepository.findAll());
        return "boatTourForm";
    }

    @PostMapping("/boattour/new")
    private String saveBoatTour(@ModelAttribute("boatTour") BoatTour boatTourToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            boatTourRepository.save(boatTourToBeSaved);
        }

        return "redirect:/";
    }

    @GetMapping("/boattour/edit/{boatTourId}")
    private String showEditBookForm(@PathVariable("boatTourId") Long boatTourId, Model model) {
        Optional<BoatTour> boatTour = boatTourRepository.findById(boatTourId);

        if (boatTour.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("boatTour", boatTour.get());
        model.addAttribute("allSkippers", skipperRepository.findAll());
        model.addAttribute("allGuides", guideRepository.findAll());
        model.addAttribute("allBoats", boatRepository.findAll());

        return "boatTourForm";
    }
}
