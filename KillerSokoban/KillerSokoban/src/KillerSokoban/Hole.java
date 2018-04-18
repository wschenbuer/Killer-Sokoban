package KillerSokoban;

public class Hole extends Thing {
	
	private int id;
	private int squareid;
	
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
		
	}
	
	public void HitBy(Worker w)
	{
	
	}
	
	public void SwitchedOn()
	{
	
	}
	
	public void SwitchedOFF(){
		
	}
}
