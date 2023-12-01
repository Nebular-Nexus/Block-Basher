package org.example;

import java.awt.Graphics2D;
import java.awt.Color;


public class BallController {
    private int ballPositionX;
    private int ballPositionY;
    private int ballSpeed;

    private int ballDirX;   
    private int ballDirY;
    private CollisionConnector collisionConnector;
    private Color color;
    private int gameover=0;


    public BallController(int ballPositionX, int ballPositionY, int ballSpeed, int ballDirX,
            int ballDirY, CollisionConnector collisionConnector,Color color) {
        this.ballPositionX = ballPositionX;
        this.ballPositionY = ballPositionY;
        this.ballSpeed = ballSpeed;
        this.ballDirX = ballDirX;
        this.ballDirY = ballDirY;
        this.collisionConnector = collisionConnector;
        this.color = color;
    }

    public void move(BrickManager brickManager,PaddleController paddleController,ScoreConnector scoreConnector) {

        this.collisionConnector.checkCollisions(this, brickManager, paddleController, scoreConnector);

        this.setBallPositionX(this.getBallPositionX()+this.getBallSpeed()*this.getBallDirX());
        this.setBallPositionY(this.getBallPositionY()+this.getBallSpeed()*this.getBallDirY());
        
        // System.out.println(this.getBallPositionX());

        //checks if the ball hits the side walls
        checkCollisionsWall();
    }

    public void checkCollisionsWall(){
        if (this.getBallPositionX() < 0) {
            this.setBallDirX(-1*this.getBallDirX());
        }
        if (this.getBallPositionX() > 770) {
            this.setBallDirX(-1*this.getBallDirX());
        }

        //checks if the ball hits the upper wall
        if (this.getBallPositionY() < 0) {
            this.setBallDirY(-1*this.getBallDirY());
        }

        if(this.getBallPositionY()>570)
        {
            gameover=1;
        }
        // Move the ball

    }
    public int GameOver()
    {
        return gameover;
    }
    public int getBallSpeed() {
        return this.ballSpeed;
    }
    public void setBallSpeed(int ballSpeed) {
        this.ballSpeed = ballSpeed;
    }

    public void ballDisplay(Graphics2D g)
    {
        g.setColor(color);
        g.fillOval(this.ballPositionX, this.ballPositionY, 20, 20);
    }

    public int getBallPositionX() {
        return this.ballPositionX;
    }

    public void setBallPositionX(int ballPositionX) {
        this.ballPositionX = ballPositionX;
    }

    public int getBallPositionY() {
        return this.ballPositionY;
    }

    public void setBallPositionY(int ballPositionY) {
        this.ballPositionY = ballPositionY;
    }

    

    public int getBallDirX() {
        return this.ballDirX;
    }

    public void setBallDirX(int ballDirX) {
        this.ballDirX = ballDirX;
    }

    public int getBallDirY() {
        return this.ballDirY;
    }

    public void setBallDirY(int ballDirY) {
        this.ballDirY = ballDirY;
    }

    public CollisionConnector getCollisionConnector() {
        return this.collisionConnector;
    }

    public void setCollisionConnector(CollisionConnector collisionConnector) {
        this.collisionConnector = collisionConnector;
    }  
}

