package org.example.Map;

import lombok.extern.log4j.Log4j2;
import org.example.Entities.Entities;
import org.example.Entities.Organism;
import org.example.Services.ConfigLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public class Cell {
        private final Coordinates coordinates;
        private final Map<Entities, List<Organism>> entitiesMap = new HashMap<>();

        public Cell(Coordinates coordinates) {
            this.coordinates = coordinates;
            this.entitiesMap.put(Entities.ANIMAL,new ArrayList<>());
            this.entitiesMap.put(Entities.PLANT,new ArrayList<>());
            log.debug(this + "was initialized.");
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }
        public void putEntityToArrayListInMap(Organism organism){
            entitiesMap.get(organism.getENTITY_TYPE()).add(organism);
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "coordinates=" + coordinates +
                    ", entitiesMap=" + entitiesMap +
                    '}';
        }
    }
}
