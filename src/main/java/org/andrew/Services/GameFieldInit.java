package org.andrew.Services;

import lombok.extern.log4j.Log4j2;
import org.andrew.Entities.Animals.Animal;
import org.andrew.Entities.Animals.AnimalType;
import org.andrew.Entities.Animals.Herbivores.Horse;
import org.andrew.Entities.Animals.Predators.Wolf;
import org.andrew.Entities.EntityType;
import org.andrew.Entities.Organism;
import org.andrew.Entities.Plants.Grass;
import org.andrew.Entities.Plants.PlantType;
import org.andrew.Map.Coordinates;
import org.andrew.Map.GameField;


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
        addRandomEntity();
    }

    private void addRandomEntity() { //going through all cells in gameField and add random quantity of Animal
        gameField.getCells().forEach(cell -> {
            for (int i = 0; i < (Math.random() * cell.getMaxEntities()); i++) {
                final Organism entity = getRandomEntity();
                cell.putEntityToArrayListInMap(entity.getENTITY_TYPE(), entity);
                log.debug(entity.getENTITY_TYPE() + " was added to " + cell);
            }
            log.debug(cell + cell.getEntitiesMap().toString());
        });
    }

    private Organism getRandomEntity() {
        EntityType[] entities = EntityType.values();
        EntityType randomEntity = entities[(int) (Math.random() * entities.length)];

        switch (randomEntity) {
            case ANIMAL:
                return getRandomAnimal();
            case PLANT:
                return getRandomPlant();
            default:
                throw new IllegalStateException("Unexpected value: " + randomEntity);
        }
    }


    private Animal getRandomAnimal() {
        AnimalType[] animals = AnimalType.values();
        AnimalType randomAnimal = animals[(int) (Math.random() * animals.length)];
        return createAnimal(randomAnimal);
    }
    private Animal createAnimal(AnimalType randomAnimal) {
        switch (randomAnimal) {
            case WOLF:
                return new Wolf();
            case HORSE:
                return new Horse();
            default:
                throw new IllegalStateException("Unexpected value: " + randomAnimal);
        }
    }
    private Grass getRandomPlant() {
        PlantType[] plants = PlantType.values();
        PlantType randomPlant = plants[(int) (Math.random() * plants.length)];
        return createPlant(randomPlant);
    }

    private Grass createPlant(PlantType randomPlant) {
        switch (randomPlant) {
            case GRASS:
                return new Grass();
            default:
                throw new IllegalStateException("Unexpected value: " + randomPlant);
        }
    }
}
