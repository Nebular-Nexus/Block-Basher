import java.awt.event.KeyEvent;

public class InputConnector {
    private InputHandler inputHandler;

    public void InputConnector(){
        inputHandler = new InputHandler();
    }

    public boolean isLeftKeyPressed() {
        return inputHandler.isLeftKeyPressed();
    }

    public boolean isRightKeyPressed() {
        return inputHandler.isLeftKeyPressed();
    }
}
