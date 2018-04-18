package KillerSokoban;

public class Worker extends Thing {
	
	private int id;
	private int squareid;
	
	public void setsquareid(int squareid)
	{
		this.squareid=squareid;
	}
	public int getsquareid()
	{return this.squareid;
	}
	public void Move(Direction d){
		
		
	}
	
	Worker(int id)
	{
		this.id=id;
	}
	
	public void Die(){
		

	}
	
	public void HitBy(Box b){
		
	}
	
	public void HitBy(Worker w){
		

	}
	
	public void CollideWith(Obstacle o){}
}
