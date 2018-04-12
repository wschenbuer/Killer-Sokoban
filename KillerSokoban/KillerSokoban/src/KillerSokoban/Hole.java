package KillerSokoban;

public class Hole extends Thing {
	
	private boolean SwitchedOn;
	
	public void HitBy(Box b){
		System.out.println("[:Hole].HitBy(b)");
	}
	
	public void HitBy(Worker w){
		System.out.println("[:Hole].HitBy(w)");
	}
	
	public void SwitchedOn(){
		System.out.println("[:Hole].SwitchOn()");
	}
	
	public void SwitchedOFF(){
		System.out.println("[:Hole].SwitchOFF()");
	}
}
