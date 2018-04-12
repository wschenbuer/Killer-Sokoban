package KillerSokoban;

public class Square {
	
	
	private int x;
	private int y;
	private int id;
	public boolean IsOccupied;
	Square(int x, int y, int id)
	{
		this.x=x;
		this.y=y;
		this.id = id;
	}
	
	public void Accept(Thing t){
		
	}
	
	public void Remove(Thing t){
		
	}
	
	public boolean GetObstacle (Square s){
		return false;
	}
		
	public Square GetNeighbor(Direction d){
		
		return null;
	}
	
	public void SetNeighbor(Direction d, Square s) {
	}
	
}
