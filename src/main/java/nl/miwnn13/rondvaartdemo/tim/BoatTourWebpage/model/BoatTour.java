package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
    private String skipper;

    public BoatTour(String boat, String guide, String skipper) {
        this.boat = boat;
        this.guide = guide;
        this.skipper = skipper;
    }

    public BoatTour() {
    }

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

    public String getSkipper() {
        return skipper;
    }

    public void setSkipper(String skipper) {
        this.skipper = skipper;
    }
}
