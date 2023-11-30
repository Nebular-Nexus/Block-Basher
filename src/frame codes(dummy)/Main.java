import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Start Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(3, 1));

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Main1 main1 = new Main1();
                // gameEngine.setVisible(true);
                // dispose();
                // Handle start game button click here
                // System.out.println("Start Game clicked");
            }
        });

        JButton settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle settings button click here
                System.out.println("Settings clicked");
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle exit button click here
                System.out.println("Exit clicked");
                System.exit(0);
            }
        });

        panel.add(startButton);
        panel.add(settingsButton);
        panel.add(exitButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}