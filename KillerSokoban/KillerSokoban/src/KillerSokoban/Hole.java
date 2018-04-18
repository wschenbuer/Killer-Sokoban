package KillerSokoban;

import java.util.ArrayList;

public class Hole extends Thing {
	
	private int id;
	private int squareid;
	private boolean holeAppear = false;
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
			floor.get(b.GetSquare().getid() - 1).Remove();
		else
			return;
	}
	
	public void HitBy(Worker w)
	{
		if(this.holeAppear == true)
			floor.get(w.GetSquare().getid()- 1).Remove();
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
