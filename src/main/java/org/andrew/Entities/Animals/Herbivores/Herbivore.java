package org.andrew.Entities.Animals.Herbivores;

import org.andrew.Entities.Animals.Animal;
import org.andrew.Entities.Animals.AnimalType;

public abstract class Herbivore extends Animal {
    public Herbivore(String PROPERTIES_KEY,AnimalType ANIMAL_TYPE){
        super(PROPERTIES_KEY, ANIMAL_TYPE);
    }
}
