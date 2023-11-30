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
        addLabelAndTextField("Ball Color:", "BLACK", gbc);

        // Paddle Design
        // addLabelAndTextField("Paddle Design:", customizationManager.getPaddleDesign(), gbc);

        // Background Theme
        addLabelAndTextField("Background Theme:","WHITE", gbc);

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

        String ballColorInput = getText(labelTextFieldMap.get(getLabel("Ball Color:")));
        Color ballColor = parseColor(ballColorInput);
        customizationManager.setBallColor(ballColor);
        String backgroundColorInput =getText(labelTextFieldMap.get(getLabel("Background Theme:")));
        Color backGroundColor = parseColor(backgroundColorInput);
        // customizationManager.setPaddleDesign(getText(labelTextFieldMap.get(getLabel("Paddle Design:"))));
        customizationManager.setBackgroundTheme(backGroundColor);
        System.out.println(getText(labelTextFieldMap.get(getLabel("Ball Color:"))));
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
