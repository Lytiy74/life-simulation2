package org.andrew.Entities.Animals;

import lombok.extern.log4j.Log4j2;
import org.andrew.Entities.EntityType;
import org.andrew.Entities.Movable;
import org.andrew.Entities.Organism;

import static org.reflections.Reflections.log;

@Log4j2

public abstract class Animal extends Organism implements Movable {
    private final AnimalType ANIMAL_TYPE;
    public Animal(String PROPERTIES_KEY, AnimalType ANIMAL_TYPE){
        super(PROPERTIES_KEY, EntityType.ANIMAL);
        this.ANIMAL_TYPE = ANIMAL_TYPE;
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return  ANIMAL_TYPE.toString();
    }
}
