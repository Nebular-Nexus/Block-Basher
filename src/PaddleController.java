import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class PaddleController {
    private int paddlePosition;

    private int paddleWidth;
    private InputConnector inputConnector;

    public int getPaddlePosition() {
        return paddlePosition;
    }

    public PaddleController(InputConnector inputConnector,int paddleWidth,int paddlePosition) {
        this.inputConnector = inputConnector;
        this.paddleWidth = paddleWidth;
        this.paddlePosition =paddlePosition;
    }

    public void moveLeft() {
        // Move paddle to the left
        if(this.paddlePosition>0){
            this.paddlePosition -= 5;
        }
    }

    public void moveRight() {
        // Move paddle to the right
        if(this.paddlePosition<600){
            this.paddlePosition += 5;
        }
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
        System.out.println(this.paddlePosition);
        System.out.println(this.paddleWidth);
        g.setColor(Color.black);
        g.fillRect(this.paddlePosition, 550, this.paddleWidth, 8);
    }
}
