import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class BrickManager {
    private Brick bricks[][];

    public BrickManager(int row, int col) {
        bricks = new Brick[row][col];
        createBricks(row, col); // Initialize bricks here
    }

    public Brick[][] getBricks() {
        return bricks;
    }

    public void createBricks(Integer x, Integer y) {
        double bricksWidth = 540 / y;
        double bricksHeight = 150 / x;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Integer duraInteger = 1;
                Brick brick = new Brick(duraInteger, Color.blue, bricksWidth, bricksHeight);
                this.bricks[i][j] = brick;
            }
        }
    }

    public void drawBricks(Graphics2D g) {
        for (int i = 0; i < this.bricks.length; i++) {
            for (int j = 0; j < this.bricks[i].length; j++) {
                Brick brick = bricks[i][j];
                if (brick.getDurability() == 1) {
                    int brickX = j * brick.getX().intValue() + 80;
                    int brickY = i * brick.getY().intValue() + 50;

                    g.setColor(brick.getColor());
                    g.fillRect(brickX, brickY, brick.getX().intValue(), brick.getY().intValue());

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.white);
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
                if (bricks[i][j].getDurability() == 1) {
                    return false; // At least one brick is still intact
                }
            }
        }
        return true; // All bricks have been hit
    }
}
