//Carlos He He
public class Player {
	int score;
	int SplitBallHits;
	int ShrinkBallHits;
	int BasicBallHits;
	int BounceBallHits;
	
	public Player() { //initialize all variables to zero
		score = 0;
		SplitBallHits = 0;
		BasicBallHits = 0;
		ShrinkBallHits = 0;
		BounceBallHits = 0;
	}
	
	public void addScore(int add) {
		score = score + add;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addSplitBall(int add) {
		SplitBallHits = SplitBallHits + add;
	}
	
	public int getSplitBall() {
		return SplitBallHits;
	}
	
	public void addShrinkBall(int add) {
		ShrinkBallHits = ShrinkBallHits + add;
	}
	
	
	public int getShrinkBall() {
		return ShrinkBallHits;
	}
	
	public void addBounceBall(int add) {
		BounceBallHits = BounceBallHits + add;
	}
	
	public int getBounceBall() {
		return BounceBallHits;
	}
	
	public void addBasicBall(int add) {
		BasicBallHits = BasicBallHits + add;
	}
	
	public int getBasicBall() {
		return BasicBallHits;
		}
	
	public String maxhit() {
		int max;
		max = Math.max(Math.max(SplitBallHits, BounceBallHits), Math.max(ShrinkBallHits,BasicBallHits));
		
		if(max == BasicBallHits)
			return "Basic";
		if(max == BounceBallHits)
			return "Bounce";
		if(max == ShrinkBallHits)
			return "Shrink";
		
		return "Split";
		
	}

	
}
	
