import javax.swing.*;

public class GameFrame extends JFrame {
    private GameEngine gameEngine;
    public GameFrame() {
        setTitle("Block Basher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        setSize(800, 600); // Set your preferred size
        setLocationRelativeTo(null);
        gameEngine = new GameEngine(); // Your GameEngine JPanel

        add(gameEngine);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame();
            gameFrame.setVisible(true);
        });
    }
}
