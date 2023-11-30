import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

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

    private HashMap<Integer,Integer>difficulty_speed;
    private HashMap<Integer,Integer>difficulty_paddle_length;
    private HashMap<Integer,Integer>difficulty_paddle_speed;
    private int delay = 8;
    private Timer timer;
    private int ballposX=120;
    private int ballposY=350;
    private int ballXdir=-1;
    private int ballYdir=-2;
    private boolean play = false;

    public GameEngine(DifficultyManager difficultyManager,CustomizationManager customizationManager){
        this.difficultyManager = difficultyManager;
        this.customizationManager =customizationManager;
        this.difficulty_speed = new HashMap<>();
        this.difficulty_paddle_length = new HashMap<>();
        this.difficulty_paddle_speed = new HashMap<>();
        this.initializeGame();
        addKeyListener(this);
        setFocusable(true);
        setBackground(customizationManager.getBackgroundTheme());
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
    

        this.difficulty_speed.put(1,2);
        this.difficulty_speed.put(2,3);
        this.difficulty_speed.put(3,4);
        this.difficulty_paddle_length.put(1,200);
        this.difficulty_paddle_length.put(2,150);
        this.difficulty_paddle_length.put(3,125);
        this.difficulty_paddle_speed.put(1,10);
        this.difficulty_paddle_speed.put(2,20);
        this.difficulty_paddle_speed.put(3,30);
        this.brickManager = new BrickManager(4,10);
        this.scoringSystem = new ScoringSystem(0);
        this.scoreConnector = new ScoreConnector(this.scoringSystem);
        // this.customizationManager = new CustomizationManager();
       
        this.ui = new UserInterface();

        
        // this.collisionConnector = new CollisionConnector(this.brickManager,this.scoreConnector);
        this.collisionConnector = new CollisionConnector();
        
        this.ballController = new BallController(ballposX,ballposY,this.difficulty_speed.get(this.difficultyManager.getLevel()),ballXdir,ballYdir,this.collisionConnector,this.customizationManager.getBallColor());


        this.inputHandler = new InputHandler();
        this.inputConnector = new InputConnector(this.inputHandler);

        this.paddleController = new PaddleController(this.inputConnector,this.difficulty_paddle_length.get(this.difficultyManager.getLevel()),310,this.difficulty_paddle_speed.get(this.difficultyManager.getLevel()));


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

