/*
 * Rectangle.java
 * 
 * makes rectangles
 * 
 * */

import java.awt.*;

//class header
public class Rectangle
{
 private int xStart;
 private int yStart;
 private int width2;
 private int height2;
 private Color color2;
// private Color rectColor;
  
  
  public Rectangle (int x, int y, int width, int height, Color color)
  {
    xStart = x;
    yStart = y; 
    width2 = width;
    height2 = height;
    color2 = color;
  }
  
    //Draw a filled circle 
  public void drawFilled (Graphics g)
  {
    g.setColor (color2);
    g.fillRect (xStart, yStart, width2, height2);
  }
  
  public void drawUnFilled (Graphics g)
  {
   g.setColor (color2); 
   g.drawRect (xStart, yStart, width2, height2);
  }
  
  
}//end of the class
