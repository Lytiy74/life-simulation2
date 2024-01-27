package org.andrew.Entities.Animals;

import lombok.extern.log4j.Log4j2;
import org.andrew.Entities.EntityType;
import org.andrew.Entities.Organism;
import org.andrew.Map.Coordinates;

import java.util.Random;

import static org.reflections.Reflections.log;

@Log4j2

public abstract class Animal extends Organism implements Movable {
    private final AnimalType ANIMAL_TYPE;

    public Animal(String PROPERTIES_KEY, AnimalType ANIMAL_TYPE) {
        super(PROPERTIES_KEY, EntityType.ANIMAL);
        this.ANIMAL_TYPE = ANIMAL_TYPE;
    }

    @Override
    public void move() {
        Coordinates newCoordinates = chooseDirection();
        if (canMove(newCoordinates)) {
            this.setCoordinates(newCoordinates);
            log.debug(ANIMAL_TYPE + " moved to " + newCoordinates);
        }
        log.debug(ANIMAL_TYPE + "cant move to " + newCoordinates);
    }

    private Coordinates chooseDirection() {
        Random random = new Random();
        int deltaX = random.nextInt(3) - 1;
        int deltaY = random.nextInt(3) - 1;
        return new Coordinates(this.getCoordinates().getX() + deltaX, this.getCoordinates().getY() + deltaY);
    }

    private boolean canMove(Coordinates coordinates) {
        return false;
    }

    @Override
    public String toString() {
        return ANIMAL_TYPE.toString();
    }
}
