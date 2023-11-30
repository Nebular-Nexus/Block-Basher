import java.awt.Rectangle;

public class CollisionConnector {
    // private BrickManager brickManager;
    // private ScoreConnector scoreConnector;
    // public CollisionConnector(BrickManager brickManager,ScoreConnector scoreConnector) {
        // brickManager = brickManager;
        // scoreConnector = scoreConnector;
    // }

    public CollisionConnector(){}

    public void checkCollisions(BallController ballController,BrickManager brickManager,PaddleController paddleController,ScoreConnector scoreConnector) {



        if (new Rectangle(ballController.getBallPositionX(), ballController.getBallPositionY(), 20, 20).intersects(new Rectangle(paddleController.getPaddlePosition(), 550,paddleController.getpaddlewidth(), 8))) {
            ballController.setBallDirY(-1*ballController.getBallDirY());;
        }


        Brick bricks[][] = brickManager.getBricks();
        A:
        for (int i = 0; i < brickManager.getBricks().length; i++) {
            for (int j = 0; j < brickManager.getBricks()[0].length; j++) {
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
                        scoreConnector.updateScore(1);
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
    }
    

}
