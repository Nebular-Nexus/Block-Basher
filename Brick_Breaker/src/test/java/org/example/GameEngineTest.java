package org.example;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    @Test
    public void testCheckPass() {
        GameEngine gameEngine = new GameEngine(new DifficultyManager(1), new CustomizationManager());
        BallController ballController = new BallController(350, 500, 1, 1, 2, new CollisionConnector(), Color.RED);
        gameEngine.setBallController(ballController);
        gameEngine.checkDefeat();
        assertFalse(gameEngine.isDefeat());

    }

    @Test
    public void testCheckDefault()
    {
        GameEngine gameEngine = new GameEngine(new DifficultyManager(1), new CustomizationManager());
        BallController ballController = new BallController(350, 571, 1, 1, 2, new CollisionConnector(), Color.RED);
        gameEngine.setBallController(ballController);
        gameEngine.getBallController().checkCollisionsWall();
        gameEngine.checkDefeat();
        assertTrue(gameEngine.isDefeat());
    }
}