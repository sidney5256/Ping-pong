import java.awt.Graphics;


public class Score {
	
	//declare and initialize scores scores
	int compScore = 0, playerScore = 0;
	
	// declare a player object
	Player1 playerOne;
	Computer computer;

	// declares a ball object
	Ball ball;
	public Score(Ball b, Player1 p1, Computer c){
		ball = b;
		playerOne = p1;
		computer = c;
	}
	

	public void update(){
		this.compScore();
		this.playerScore();

	}
	
	public void compScore(){
		if (ball.getX() == computer.getX()+computer.getWidth()+5){
				playerScore = playerScore+1; //updates score when condition is met
				System.out.println("Player Score: " + playerScore); //prints player score
		}
	}
	
	public void playerScore(){
		if (ball.getX() <=  30){
			compScore = compScore+1; //updates score when condition is met
			System.out.println("Computer Score: " + compScore); //prints the computer score
		}
		
	}
	
	public int computerScore(){
		return compScore; //returns the computer score
	}
	
	public int playerOneScore(){
		return playerScore; //returns player score
	}
	
	
}//end
