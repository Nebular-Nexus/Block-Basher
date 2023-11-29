import java.awt.event.KeyEvent;

public class InputConnector {
    private InputHandler inputHandler;

    public InputConnector(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public boolean isLeftKeyPressed(KeyEvent e) {
        return inputHandler.isLeftKeyPressed(e);
    }

    public boolean isRightKeyPressed(KeyEvent e) {
        return inputHandler.isLeftKeyPressed(e);
    }

    public String keyPressed(KeyEvent e){
        return inputHandler.keyPressed(e);
    }
}
