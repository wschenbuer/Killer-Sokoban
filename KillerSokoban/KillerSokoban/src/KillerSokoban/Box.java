package KillerSokoban;

public class Box extends Obstacle implements Steppable  {
	public void HitBy(Worker w){System.out.println("[:Box].HitBy(w)");}
	
	public void HitBy(Box b){System.out.println("[:Box].HitBy(b)");}
	

	public Square GetSquare(){
		return null;
	}
	public void Eliminate(){System.out.println("[:Box].Eliminate()");}


	public void Step(Direction d) {
		
		System.out.println("[:Box].Step(d)");
	}
	
	


	
}
