package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.controller;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.BoatTour;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.BoatTourRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
