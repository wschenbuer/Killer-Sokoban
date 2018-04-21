package KillerSokoban;

public class Pillar extends Obstacle {

	private int id;
private int squareid;
	
	public void setsquareid(int squareid)
	{
		this.squareid=squareid;
	}
	public int getsquareid()
	{return this.squareid;
	}
	Pillar(int id)
	{
		this.id=id;
	}
	public void HitBy(Worker w)
	{
		System.out.println("Pillar infront, can not move");
	}
	public void HitBy(Box box)
	{
		System.out.println("Pillar infront, can not move");
	}
}
