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
			
			
		}else if(WorkerSquareID==this.squareid+1)//worker is on you right side
		{
			
		}else if(WorkerSquareID==this.squareid+6)//worker is below you
		{
			
		}else if(WorkerSquareID==this.squareid-6)//worker is above you
		{
			
		}
	}
	
	public void HitBy(Box b)
	{
		
	}
	
	public Square GetSquare(){
		return null;
	}
	public void Eliminate()
	{
		
	}

	public void Step(Direction d) {
		
		
		switch(d)
		{
			case UP:    floor.get(this.squareid).Remove();
					    floor.get(this.squareid-6-1).SetObjectOnSquare(this); break;
			
			case LEFT:  floor.get(this.squareid).Remove();
						floor.get(this.squareid-1-1).SetObjectOnSquare(this); break;
			
			case DOWN:  floor.get(this.squareid).Remove();
						floor.get(this.squareid+6-1).SetObjectOnSquare(this); break;
			
			case RIGHT:  floor.get(this.squareid).Remove();
						 floor.get(this.squareid+1-1).SetObjectOnSquare(this); break;
					
			
		}
		
	}
	
	


	
}
