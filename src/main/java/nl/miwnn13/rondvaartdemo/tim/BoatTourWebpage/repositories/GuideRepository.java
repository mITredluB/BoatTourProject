package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Guide;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Skipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
}
