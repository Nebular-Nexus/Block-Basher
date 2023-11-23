public class BallController {
    private int ballPositionX;
    private int ballPositionY;
    private int ballSpeedX;
    private int ballSpeedY;

    public void move() {
        // Move the ball
    }

    private CollisionConnector collisionConnector;

    public BallController(CollisionConnector collisionConnector) {
        this.collisionConnector = collisionConnector;
    }

    public void checkCollisions() {
        collisionConnector.checkCollisions(this);
    }
}

