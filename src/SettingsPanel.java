// SettingsPanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {
    private CustomizationManager customizationManager;
    private DifficultyManager difficultyManager;

    public SettingsPanel(CustomizationManager customizationManager,DifficultyManager difficultyManager, MenuFrame menuFrame) {
        this.customizationManager = customizationManager;
        this.difficultyManager = difficultyManager;

        JLabel ballColorLabel = new JLabel("Ball Color:");
        JTextField ballColorTextField = new JTextField(10);

        JLabel paddleDesignLabel = new JLabel("Paddle Design:");
        JTextField paddleDesignTextField = new JTextField(10);

        JLabel backgroundThemeLabel = new JLabel("Background Theme:");
        JTextField backgroundThemeTextField = new JTextField(10);

        JLabel difficultyLevelLabel = new JLabel("Difficulty Level:");
        JTextField difficultyLevelTextField = new JTextField(10);
        
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSettings();
                System.out.println("Settings saved!");
                menuFrame.showMenu();  // Show the menu after saving settings
            }
        });

        setLayout(new GridLayout(4, 2));
        add(ballColorLabel);
        add(ballColorTextField);
        add(paddleDesignLabel);
        add(paddleDesignTextField);
        add(backgroundThemeLabel);
        add(backgroundThemeTextField);
        add(difficultyLevelLabel);
        add(difficultyLevelTextField);
        add(saveButton);
    }

    private void saveSettings() {
        customizationManager.setBallColor(getText("Ball Color:"));
        customizationManager.setPaddleDesign(getText("Paddle Design:"));
        customizationManager.setBackgroundTheme(getText("Background Theme:"));
        difficultyManager.setLevel(Integer.parseInt(getText("Difficulty Level:")));

    }

    private String getText(String labelText) {
        // Extracts text from the JLabel and removes the label part
        for (Component component : getComponents()) {
            if (component instanceof JLabel && ((JLabel) component).getText().equals(labelText)) {
                Component nextComponent = getComponent(getComponentZOrder(component) + 1);
                if (nextComponent instanceof JTextField) {
                    return ((JTextField) nextComponent).getText();
                }
            }
        }
        return "";
    }
}
