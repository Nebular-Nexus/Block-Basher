import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        GameEngine gameEngine = new GameEngine();
        obj.setBounds(10,10,700,600);
        obj.setTitle("Breakout Ball");
        // obj.getContentPane().setBackground(Color.black);
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameEngine);
    }
}


