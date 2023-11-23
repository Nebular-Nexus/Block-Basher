import java.awt.event.KeyEvent;

public class InputConnector {
    private InputHandler inputHandler;

    public void handleKeyTyped(KeyEvent e) {
        // Handle key typed events through InputHandler
        inputHandler.handleKeyTyped(e);
    }

    public void handleKeyPressed(KeyEvent e, PaddleController paddleController, GameEngine gameEngine) {
        // Handle key pressed events through InputHandler
        inputHandler.handleKeyPressed(e, paddleController, gameEngine);
    }

    public void handleKeyReleased(KeyEvent e) {
        // Handle key released events through InputHandler
        inputHandler.handleKeyReleased(e);
    }
}
