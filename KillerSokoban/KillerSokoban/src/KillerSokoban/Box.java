package KillerSokoban;

import java.util.ArrayList;

public class Box extends Obstacle implements Steppable  {
	
	private int id;
	private int squareid;
	static ArrayList<Square> floor = Floor.getSquare();//new ArrayList<Square>();
	
	
	
	
	public void setsquareid(int squareid)
	{
		this.squareid=squareid;
	}
	public int getsquareid()
	{return this.squareid;
	}
	Box(int id)
	{
		this.id=id;
		
	}
	
	public void HitBy(Worker w)
	{
		
		
		
		int WorkerSquareID = w.getsquareid();
		if(WorkerSquareID==this.squareid-1)//worker is on your left side
		{
			//current square this.squareid-1
			if(floor.get(this.squareid-1+1).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1-1).Remove();
			floor.get(this.squareid-1+1).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(w);
			}
			
		}else if(WorkerSquareID==this.squareid+1)//worker is on your right side
		{
			if(floor.get(this.squareid-1-1).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1+1).Remove();
			floor.get(this.squareid-1-1).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(w);
			}
			
		}else if(WorkerSquareID==this.squareid+6)//worker is below you
		{
			if(floor.get(this.squareid-1-6).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1+6).Remove();
			floor.get(this.squareid-1-6).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(w);
			}
		}else if(WorkerSquareID==this.squareid-6)//worker is above you
		{
			if(floor.get(this.squareid-1+6).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1-6).Remove();
			floor.get(this.squareid-1+6).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(w);
			}
		}
	}
	
	public void HitBy(Box b)
	{
		
		int boxsquareID = b.getsquareid();
		if(boxsquareID==this.squareid-1)//worker is on your left side
		{
			//current square this.squareid-1
			if(floor.get(this.squareid-1+1).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1-1).Remove();
			floor.get(this.squareid-1+1).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
			
		}else if(boxsquareID==this.squareid+1)//worker is on your right side
		{
			if(floor.get(this.squareid-1-1).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1+1).Remove();
			floor.get(this.squareid-1-1).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
			
		}else if(boxsquareID==this.squareid+6)//worker is below you
		{
			if(floor.get(this.squareid-1-6).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1+6).Remove();
			floor.get(this.squareid-1-6).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
		}else if(boxsquareID==this.squareid-6)//worker is above you
		{
			if(floor.get(this.squareid-1+6).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1-6).Remove();
			floor.get(this.squareid-1+6).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
		}
		
	}
	
	public Square GetSquare(){
		
		return floor.get(this.squareid-1);
	}
	public void Eliminate()
	{
		int squareid = this.getsquareid();
		floor.get(squareid-1).Remove();
	}

	public void Step(Direction d) {
		
		
		switch(d)
		{
			case UP:    floor.get(this.squareid-1).Remove();
					    floor.get(this.squareid-6-1).SetObjectOnSquare(this); break;
			
			case LEFT:  floor.get(this.squareid-1).Remove();
						floor.get(this.squareid-1-1).SetObjectOnSquare(this); break;
			
			case DOWN:  floor.get(this.squareid-1).Remove();
						floor.get(this.squareid+6-1).SetObjectOnSquare(this); break;
			
			case RIGHT:  floor.get(this.squareid-1).Remove();
						 floor.get(this.squareid+1-1).SetObjectOnSquare(this); break;
					
			
		}
		
	}
	
	


	
}
