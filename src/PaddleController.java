import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class PaddleController {
    private int paddlePosition;
    private int paddleWidth;
    private InputConnector inputConnector;

    public PaddleController(InputConnector inputConnector,int paddleWidth,int paddlePosition) {
        this.inputConnector = inputConnector;
        this.paddleWidth = paddleWidth;
        this.paddlePosition =paddlePosition;
    }

    public void moveLeft() {
        // Move paddle to the left
        this.paddlePosition -= 5; // For example: Adjust the position by a fixed amount
    }

    public void moveRight() {
        // Move paddle to the right
        this.paddlePosition += 5; // For example: Adjust the position by a fixed amount
    }

    public void handleInput(KeyEvent e) {
        // Handling input events using InputConnector
        // if (inputConnector.isLeftKeyPressed(e)) {
        //     moveLeft();
        // } else if (inputConnector.isRightKeyPressed(e)) {
        //     moveRight();
        // }

        if(inputConnector.keyPressed(e).equals("left")){
            moveLeft();
        }
        else{
            moveRight();
        }
    }

    public void paddleDisplay(Graphics2D g)
    {
        g.setColor(Color.black);
        g.fillRect(this.paddlePosition, 550, 100, 8);
    }


}
