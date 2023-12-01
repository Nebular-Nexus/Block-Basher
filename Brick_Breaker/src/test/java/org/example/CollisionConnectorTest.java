package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CollisionConnectorTest {
    private CollisionConnector collisionConnector;
    private BallController ballController;
    private BrickManager brickManager;
    private PaddleController paddleController;
    private ScoreConnector scoreConnector;
    private InputHandler inputHandler;
    private InputConnector inputConnector;
    private ScoringSystem scoringSystem;

    @BeforeEach
    public void setUp() {
        // Initialize necessary objects before each test
        collisionConnector = new CollisionConnector();
        ballController = new BallController(0,0,1,1,1,collisionConnector, Color.RED); // Initialize with necessary parameters
        brickManager = new BrickManager(3,4,Color.WHITE); // Initialize with necessary parameters
        inputHandler = new InputHandler();
        inputConnector = new InputConnector(inputHandler);
        paddleController = new PaddleController(inputConnector,100,310,10); // Initialize with necessary parameters
        scoreConnector = new ScoreConnector(scoringSystem); // Initialize with necessary parameters
    }


    @Test
    void checkCollisions() {
        // Test collision with paddle
        ballController.setBallPositionX(100);
        ballController.setBallPositionY(550); // Set ball position for collision with paddle
        paddleController.setpaddlePosition(90); // Set paddle position for collision

        collisionConnector.checkCollisions(ballController, brickManager, paddleController, scoreConnector);

        // Assert changes in ball direction after collision with paddle
        Assertions.assertEquals(-1, ballController.getBallDirY());

    }

    @Test
    public void testCheckCollisionsBricks() {
        // Test collision with bricks
//        ballController.setBallPosition(200, 200); // Set ball position for collision with bricks
        Brick[][] bricks = brickManager.getBricks();
        Integer durability = bricks[1][1].getDurability();

        ballController.setBallPositionX(200);
        ballController.setBallPositionY(200);
        // Get the bricks from the BrickManager


        // Perform collision check with each brick
        collisionConnector.checkCollisions(ballController, brickManager, paddleController, scoreConnector);

        // Assert changes in brick durability, score update, and ball direction after collision with bricks
        // Add assertions based on your collision logic and expected behavior

        // Example assertion to check if the brick durability is updated after collision
        Assertions.assertNotEquals(durability-1, bricks[1][1].getDurability()); // Change the indices according to your logic
    }


}