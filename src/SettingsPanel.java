import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SettingsPanel extends JPanel {
    private CustomizationManager customizationManager;
    private DifficultyManager difficultyManager;

    private Map<JLabel, JTextField> labelTextFieldMap;

    public SettingsPanel(CustomizationManager customizationManager, DifficultyManager difficultyManager, MenuFrame menuFrame) {
        this.customizationManager = customizationManager;
        this.difficultyManager = difficultyManager;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        labelTextFieldMap = new HashMap<>();

        // Ball Color
        addLabelAndTextField("Ball Color:", customizationManager.getBallColor(), gbc);

        // Paddle Design
        addLabelAndTextField("Paddle Design:", customizationManager.getPaddleDesign(), gbc);

        // Background Theme
        addLabelAndTextField("Background Theme:", customizationManager.getBackgroundTheme(), gbc);

        // Difficulty Level
        addLabelAndTextField("Difficulty Level:", String.valueOf(difficultyManager.getLevel()), gbc);

        // Save Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSettings();
                System.out.println("Settings saved!");
                menuFrame.showMenu();  // Show the menu after saving settings
            }
        });
        add(saveButton, gbc);
    }

    private void addLabelAndTextField(String labelText, String defaultValue, GridBagConstraints gbc) {
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(defaultValue, 10);

        gbc.gridx = 0;
        gbc.gridy++;
        add(label, gbc);

        gbc.gridx = 1;
        add(textField, gbc);

        labelTextFieldMap.put(label, textField);
    }

    private void saveSettings() {
        customizationManager.setBallColor(getText(labelTextFieldMap.get(getLabel("Ball Color:"))));
        customizationManager.setPaddleDesign(getText(labelTextFieldMap.get(getLabel("Paddle Design:"))));
        customizationManager.setBackgroundTheme(getText(labelTextFieldMap.get(getLabel("Background Theme:"))));

        try {
            int level = Integer.parseInt(getText(labelTextFieldMap.get(getLabel("Difficulty Level:"))));
            difficultyManager.setLevel(level);
        } catch (NumberFormatException e) {
            // Handle invalid input for difficulty level
            System.out.println("Invalid input for Difficulty Level!");
        }
    }

    private JLabel getLabel(String labelText) {
        for (Map.Entry<JLabel, JTextField> entry : labelTextFieldMap.entrySet()) {
            if (entry.getKey().getText().equals(labelText)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private String getText(JTextField textField) {
        return textField != null ? textField.getText() : "";
    }
}
