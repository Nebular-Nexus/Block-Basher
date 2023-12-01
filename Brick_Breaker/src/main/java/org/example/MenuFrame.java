package org.example;

import javax.swing.*;
import java.awt.*;

//public class MenuFrame extends JFrame {
//    private CardLayout cardLayout;
//    private JPanel cardPanel;
//    private DifficultyManager difficultyManager;
//    private CustomizationManager customizationManager;
//
//    public MenuFrame() {
//        setTitle("Game Menu");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600);
//        setResizable(true);
//        setLocationRelativeTo(null);
//
//        difficultyManager = new DifficultyManager(1);
//        customizationManager = new CustomizationManager();
//
//        cardLayout = new CardLayout();
//        cardPanel = new JPanel(cardLayout);
//
//        JPanel menuPanel = createMenuPanel();
//        SettingsPanel settingsPanel = new SettingsPanel(customizationManager, difficultyManager, this);
//
//        cardPanel.add(menuPanel, "menu");
//        cardPanel.add(settingsPanel, "settings");
//
//        add(cardPanel, BorderLayout.CENTER);
//
//        showMenu();  // Show the menu initially
//    }
//
//    private JPanel createMenuPanel() {
//        JButton startButton = new JButton("Start Game");
//        startButton.addActionListener(e -> {
//            GameFrame gameFrame = new GameFrame(this.difficultyManager,this.customizationManager);
//            gameFrame.setVisible(true);
//            System.out.println("Game started!");
//            printSettings();
//        });
//
//        JButton settingsButton = new JButton("Settings");
//        settingsButton.addActionListener(e -> showSettings());
//
//        JPanel panel = new JPanel();
//        panel.add(startButton);
//        panel.add(settingsButton);
//        return panel;
//    }
//
//    private void printSettings() {
//        System.out.println("Ball Color: " + customizationManager.getBallColor());
//        // System.out.println("Paddle Design: " + customizationManager.getPaddleDesign());
//        System.out.println("Background Theme: " + customizationManager.getBackgroundTheme());
//        System.out.println("Difficulty Level: " + difficultyManager.getLevel());
//
//    }
//
//    public void showMenu() {
//        cardLayout.show(cardPanel, "menu");
//    }
//
//    private void showSettings() {
//        cardLayout.show(cardPanel, "settings");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            MenuFrame menuFrame = new MenuFrame();
//            menuFrame.setVisible(true);
//        });
//    }
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class RoundButton extends JButton {
//    public RoundButton(String label) {
//        super(label);
//        setFocusPainted(false);
//        setContentAreaFilled(false);
//
//        setPreferredSize(new Dimension(100, 50));
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//
//        if (getModel().isArmed()) {
//            g.setColor(Color.lightGray);
//        } else {
//            g.setColor(getBackground());
//        }
//        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);
//
//        super.paintComponent(g);
//    }
//
//    @Override
//    protected void paintBorder(Graphics g) {
//        g.setColor(Color.black);
//        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);
//    }
//}
//
//public class MenuFrame extends JFrame {
//    private CardLayout cardLayout;
//    private JPanel cardPanel;
//    private DifficultyManager difficultyManager;
//    private CustomizationManager customizationManager;
//
//    public MenuFrame() {
//        setTitle("Block Basher");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600);
//        setResizable(false);
//        setLocationRelativeTo(null);
//
//        difficultyManager = new DifficultyManager(1);
//        customizationManager = new CustomizationManager();
//
//        cardLayout = new CardLayout();
//        cardPanel = new JPanel(cardLayout);
//
//        JPanel menuPanel = createMenuPanel();
//        SettingsPanel settingsPanel = new SettingsPanel(customizationManager, difficultyManager, this);
//
//        cardPanel.add(menuPanel, "menu");
//        cardPanel.add(settingsPanel, "settings");
//
//        add(cardPanel, BorderLayout.CENTER);
//
//        showMenu();  // Show the menu initially
//    }
//
//    private JPanel createMenuPanel() {
//        Font titleFont = new Font("Press Start 2P", Font.PLAIN, 36);
//
//        JLabel titleLabel = new JLabel("Block Basher");
//        titleLabel.setFont(titleFont);
//        titleLabel.setHorizontalAlignment(JLabel.CENTER);
//
//        RoundButton startButton = new RoundButton("Start");
//        startButton.addActionListener(e -> {
//            GameFrame gameFrame = new GameFrame(this.difficultyManager, this.customizationManager);
//            gameFrame.setVisible(true);
//            System.out.println("Game started!");
//            printSettings();
//        });
//
//        RoundButton settingsButton = new RoundButton("Settings");
//        settingsButton.addActionListener(e -> showSettings());
//
//        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 30));
//        buttonPanel.add(startButton);
//        buttonPanel.add(settingsButton);
//
//        JPanel mainMenuPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        mainMenuPanel.add(titleLabel, gbc);
//
//        gbc.gridy = 1;
//        mainMenuPanel.add(buttonPanel, gbc);
//
//        return mainMenuPanel;
//    }
//
//    private void printSettings() {
//        System.out.println("Ball Color: " + customizationManager.getBallColor());
//        System.out.println("Background Theme: " + customizationManager.getBackgroundTheme());
//        System.out.println("Difficulty Level: " + difficultyManager.getLevel());
//    }
//
//    public void showMenu() {
//        cardLayout.show(cardPanel, "menu");
//    }
//
//    private void showSettings() {
//        cardLayout.show(cardPanel, "settings");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            try {
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            MenuFrame menuFrame = new MenuFrame();
//            menuFrame.setVisible(true);
//        });
//    }
//}

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//class RoundButton extends JButton {
//    public RoundButton(String label) {
//        super(label);
//        setFocusPainted(false);
//        setContentAreaFilled(false);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        if (getModel().isArmed()) {
//            g.setColor(Color.lightGray);
//        } else {
//            g.setColor(getBackground());
//        }
//        g.fillRoundRect(200, 20, getSize().width/2, getSize().height/3, 15, 15);
//
//        super.paintComponent(g);
//    }
//
//    @Override
//    protected void paintBorder(Graphics g) {
//        g.setColor(Color.black);
//        g.drawRoundRect(200, 0, getSize().width/2, getSize().height/3, 15, 15);
//    }
//}
//
//public class MenuFrame extends JFrame {
//    private CardLayout cardLayout;
//    private JPanel cardPanel;
//
//
//    private DifficultyManager difficultyManager;
//
//    private CustomizationManager customizationManager;
//
//    public MenuFrame() {
//        setTitle("Block Basher");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600);
//        setResizable(false);
//        setLocationRelativeTo(null);
//
//
//        difficultyManager = new DifficultyManager(1);
//
//        customizationManager = new CustomizationManager();
//
//        cardLayout = new CardLayout();
//        cardPanel = new JPanel(cardLayout);
//
//        JPanel menuPanel = createMenuPanel();
//
//
//        SettingsPanel settingsPanel = new SettingsPanel(customizationManager, difficultyManager, this);
//
//        cardPanel.add(menuPanel, "menu");
//        cardPanel.add(settingsPanel, "settings");
//
//        add(cardPanel, BorderLayout.CENTER);
//
//        showMenu();  // Show the menu initially
//    }
//
//    private JPanel createMenuPanel() {
//        // Use a custom font for the title
//        Font titleFont = new Font("Press Start 2P", Font.PLAIN, 36);
//
//        // Create a big title label
//        JLabel titleLabel = new JLabel("Block Basher");
//        titleLabel.setFont(titleFont);
//        titleLabel.setHorizontalAlignment(JLabel.CENTER);
//
//        // Create circular buttons
//        RoundButton startButton = new RoundButton("Start Game");
//        startButton.addActionListener(e -> {
//
//
//            GameFrame gameFrame = new GameFrame(this.difficultyManager, this.customizationManager);
//
//            gameFrame.setVisible(true);
//            System.out.println("Game started!");
//            printSettings();
//        });
//
//        RoundButton settingsButton = new RoundButton("Settings");
//        settingsButton.addActionListener(e -> showSettings());
//
//        // Use a layout manager for better organization
//        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
//        buttonPanel.add(startButton);
//        buttonPanel.add(settingsButton);
//
//        // Create a panel for the buttons with centered alignment
//        JPanel buttonPanelContainer = new JPanel(new BorderLayout());
//        buttonPanelContainer.add(buttonPanel, BorderLayout.CENTER);
//
//        // Create the main menu panel
//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(titleLabel, BorderLayout.NORTH);
//        panel.add(buttonPanelContainer, BorderLayout.CENTER);
//        return panel;
//    }
//
//    private void printSettings() {
//        System.out.println("Ball Color: " + customizationManager.getBallColor());
//        System.out.println("Background Theme: " + customizationManager.getBackgroundTheme());
//        System.out.println("Difficulty Level: " + difficultyManager.getLevel());
//    }
//
//    public void showMenu() {
//        cardLayout.show(cardPanel, "menu");
//    }
//
//    private void showSettings() {
//        cardLayout.show(cardPanel, "settings");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            try {
//                // Use the system look and feel for a native appearance
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            MenuFrame menuFrame = new MenuFrame();
//            menuFrame.setVisible(true);
//        });
//    }
//}

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MenuFrame extends JFrame {
//    private CardLayout cardLayout;
//    private JPanel cardPanel;
//
//
//    private DifficultyManager difficultyManager;
//
//    private CustomizationManager customizationManager;
//
//    public MenuFrame() {
//        setTitle("Game Menu");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600);
//        setResizable(false); // To maintain a fixed size
//        setLocationRelativeTo(null);
//
//        difficultyManager = new DifficultyManager(1);
//        customizationManager = new CustomizationManager();
//
//        cardLayout = new CardLayout();
//        cardPanel = new JPanel(cardLayout);
//
//        JPanel menuPanel = createMenuPanel();
//        SettingsPanel settingsPanel = new SettingsPanel(customizationManager, difficultyManager, this);
//
//        cardPanel.add(menuPanel, "menu");
//        cardPanel.add(settingsPanel, "settings");
//
//        add(cardPanel, BorderLayout.CENTER);
//
//        showMenu();  // Show the menu initially
//    }
//
//    private JPanel createMenuPanel() {
//        JButton startButton = new JButton("Start Game");
//        startButton.addActionListener(e -> {
//            GameFrame gameFrame = new GameFrame(this.difficultyManager, this.customizationManager);
//            gameFrame.setVisible(true);
//            System.out.println("Game started!");
//            printSettings();
//        });
//
//        JButton settingsButton = new JButton("Settings");
//        settingsButton.addActionListener(e -> showSettings());
//
//        // Use a layout manager for better organization
//        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
//        buttonPanel.add(startButton);
//        buttonPanel.add(settingsButton);
//
//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(buttonPanel, BorderLayout.CENTER);
//        return panel;
//    }
//
//    private void printSettings() {
//        System.out.println("Ball Color: " + customizationManager.getBallColor());
//        // System.out.println("Paddle Design: " + customizationManager.getPaddleDesign());
//        System.out.println("Background Theme: " + customizationManager.getBackgroundTheme());
//        System.out.println("Difficulty Level: " + difficultyManager.getLevel());
//    }
//
//    public void showMenu() {
//        cardLayout.show(cardPanel, "menu");
//    }
//
//    private void showSettings() {
//        cardLayout.show(cardPanel, "settings");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            try {
//                // Use the system look and feel for a native appearance
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            MenuFrame menuFrame = new MenuFrame();
//            menuFrame.setVisible(true);
//        });
//    }
//}

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private DifficultyManager difficultyManager;
    private CustomizationManager customizationManager;

    public MenuFrame() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(true);
        setLocationRelativeTo(null);

        difficultyManager = new DifficultyManager(1);
        customizationManager = new CustomizationManager();

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(new Color(240, 240, 240));

        JPanel menuPanel = createMenuPanel();
        menuPanel.setBackground(new Color(240, 240, 240));

        SettingsPanel settingsPanel = new SettingsPanel(customizationManager, difficultyManager, this);

        cardPanel.add(menuPanel, "menu");
        cardPanel.add(settingsPanel, "settings");

        add(cardPanel, BorderLayout.CENTER);

        showMenu();  // Show the menu initially
    }

//    private JPanel createMenuPanel() {
//        JButton startButton = new JButton("Start Game");
//        startButton.addActionListener(e -> {
//            GameFrame gameFrame = new GameFrame(this.difficultyManager,this.customizationManager);
//            gameFrame.setVisible(true);
//            System.out.println("Game started!");
//            printSettings();
//        });
//        customizeButton(startButton);
//
//        JButton settingsButton = new JButton("Settings");
//        settingsButton.addActionListener(e -> showSettings());
//        customizeButton(settingsButton);
//
//        JPanel panel = new JPanel();
//        panel.add(startButton);
//        panel.add(settingsButton);
//        return panel;
//    }


    private JPanel createMenuPanel() {
        // Create a panel to hold the title and buttons
        JPanel menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setBackground(new Color(240, 240, 240));

        // Create the title label
        JLabel titleLabel = new JLabel("Block Basher");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));

        // Create and customize the "Start Game" button
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame(this.difficultyManager, this.customizationManager);
            gameFrame.setVisible(true);
            System.out.println("Game started!");
            printSettings();
        });
        customizeButton(startButton);

        // Create and customize the "Settings" button
        JButton settingsButton = new JButton("Settings");
        settingsButton.addActionListener(e -> showSettings());
        customizeButton(settingsButton);

        // Use GridBagConstraints for positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0); // Add spacing between title and buttons
        menuPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        menuPanel.add(startButton, gbc);

        gbc.gridy = 2;
        menuPanel.add(settingsButton, gbc);

        return menuPanel;
    }



    private void customizeButton(JButton button) {
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(150, 40));
    }

    private void printSettings() {
        System.out.println("Ball Color: " + customizationManager.getBallColor());
        System.out.println("Background Theme: " + customizationManager.getBackgroundTheme());
        System.out.println("Difficulty Level: " + difficultyManager.getLevel());
    }

    public void showMenu() {
        cardLayout.show(cardPanel, "menu");
    }

    private void showSettings() {
        cardLayout.show(cardPanel, "settings");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuFrame menuFrame = new MenuFrame();
            menuFrame.setVisible(true);
        });
    }
}

