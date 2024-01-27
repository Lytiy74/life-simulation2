package org.andrew.Map;

import org.andrew.Entities.EntityType;
import org.andrew.Map.GameField;
import org.andrew.Services.GameFieldInit;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameFieldTest {
    GameFieldInit gameFieldInit;
    GameField gameField;

    public GameFieldTest() {
        gameFieldInit = GameFieldInit.getInstance();
        gameField = GameField.getInstance();
    }

    @Test
    void testGetInstance() {
        GameField instance2 = GameField.getInstance();

        assertNotNull(gameField);
        assertNotNull(instance2);
        assertSame(gameField, instance2);
    }

    @Test
    void testGameFieldSize() {
        int height = gameField.getHeight();
        int width = gameField.getWidth();
        int expected = height * width;

        assertEquals(expected, gameField.getCells().size());
        assertEquals(2, height);
        assertEquals(2, width);
    }

    @Nested
    public class CellTest {
        @Test
        void testMaxEntities() {
            gameField.getCells().forEach(o -> {
                assertEquals(5, o.getMaxEntities());
            });
        }
        @Test
        void testCellMapSize() {
            gameField.getCells().forEach(cell -> {
                assertEquals(2, cell.getEntitiesMap().size());
            });
        }
        @Test
        void testCurrentCountOfEntities(){
            gameField.getCells().forEach(cell -> {
                int currentCount = cell.getEntitiesMap().get(EntityType.ANIMAL).size();
                currentCount += cell.getEntitiesMap().get(EntityType.PLANT).size();
                assertTrue( currentCount <= 5 );
            });
        }



    }

}
