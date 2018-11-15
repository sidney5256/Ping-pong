/*
 * GamePanel.java
 * 
 */

//imports classes from swing package
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;

//imports classes from awt packages
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {

	//declarations
	
	// declare a player object
	Player1 playerOne = new Player1();
	// declares a ball object
	Ball ball = new Ball();
	//declare a computer object 
	Computer computer = new Computer (this);
	//declare a score object
	Score score = new Score(ball, playerOne, computer);
	//timer
	private Timer timer;
	//declare boolean
	boolean gameOn = false;
	// declare new circle
	Circle circle = new Circle(Pong.WINDOW_WIDTH/2-25, ((Pong.WINDOW_HEIGHT+30)/2)-25, 25, Color.white);
	//creates a new Font
	Font font = new Font ("Default", Font.BOLD, 14);
	//declares a new JButton variable
	private JButton easy, hard;
	
	// constructor
	public GamePanel() {

		//instantiate the button variable
		easy = new JButton ("Easy");
		hard = new JButton ("OMEGA");
		//Construct a ButtonListener object
		ButtonListener listenerEasy = new ButtonListener(this,2);
		ButtonListener listenerHard = new ButtonListener(this,3);

		// add listener to button
		easy.addActionListener(listenerEasy);
		hard.addActionListener(listenerHard);
		// add button
		add(easy);
		add(hard);


		// adds a new listener
		KeyBoardAdapter keyboard =new KeyBoardAdapter ();
		addKeyListener(keyboard);
		
		// sets the KeyBoard Focusable
		setFocusable(true);
		
		easy.setFocusable(false);
		hard.setFocusable(false);
		
	}
	
	public Ball getBall(){
		return ball;
	}
	
	public void easy(){
		if(!gameOn){
			score.compScore = 0; //sets computer score = 0
			score.playerScore = 0; //sets score = 0
			gameOn = true;
			int pause = new Integer(50);
			System.out.println(pause);
//		Timer timer;
			timer = new Timer(pause, this); // declares a timer and sets the
			// parameters to how long before it
			// updates
			timer.start();//runs the timer
		}
	}
	
	public void hard (){
		if (!gameOn){
			score.compScore = 0; //sets computer score = 0
			score.playerScore = 0; //sets score = 0
			int pause = new Integer(10);
			System.out.println(pause);
			gameOn = true;
			timer = new Timer(pause, this); // declares a timer and sets the
			// parameters to how long before it
			// updates
			timer.start();//runs the timer
		}
	}

	//updates the game
	private void update() {
		
		if (gameOn){
		playerOne.update(); //runs update method
		ball.update();//runs update method
		computer.update();//runs update method
		score.update();//runs update method
		
		ball.checkCollision(playerOne);//runs checkCollision method
		ball.checkCollision(computer);//runs checkCollision method
		
		}
		
		checkStatus();
	}

	// paints
	public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(Color.black);
        pen.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT+20);
        
		if (gameOn){
		playerOne.paint(pen);
		ball.paint(pen);
		computer.paint(pen);
		
		background(pen);
		
		drawScore(pen);

		}
		
		else{
			gameOver(pen);
		}
	}
	
	public void drawScore(Graphics pen){
		String compScore = "Comp Score: " + score.computerScore(); //declares and initializes string as Score
		String playerScore = "Player Score: " + score.playerOneScore();
		
        pen.setColor(Color.white); //sets the color of the pen to white
        pen.setFont(font); //set the size of the font to small
        pen.drawString(compScore,Pong.WINDOW_WIDTH-Pong.WINDOW_WIDTH/3, Pong.WINDOW_HEIGHT+12);//draws the string
        pen.drawString(playerScore, Pong.WINDOW_WIDTH/10, Pong.WINDOW_HEIGHT+12);
	}

	public void background(Graphics pen){
		pen.setColor(Color.white); //sets pen color to white
		pen.drawLine(0, 30, Pong.WINDOW_WIDTH, 30); //draws a horizontal line 30 units down
		pen.drawLine(0, Pong.WINDOW_HEIGHT, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);//bottome line
		pen.drawLine(Pong.WINDOW_WIDTH/2, 30, Pong.WINDOW_WIDTH/2, Pong.WINDOW_HEIGHT);//draws a vertical line down middle 
		circle.drawUnFilled(pen);//draws a circle half way down the vertical line
		pen.drawLine(26, 30, 26, Pong.WINDOW_HEIGHT);//line behind player
		pen.drawLine(482, 30, computer.getX()+computer.getWidth()+10, Pong.WINDOW_HEIGHT);//line behind computer
	}
	
	public void checkStatus(){
		if (score.computerScore() == 10 || score.playerOneScore() == 10){
			gameOn = false;
			timer.stop();
		}
	}
	
	//checks to see when game is over
	public void gameOver(Graphics pen){
		pen.setColor(Color.black);
		pen.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT+20);
		if (score.computerScore() == 10){
			compWin(pen);
		}
		else if (score.playerOneScore() == 10){
			//game is over, you win
			youWin(pen);
		}
	}
	
	private void compWin(Graphics pen){
		String compWin = "Computer Wins! Better Luck Next Time";
		pen.setFont(font);
		pen.setColor(Color.white);
		pen.drawString(compWin, Pong.WINDOW_WIDTH/3, Pong.WINDOW_WIDTH/3);
	}
	
	public void youWin(Graphics pen){
		String youWin = "You Win! Good Job!"; //declares a string
		pen.setFont(font);//sets the pen font to declared font from before
		pen.setColor(Color.white);//sets pen color white
		pen.drawString(youWin, Pong.WINDOW_WIDTH/3, Pong.WINDOW_WIDTH/3);//draws String at location
	}

	
	// methods from ActionListener
	public void actionPerformed(ActionEvent e) {
		update(); // calls the update method
		repaint(); // calls paint component again		
	}
	
	
	/*
	 * KeyBoardAdapter.java 
	 * Embedded class
	 * checks to see when key board keys are pressed 
	 * 
	 */
	private class KeyBoardAdapter implements KeyListener {
		// methods from KeyListener
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				playerOne.setYSpeed(-10);
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				playerOne.setYSpeed(10);
			}
		}
		
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
				playerOne.setYSpeed(0);
			}
		}
		
		public void keyTyped(KeyEvent e) {
		}
	}//end of KeyBoardAdapter class
		
}// end of class
