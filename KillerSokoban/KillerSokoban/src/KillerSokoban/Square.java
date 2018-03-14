package KillerSokoban;

public class Square {
	public void Accept(Worker w){}
	
	public void Remove(Worker w){}
	
	public boolean GetObstacle (Square s){}
	
	public Square GetNeighbor(Direction d){}
	
	public void SetNeighbor(Direction d, Square s){}
	
}
