package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.repositories;

import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Boat;
import nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatRepository extends JpaRepository<Boat, Long> {
}
