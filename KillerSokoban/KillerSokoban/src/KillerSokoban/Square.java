package KillerSokoban;



public class Square {
	
	
	private int x;
	private int y;
	private int id;
	public boolean IsOccupied;
	private String OccupiedThing;
	private Thing object;
	
	Square(int x, int y, int id)
	{
		this.x=x;
		this.y=y;
		this.id = id;
	}
	
	
	public Thing getObjectOnSquare()
	{
		return object;
		
	}
	
	public String getOccupieThingOnSquareWithString()
	{
		return this.OccupiedThing;
	}
	public void SetOccupied(String OccupiedThing) {
		this.OccupiedThing=OccupiedThing;
	}
	public void SetObjectOnSquare(Thing object)
	{
		this.object=object;
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
