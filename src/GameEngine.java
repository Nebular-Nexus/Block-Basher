import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.awt.*;

public class GameEngine extends JPanel implements KeyListener, ActionListener{
    private PaddleController paddleController;
    private BallController ballController;
    private BrickManager brickManager;
    private ScoringSystem scoringSystem;
    private CustomizationManager customizationManager;
    private DifficultyManager difficultyManager;
    private UserInterface ui;
    private InputHandler inputHandler;
    private ErrorHandler errorHandler;
    private CollisionConnector collisionConnector;
    private InputConnector inputConnector;
    private ScoreConnector scoreConnector;


    private int delay = 8;
    private Timer timer;
    private int ballposX=120;
    private int ballposY=350;
    private int ballXdir=-1;
    private int ballYdir=-2;

    public GameEngine(){
        this.initializeGame();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        this.brickManager.drawBricks((Graphics2D) g);
        this.ballController.ballDisplay((Graphics2D) g);
        this.paddleController.paddleDisplay((Graphics2D) g);
        this.scoreConnector.scoreDisplay((Graphics2D) g);
    }

    public void initializeGame() {
        // Initialize all game components
         // Create an instance of InputConnector 
         // Provide InputConnector to PaddleController
        
    
        this.brickManager = new BrickManager(4,10);
        this.scoringSystem = new ScoringSystem(0);
        this.scoreConnector = new ScoreConnector(this.scoringSystem);
        this.customizationManager = new CustomizationManager();
        this.difficultyManager = new DifficultyManager();
        this.ui = new UserInterface();


        this.collisionConnector = new CollisionConnector(this.brickManager,this.scoreConnector);
        this.ballController = new BallController(ballposX,ballposY,0,0,ballXdir,ballYdir,this.collisionConnector);


        this.inputHandler = new InputHandler();
        this.inputConnector = new InputConnector(this.inputHandler);

        this.paddleController = new PaddleController(this.inputConnector,10,310);


        this.errorHandler = new ErrorHandler();
    }

    public void updateGame() {
        // Perform game updates
        ballController.move();
        ballController.checkCollisions();
        // Other game updates
    }

    public void start() {
        // Start the game loop
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Timer.start();

        // if (play) {
        //     if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
        //         ballYdir = -ballYdir;
        //     }

        //     A:
        //     for (int i = 0; i < map.map.length; i++) {
        //         for (int j = 0; j < map.map[0].length; j++) {
        //             if (map.map[i][j] > 0) {
        //                 int brickX = j * map.bricksWidth + 80;
        //                 int brickY = i * map.bricksHeight + 50;
        //                 int bricksWidth = map.bricksWidth;
        //                 int bricksHeight = map.bricksHeight;

        //                 Rectangle rect = new Rectangle(brickX, brickY, bricksWidth, bricksHeight);
        //                 Rectangle ballrect = new Rectangle(ballposX, ballposY, 20, 20);
        //                 Rectangle brickrect = rect;

        //                 if (ballrect.intersects(brickrect)) {
        //                     map.setBricksValue(0, i, j);
        //                     totalbricks--;
        //                     score += 5;
        //                     if (ballposX + 19 <= brickrect.x || ballposX + 1 >= brickrect.x + bricksWidth) {
        //                         ballXdir = -ballXdir;
        //                     } else {
        //                         ballYdir = -ballYdir;
        //                     }
        //                     break A;
        //                 }
        //             }


        //         }
        //     }


        //     ballposX += ballXdir;
        //     ballposY += ballYdir;
        //     if (ballposX < 0) {
        //         ballXdir = -ballXdir;
        //     }
        //     if (ballposY < 0) {
        //         ballYdir = -ballYdir;
        //     }
        //     if (ballposX > 670) {
        //         ballXdir = -ballXdir;
        //     }
        // }
        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

       }


    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("press");
        this.paddleController.handleInput(e);
        // System.out.println(this.paddleController.position);
        // this.paddleController.move();
        // if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        //     if (playerX >= 600) {
        //         playerX = 600;
        //     } else {
        //         moveRight();
        //     }
        // }
        // if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        //     if (playerX < 10) {
        //         playerX = 10;
        //     } else {
        //         moveLeft();
        //     }
        // }

        // if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        //     if (!play) {
        //         ballposX = 120;
        //         ballposY = 350;
        //         ballXdir = -1;
        //         ballYdir = -2;
        //         score = 0;
        //         playerX = 310;
        //         totalbricks = 21;
        //         map = new MapGenerator(3, 7);

        //         repaint();
        //     }
        }

    // @Override
    // public void actionPerformed(ActionEvent arg0) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    // }
}

