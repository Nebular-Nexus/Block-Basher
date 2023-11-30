import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    public MenuFrame() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(true);
        setLocationRelativeTo(null);

        DifficultyManager difficultyManager = new DifficultyManager(1);
        CustomizationManager customizationManager = new CustomizationManager();
        

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameFrame gameFrame = new GameFrame();
                gameFrame.setVisible(true);
                dispose();
            }
        });

        // JButton settingsButton = new JButton("Settings Game");
        // settingsButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         SettingsFrame settingsFrame = new SettingsFrame(difficultyManager,customizationManager);
        //         settingsFrame.setVisible(true);
        //         dispose();
        //     }
        // });

        JPanel panel = new JPanel();
        panel.add(startButton);
        // panel.add(settingsButton);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuFrame menuFrame = new MenuFrame();
            menuFrame.setVisible(true);
        });
    }
}
