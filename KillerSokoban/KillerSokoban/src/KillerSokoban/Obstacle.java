package KillerSokoban;

public class Obstacle extends Thing {
	
	public void HitBy(Box b) {
		System.out.println("[:Obstacle].HitBy(b)");
	}
	
	public void HitBy(Worker w) {
		System.out.println("[:Obstacle].HitBy(w)");
	}

	
	
}
