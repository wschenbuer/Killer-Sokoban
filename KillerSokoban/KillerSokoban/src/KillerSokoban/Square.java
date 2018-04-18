package KillerSokoban;



public class Square {
	
	
	private int x;
	private int y;
	private int id;
	public boolean IsOccupied;
	private String OccupiedThing;
	private Thing object=null;
	public int getid()
	{return this.id;}
	
	
	Square(int x, int y, int id)
	{
		this.x=x;
		this.y=y;
		this.id = id;
	}
	public int getX()
	{return this.x;}
	public int getY()
	{return this.y;}
	
	public Thing getObjectOnSquare()
	{
		return object;
		
	}
	
	public String getOccupieThingOnSquareWithString()
	{
		return this.OccupiedThing;
	}
	
	public void SetObjectOnSquare(Thing object)
	{
		this.IsOccupied=true;
		this.object=object;
		this.OccupiedThing=object.getClass().getSimpleName().toLowerCase();
	}
	
	
	
	public void Accept(Thing t){
		
	}
	
	public void Remove(){
		
		if(this.object!=null){return;}
	
		this.object=null;
	}
	
	
		
	public Square GetNeighbor(Direction d){
		
		return null;
	}
	
	public void SetNeighbor(Direction d, Square s) {
	}
	
}
