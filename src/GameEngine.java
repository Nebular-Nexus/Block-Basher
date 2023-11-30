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
    private boolean play = false;

    public GameEngine(){
        this.initializeGame();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g); // Ensure the panel is properly painted

        Graphics2D g2d = (Graphics2D) g;

        this.ui.paddleDisplay(this.paddleController,g2d);
        this.ui.ballDisplay(this.ballController, g2d);
        this.ui.scoreDisplay(this.scoreConnector, g2d);
        this.ui.drawBricks(this.brickManager,g2d);
    }

    public void initializeGame() {
    
        this.brickManager = new BrickManager(4,10);
        this.scoringSystem = new ScoringSystem(0);
        this.scoreConnector = new ScoreConnector(this.scoringSystem);
        this.customizationManager = new CustomizationManager();
       
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
    
        // public static void main(String[] args) {
        //     SwingUtilities.invokeLater(() -> {
        //         JFrame obj = new JFrame();
        //         GameEngine gameEngine = new GameEngine();
        //         obj.setBounds(10,10,700,600);
        //         obj.setTitle("Breakout Ball");
        //         // obj.getContentPane().setBackground(Color.black);
        //         obj.setResizable(true);
        //         obj.setVisible(true);
        //         obj.setLocationRelativeTo(null);
        //         obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //         obj.add(gameEngine);
        //     });
        // }
}

