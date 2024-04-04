package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Tim Bulder
 * <p>
 * This describes a boat tour
 **/

@Entity
public class BoatTour {
    @Id @GeneratedValue
    private Long boatTourId;
    private String boat;
    private String guide;

    @ManyToMany
    private Set<Skipper> skippers;


    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public Set<Skipper> getSkippers() {
        return skippers;
    }

    public void setSkippers(Set<Skipper> skippers) {
        this.skippers = skippers;
    }
}
