import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Hashtable;
import java.util.Random;

public class BrickManager {
    private Color bgcolor;

    private Brick bricks[][];

    public BrickManager(int row, int col,Color bgColor) {
        this.bgcolor = bgColor;
        bricks = new Brick[row][col];
        createBricks(row, col); // Initialize bricks here
    
    }

    public Brick[][] getBricks() {
        return bricks;
    }

    public void createBricks(Integer x, Integer y) {
        double bricksWidth = 630 / y;
        double bricksHeight = 150 / x;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Integer duraInteger = getRandomNumber();
                System.out.println(duraInteger);
                // System.out.println(Brick.);
                Brick brick = new Brick(duraInteger,Brick.brickDurability.get(duraInteger), bricksWidth, bricksHeight);
                this.bricks[i][j] = brick;
            }
        }
    }

    public void drawBricks(Graphics2D g) {
        for (int i = 0; i < this.bricks.length; i++) {
            for (int j = 0; j < this.bricks[i].length; j++) {
                Brick brick = bricks[i][j];
                if (brick.getDurability() > 0) {
                    int brickX = j * brick.getX().intValue() + 80;
                    int brickY = i * brick.getY().intValue() + 50;

                    g.setColor(brick.getColor());
                    g.fillRect(brickX, brickY, brick.getX().intValue(), brick.getY().intValue());

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brick.getX().intValue() + 80, i * brick.getY().intValue() + 50,
                            brick.getX().intValue(), brick.getY().intValue());
                } else if (brick.getDurability() == 0) {
                    // Brick has been hit, you can add additional logic if needed
                }
            }
        }
    }

    public boolean allBricksHit() {
        for (int i = 0; i < this.bricks.length; i++) {
            for (int j = 0; j < this.bricks[i].length; j++) {
                if (bricks[i][j].getDurability()>0) {
                    return false; // At least one brick is still intact
                }
            }
        }
        return true; // All bricks have been hit
    }

    private int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(3) + 1; // Generates a random number between 1 and 5
    }
}
