package KillerSokoban;

import java.util.ArrayList;

public class Hole extends Thing {
	
	private int id;
	private int squareid;
	private boolean holeAppear;
	static ArrayList<Square> floor = Floor.getSquare();
	
	public int getid()
	{
		return this.id;
	}
	
	
	public void setsquareid(int squareid)
	{
		this.squareid=squareid;
	}
	
	public int getsquareid()
	{
		return this.squareid;
	}
	
	Hole(int id)
	{
		this.id=id;
	}
	
	public void HitBy(Box b)
	{
		if(this.holeAppear == true)
		{	b.Eliminate();
		System.out.println("Box with ID: "+ b.getboxid()+" Has been eliminated by hole");
		}
		
		else
			return;
	}
	
	public void HitBy(Worker w)
	{
		if(this.holeAppear == true)
			{w.Die();
			System.out.println("worker with ID: "+w.getworkerid()+ " has been eliminated by hole");
			
			}
		else
			return;
	}
	
	public void HoleAppear() {
		this.holeAppear = true; 
		System.out.println("Hole with ID: "+ this.id +" appeard");
		
		if(floor.get(this.squareid-1).getOccupieThingOnSquareWithString().equals("worker"))
		{
			floor.get(this.squareid-1).Remove();
			System.out.println("Worker standing on the hole falling into hole");
			
		}else if(floor.get(this.squareid-1).getOccupieThingOnSquareWithString().equals("box"))
		{
			floor.get(this.squareid-1).Remove();
			System.out.println("Box standing on the hole falling into hole");
		}
	}
	
	public void HoleDisappear() {
		this.holeAppear = false;
		System.out.println("Hole with ID: "+ this.id +" disappeard");
	}
}
