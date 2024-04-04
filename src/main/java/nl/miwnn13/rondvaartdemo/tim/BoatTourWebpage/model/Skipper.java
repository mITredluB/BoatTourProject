package nl.miwnn13.rondvaartdemo.tim.BoatTourWebpage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Author: Tim Bulder
 * <p>
 * a Skipper in our company
 **/
@Entity
public class Skipper {
    @Id @GeneratedValue
    private Long skipperId;
    private String name;

    public Long getSkipperId() {
        return skipperId;
    }

    public void setSkipperId(Long skipperId) {
        this.skipperId = skipperId;
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

