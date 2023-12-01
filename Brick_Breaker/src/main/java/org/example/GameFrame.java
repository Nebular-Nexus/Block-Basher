package org.example;

import java.awt.Color;

import javax.swing.*;

public class GameFrame extends JFrame {
    private GameEngine gameEngine;
    public GameFrame(DifficultyManager difficultyManager,CustomizationManager customizationManager) {
        setTitle("Block Basher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        setSize(800, 600); // Set your preferred size
        setLocationRelativeTo(null);
        // getContentPane().setBackground(customizationManager.getBackgroundTheme());
        gameEngine = new GameEngine(difficultyManager,customizationManager); // Your GameEngine JPanel

        add(gameEngine);
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         GameFrame gameFrame = new GameFrame();
    //         gameFrame.setVisible(true);
    //     });
    // }
}
