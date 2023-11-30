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


        this.collisionConnector = new CollisionConnector(this.brickManager,this.scoreConnector);
        this.ballController = new BallController(ballposX,ballposY,0,0,ballXdir,ballYdir,this.collisionConnector);


        this.inputHandler = new InputHandler();
        this.inputConnector = new InputConnector(this.inputHandler);

        this.paddleController = new PaddleController(this.inputConnector,100,310);


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
        timer.start();

        if (play) {
            if (new Rectangle(this.ballController.getBallPositionX(), this.ballController.getBallPositionY(), 20, 20).intersects(new Rectangle(this.paddleController.getPaddlePosition(), 550, 100, 8))) {
                this.ballController.setBallDirY(-1*this.ballController.getBallDirY());;
            }

            Brick bricks[][] = this.brickManager.getBricks();
        A:
        for (int i = 0; i < this.brickManager.getBricks().length; i++) {
            for (int j = 0; j < this.brickManager.getBricks()[0].length; j++) {
                if (bricks[i][j].getDurability()> 0) {
                    int brickX = j * bricks[i][j].getX().intValue()+ 80;
                    int brickY = i * bricks[i][j].getY().intValue() + 50;
                    int bricksWidth = bricks[i][j].getX().intValue();
                    int bricksHeight = bricks[i][j].getY().intValue();

                    Rectangle rect = new Rectangle(brickX, brickY, bricksWidth, bricksHeight);
                    Rectangle ballrect = new Rectangle(ballController.getBallPositionX(),ballController.getBallPositionY(), 20, 20);
                    Rectangle brickrect = rect;

                    if (ballrect.intersects(brickrect)) {
                        bricks[i][j].setDurability(bricks[i][j].getDurability()-1);
                        this.scoreConnector.updateScore(1);
                        if (ballController.getBallPositionX() + 19 <= brickrect.x || ballController.getBallPositionX() + 1 >= brickrect.x + bricksWidth) {
                            ballController.setBallDirX(ballController.getBallDirX()*-1); 
                        } else {
                            ballController.setBallDirY(ballController.getBallDirY()*-1);;
                        }
                        break A;
                    }
                }


            }
        }


            this.ballController.setBallPositionX(this.ballController.getBallPositionX()+this.ballController.getBallDirX());
            this.ballController.setBallPositionY(this.ballController.getBallPositionY() + this.ballController.getBallDirY());
            
            System.out.println(this.ballController.getBallPositionX());

            //checks if the ball hits the side walls
            if (this.ballController.getBallPositionX() < 0) {
                this.ballController.setBallDirX(-1*this.ballController.getBallDirX());
            }
            if (this.ballController.getBallPositionX() > 670) {
                this.ballController.setBallDirX(-1*this.ballController.getBallDirX());
            }

            //checks if the ball hits the upper wall
            if (this.ballController.getBallPositionY() < 0) {
                this.ballController.setBallDirY(-1*this.ballController.getBallDirY());
            }
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

