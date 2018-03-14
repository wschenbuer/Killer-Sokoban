package KillerSokoban;

public class Square {
	public void Accept(Worker w){
		 System.out.println("[:Square].accept(w)");
	}
	
	public void Remove(Worker w){
		 System.out.println("[:Square].remove(w)");
	}
	
	public boolean GetObstacle (Square s){
		return false;
	}
		
	public Square GetNeighbor(Direction d){
		 System.out.println("[:Square].Getneighbor(d)");
		return null;
	}
	
	public void SetNeighbor(Direction d, Square s) {
	}
	
}
