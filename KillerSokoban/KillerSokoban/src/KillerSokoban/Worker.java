package KillerSokoban;

public class Worker extends Thing {
	
	public void Move(Direction d){
		System.out.println("[:Worker].Move(" + d.toString() + ")");
	}
	
	public void Die(){
		System.out.println("[:Worker].Die()");

	}
	
	public void HitBy(Box b){
		System.out.println("[:Worker].HitBy(b)");
	}
	
	public void HitBy(Worker w){
		System.out.println("[:Worker].HitBy(w)");

	}
	
	public void CollideWith(Obstacle o){}
}
