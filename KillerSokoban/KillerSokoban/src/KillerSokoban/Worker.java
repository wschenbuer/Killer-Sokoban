package KillerSokoban;

import java.util.ArrayList;

public class Worker extends Thing {
	
	private int id;
	private int squareid;
	
	
	
static ArrayList<Square> floor = Floor.getSquare();

public int getworkerid()
{return this.id;}

public void setsquareid(int squareid)
{
	this.squareid=squareid;
}
public int getsquareid()
{return this.squareid;
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
						this.setsquareid(getsquareid()-6-1);
					    floor.get(this.squareid-6-1).SetObjectOnSquare(this); break;
			
			case LEFT:  floor.get(this.squareid).Remove();
						this.setsquareid(getsquareid()-1-1);
						floor.get(this.squareid-1-1).SetObjectOnSquare(this); break;
			
			case DOWN:  floor.get(this.squareid).Remove();
						this.setsquareid(getsquareid()+6-1);
						floor.get(this.squareid+6-1).SetObjectOnSquare(this); break;
			
			case RIGHT:  floor.get(this.squareid).Remove();
						 this.setsquareid(getsquareid()+1-1);
						 floor.get(this.squareid+1-1).SetObjectOnSquare(this); break;
			
		}	
}
	

public void Die()   		
{   
	floor.get(this.squareid-1).Remove();
}
	
	public void HitBy(Box b){
		
		int boxsquareID = b.getsquareid();
		if(boxsquareID==this.squareid-1)//box is on your left side
		{
			System.out.println("Collision occured, there is a box on your left");
			//current square this.squareid-1
			if(floor.get(this.squareid-1+1).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1-1).Remove();
			floor.get(this.squareid-1+1).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
			
		}else if(boxsquareID==this.squareid+1)//worker is on your right side
		{
			System.out.println("Collision occured, there is a box on your right");
			if(floor.get(this.squareid-1-1).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1+1).Remove();
			floor.get(this.squareid-1-1).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
			
		}else if(boxsquareID==this.squareid+6)//worker is below you
		{
			System.out.println("Collision occured, there is a box on your bottom");
			if(floor.get(this.squareid-1-6).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1+6).Remove();
			floor.get(this.squareid-1-6).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
		}else if(boxsquareID==this.squareid-6)//worker is above you
		{
			System.out.println("Collision occured, there is a box on your top");
			if(floor.get(this.squareid-1+6).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1-6).Remove();
			floor.get(this.squareid-1+6).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
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
