package KillerSokoban;

import java.util.ArrayList;

public class Hole extends Thing {
	
	private int id;
	private int squareid;
	private Square square;
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
		floor.get(b.GetSquare().getid() - 1).Remove();
	}
	
	public void HitBy(Worker w)
	{
		floor.get(w.GetSquare().getid() - 1).Remove();
	}
	
	public void HoleAppears(Hole hole)
	{
		
	}
	
	public void HoleDisappears(Hole hole)
	{
		
	}
}
