package org.andrew.Map;

import lombok.extern.log4j.Log4j2;
import org.andrew.Entities.EntityType;
import org.andrew.Entities.Organism;
import org.andrew.Services.ConfigLoader;

import java.util.*;

import static org.reflections.Reflections.log;

@Log4j2
public class GameField {
    private static GameField instance;
    private final String PROPERTIES_KEY = "map.game-field.";
    private final int height;
    private final int width;
    private final List<Cell> cells;


    private GameField() {
        height = ConfigLoader.getIntProperty(PROPERTIES_KEY + "height");
        width = ConfigLoader.getIntProperty(PROPERTIES_KEY + "width");
        cells = new ArrayList<>();
        log.debug(this.getClass().getSimpleName() + " loaded " +
                "cells initialized [" + height + "][" + width + "]");
    }

    public static GameField getInstance() {
        if (instance == null) {
            instance = new GameField();
        }
        return instance;
    }

    public String getPROPERTIES_KEY() {
        return PROPERTIES_KEY;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Optional<Cell> getCellAt(Coordinates coordinates) {
        return cells.stream()
                .filter(o -> o.coordinates.equals(coordinates))
                .findFirst();
    }

    public class Cell {
        private final String PROPERTIES_KEY = "map.game-field.cell.";
        private final int maxEntities;
        private final Coordinates coordinates;
        private final Map<EntityType, List<Organism>> entitiesMap = new HashMap<>();


        public Cell(Coordinates coordinates) {
            this.coordinates = coordinates;
            this.maxEntities = ConfigLoader.getIntProperty(getPROPERTIES_KEY() + "maxEntities");
            this.entitiesMap.put(EntityType.ANIMAL, new ArrayList<>());
            this.entitiesMap.put(EntityType.PLANT, new ArrayList<>());
            log.debug(this + "was initialized.");
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }

        public void putEntityToArrayListInMap(EntityType ENTITY_TYPE, Organism organism) {
            entitiesMap.get(organism.getENTITY_TYPE()).add(organism);
        }

        public Map<EntityType, List<Organism>> getEntitiesMap() {
            return entitiesMap;
        }

        public String getPROPERTIES_KEY() {
            return PROPERTIES_KEY;
        }

        public int getMaxEntities() {
            return maxEntities;
        }

        @Override
        public String toString() {
            return "Cell{" + coordinates +
                    '}';
        }
    }
}
