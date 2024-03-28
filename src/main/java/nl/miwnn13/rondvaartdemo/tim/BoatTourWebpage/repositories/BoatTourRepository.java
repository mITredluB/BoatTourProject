package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.BoatTour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatTourRepository extends JpaRepository<BoatTour, Long> {
}
