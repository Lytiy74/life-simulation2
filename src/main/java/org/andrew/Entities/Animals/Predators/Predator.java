package org.andrew.Entities.Animals.Predators;

import org.andrew.Entities.Animals.Animal;
import org.andrew.Entities.Animals.AnimalType;

public abstract class Predator extends Animal {
    public Predator(String PROPERTIES_KEY, AnimalType ANIMAL_TYPE){
        super(PROPERTIES_KEY, ANIMAL_TYPE);
    }
}
