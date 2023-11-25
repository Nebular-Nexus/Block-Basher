import java.awt.Rectangle;

public class CollisionConnector {
    private BrickManager brickManager;
    private ScoreConnector scoreConnector;
    public CollisionConnector(BrickManager brickManager,ScoreConnector scoreConnector) {
        this.brickManager = brickManager;
        this.scoreConnector = scoreConnector;
    }

    public void checkCollisions(BallController ballController) {
        Brick bricks[][] = this.brickManager.getBricks();
        A:
        for (int i = 0; i < this.brickManager.getBricks().length; i++) {
            for (int j = 0; j < this.brickManager.getBricks()[0].length; j++) {
                if (bricks[i][j].getDurability()> 0) {
                    int brickX = j * bricks[i][j].getX().intValue()+ 80;
                    int brickY = i * bricks[i][j].getY().intValue() + 50;
                    int bricksWidth = bricks[i][j].getX().intValue();
                    int bricksHeight = bricks[i][j].getY().intValue();

                    Rectangle rect = new Rectangle(brickX, brickY, bricksWidth, bricksHeight);
                    Rectangle ballrect = new Rectangle(ballController.getBallPositionX(),ballController.getBallPositionY(), 20, 20);
                    Rectangle brickrect = rect;

                    if (ballrect.intersects(brickrect)) {
                        bricks[i][j].setDurability(bricks[i][j].getDurability()-1);
                        this.scoreConnector.updateScore(1);
                        if (ballController.getBallPositionX() + 19 <= brickrect.x || ballController.getBallPositionX() + 1 >= brickrect.x + bricksWidth) {
                            ballController.setBallDirX(ballController.getBallDirX()*-1); 
                        } else {
                            ballController.setBallDirY(ballController.getBallDirY()*-1);;
                        }
                        break A;
                    }
                }


            }
        }
        // brickManager.updateBrickDurability(ballController);
    }
    

}
