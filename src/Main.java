import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        GameEngine gameEngine = new GameEngine();
        obj.setBounds(10,10,700,600);
        obj.setTitle("Breakout Ball");
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameEngine);
    }
}


