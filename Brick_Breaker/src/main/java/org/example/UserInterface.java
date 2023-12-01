package org.example;

import java.awt.Graphics2D;
public class UserInterface {

    public void paddleDisplay(PaddleController paddleController,Graphics2D g)
    {
        paddleController.paddleDisplay(g);
    }
    public void drawBricks(BrickManager brickManager,Graphics2D g)
    {
        brickManager.drawBricks(g);
    }
    public void scoreDisplay (ScoreConnector scoreConnector,Graphics2D g)
    {
        scoreConnector.scoreDisplay(g);
    }
    public void ballDisplay(BallController ballController,Graphics2D g)
    {
        ballController.ballDisplay(g);
    }


}

