package org.example.Services;

import lombok.extern.log4j.Log4j2;
import org.example.Map.Coordinates;
import org.example.Map.GameField;

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
                Coordinates coordinates = new Coordinates(x, y);
                gameField.getCells().add(gameField.new Cell(coordinates));
            }
        }
    }

    private void fillCells() {
    }


}
