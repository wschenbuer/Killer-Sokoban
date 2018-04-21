package KillerSokoban;

import java.util.ArrayList;

public class Worker extends Thing {
	
	private int id;
	private int squareid;
	private boolean isDie;
	
	
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
			case UP:    if(!this.isDie){
						floor.get(this.squareid-1).Remove();
						this.setsquareid(getsquareid()-6);
					    floor.get(this.squareid-1).SetObjectOnSquare(this);
					    System.out.println("Worker with ID "+ this.id + " moved up"); 
						}else
						{
							System.out.println("Worker died, can not move");
						}
						break;
			
			case LEFT:   if(!this.isDie){
						floor.get(this.squareid-1).Remove();
						this.setsquareid(getsquareid()-1);
						floor.get(this.squareid-1).SetObjectOnSquare(this); 
						System.out.println("Worker with ID "+ this.id + " moved left");
						}else
						{
							System.out.println("Worker died, can not move");
						}
						
						break;
			
			case DOWN:  if(!this.isDie){
						floor.get(this.squareid-1).Remove();
						this.setsquareid(getsquareid()+6);
						floor.get(this.squareid-1).SetObjectOnSquare(this); 
						System.out.println("Worker with ID "+ this.id + " moved down");
						}else
						{
						 System.out.println("Worker died, can not move");
						}
						break;
			
			case RIGHT: 
						if(!this.isDie){
						floor.get(this.squareid-1).Remove();
						 this.setsquareid(getsquareid()+1);
						 floor.get(this.squareid-1).SetObjectOnSquare(this);
						 System.out.println("Worker with ID "+ this.id + " moved right");
						}else
						{
						 System.out.println("Worker died, can not move");
						}
						 
						 break;
			
		}	
}
	

public void Die()   		
{   
	
	floor.get(this.squareid-1).Remove();
	this.isDie=true;
}
	
	public void HitBy(Box b){
		
		
		int boxsquareID = b.getsquareid();
		
		if(boxsquareID==this.squareid-1)//box is on your left side
		{
			
			//current square this.squareid-1
			if(floor.get(this.squareid-1+1).IsOccupied==false||floor.get(this.squareid-1+1).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Move(Direction.RIGHT);
			}else if(!floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("worker"))
			{
				this.Die();
				System.out.println("Worker with ID: "+ this.id  + " die by sandwitch..");
			}
			
		}else if(boxsquareID==this.squareid+1)//worker is on your right side
		{
			
			if(floor.get(this.squareid-1-1).IsOccupied==false||floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Move(Direction.LEFT);
			}else if(!floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("worker"))
			{
				this.Die();
				System.out.println("Worker with ID: "+ this.id  + " die by sandwitch..");
			}
			
		}else if(boxsquareID==this.squareid+6)//worker is below you
		{
			
			if(floor.get(this.squareid-1-6).IsOccupied==false||floor.get(this.squareid-1-6).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Move(Direction.UP);
			}else if(!floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("worker"))
			{
				this.Die();
				System.out.println("Worker with ID: "+ this.id  + " die by sandwitch..");
			}
		}else if(boxsquareID==this.squareid-6)//worker is above you
		{
			
			if(floor.get(this.squareid-1+6).IsOccupied==false||floor.get(this.squareid-1+6).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Move(Direction.DOWN);
			}else if(!floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("worker"))
			{
				this.Die();
				System.out.println("Worker with ID: "+ this.id  + " die by sandwitch..");
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
