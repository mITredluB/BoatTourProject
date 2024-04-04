package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Author: Tim Bulder
 * <p>
 * a boat in our company
 **/
@Entity
public class Boat {
    @Id @GeneratedValue
    private Long boatID;
    private String name;

    public Long getBoatID() {
        return boatID;
    }

    public void setBoatID(Long boatID) {
        this.boatID = boatID;
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
