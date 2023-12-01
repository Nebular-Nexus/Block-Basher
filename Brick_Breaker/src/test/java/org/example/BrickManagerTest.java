package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BrickManagerTest {

    @Test
    public void testAllBricksHitWhenAllBricksIntact() {
        BrickManager brickManager = new BrickManager(2, 2, Color.WHITE);
        Brick[][] bricks = brickManager.getBricks();

        boolean result = brickManager.allBricksHit();

        Assertions.assertFalse(result); // At least one brick is still intact
    }

    @Test
    public void testAllBricksHitWhenAllBricksHit() {
        BrickManager brickManager = new BrickManager(1, 1, Color.WHITE);
        Brick[][] bricks = brickManager.getBricks();
        bricks[0][0].updateBrick(0);

        boolean result = brickManager.allBricksHit();

        Assertions.assertTrue(result);
    }


}