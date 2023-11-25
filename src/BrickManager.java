import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BrickManager {
    private Brick bricks[][];

    public BrickManager(int row, int col) {
        bricks = new Brick[row][col];
        createBricks(row,col); // Initialize bricks here
    }

    public Brick[][] getBricks() {
        return bricks;
    }

    public void createBricks(Integer x,Integer y) {

        double bricksWidth = 540/y;
        double bricksHeight = 150/x;
        // Scanner input = new Scanner(System.in);
        // Double x1,x2;String coloString;
        // String coloString;
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++){
                // x1 = 800*Math.random();
                // x2 = (800-600)*Math.random();
                // coloString = "Blue";
                Integer duraInteger = 1;
                Brick brick = new Brick(duraInteger,Color.BLUE,bricksWidth,bricksHeight);
                this.bricks[i][j]=brick;
            }
        // input.close();
        
        // Create bricks
        }


    }

    public void drawBricks(Graphics g) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                Brick brick = bricks[i][j];
                int brickX = j * brick.getX().intValue();
                int brickY = i * brick.getY().intValue();

                g.setColor(brick.getColor());
                g.fillRect(brickX, brickY,brick.getX().intValue(),brick.getY().intValue());
            }
        }
    }
    


    
}

