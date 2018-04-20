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
			case UP:    floor.get(this.squareid-1).Remove();
						this.setsquareid(getsquareid()-6);
					    floor.get(this.squareid-1).SetObjectOnSquare(this); break;
			
			case LEFT:  floor.get(this.squareid-1).Remove();
						this.setsquareid(getsquareid()-1);
						floor.get(this.squareid-1).SetObjectOnSquare(this); break;
			
			case DOWN:  floor.get(this.squareid-1).Remove();
						this.setsquareid(getsquareid()+6);
						floor.get(this.squareid-1).SetObjectOnSquare(this); break;
			
			case RIGHT:  floor.get(this.squareid-1).Remove();
						 this.setsquareid(getsquareid()+1);
						 floor.get(this.squareid-1).SetObjectOnSquare(this); break;
			
		}	
}
	

public void Die()   		
{   
	
	floor.get(this.squareid-1).Remove();
}
	
	public void HitBy(Box b){
		
		System.out.println("Worker hitten by box");
		int boxsquareID = b.getsquareid();
		
		if(boxsquareID==this.squareid-1)//box is on your left side
		{
			System.out.println("Collision occured, there is a box on your left");
			//current square this.squareid-1
			if(floor.get(this.squareid-1+1).IsOccupied==false||floor.get(this.squareid-1+1).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Move(Direction.RIGHT);
			}else if(!floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("worker"))
			{
				this.Die();
				System.out.println("Worker die by sandwitch..");
			}
			
		}else if(boxsquareID==this.squareid+1)//worker is on your right side
		{
			System.out.println("there is a box on your right");
			if(floor.get(this.squareid-1-1).IsOccupied==false||floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Move(Direction.LEFT);
			}else if(!floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("worker"))
			{
				this.Die();
				System.out.println("Worker die by sandwitch..");
			}
			
		}else if(boxsquareID==this.squareid+6)//worker is below you
		{
			System.out.println("there is a box on your bottom");
			if(floor.get(this.squareid-1-6).IsOccupied==false||floor.get(this.squareid-1-6).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Move(Direction.UP);
			}else if(!floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("worker"))
			{
				this.Die();
				System.out.println("Worker die by sandwitch..");
			}
		}else if(boxsquareID==this.squareid-6)//worker is above you
		{
			System.out.println("there is a box on your top");
			if(floor.get(this.squareid-1+6).IsOccupied==false||floor.get(this.squareid-1+6).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Move(Direction.DOWN);
			}else if(!floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("worker"))
			{
				this.Die();
				System.out.println("Worker die by sandwitch..");
			}
		}

	
}
	
	public void HitBy(Worker w){
		//DO NOTHING
		System.out.println("Worker hit by another worker, nothing happens");
	}
	
	public void CollideWith(Obstacle o)
	{
		
	}
}
