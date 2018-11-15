/*
 * Pong Game.java
 */

import javax.swing.JFrame; //imports to JFrame class from the swing package
import javax.swing.JPanel; //

/*
 * Pong Class 
 */
public class Pong extends JFrame {
	
	final static int WINDOW_WIDTH = 507;
	final static int WINDOW_HEIGHT = 300;
	
	public static GamePanel gp = new GamePanel();	
	
	public Pong () {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH+7, WINDOW_HEIGHT+53);//sets the size of the frame
		setLocationRelativeTo(null); //sets the frame to center of the screen
		setTitle("Pong"); //sets the title of the frame

		add (gp); //adds a new Panel called GamePanel to the Frame
		
		setResizable(false); //can not change the size
		setVisible(true); //makes the frame visible
		
		gp.setFocusable(true);
    }
	
	/*
	 * main method
	 */
	public static void main(String[] args) {
	    System.out.println(" Welcome to Java Pong game, a Luvneesh Mugrai masterpiece!"); //print message
	    System.out.println("The  up and down arrow keys control player"); //print message
	    System.out.println("To play either click the Easy button or OMEGA button"); //print message
	    System.out.println("The level OMEGA is very difficult to win :P"); //print message
	    System.out.println("Click either button again after finishing to play either level again"); //print message
	    System.out.println( "^MAKE SURE YOU READ ALL OF THE DIRECTIONS^");  //print message
	    System.out.println("Good Luck"); //print message

	    
		new Pong ();
	}

}
