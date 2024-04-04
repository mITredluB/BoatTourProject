package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Tim Bulder
 * <p>
 * This describes a boat tour
 **/

@Entity
public class BoatTour {
    @Id
    @GeneratedValue
    private Long boatTourId;

    @ManyToMany
    private Set<Boat> boats;

    @ManyToMany
    private Set<Skipper> skippers;

    @ManyToMany
    private Set<Guide> guides;

    public Set<Skipper> getSkippers() {
        return skippers;
    }

    public void setSkippers(Set<Skipper> skippers) {
        this.skippers = skippers;
    }

    public Set<Guide> getGuides() {
        return guides;
    }

    public void setGuides(Set<Guide> guides) {
        this.guides = guides;
    }

    public Set<Boat> getBoats() {
        return boats;
    }

    public void setBoats(Set<Boat> boats) {
        this.boats = boats;
    }

    public Long getBoatTourId() {
        return boatTourId;
    }

    public void setBoatTourId(Long boatTourId) {
        this.boatTourId = boatTourId;
    }
}
