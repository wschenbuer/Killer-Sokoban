package KillerSokoban;

import java.util.ArrayList;

public class Box extends Obstacle implements Steppable  {
	
	private int id;
	private int squareid;
	static ArrayList<Square> floor = Floor.getSquare();//new ArrayList<Square>();
	
	
	
	
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
		
	
		int WorkerSquareID = w.getsquareid();
		if(WorkerSquareID==this.squareid-1)//worker is on your left side
		{
			//current square this.squareid-1
			if(floor.get(this.squareid-1+1).IsOccupied==false||floor.get(this.squareid-1+1).getOccupieThingOnSquareWithString().equals("hole")
					||floor.get(this.squareid-1+1).getOccupieThingOnSquareWithString().equals("switch"))
			{
			
			this.Step(Direction.RIGHT);
			
			
			}else{
			System.out.println("Next square occuiped"+ floor.get(this.squareid-1+1).getOccupieThingOnSquareWithString());
			}
			
		}else if(WorkerSquareID==this.squareid+1)//worker is on your right side
		{
			if(floor.get(this.squareid-1-1).IsOccupied==false||floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("hole")
					||floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("switch"))
			{
			this.Step(Direction.LEFT);
			
			
			
			}else{
			System.out.println("Next square occuiped"+ floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString());
			}
			
		}else if(WorkerSquareID==this.squareid+6)//worker is below you
		{
			if(floor.get(this.squareid-1-6).IsOccupied==false||floor.get(this.squareid-1-6).getOccupieThingOnSquareWithString().equals("hole")
					||floor.get(this.squareid-1-6).getOccupieThingOnSquareWithString().equals("switch"))
			{
				
				
			this.Step(Direction.UP);
			
			
			}else{System.out.println("Next square occuiped"+ floor.get(this.squareid-1-6).getOccupieThingOnSquareWithString());}
		}else if(WorkerSquareID==this.squareid-6)//worker is above you
		{
			if(floor.get(this.squareid-1+6).IsOccupied==false||floor.get(this.squareid-1+6).getOccupieThingOnSquareWithString().equals("hole")
					||floor.get(this.squareid-1+6).getOccupieThingOnSquareWithString().equals("switch"))
			{
			this.Step(Direction.DOWN);
			
			}else{System.out.println("Next square occuiped"+ floor.get(this.squareid-1+6).getOccupieThingOnSquareWithString());}
		}
	}
	
	public void HitBy(Box b)
	{
		
		int boxsquareID = b.getsquareid();
		if(boxsquareID==this.squareid-1)//box is on your left side
		{
			//current square this.squareid-1
			if(floor.get(this.squareid-1+1).IsOccupied==false||floor.get(this.squareid-1+1).getOccupieThingOnSquareWithString().equals("hole"))
			{
			this.Step(Direction.RIGHT);
			
			}else{System.out.println("Next square occuiped, can not move");}
			
		}else if(boxsquareID==this.squareid+1)//box is on your right side
		{
			if(floor.get(this.squareid-1-1).IsOccupied==false||floor.get(this.squareid-1-1).getOccupieThingOnSquareWithString().equals("hole"))
			{
				this.Step(Direction.LEFT);
				
			}else{System.out.println("Next square occuiped, can not move");}
			
		}else if(boxsquareID==this.squareid+6)//box is below you
		{
			if(floor.get(this.squareid-1-6).IsOccupied==false||floor.get(this.squareid-1-6).getOccupieThingOnSquareWithString().equals("hole"))
			{
				this.Step(Direction.UP);
				
				
			}else{System.out.println("Next square occuiped, can not move");}
		}else if(boxsquareID==this.squareid-6)//box is above you
		{
			if(floor.get(this.squareid-1+6).IsOccupied==false||floor.get(this.squareid-1+6).getOccupieThingOnSquareWithString().equals("hole"))
			{
				this.Step(Direction.DOWN);
			
			}else{System.out.println("Next square occuiped, can not move");}
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
					    System.out.println("Box with ID:"+this.id + " moved to up");
					    break;
			
			case LEFT:  floor.get(this.squareid-1).Remove();
						this.setsquareid(this.squareid-1);
						floor.get(this.squareid-1).SetObjectOnSquare(this); 
						System.out.println("Box with ID:"+this.id + " moved to left");
						break;
			
			case DOWN:  floor.get(this.squareid-1).Remove();
						this.setsquareid(this.squareid+6);
						floor.get(this.squareid-1).SetObjectOnSquare(this);
						System.out.println("Box with ID:"+this.id + " moved to down");
						break;
			
			case RIGHT:  floor.get(this.squareid-1).Remove();
						this.setsquareid(this.squareid+1);
						 floor.get(this.squareid-1).SetObjectOnSquare(this);
						 System.out.println("Box with ID:"+this.id + " moved to right");
						 break;
					
			
		}
		
	}
	
	


	
}
