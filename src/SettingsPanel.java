import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SettingsPanel extends JPanel {
    private CustomizationManager customizationManager;
    private DifficultyManager difficultyManager;

    private Map<JLabel, JComboBox<String>> labelComboBoxMap;

    public SettingsPanel(CustomizationManager customizationManager, DifficultyManager difficultyManager, MenuFrame menuFrame) {
        this.customizationManager = customizationManager;
        this.difficultyManager = difficultyManager;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        labelComboBoxMap = new HashMap<>();

        // Ball Color
        addLabelAndComboBox("Ball Color:", new String[]{"BLACK", "RED", "BLUE"}, gbc);

        // Paddle Design
        // addLabelAndComboBox("Paddle Design:", new String[]{"Design1", "Design2", "Design3"}, gbc);

        // Background Theme
        addLabelAndComboBox("Background Theme:", new String[]{"WHITE", "GRAY", "BLUE"}, gbc);

        // Difficulty Level
        addLabelAndComboBox("Difficulty Level:", new String[]{"1", "2", "3"}, gbc);

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

    private void addLabelAndComboBox(String labelText, String[] options, GridBagConstraints gbc) {
        JLabel label = new JLabel(labelText);
        JComboBox<String> comboBox = new JComboBox<>(options);

        gbc.gridx = 0;
        gbc.gridy++;
        add(label, gbc);

        gbc.gridx = 1;
        add(comboBox, gbc);

        labelComboBoxMap.put(label, comboBox);
    }

    private void saveSettings() {
        Color ballColor = parseColor((String) labelComboBoxMap.get(getLabel("Ball Color:")).getSelectedItem());
        customizationManager.setBallColor(ballColor);

        Color backGroundColor = parseColor((String) labelComboBoxMap.get(getLabel("Background Theme:")).getSelectedItem());
        customizationManager.setBackgroundTheme(backGroundColor);

        try {
            int level = Integer.parseInt((String) labelComboBoxMap.get(getLabel("Difficulty Level:")).getSelectedItem());
            difficultyManager.setLevel(level);
        } catch (NumberFormatException e) {
            // Handle invalid input for difficulty level
            System.out.println("Invalid input for Difficulty Level!");
        }
    }

    private JLabel getLabel(String labelText) {
        for (Map.Entry<JLabel, JComboBox<String>> entry : labelComboBoxMap.entrySet()) {
            if (entry.getKey().getText().equals(labelText)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private Color parseColor(String colorInput) {
        try {
            // Try to create a Color object using the Color class constants
            return (Color) Color.class.getField(colorInput.toUpperCase()).get(null);
        } catch (Exception e) {
            try {
                // If it's not a constant, try to decode it as a hex color
                return Color.decode(colorInput);
            } catch (NumberFormatException ex) {
                // Handle invalid color input
                System.out.println("Invalid color input: " + colorInput);
                return Color.BLACK; // or any default color
            }
        }
    }
}
