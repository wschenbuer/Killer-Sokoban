package KillerSokoban;

public class Switch extends Thing {
	
	private int id;
	private int squareid;
	private boolean SwitchedOn;
	
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
	
	Switch(int id)
	{
		this.id=id;
	}
	
	public void HitBy(Box b, Hole h)
	{
		SwitchedOn = true;
		h.HoleAppear();
	}
	
	public void HitBy(Worker w, Hole h)
	{
		SwitchedOn = false;
		h.HoleDisappear();
	}
}
