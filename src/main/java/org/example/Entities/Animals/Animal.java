package org.example.Entities.Animals;

import lombok.extern.log4j.Log4j2;
import org.example.Entities.Entities;
import org.example.Entities.Movable;
import org.example.Entities.Organism;

import static org.reflections.Reflections.log;

@Log4j2

public abstract class Animal extends Organism implements Movable {
    private final Animals ANIMAL_TYPE;


    public Animal(Animals animalType) {
        super(Entities.ANIMAL);
        ANIMAL_TYPE = animalType;
    }


    public void move() {

        log.info(this.getClass().getSimpleName() + " moved!");
    }
    public Animals getANIMAL_TYPE() {
        return ANIMAL_TYPE;
    }

    @Override
    public String toString() {
        return ANIMAL_TYPE.toString();
    }
}
