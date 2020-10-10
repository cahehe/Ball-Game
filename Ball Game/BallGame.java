/******************************************************************************
 *  Compilation:  javac BallGame.java

 *  Execution:    java BallGame n
 *  Dependencies: BasicBall.java StdDraw.java
 *
 *  Creates a BasicBall and animates it
 *
 *  Part of the animation code is adapted from Computer Science:   An Interdisciplinary Approach Book
 *  
 *  Run the skeleton code with arguments : 1  basic  0.08
 *******************************************************************************/
//Carlos He He WSU 11580870
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class BallGame{ 

    public static void main(String[] args) {
  
    	// number of bouncing balls
    	int numBalls = Integer.parseInt(args[0]);//converts first arg into int
    	//ball types
    	String ballTypes[] = new String[numBalls];
    	//sizes of balls
    	double ballSizes[] = new double[numBalls];
    	
    	//retrieve ball types
    	int index =1;
    	for (int i=0; i<numBalls; i++) {
    		ballTypes[i] = args[index];
    		index = index+2;
    	}
    	//retrieve ball sizes
    	index = 2;
    	for (int i=0; i<numBalls; i++) {
    		ballSizes[i] = Double.parseDouble(args[index]); //parse arg into double
    		index = index+2;
    	}
     
    	//create a Player object and initialize the player game stats.  
    	Player one = new Player();
    	
    	
    	//number of active balls
    	int numBallsinGame = 0;
    	int counter = 0;
    	double basic_radius;
    	double shrink_radius;
    	double split_radius = 0.00;
    	double bounce_radius;
    	
        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(800, 800);
        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);
        
        ArrayList<Ball> ball_list = new ArrayList<>();
        

        // create colored balls 
        //Create "numBalls" balls (of types given in "ballTypes" with sizes given in "ballSizes") and store them in an Arraylist
for(int i=0; i<ballTypes.length; i++) {
	
			if(ballTypes[i].equals("shrink")) {
				shrink_radius = ballSizes[i];
				ShrinkBall shrinkball = new ShrinkBall(ballSizes[i],Color.BLUE);
				ball_list.add(shrinkball);
			}
   			
			else if(ballTypes[i].equals("basic")) {
				basic_radius = ballSizes[i];
   				BasicBall basicball = new BasicBall(ballSizes[i],Color.RED);
   				ball_list.add(basicball);
   			}
   			
   			else if(ballTypes[i].equals("bounce")) {
   				bounce_radius = ballSizes[i];
   				BounceBall bounceball = new BounceBall(ballSizes[i],Color.YELLOW);
   				ball_list.add(bounceball);
   			}
   			
   			else {
   				split_radius = ballSizes[i];
   				SplitBall splitball = new SplitBall(ballSizes[i],Color.GREEN);
   				ball_list.add(splitball);
   			}
   			
   			
   		}
   		//initialize the numBallsinGame
		Player player_one = new Player();
		int basic_score = 25;
		int bounce_score = 15;
		int split_score = 10;
		int shrink_score = 20;
   		numBallsinGame++;
   		int bounce_times = 0; //counter for bounce ball
        
        // do the animation loop
        StdDraw.enableDoubleBuffering();
        while (numBallsinGame > 0) {

        	//move all balls
        	for(int i=0; i<ball_list.size(); i++) {
        		ball_list.get(i).move();
        	}

            //Check if the mouse is clicked
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                //check whether a ball is hit. Check each ball.  

                for(int i=0; i<ball_list.size(); i++) {
                	Ball dummy = ball_list.get(i);
                	if(dummy.isHit(x, y)) {
                		if(dummy instanceof BasicBall) {
                			player_one.addScore(basic_score);
                			player_one.addBasicBall(1);
                		}
                		else if(dummy instanceof ShrinkBall) {
                			player_one.addScore(shrink_score);
                			player_one.addShrinkBall(1);
                		}
                		else if(dummy instanceof SplitBall) {//actually split the ball
                			player_one.addScore(split_score);
                			player_one.addSplitBall(1);
                	        SplitBall cpy = new SplitBall(split_radius,Color.GREEN);
                	        ball_list.add(cpy);
                		}
                		else{ //else it must be a bounce ball
                			player_one.addScore(bounce_score);
                			player_one.addBounceBall(1);
                		}
                		dummy.reset();
                			
                	}
                	}
            }
            
                
            numBallsinGame = 0;
            // draw the n balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            
            /check each ball and see if they are still visible. numBallsinGame should hold the number of visible balls in the game.  

            
            for(int i=0; i<ball_list.size(); i++) {
            	Ball dummy = ball_list.get(i);
            	if(dummy.isOut() == false) {
            		dummy.draw();
            		numBallsinGame++;
            	}
            }
            
            //Print the game progress
            StdDraw.setPenColor(StdDraw.YELLOW);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            StdDraw.text(-0.65, 0.90, "Number of balls in game: "+ String.valueOf(numBallsinGame));
            //TO DO: print the rest of the player statistics

            StdDraw.show();
            StdDraw.pause(20);
        }
        while (true) {
            StdDraw.setPenColor(StdDraw.BLUE);
            Font font = new Font("Arial", Font.BOLD, 50);
            StdDraw.setFont(font);
            String result = String.valueOf(player_one.getScore()); //turn score into string
            StdDraw.text(0, 0.6, "GAME OVER");
            StdDraw.text(0, 0.3, result);
            //TO DO: print the rest of the player statistics
            StdDraw.setPenColor(StdDraw.BLUE);
            Font font2 = new Font("Arial", Font.BOLD, 30);
            StdDraw.setFont(font2);
            StdDraw.text(0, 0.4, "Total score is "); //second number is height
            StdDraw.text(0, 0.1, "Total hits for each category are ");
            StdDraw.text(-0.3, -0.2, "Basic");
            StdDraw.text(-0.3, -0.3, "Shrink");
            StdDraw.text(-0.3, -0.4, "Split");
            StdDraw.text(-0.3, -0.5, "Bounce");
            double height = -0.2;
            
            String result2 = String.valueOf(player_one.getBasicBall()); //print basic score
            StdDraw.text(0.3, height, result2);
            height = height - 0.1;
       
        	String result3 = String.valueOf(player_one.getShrinkBall()); //print shrink score   			
        	StdDraw.text(0.3, height, result3);
        	height = height - 0.1;
       
        	String result4 = String.valueOf(player_one.getSplitBall()); //split      			
        	StdDraw.text(0.3, height, result4);
        	height = height - 0.1;
        		
        	String result5 = String.valueOf(player_one.getBounceBall()); //bounce
        	StdDraw.text(0.3, height, result5);
        	height = height - 0.1;
        	
        	StdDraw.text(-0.3, -0.7, "Max Hits is ");
        	StdDraw.text(0.3, -0.7, player_one.maxhit());
        	
            
            
            StdDraw.show();
            StdDraw.pause(10);           
        }
        	
        
    }
}

