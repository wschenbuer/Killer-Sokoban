package KillerSokoban;

public class Square {
	public void Accept(Thing t){
		 System.out.println("[:Square].accept(t)");
	}
	
	public void Remove(Thing t){
		 System.out.println("[:Square].remove(t)");
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
