//*****************************************************************************
//  ButtonListener.java
//
//  Represents the push button listener for the PushCounter program.
//*****************************************************************************

//imports 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {

	// declare private GamePanel object
	private GamePanel panel2;
	private int y;
	


	// --------------------------------------------------------------------------
	// Stores the panel in order to update the counter.
	// --------------------------------------------------------------------------

	// Constructor method that takes PushCounterPanel object as parameter
	public ButtonListener(GamePanel panel, int x ) {
		// set panel variable equal to the panel passed via parameter and integer
		panel2 = panel;
		 y = x;
	}
	
	public void actionPerformed(ActionEvent event){
		switch (y){
		//case 1: panel2.resetGame(); break;
		case 2: panel2.easy(); break;
		case 3: panel2.hard(); break;
		
		}
	}


}
