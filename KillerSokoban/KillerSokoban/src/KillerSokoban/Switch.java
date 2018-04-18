package KillerSokoban;

public class Switch extends Thing {
	
	private int id;
	Switch(int id)
	{
		this.id=id;
	}
	
	public void HitBy(Box b){}
	public void HitBy(Worker w){}
}
