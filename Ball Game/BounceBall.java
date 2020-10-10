//Carlos He He CPTS 355
import java.awt.Color;

public class BounceBall implements Ball { 
    protected double rx, ry;         // position
    protected double vx, vy;         // velocity
    protected double radius;   // radius
    protected final Color color;     // color
    public boolean isOut;
    protected double temp;
    private int numOfBounces=0;
    

    // constructor
    public BounceBall(double r, Color c) {
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
        if ((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0)) {
        	if(numOfBounces >= 3)
        		isOut = true;
        	else {
        		numOfBounces++;
        		vx = -vx;
        		vy = -vy;
        		}
        	}
        rx = rx + vx;
        ry = ry + vy;
        	
    }

    // draw the ball
    /*
    public void draw() { 
    	if ((Math.abs(rx) <= 1.0) && (Math.abs(ry) <= 1.0)) {
    		StdDraw.setPenColor(color);
    		StdDraw.filledCircle(rx, ry, radius);
    	} else
    		isOut = true;
    	
    } */
    
    public void draw() { 
    	if ((Math.abs(rx) <= 1.0) && (Math.abs(ry) <= 1.0)) {
    		StdDraw.setPenColor(color);
    		StdDraw.filledCircle(rx, ry, radius);
    	} /*else {
    		if ( numOfBounces >=3 && ((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0)) ) {//if bounce_count >= 3 and is out of bounds.
            	isOut = true;
    		}
            else if(numOfBounces < 3 && ((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0))) { 
            	numOfBounces++;
            	vx=-vx;
            	vy=-vy;
            	//isOut = false;
            //	rx = rx - vx;
             //   ry = ry - vy;
 
            
            
    	}
    }*/
    } 

    public int reset() {
        rx = StdRandom.uniform(-1.01, 1.01);
        ry = StdRandom.uniform(-1.01, 1.01); 	
        //assign a random speed 
        return 1;
    }
    
    public boolean isHit(double x, double y) {
    	if ((Math.abs(rx-x)<=radius) && (Math.abs(ry-y)<=radius)) {
			return true;}
		else return false; 

    }
    public int getScore() {
    	return 15;
    }
    
    public double getRadius() {
    	return radius;
    }
    
    public boolean isOut() {
    	return isOut;
    }


}
