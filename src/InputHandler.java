import java.awt.event.KeyEvent;

public class InputHandler {
    public void handleKeyTyped(KeyEvent e) {
        // Handle key typed events
        // Not handling key typed events in this scenario
    }

    public void handleKeyPressed(KeyEvent e, PaddleController paddleController, GameEngine gameEngine) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                paddleController.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                paddleController.moveRight();
                break;
            case KeyEvent.VK_ENTER:
                gameEngine.initializeGame();
                gameEngine.start();
                break;
            // Add more cases for other keys if needed
        }
    }

    public void handleKeyReleased(KeyEvent e) {
        // Handle key released events
        // Not handling key released events in this scenario
    }
}
