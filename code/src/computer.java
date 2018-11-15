/*
 * Player1.java 
 * 
 */

import java.awt.Graphics;
import java.awt.Color;

public class Computer {
	
	private GamePanel field;
	
	private Score field2;

	// declares and initializes a private integers
	private int x = 35;
	private int y = Pong.WINDOW_HEIGHT/2; // y-coordinate
	private int ySpeed = 0; // how fast you move

	private int width = 10; // width of rectangle
	private int height = 40; // Height of rectangle

	public Computer(GamePanel game) {
		field = game;
	}

	public Computer (Score game){
		field2 = game;
	}
	
	// updates the location of the player
	public void update() {

		y = y + ySpeed;
		
		if (field.getBall().getY() < this.y+20 ){ // checks to see if ball is above computer
			ySpeed = -7;
		}
		else if (field.getBall().getY() > this.y ){//ball below us
			ySpeed = 7;
		}
		
		if (y <= 30) {//stop at 2
			y = 31;
		}

		if (y + height >= Pong.WINDOW_HEIGHT) {//stop at one above bot line
			y = Pong.WINDOW_HEIGHT - (height +1) ;
		}
		
		
	}

	//
	public void paint(Graphics pen) {
		Rectangle computer = new Rectangle(Pong.WINDOW_WIDTH- x - width, y, width, height, Color.green);
		computer.drawFilled(pen);
	}

	//
	public void setYSpeed(int velocity) {
		ySpeed = velocity; //sets the yspeed = to the velocity
	}

	public int getX() {
		return Pong.WINDOW_WIDTH - width - x; //returns the x-coordinate
	}

	public int getY() {
		return y; //returns the y-coordinate
	}

	public int getWidth() {
		return width;//returns the width
	}

	public int getHeight() {
		return height;//returns the height
	}

}// end of class
