import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyFrame {
    private String difficulty;
    private boolean soundEnabled;

    private JComboBox<String> difficultyComboBox;
    private JCheckBox soundEffectsCheckbox;
    private JButton saveButton;

    public DifficultyFrame() {
        // Initialize GUI components
        difficultyComboBox = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        difficultyComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                difficulty = (String) difficultyComboBox.getSelectedItem();
            }
        });

        soundEffectsCheckbox = new JCheckBox("Enable Sound Effects");
        soundEffectsCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                soundEnabled = soundEffectsCheckbox.isSelected();
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSettings();
            }
        });
    }

    private void saveSettings() {
        // Save the user settings here
        // You may want to save to a file, database, or some persistent storage
        // For simplicity, let's assume it's just closing the settings frame
        settingsFrame.dispose();
    }

    // Apply the saved settings to the game when it starts
    public void startGame(Game game, boolean settingsButtonState) {
        if (settingsButtonState) {
            // Apply the saved settings to the game
            game.setDifficulty(difficulty);
            game.setSoundEnabled(soundEnabled);
        } else {
            // Use the default settings
        }
    }

    // Assume settingsFrame is a reference to the frame containing these components
    private JFrame settingsFrame;

    // Setter method for the settings frame
    public void setSettingsFrame(JFrame settingsFrame) {
        this.settingsFrame = settingsFrame;
    }

    // Getter methods for difficulty and soundEnabled
    public String getDifficulty() {
        return difficulty;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public static void main(String[] args) {
        // Example usage:
        DifficultyFrame gameSettings = new DifficultyFrame();
        JFrame frame = new JFrame("Game Settings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components to the frame

        frame.pack();
        frame.setVisible(true);
    }
}

