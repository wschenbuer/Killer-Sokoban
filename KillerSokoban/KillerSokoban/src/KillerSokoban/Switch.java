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
		
		try{
		SwitchedOn = true;
		h.HoleAppear();
		}catch(NullPointerException e){System.out.println("Box stepped on switch with id: "+ this.id	+" but No corresponding hole to this switch");}
	}
	
	public void HitBy(Worker w, Hole h)
	{
		try{
		SwitchedOn = false;
		h.HoleDisappear();
		}catch(NullPointerException e){System.out.println("Worker stepped on switch with id: "+ this.id	+" but No corresponding hole to this switch");}
	}
}
