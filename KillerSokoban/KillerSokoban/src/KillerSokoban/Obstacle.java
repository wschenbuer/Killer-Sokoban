package KillerSokoban;

public abstract class Obstacle extends Thing {
	
	public void HitBy(Box b) {
		System.out.println("Obstacle infront, can not move");
	}
	
	public void HitBy(Worker w) {
		
		System.out.println("Obstacle infront, can not move");
	}

	
	
}
