package KillerSokoban;

public class Box extends Obstacle implements Steppable  {
	public void HitBy(Worker w){}
	
	public void HitBy(Box b){}
	
	@Override
	public void  Step(Direction d){}
	
	public Square GetSquare(){
		return null;
	}
	public void Eliminate(){}

	
}
