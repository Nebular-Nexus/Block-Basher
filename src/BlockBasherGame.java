// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class BlockBasherGame {
//     private static final int WINDOW_WIDTH = 800;
//     private static final int WINDOW_HEIGHT = 600;
//     private static final int BALL_DIAMETER = 20;
//     private static final int FPS = 125;
//     private static final int BALL_SPEED = 3;

//     private int ballX = WINDOW_WIDTH / 2;
//     private int ballY = WINDOW_HEIGHT / 2;
//     private int ballXSpeed = BALL_SPEED;
//     private int ballYSpeed = BALL_SPEED;

//     public BlockBasherGame() {
//         JFrame frame = new JFrame("Block Basher Game");
//         frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLocationRelativeTo(null);
//         frame.setResizable(true);;
        
//         JPanel gamePanel = new JPanel() {
//             @Override
//             protected void paintComponent(Graphics g) {
//                 super.paintComponent(g);
//                 g.setColor(Color.BLACK);
//                 g.fillOval(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);
//             }
//         };

//         frame.add(gamePanel);
//         frame.setVisible(true);

//         Timer timer = new Timer(1000 / FPS, new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 ballX += ballXSpeed;
//                 ballY += ballYSpeed;

//                 if (ballX <= 0 || ballX >= WINDOW_WIDTH - BALL_DIAMETER) {
//                     ballXSpeed *= -1;
//                 }
//                 if (ballY <= 0 || ballY >= WINDOW_HEIGHT - BALL_DIAMETER) {
//                     ballYSpeed *= -1;
//                 }

//                 // Adjusting ball position to stay within screen boundaries
//                 if (ballX < 0) {
//                     ballX = 0;
//                 } else if (ballX > WINDOW_WIDTH - BALL_DIAMETER) {
//                     ballX = WINDOW_WIDTH - BALL_DIAMETER;
//                 }
//                 if (ballY < 0) {
//                     ballY = 0;
//                 } else if (ballY > WINDOW_HEIGHT - BALL_DIAMETER) {
//                     ballY = WINDOW_HEIGHT - BALL_DIAMETER;
//                 }

//                 gamePanel.repaint();
//             }
//         });
//         timer.start();
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new BlockBasherGame());
//     }
// }
