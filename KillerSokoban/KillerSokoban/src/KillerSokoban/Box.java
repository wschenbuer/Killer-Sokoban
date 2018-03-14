package KillerSokoban;

public class Box extends Obstacle implements Steppable  {
	public void HitBy(Worker w){}
	
	public void HitBy(Box b){}
	
	
	public Square GetSquare(){
		return null;
	}
	public void Eliminate(){}

	public void Step(Direction d) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
