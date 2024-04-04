package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.controller;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Skipper;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories.SkipperRepository;
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
public class SkipperController {

    private final SkipperRepository skipperRepository;

    public SkipperController(SkipperRepository skipperRepository) {
        this.skipperRepository = skipperRepository;
    }

    @GetMapping("/boattour/skipper")
    private String showAllSkippers(Model model) {
        model.addAttribute("allSkippers", skipperRepository.findAll());
        model.addAttribute("newSkipper", new Skipper());

        return "skipperOverview";
    }

    @PostMapping("/boattour/skipper/new")
    private String saveOrUpdateSkipper(@ModelAttribute("newSkipper") Skipper skipper, BindingResult result) {
        if (!result.hasErrors()) {
            skipperRepository.save(skipper);
        }

        return "redirect:/boattour/skipper";
    }
}
