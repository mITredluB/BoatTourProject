package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Author: Tim Bulder
 * <p>
 * A guide in our company
 **/
@Entity
public class Guide {
    @Id @GeneratedValue
    private Long guideID;
    private String name;

    public Long getGuideID() {
        return guideID;
    }

    public void setGuideID(Long guideID) {
        this.guideID = guideID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
