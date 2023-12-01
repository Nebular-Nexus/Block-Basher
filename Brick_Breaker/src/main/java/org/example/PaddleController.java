package org.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class PaddleController {
    private int paddlePosition;
    private int paddleSpeed;
    private int paddleWidth;
    private InputConnector inputConnector;

    public int getPaddlePosition() {
        return paddlePosition;
    }
    public int getpaddlewidth(){
        return paddleWidth;
    }

    public PaddleController(InputConnector inputConnector,int paddleWidth,int paddlePosition,int paddleSpeed) {
        this.inputConnector = inputConnector;
        this.paddleWidth = paddleWidth;
        this.paddlePosition =paddlePosition;
        this.paddleSpeed = paddleSpeed;
    }

    public void moveLeft() {
        // Move paddle to the left
        if(this.paddlePosition>0){
            this.paddlePosition -= this.paddleSpeed;
        }
    }

    public void moveRight() {
        // Move paddle to the right
        if(this.paddlePosition+(paddleWidth/2)<700){
            this.paddlePosition += this.paddleSpeed;
        }
    }

    public void handleInput(KeyEvent e) {

        if(inputConnector.keyPressed(e).equals("left")){
            moveLeft();
        }
        else{
            moveRight();
        }
    }

    public void paddleDisplay(Graphics2D g)
    {
        g.setColor(Color.black);
        g.fillRect(this.paddlePosition, 550, this.paddleWidth, 8);
    }
    

    public void setpaddlePosition(int x)
    {
        this.paddlePosition = x;
    }
      
}
