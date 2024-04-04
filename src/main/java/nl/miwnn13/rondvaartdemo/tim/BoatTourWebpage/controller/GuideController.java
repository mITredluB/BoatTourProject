package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.controller;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Guide;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Skipper;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.GuideRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: Tim Bulder
 * <p>
 * Handles everything to do with guides
 **/

@Controller
public class GuideController {
    private final GuideRepository guideRepository;

    public GuideController(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @GetMapping("/boattour/guide")
    private String showAllGuides(Model model) {
        model.addAttribute("allGuides", guideRepository.findAll());
        model.addAttribute("newGuide", new Guide());

        return "guideOverview";
    }

    @PostMapping("/boattour/guide/new")
    private String saveOrUpdateSkipper(@ModelAttribute("newGuide") Guide guide, BindingResult result) {
        if (!result.hasErrors()) {
            guideRepository.save(guide);
        }

        return "redirect:/boattour/guide";
    }
}
