// import javax.swing.*;
// import java.awt.*;

// public class MenuFrame extends JFrame {
//     private CardLayout cardLayout;
//     private JPanel cardPanel;
//     private DifficultyManager difficultyManager;
//     private CustomizationManager customizationManager;

//     public MenuFrame() {
//         setTitle("Game Menu");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(800, 600);
//         setResizable(true);
//         setLocationRelativeTo(null);

//         difficultyManager = new DifficultyManager(1);
//         customizationManager = new CustomizationManager();

//         cardLayout = new CardLayout();
//         cardPanel = new JPanel(cardLayout);

//         JPanel menuPanel = createMenuPanel();
//         SettingsPanel settingsPanel = new SettingsPanel(customizationManager, difficultyManager, this);

//         cardPanel.add(menuPanel, "menu");
//         cardPanel.add(settingsPanel, "settings");

//         add(cardPanel, BorderLayout.CENTER);

//         showMenu();  // Show the menu initially
//     }

//     private JPanel createMenuPanel() {
//         JButton startButton = new JButton("Start Game");
//         startButton.addActionListener(e -> {
//             GameFrame gameFrame = new GameFrame(this.difficultyManager,this.customizationManager);
//             gameFrame.setVisible(true);
//             System.out.println("Game started!");
//             printSettings();
//         });

//         JButton settingsButton = new JButton("Settings");
//         settingsButton.addActionListener(e -> showSettings());

//         JPanel panel = new JPanel();
//         panel.add(startButton);
//         panel.add(settingsButton);
//         return panel;
//     }

//     private void printSettings() {
//         System.out.println("Ball Color: " + customizationManager.getBallColor());
//         // System.out.println("Paddle Design: " + customizationManager.getPaddleDesign());
//         System.out.println("Background Theme: " + customizationManager.getBackgroundTheme());
//         System.out.println("Difficulty Level: " + difficultyManager.getLevel());

//     }

//     public void showMenu() {
//         cardLayout.show(cardPanel, "menu");
//     }

//     private void showSettings() {
//         cardLayout.show(cardPanel, "settings");
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             MenuFrame menuFrame = new MenuFrame();
//             menuFrame.setVisible(true);
//         });
//     }
// }
