//Carlos He He

import java.awt.Color;

	public class ShrinkBall implements Ball { 
	    protected double rx, ry;         // position
	    protected double vx, vy;         // velocity
	    protected double radius,radius2;   // radius
	    protected final Color color;     // color
	    public boolean isOut;
	    protected double twenty_five,one_third;
	    

	    // constructor
	    public ShrinkBall(double r, Color c) {
	        rx = 0.0;
	        ry = 0.0;
	        vx = StdRandom.uniform(-0.01, 0.01);
	        vy = StdRandom.uniform(-0.01, 0.01);
	        radius = r;
	        radius2 = r;
	        color = c;
	        isOut = false;
	        twenty_five = (0.25*radius);
	        one_third = (0.33*radius);
	    }
	   
	   
	    // move the ball one step
	    public void move() {
	        rx = rx + vx;
	        ry = ry + vy;
	        if ((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0)) 
	        	isOut = true;
	    }

	    // draw the ball
	    public void draw() { 
	    	if ((Math.abs(rx) <= 1.0) && (Math.abs(ry) <= 1.0)) {
	    		StdDraw.setPenColor(color);
	    		StdDraw.filledCircle(rx, ry, radius);
	    	} else
	    		isOut = true;
	    	
	    }

	    public int reset() {
	        rx = 0.0;
	        ry = 0.0;  	
	        //assign a random speed 
	        vx = StdRandom.uniform(-0.01, 0.01);
	        vy = StdRandom.uniform(-0.01, 0.01);
	        return 1;
	    }
	    
	    public boolean isHit(double x, double y) {
	    	if ((Math.abs(rx-x)<=radius) && (Math.abs(ry-y)<=radius)) {
	    		if(radius <= twenty_five) {
	    			radius = radius2;
	    			return true;
	    		}   			
	    		radius = radius - one_third; 
				return true;}
			else return false; 

	    }
	    public int getScore() {
	    	return 20;
	    }
	    
	    public double getRadius() {
	    	return radius;
	    }
	    
	    public boolean isOut() {
	    	return isOut;
	    }
	    


	}

