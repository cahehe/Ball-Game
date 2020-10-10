//Carlos He He

import java.awt.Color;
import java.util.ArrayList;

public interface Ball {
	 public void move();
	    // draw the ball
	    public void draw();  	    	    

	    public int reset(); 	    
	    
	    public boolean isHit(double x, double y);	    
	    
	    public int getScore(); 	   
	    	    
	    public double getRadius(); 
	    
	    public boolean isOut();
	    
}
