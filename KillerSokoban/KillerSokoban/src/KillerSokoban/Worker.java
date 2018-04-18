package KillerSokoban;

import java.util.ArrayList;

public class Worker extends Thing {
	
	private int id;
	private int squareid;
	
	
	
static ArrayList<Square> floor = Floor.getSquare();

public void setsquareid(int squareid)
{
	this.squareid=squareid;
}
	
public int getsquareid()
{
	return this.squareid;
}
	
Worker(int id)
{
	this.id=id;
}
	
public void Move(Direction d)
{
	switch(d)
		{
			case UP:    floor.get(this.squareid).Remove();
					    floor.get(this.squareid-6-1).SetObjectOnSquare(this); break;
			
			case LEFT:  floor.get(this.squareid).Remove();
						floor.get(this.squareid-1-1).SetObjectOnSquare(this); break;
			
			case DOWN:  floor.get(this.squareid).Remove();
						floor.get(this.squareid+6-1).SetObjectOnSquare(this); break;
			
			case RIGHT:  floor.get(this.squareid).Remove();
						 floor.get(this.squareid+1-1).SetObjectOnSquare(this); break;
			
		}	
}
	

public void Die()   		
{   
	floor.get(this.squareid-1).Remove();
}
	
	public void HitBy(Box b){
		int BoxSquareID = b.getsquareid();
		
		if (BoxSquareID==this.squareid-1)  //Box is on the left 
		{
			if (floor.get(this.squareid+1).IsOccupied==false) {
				this.squareid= this.squareid+1;			
				b.setsquareid(BoxSquareID+1);

		} else if ( BoxSquareID==this.squareid+1) //right
		{
			if (floor.get(this.squareid-1).IsOccupied==false) {
				this.squareid= this.squareid-1;			
				b.setsquareid(BoxSquareID-1);				
			}
			
		} else if (BoxSquareID==this.squareid+6)
		{
			if (floor.get(this.squareid-6).IsOccupied==false) {
				this.squareid= this.squareid-6;			
				b.setsquareid(BoxSquareID-6);
			}
			
		} else if (BoxSquareID==this.squareid-6) 
		{
			if (floor.get(this.squareid+6).IsOccupied==false) {
				this.squareid= this.squareid+6;			
				b.setsquareid(BoxSquareID+6);
			}
		}
		
	}
}
	
	public void HitBy(Worker w){
		//DO NOTHING
	}
	
	public void CollideWith(Obstacle o)
	{
		
	}
}
