package KillerSokoban;

import java.util.ArrayList;

public class Square {


	private int x;
	private int y;
	private int id;
	public boolean IsOccupied;
	private String OccupiedThing;
	private Thing object=null;
	public int getid()
	{return this.id;}
	static ArrayList<Square> floor = Floor.getSquare();//new ArrayList<Square>();

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
		return this.object;
	}

	public String getOccupieThingOnSquareWithString()
	{
		return this.OccupiedThing;
	}

	//Method renamed from Accept to setobject on square
	public void SetObjectOnSquare(Thing object)
	{
		if (this.object == null) {
			this.IsOccupied=true;
			this.object=object;
			this.OccupiedThing=object.getClass().getSimpleName().toLowerCase();
		} else {
			System.out.println("There is an object in this square already.");
		}
	}

	public void Remove(){
		if(this.object!=null){
			this.object=null;
			this.OccupiedThing=null;
			this.IsOccupied=false;
			}
	}



	public Square GetNeighbor(Direction d){
		switch(d) {
		case UP:
			return floor.get(this.id-6-1);

		case LEFT:
			return floor.get(this.id-1-1);

		case RIGHT:
			return floor.get(this.id+1-1);

		case DOWN:
			return floor.get(this.id+6-1);
		}
		return null;
	}

}
