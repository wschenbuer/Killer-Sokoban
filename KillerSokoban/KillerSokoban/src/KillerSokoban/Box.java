package KillerSokoban;

import java.util.ArrayList;

public class Box extends Obstacle implements Steppable  {
	
	private int id;
	private int squareid;
	static ArrayList<Square> floor = Floor.getSquare();//new ArrayList<Square>();
	private boolean canMove;
	
	
	public boolean passback()
	{
		
	return this.canMove;	
		
	}
	
	
	public void setsquareid(int squareid)
	{
		this.squareid=squareid;
	}
	public int getsquareid()
	{return this.squareid;
	}
	
	 public int getboxid()
	 {
		 return this.id;
	 }
	Box(int id)
	{
		this.id=id;
		
	}
	
	
	
	
	public void HitBy(Worker w)
	{
		
	
		int WorkerSquareID = w.getsquareid(); Direction direction=null;
		int newSquareId = 0;
		/*worker comes from left*/if(WorkerSquareID==this.squareid-1){direction=Direction.RIGHT;newSquareId = +1;}
		/*worker comes from right*/else if(WorkerSquareID==this.squareid+1){direction=Direction.LEFT;newSquareId = -1;}
		/*worker comes from below*/else if(WorkerSquareID==this.squareid+6){direction=Direction.UP;newSquareId = -6;}
		/*worker comes from up*/else if(WorkerSquareID==this.squareid-6){direction=Direction.DOWN;newSquareId = +6;}
		
		
		
		 if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("worker"))
		 {
			 Worker worker = (Worker)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
			 worker.HitBy(this);
			 
			 if(worker.passback()==false)
			 {
				
				 worker.Die();
				this.canMove=true;
				 this.Step(direction);
				
			 }else
			 {
				 
				
				 this.canMove=true;
				 this.Step(direction);
			 }
			 
			
		 }
		else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("nothing")&&floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectWithString().equals("nothing"))
		{
			
			this.canMove=true;
			this.Step(direction);
			
			
		}else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("wall")||
				floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("pillar"))
		{
			Obstacle obstacle = (Obstacle)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
			this.canMove=false;
			obstacle.HitBy(this);
			
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
	
	
	
	public void HitBy(Box b)
	{
		
		int BoxSquareId = b.getsquareid(); Direction direction=null;
		int newSquareId = 0;
		/*box comes from left*/if(BoxSquareId==this.squareid-1){direction=Direction.RIGHT;newSquareId = +1;}
		/*box comes from right*/else if(BoxSquareId==this.squareid+1){direction=Direction.LEFT;newSquareId = -1;}
		/*box comes from below*/else if(BoxSquareId==this.squareid+6){direction=Direction.UP;newSquareId = -6;}
		/*box comes from up*/else if(BoxSquareId==this.squareid-6){direction=Direction.DOWN;newSquareId = +6;}
		
		
		
		
		 if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("worker"))
		 {
			 Worker worker = (Worker)floor.get(this.squareid-1).GetNeighbor(direction).getObjectOnSquare();
			 worker.HitBy(this);
			 if(worker.passback()==false)
			 {
				 worker.Die();
				this.canMove=true;	
				 this.Step(direction);
				 
			 }else
			 {
				 
				 this.canMove=true;
				 this.Step(direction);
			 }
		 }
		else if(floor.get(this.squareid-1).GetNeighbor(direction).getOccupieThingOnSquareWithString().equals("nothing")&&floor.get(this.squareid-1).GetNeighbor(direction).getSpecialObjectWithString().equals("nothing"))
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
	
	public Square GetSquare(){
		
		return floor.get(this.squareid-1);
	}
	public void Eliminate()
	{
		int squareid = this.getsquareid();
		floor.get(squareid-1).Remove();
	}

	public void Step(Direction d) {
		
		
		switch(d)
		{
			case UP:    floor.get(this.squareid-1).Remove();
						
						this.setsquareid(this.squareid-6);
					    floor.get(this.squareid-1).SetObjectOnSquare(this);
					   
					    System.out.println("Box with ID:"+this.id + " moved to up " +",Current Square ID: "+this.squareid);
					    break;
			
			case LEFT:  floor.get(this.squareid-1).Remove();
						this.setsquareid(this.squareid-1);
						
						floor.get(this.squareid-1).SetObjectOnSquare(this); 
						
						System.out.println("Box with ID:"+this.id + " moved to left "+",Current Square ID: "+this.squareid);
						break;
			
			case DOWN:  floor.get(this.squareid-1).Remove();
						this.setsquareid(this.squareid+6);
						floor.get(this.squareid-1).SetObjectOnSquare(this);
						System.out.println("Box with ID:"+this.id + " moved to down "+",Current Square ID: "+this.squareid);
						break;
			
			case RIGHT:  floor.get(this.squareid-1).Remove();
						this.setsquareid(this.squareid+1);
						 floor.get(this.squareid-1).SetObjectOnSquare(this);
						 System.out.println("Box with ID:"+this.id + " moved to right "+",Current Square ID: "+this.squareid);
						 break;
					
			
		}
		
	}
	
	


	
}
