//Carlos He He
import java.awt.Color;

public class SplitBall implements Ball{
	 
	    protected double rx, ry;         // position
	    protected double vx, vy;         // velocity
	    protected double radius;   // radius
	    protected final Color color;     // color
	    public boolean isOut;
	    protected double temp;
	    

	    // constructor
	    public SplitBall(double r, Color c) {
	    	//super(double r, Color c);
	        rx = 0.0;
	        ry = 0.0;
	        vx = StdRandom.uniform(-0.01, 0.01);
	        vy = StdRandom.uniform(-0.01, 0.01);
	        radius = r;
	        color = c;
	        isOut = false;

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
	    	//put ball back into the middle
	        rx = 0.0;
	        ry = 0.0; 	
	        //assign a random speed 
	        vx = StdRandom.uniform(-0.01, 0.01);
	        vy = StdRandom.uniform(-0.01, 0.01);

	        return 1;
	    }
	    
	    public boolean isHit(double x, double y) {
	    	if ((Math.abs(rx-x)<=radius) && (Math.abs(ry-y)<=radius)) {
				return true;}
			else return false; 

	    }
	    public int getScore() {
	    	return 10;
	    }
	    
	    public double getRadius() {
	    	return radius;
	    }
	    
	    public boolean isOut() {
	    	return isOut;
	    }


	}