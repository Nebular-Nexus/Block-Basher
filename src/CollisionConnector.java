public class CollisionConnector {
    private BrickManager brickManager;

    public CollisionConnector(BrickManager brickManager) {
        this.brickManager = brickManager;
    }

    public void checkCollisions(BallController ballController) {
        brickManager.updateBrickDurability(ballController);
    }
}
