/*
 * Player1.java 
 * 
 */

import java.awt.Graphics;
import java.awt.Color;

public class Player1 {

	// declares and initializes a private integers
	private int x = 35;
	private int y = Pong.WINDOW_HEIGHT/2; // y-coordinate
	private int ySpeed = 0; // how fast you move

	private int width = 10; // width of rectangle
	private int height = 40; // Height of rectangle

	public Player1() {

	}

	public void paint(Graphics pen) {
		Rectangle playerOne = new Rectangle(x, y, width, height, Color.yellow);
		playerOne.drawFilled(pen);
	}
	// updates the location of the player
	public void update() {
		y = y + ySpeed; //sets y equal to y + ySpeed


		if (y <= 30) {//stop at 2
			y = 31; //sets y equal to 31
		}

		if (y + height >= Pong.WINDOW_HEIGHT) {//stop at one above bot line
			y = Pong.WINDOW_HEIGHT - (height +1) ;
		}
	}

	//

	//
	public void setYSpeed(int velocity) {
		ySpeed = velocity;//return value
	}

	public int getX() {
		return x;//return value
	}

	public int getY() {
		return y;//return value
	}
	
	public int getWidth() {
		return width;//return value
	}
	
	public int getHeight(){
		return height;//return value
	}

}// end of class
