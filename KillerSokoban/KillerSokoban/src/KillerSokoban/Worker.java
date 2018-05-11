package KillerSokoban;

import java.util.ArrayList;

public class Worker extends Thing implements Steppable{
	
	private int id;
	private int squareid;
	private boolean isDie;
	
	
static ArrayList<Square> floor = Floor.getSquare();
static ArrayList<Worker> workerlist = Floor.workerlist;

private boolean canMove;


public boolean passback()
{
	
return this.canMove;	
	
}

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
	Direction direction=null; int newSquareId = 0;
	if(d==Direction.UP){direction = Direction.UP; newSquareId = -6;}
	else if(d==Direction.DOWN){direction=Direction.DOWN; newSquareId = 6;}
	else if(d==Direction.LEFT){direction=Direction.LEFT; newSquareId = -1;}
	else if(d==Direction.RIGHT){direction=Direction.RIGHT; newSquareId = +1;}
	
	
		if(!this.isDie){
			
			
			if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("worker"))
			{	
				Worker worker = (Worker)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
				worker.HitBy(this);
			}
			else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("pillar")
					||floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("wall"))
			{
				
				Obstacle obstacle = (Obstacle)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
				obstacle.HitBy(this);
				this.canMove=false;
				
			}else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("box"))
			{
				
				Box box = (Box)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
				
				box.HitBy(this);
				if(box.passback()==true)this.Move(direction);
					
				
				
			}else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("nothing")&&floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectWithString().equals("nothing"))
			{
				this.canMove=true;
			this.Step(direction);
			
			}
			else if(floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectWithString().equals("switch"))
			{
				Hole hole = null;
				Switch switches = (Switch)floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectOnSquare();
				for(int i=0;i<Floor.holelist.size();i++)
				{
					if(Floor.holelist.get(i).getid()==switches.getid())
					{
						hole=Floor.holelist.get(i);
					}
				}
				
				
				this.canMove=true;
				this.Step(direction);
				switches.HitBy(this,hole);
			}
			else if(floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectWithString().equals("hole"))
			{
				Hole hole = (Hole)floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectOnSquare();
				this.Step(direction);
				hole.HitBy(this);
			}
			
			
			
			}else{System.out.println("Worker died, can not move");}
}
	

public void Die()   		
{   
	
	floor.get(this.squareid-1).Remove();
	workerlist.remove(this);
	this.isDie=true;
	System.out.println("Worker with ID: "+ this.id +" died" );
	
}
	
	public void HitBy(Box b){
		
		int BoxSquareId = b.getsquareid(); Direction direction=null;
		int newSquareId = 0;
		/*box comes from left*/if(BoxSquareId==this.squareid-1){direction=Direction.RIGHT;newSquareId = +1;}
		/*box comes from right*/else if(BoxSquareId==this.squareid+1){direction=Direction.LEFT;newSquareId = -1;}
		/*box comes from below*/else if(BoxSquareId==this.squareid+6){direction=Direction.UP;newSquareId = -6;}
		/*box comes from up*/else if(BoxSquareId==
				
				this.squareid-6){direction=Direction.DOWN;newSquareId = +6;}
		
		 if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("worker"))
		 {
			 Worker worker = (Worker)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
			this.canMove=true;
			 worker.HitBy(this);
			
		 }
		else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("nothing"))
		{
			
			this.canMove=true;
			
			
			this.Step(direction);
			
			
			
		
		}else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("wall")||
				floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("pillar"))
		{
			Obstacle obstacle = (Obstacle)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
			obstacle.HitBy(this);
			this.canMove=false;
			
			
		}else if(floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectWithString().equals("switch"))
		{
			Hole hole = null;
			Switch switches = (Switch)floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectOnSquare();
			for(int i=0;i<Floor.holelist.size();i++)
			{
				if(Floor.holelist.get(i).getid()==switches.getid())
				{
					hole=Floor.holelist.get(i);
				}
			}
			
			
			this.canMove=true;
			this.Step(direction);
			switches.HitBy(this,hole);
			
			
		}else if(floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectWithString().equals("hole"))
		{
			Hole hole = (Hole)floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectOnSquare();
			//this.canMove=true;
			this.Step(direction);
			this.canMove=true;
			hole.HitBy(this);
			
		}else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("box"))
		{
			Box box= (Box)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
			box.HitBy(this);
			if(box.passback()==true)
			{
				this.canMove=true;
				this.Step(direction);
			}
			
		}
		

	
}
	
	public void HitBy(Worker w){
		//DO NOTHING
		System.out.println("Worker hit by another worker, nothing happens");
	}
	
	

	public void Step(Direction d) {
		
		int newSquareId = 0;
		String direction = null;
		
		if(d==Direction.UP){ newSquareId = -6;direction="up";}
		else if(d==Direction.DOWN){newSquareId = 6;direction="down";}
		else if(d==Direction.LEFT){ newSquareId = -1;direction="left";}
		else if(d==Direction.RIGHT){ newSquareId = +1;direction="right";}
		
		floor.get(this.squareid-1).Remove();
		this.setsquareid(getsquareid()+newSquareId);
	    floor.get(this.squareid-1).SetObjectOnSquare(this);
	    System.out.println("Worker with ID "+ this.id + " moved to "+direction + ", Current square ID: "+this.squareid);
		
		
	}
}
