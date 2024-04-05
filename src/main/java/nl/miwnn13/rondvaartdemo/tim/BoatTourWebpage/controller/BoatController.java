package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.controller;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Boat;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.BoatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: Tim Bulder
 * <p>
 * Handles everything to do with boats
 **/
@Controller
public class BoatController {
    private final BoatRepository boatRepository;

    public BoatController(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    @GetMapping("/boattour/boat")
    private String showAllGuides(Model model) {
        model.addAttribute("allBoats", boatRepository.findAll());
        model.addAttribute("newBoat", new Boat());

        return "boatOverview";
    }

    @PostMapping("/boattour/boat/new")
    private String saveOrUpdateSkipper(@ModelAttribute("newBoat") Boat boat, BindingResult result) {
        if (!result.hasErrors()) {
            boatRepository.save(boat);
        }

        return "redirect:/boattour/boat";
    }
}
