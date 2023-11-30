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
    private boolean play = true;

    public GameEngine(){
        this.initializeGame();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g); // Ensure the panel is properly painted

        Graphics2D g2d = (Graphics2D) g;

        // g.setColor(Color.black);
        // g.fillRect(1, 1, 692, 592);
        this.paddleController.paddleDisplay(g2d);
        this.brickManager.drawBricks(g2d);
        this.ballController.ballDisplay(g2d);
        this.paddleController.paddleDisplay((Graphics2D) g);
        this.scoreConnector.scoreDisplay(g2d);
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


        // this.collisionConnector = new CollisionConnector(this.brickManager,this.scoreConnector);
        this.collisionConnector = new CollisionConnector();
        this.ballController = new BallController(ballposX,ballposY,1,ballXdir,ballYdir,this.collisionConnector);


        this.inputHandler = new InputHandler();
        this.inputConnector = new InputConnector(this.inputHandler);

        this.paddleController = new PaddleController(this.inputConnector,100,310);


        this.errorHandler = new ErrorHandler();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play){
            this.ballController.move(this.brickManager, this.paddleController, this.scoreConnector);
        }
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
        // System.out.println("press");
        if(this.inputConnector.keyPressed(e).equals("enter")){
            if(!play){
                play=true;
            }  
        }
        this.paddleController.handleInput(e);
        }

    // @Override
    // public void actionPerformed(ActionEvent arg0) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    // }
}

