public class BallController {
    private int ballPositionX;
    private int ballPositionY;
    private int ballSpeedX;
    private int ballSpeedY;
    private int ballDirX;
    private int ballDirY;
    private CollisionConnector collisionConnector;

    public BallController(int ballPositionX, int ballPositionY, int ballSpeedX, int ballSpeedY, int ballDirX,
            int ballDirY, CollisionConnector collisionConnector) {
        this.ballPositionX = ballPositionX;
        this.ballPositionY = ballPositionY;
        this.ballSpeedX = ballSpeedX;
        this.ballSpeedY = ballSpeedY;
        this.ballDirX = ballDirX;
        this.ballDirY = ballDirY;
        this.collisionConnector = collisionConnector;
    }

    public void move() {
        // Move the ball
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

    public int getBallSpeedX() {
        return this.ballSpeedX;
    }

    public void setBallSpeedX(int ballSpeedX) {
        this.ballSpeedX = ballSpeedX;
    }

    public int getBallSpeedY() {
        return this.ballSpeedY;
    }

    public void setBallSpeedY(int ballSpeedY) {
        this.ballSpeedY = ballSpeedY;
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
    
    public void checkCollisions()
    {
        this.collisionConnector.checkCollisions(this);
    }
}

