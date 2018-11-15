/*
 * circle.java
 * 
 * represents a circle object
 * with specific size, color, position
 * 
 * */

import java.awt.*; // imports awt package

//class header
public class Circle{
  
  //global variables for the circle information
  private int x_Center; // x coordinate of the center
  private int y_Center; // y coordinate of the center
  private int radius; // radius of the circle
  public Color circleColor; // color of the circle
  
  
  
  //constructor for a circle
  public Circle(int xCenter, int yCenter, int size, Color color){
    x_Center=xCenter;
    y_Center=yCenter;
    radius=size;
    circleColor=color;
  }
  
  //drawFilled - draws a filled circle
  public void drawFilled(Graphics pen){
    pen.setColor(circleColor);
    pen.fillOval(x_Center, y_Center , radius*2, radius*2);
  } 
  
    public void drawUnFilled(Graphics pen){
    pen.setColor(circleColor);
    pen.drawOval(x_Center, y_Center, radius*2, radius*2);
  } 
}
