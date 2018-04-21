package KillerSokoban;

import java.util.ArrayList;

public class Hole extends Thing {
	
	private int id;
	private int squareid;
	private boolean holeAppear = true;
	static ArrayList<Square> floor = Floor.getSquare();
	
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
		holeAppear = true;
	}
	
	public void HoleDisappear() {
		holeAppear = false;
	}
}
