package KillerSokoban;

import java.util.ArrayList;

public class Square {


	private int x;
	private int y;
	private int id;
	public boolean IsOccupied=false;
	private String OccupiedThing="nothing";
	private boolean isSpecial;
	private Thing object=null;
	private Thing specialobject=null;
	private String SpecialObjectString = "nothing";
	private Thing holes=null;
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
	
	public String getSpecialObjectWithString()
	{
		return this.SpecialObjectString;
	}
	public Thing getSpecialObjectOnSquare()
	{
		return this.specialobject;
	}
	
	public void SetSwitchOnSquare(Thing object)
	{
		if(this.isSpecial==false)
		{
			this.specialobject=object;
			this.isSpecial=true;
			this.SpecialObjectString="switch";
			
		}else
		{
		System.out.println("Already exist switch or hole in this square");
		}
	}
	
	public void SetHoleOnSquare(Thing object)
	{
		if(this.isSpecial==false)
		{
			this.specialobject=object;
			this.isSpecial=true;
			this.SpecialObjectString="hole";
			
		}else
		{
		System.out.println("Already exist a switch or hole in this square");
		}
	}
	
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
		
		
		if (this.IsOccupied==false||this.getOccupieThingOnSquareWithString().equals("hole")||this.getOccupieThingOnSquareWithString().equals("switch")) {
			
			this.IsOccupied=true;
			this.object=object;
			this.OccupiedThing=object.getClass().getSimpleName().toLowerCase();
			
		} else
		{
			
			System.out.println("There is an object in this square already.");
					System.out.println("object name: "+ this.getOccupieThingOnSquareWithString());
					
			
			
			
		}
	}
	public Square getthissquare()
	{
		return this;
	}
	public String GetNeighborStringName(Direction d)
	{
		switch(d) {
		case UP:
			return floor.get(this.id-6-1).getthissquare().getOccupieThingOnSquareWithString();

		case LEFT:
			return floor.get(this.id-1-1).getthissquare().getOccupieThingOnSquareWithString();

		case RIGHT:
			return floor.get(this.id+1-1).getthissquare().getOccupieThingOnSquareWithString();

		case DOWN:
			return floor.get(this.id+6-1).getthissquare().getOccupieThingOnSquareWithString();
		}
		return null;
	}
	public void Remove(){
		
			this.object=null;
			this.OccupiedThing=null;
			this.IsOccupied=false;
			this.OccupiedThing="nothing";
			
	}



	public Square GetNeighbor(Direction d){
		switch(d) {
		case UP:
			return floor.get(this.id-6-1).getthissquare();

		case LEFT:
			return floor.get(this.id-1-1).getthissquare();

		case RIGHT:
			return floor.get(this.id+1-1).getthissquare();

		case DOWN:
			return floor.get(this.id+6-1).getthissquare();
		}
		return null;
	}

}
