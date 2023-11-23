public class PaddleController {
    private int paddlePosition;
    private int paddleWidth;
    private InputConnector inputConnector;

    public PaddleController(InputConnector inputConnector,int paddleWidth,int paddlePosition) {
        this.inputConnector = inputConnector;
        this.paddleWidth = this.paddleWidth;
        this.paddlePosition = this.paddlePosition;
    }

    public void moveLeft() {
        // Move paddle to the left
        paddlePosition -= 5; // For example: Adjust the position by a fixed amount
    }

    public void moveRight() {
        // Move paddle to the right
        paddlePosition += 5; // For example: Adjust the position by a fixed amount
    }

    public void handleInput() {
        // Handling input events using InputConnector
        if (inputConnector.isLeftKeyPressed()) {
            moveLeft();
        } else if (inputConnector.isRightKeyPressed()) {
            moveRight();
        }
    }
}
