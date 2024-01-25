package org.example.Entities.Animals;

import lombok.extern.log4j.Log4j2;
import org.example.Entities.Entities;
import org.example.Entities.Movable;
import org.example.Entities.Organism;

import static org.reflections.Reflections.log;

@Log4j2

public abstract class Animal extends Organism implements Movable {

    public Animal() {
        super(Entities.ANIMAL);
    }

    public void move() {

        log.info(this.getClass().getSimpleName() + " moved!");
    }

}
