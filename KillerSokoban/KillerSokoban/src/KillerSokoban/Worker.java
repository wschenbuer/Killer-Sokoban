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
	System.out.println("worker died");
	floor.get(this.squareid-1).Remove();
}
	
	public void HitBy(Box b){
		
		System.out.println("Worker hitten by box");
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
			System.out.println("there is a box on your right");
			if(floor.get(this.squareid-1-1).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1+1).Remove();
			floor.get(this.squareid-1-1).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
			
		}else if(boxsquareID==this.squareid+6)//worker is below you
		{
			System.out.println("there is a box on your bottom");
			if(floor.get(this.squareid-1-6).IsOccupied==false)
			{
			floor.get(this.squareid-1).Remove();
			floor.get(this.squareid-1+6).Remove();
			floor.get(this.squareid-1-6).SetObjectOnSquare(this);
			floor.get(this.squareid-1).SetObjectOnSquare(b);
			}
		}else if(boxsquareID==this.squareid-6)//worker is above you
		{
			System.out.println("there is a box on your top");
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
		System.out.println("Worker hit by another worker, nothing happens");
	}
	
	public void CollideWith(Obstacle o)
	{
		
	}
}
/* neighbor=floor.get(this.squareid-1).GetNeighbor(Direction.UP);
			 neighborname=neighbor.getOccupieThingOnSquareWithString();
				
				neighbor2=neighbor.GetNeighbor(Direction.UP);
			 neighbor2name=neighbor2.getOccupieThingOnSquareWithString();	
				
			 neighbor3=neighbor2.GetNeighbor(Direction.UP);
			 neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
			object2 = neighbor2.getObjectOnSquare();
			 object3 = neighbor3.getObjectOnSquare();
						
						System.out.println(neighbor);
						if(neighborname.equals("nothing")||neighborname.equals("switch"))//when nothing, moves
						{
							
						floor.get(this.squareid-1).Remove();
					    floor.get(this.squareid-6-1).SetObjectOnSquare(this);
					    System.out.println("Worker moved up to square " + (this.squareid-6));
					    this.squareid=this.squareid-6;
					    
						}
						else if(neighborname.equals("worker")||neighborname.equals("pillar")||neighborname.equals("wall"))
						{
							System.out.println("Unable to move! There is an object preventing movement");
						}else if(neighborname.equals("hole"))
						{
							this.Die();
						}else if(neighborname.equals("box"))//worker box
						{
							if(neighbor2name.equals("pillar")||neighbor2name.equals("wall"))//worker box pillar wall
							{
								System.out.println("there is a pillar infront, can not move");
							}
							
							if(neighbor2name.equals("hole"))//worker box hole
							{
								
								
								floor.get(this.squareid-1-6).Remove();
								floor.get(this.squareid-1).Remove();
								floor.get(this.squareid-1-6).SetObjectOnSquare(this);
								System.out.println("box disappeared by falling into hole");
								this.squareid=this.squareid-6;
							}
							if((neighbor2name.equals("box")||neighbor2name.equals("worker"))&&neighbor3name.equals("hole"))//worker box box hole
							{
								floor.get(this.squareid-1-12).Remove();
								floor.get(this.squareid-1-6).Remove();
								floor.get(this.squareid-1).Remove();
								
								floor.get(this.squareid-1-12).SetObjectOnSquare(object2);
								floor.get(this.squareid-1-6).SetObjectOnSquare(this);
								this.squareid=this.squareid-6;
								
							}
							
							
							if(neighbor2name.equals("box")&&neighbor3name.equals("nothing"))//worker box box nothing
							{
								floor.get(this.squareid-1).Remove();
								floor.get(this.squareid-1-6).Remove();
								floor.get(this.squareid-1-12).Remove();
								
								floor.get(this.squareid-1-18).SetObjectOnSquare(object3);
								floor.get(this.squareid-1-12).SetObjectOnSquare(object2);
								floor.get(this.squareid-1-6).SetObjectOnSquare(this);
								this.squareid=this.squareid-6;
							}else if(neighbor2name.equals("box")&&((neighbor3name.equals("pillar"))||neighbor3name.equals("wall")
									||neighbor3name.equals("box")))//worker box box obstacle
							{
								System.out.println("box box obstacle, cannot move");
								
							}
							
							
							
							if(neighbor2name.equals("nothing"))//worker box nothing
							{
								floor.get(this.squareid-1).Remove();
								floor.get(this.squareid-1-6).Remove();
								floor.get(this.squareid-1-12).SetObjectOnSquare(object2);
								floor.get(this.squareid-1-6).SetObjectOnSquare(this);
								this.squareid=this.squareid-6;
							} else if (neighbor2name.equals("worker")){//worker box worker
								
								if(neighbor3name.equals("nothing"))//worker box worker nothing
								{
									
									floor.get(this.squareid-1).Remove();
									floor.get(this.squareid-1-6).Remove();
									floor.get(this.squareid-1-12).Remove();
									floor.get(this.squareid-1-18).SetObjectOnSquare(object3);
									floor.get(this.squareid-1-12).SetObjectOnSquare(object2);
									floor.get(this.squareid-1-6).SetObjectOnSquare(this);
									this.squareid=this.squareid-6;
								}else if(neighbor3name.equals("worker"))//worker box worker worker
								{
									System.out.println("There are box worker worker infront of you");
								}else if(neighbor3name.equals("wall")||neighbor3name.equals("pillar")||
										neighbor3name.equals("box"))//worker box worker obstacle, sandwitch
								{
									floor.get(this.squareid-1-12).Remove();
								}
							}
							
							
							
						}*/

