package org.example.Services;

import lombok.extern.log4j.Log4j2;
import org.example.Entities.Animals.Animal;
import org.example.Entities.Animals.Animals;
import org.example.Entities.Animals.Herbivores.Horse;
import org.example.Entities.Animals.Predators.Wolf;
import org.example.Entities.Entities;
import org.example.Map.Coordinates;
import org.example.Map.GameField;


import static org.reflections.Reflections.log;

@Log4j2
public class GameFieldInit {
    private static GameFieldInit instance;
    private final GameField gameField;

    private GameFieldInit() {
        gameField = GameField.getInstance();
        initCells();
        fillCells();
    }

    public static GameFieldInit getInstance() {
        if (instance == null) {
            instance = new GameFieldInit();
        }
        return instance;
    }

    private void initCells() {
        for (int y = 0; y < gameField.getHeight(); y++) {
            for (int x = 0; x < gameField.getWidth(); x++) {
                gameField.getCells().add(gameField.new Cell(new Coordinates(x, y)));
            }
        }
    }

    private void fillCells() {
        addRandomAnimal();
    }

    private void addRandomAnimal() {
        gameField.getCells().forEach(o -> { //going through all cells in gameField and add random quantity of Animal
            for (int i = 0; i < (Math.random() * o.getMaxEntities()); i++) {
                final Animal animal = getRandomAnimal();
                o.putEntityToArrayListInMap(Entities.ANIMAL, animal);
                log.debug(animal.getANIMAL_TYPE() + " was added to " + o);
            }
            log.debug(o + o.getEntitiesMap().toString());
        });
    }

    private Animal getRandomAnimal() {
        Animals[] animals = Animals.values();
        Animals randomAnimal = animals[(int) (Math.random() * animals.length)];

        switch (randomAnimal) {
            case WOLF:
                return new Wolf();
            case HORSE:
                return new Horse();
            default:
                throw new IllegalStateException("Unexpected value: " + randomAnimal);
        }
    }


}
