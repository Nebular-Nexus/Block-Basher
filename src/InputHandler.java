import java.awt.event.KeyEvent;
public class InputHandler {
    private boolean leftKeyPressed;
    private boolean rightKeyPressed;
    public void handleKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftKeyPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKeyPressed = true;
        }
    }

    public void handleKeyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftKeyPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKeyPressed = false;
        }
    }

    public boolean isLeftKeyPressed(KeyEvent e) {
        handleKeyPressed(e);
        return leftKeyPressed;
    }

    public boolean isRightKeyPressed(KeyEvent e) {
        handleKeyPressed(e);
        return rightKeyPressed;
    }

    public String keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           return "left";
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            return "right";
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            return "enter";
        }
        return "none";
    }
}
