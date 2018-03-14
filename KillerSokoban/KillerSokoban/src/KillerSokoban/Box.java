package KillerSokoban;

public class Box extends Obstacle implements Steppable  {
	public void HitBy(Worker w){}
	
	public void HitBy(Box b){}
	
	public void Step(Direction d){}
	public Square GetSquare(){
		return Square;
	}
	public void Eliminate(){}
}
