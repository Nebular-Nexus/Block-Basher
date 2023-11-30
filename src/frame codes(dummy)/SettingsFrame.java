import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame {
    private DifficultyManager difficultyManager;
    private CustomizationManager customizationManager;
    public SettingsFrame(DifficultyManager difficultyManager, CustomizationManager customizationManager) {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(true);
        setLocationRelativeTo(null);
        

        JButton difficultyButton = new JButton("Difficulty Level");
        difficultyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DifficultyFrame difficultyFrame =  new DifficultyFrame(difficultyManager);
                
                dispose();
            }
        });

        JButton paddleButton = new JButton("Paddle Design");
        paddleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        JButton ballButton = new JButton("Ball Design");
        ballButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JButton backgroundButton = new JButton("Background Button");
        backgroundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JPanel panel = new JPanel();
        panel.add(difficultyButton);
        panel.add(paddleButton);
        panel.add(ballButton);
        panel.add(backgroundButton);
        // panel.add(paddleButton);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuFrame menuFrame = new MenuFrame();
            menuFrame.setVisible(true);
        });
    }
}

