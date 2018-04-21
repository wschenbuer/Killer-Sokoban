package KillerSokoban;

import java.awt.List;
import java.nio.channels.AlreadyBoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MAIN {
	
	static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}

	
	public static void main(String[] args) {
		
		ArrayList<Square> floor = new ArrayList<Square>();

		
		floor = Floor.getSquare();
		ArrayList<Integer> WorkerId = new ArrayList<Integer>();
		ArrayList<Integer> BoxId = new ArrayList<Integer>();
		ArrayList<Integer> HoleId = new ArrayList<Integer>();
		ArrayList<Integer> SwitchId = new ArrayList<Integer>();
		ArrayList<Integer> PillarId = new ArrayList<Integer>();
		
		Floor.CreateFloor(floor);
		
		ArrayList<Worker> workerlist = new ArrayList<Worker>();
		ArrayList<Box> boxlist = new ArrayList<Box>();
		ArrayList<Hole> holelist = new ArrayList<Hole>();
		
		
		
		System.out.println("Add things now:\n");
		System.out.println("Avaliable things: Worker,Box,Hole,Switch,Pillar");
		System.out.println("The syntax is object objectid squareid");
		//System.out.println("enter start to start game\n");
		String userInput;
		Scanner scan = new Scanner(System.in);
		userInput = scan.nextLine();
		userInput=userInput.toLowerCase();
		
		while(!userInput.equals("start"))
		{
	
			
		String[] Input = userInput.split(" ");
		
		userInput = Input[0];
		
		
		
		
		
		
		
		if(tryParseInt(Input[1])&&tryParseInt(Input[2]))
		{	
			int thingId = Integer.parseInt(Input[1]);
			int squareID = Integer.parseInt(Input[2]);
			int workerid = 0,boxid = 0,switchid = 0,holeid = 0,pillarid = 0;
			
			if(userInput.equals("worker")){workerid=thingId;}
			if(userInput.equals("box")){boxid=thingId;}
			if(userInput.equals("pillar")){pillarid=thingId;}
			if(userInput.equals("hole")){holeid=thingId;}
			if(userInput.equals("switch")){switchid=thingId;}
			
		if(!WorkerId.contains(workerid)&&thingId>=0&&!BoxId.contains(boxid)
				&&!SwitchId.contains(switchid)&&!HoleId.contains(holeid)&&!PillarId.contains(pillarid))
			
			
		{
			
			if(floor.get(squareID-1).IsOccupied==false)
			{
			if(userInput.equals("worker"))
			{
				Worker worker = new Worker(thingId);
				worker.setsquareid(squareID);
				WorkerId.add(thingId);// add this ID to the worker ID list				
				workerlist.add(worker);
				floor.get(squareID-1).SetObjectOnSquare(worker);
			
				
				
			}else if(userInput.equals("box"))
			{
				Box box = new Box(thingId);
				boxlist.add(box);
				box.setsquareid(squareID);
				BoxId.add(thingId);// add this ID to the box ID list				
				
				floor.get(squareID-1).SetObjectOnSquare(box);
				
				
				
			}else if(userInput.equals("hole"))
			{
				Hole hole = new Hole(thingId);
				hole.setsquareid(squareID);
				HoleId.add(thingId);// add this ID to the box ID list		
				holelist.add(hole);
				floor.get(squareID-1).SetObjectOnSquare(hole);
				
			}else if(userInput.equals("switch"))
			{
				Switch switches = new Switch(thingId);
				switches.setsquareid(squareID);
				SwitchId.add(thingId);// add this ID to the box ID list				
				
				floor.get(squareID-1).SetObjectOnSquare(switches);
			}else if(userInput.equals("pillar"))
			{
				Pillar pillar = new Pillar(thingId);
				pillar.setsquareid(squareID);
				PillarId.add(thingId);// add this ID to the box ID list
				
				
				floor.get(squareID-1).SetObjectOnSquare(pillar);
			}
			
			}else{System.out.println("Occupied square! Failed to create");}
			
		}else{ System.out.println("The input ID is invalid, please choose another ID!");}
		
		}else{System.out.println("please insert integer format!");}
		
		System.out.println("--Keep adding objects, or enter 'start' to start game--	" );
		userInput = scan.nextLine();
			
		}
		System.out.println("Game started!!");
		
		
		
		Game game = new Game();
		System.out.println("Make actions:");
		System.out.println("Syntax: Worker workerid direction ");
		System.out.println("Enter 'end' to stop game");
		
		
		while(game.IsStart)
		{
		
			
			String userInput1;
			Scanner scanner = new Scanner(System.in);
			userInput1 = scanner.nextLine();
			userInput1 = userInput1.toLowerCase();
			String[] Input1 = userInput1.split(" ");
			
			//System.out.println(Input1.length);//3
			if(Input1.length==1)
			{
				game.IsStart=false;
				System.out.println("Game END!");
				System.exit(0);
			}
			String firstelement = Input1[0];
			
			int workerid= Integer.parseInt(Input1[1]);
			
			String direction = Input1[2].toLowerCase();
			
			Direction d = null;
			if(direction.equals("up"))
			{
				d=Direction.UP;
			}else if(direction.equals("down"))
					{
				d=Direction.DOWN;
					}
			else if(direction.equals("left"))
			{
					d=Direction.LEFT;
			}
			else if(direction.equals("right"))
			{
					d=Direction.RIGHT;
			}
			
			
			Worker mainWorker = new Worker(100);
			WorkerId.add(100);
			//int currentworkersquareid = 0;
			int workerindex=0;
			for(int i=0;i<workerlist.size();i++,workerindex++)
			{
			if(workerlist.get(i).getworkerid()==workerid)
				{//currentworkersquareid=workerlist.get(i).getsquareid();
					mainWorker=workerlist.get(i);
				}
			
			}
			
			
			String neighborname,neighbor2name,neighbor3name;
			Square neighbor,neighbor2,neighbor3;
			
			Box box;
			Box box1;Worker worker;
			Worker worker1;
			
			
			
			/*
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			switch(d)
			{
			case UP:

				
				
				if(mainWorker.getsquareid()>=8&&mainWorker.getsquareid()<=11)
				{
				
					
				System.out.println("Wall infront, can not move");
				
				
				
				
				
				
				}
				
				if(mainWorker.getsquareid()>=14&&mainWorker.getsquareid()<=17)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.UP);
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.UP);
				
				neighbor2=neighbor.GetNeighbor(Direction.UP);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
			
				
				if(neighborname.equals("worker"))
				{
					worker = (Worker) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					worker.HitBy(mainWorker);
				}
				if(neighborname.equals("pillar"))
				{
					Pillar pillar = (Pillar) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					pillar.HitBy(mainWorker);
					
				}
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.UP);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					switches.HitBy(mainWorker, hole);
					
					
					
				}
				
				
				if(neighborname.equals("hole"))
				{
					////////////////////////////
					
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.UP);/*********************************************************************************************************************************/
					
					hole.HitBy(mainWorker);
					
				}
				
				if(!neighborname.equals("box")&&!neighborname.equals("pillar")&&!neighborname.equals("worker")&&!neighborname.equals("hole")&&!neighborname.equals("switch"))
				{
					
					
					mainWorker.Move(Direction.UP);
					
					
					
				}
				
				if(neighborname.equals("box")&&neighborname.equals("pillar")&&neighborname.equals("worker")){
					
					
					System.out.println("Can not move, thing infront!");
							
							
				}
				
				}
				
				
				if(mainWorker.getsquareid()>=20&&mainWorker.getsquareid()<=23)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.UP);
				
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.UP);
				
				neighbor2=neighbor.GetNeighbor(Direction.UP);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
				neighbor3=neighbor2.GetNeighbor(Direction.UP);
				neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
				
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.UP);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					switches.HitBy(mainWorker, hole);
					
					
					
				}
				
				if(neighborname.equals("box")&&neighbor2name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					
					box.HitBy(mainWorker);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					
					mainWorker.Move(Direction.UP);/*********************************************************************************************************************************/
					switches.HitBy(box, hole);
					
					
					
					
				}
				
				
				
				
				
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("nothing"))//Worker box
				{
					
				box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
				
				box.HitBy(mainWorker);
				
				mainWorker.Move(Direction.UP);
				
				
				
				}else if(neighborname.equals("box")&&(neighbor2name.equals("box")||(neighbor2name.equals("pillar"))))
				{
					box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					box.HitBy(mainWorker);
					
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("hole"))
				{		
					box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
					
					box.HitBy(mainWorker);
					
					
					
					
					//box.HitBy(mainWorker);
					mainWorker.Move(Direction.UP);
					hole.HitBy(box);
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("worker"))
				{
					
					box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					worker = (Worker) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
					
					worker.HitBy(box);
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.UP);
					
				
				}
				
				if(neighborname.equals("worker"))
				{
					worker = (Worker) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					worker.HitBy(mainWorker);
				}
				if(neighborname.equals("pillar"))
				{
					Pillar pillar = (Pillar) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					pillar.HitBy(mainWorker);
					
				}
					
				if(neighborname.equals("nothing"))
				{
					mainWorker.Move(Direction.UP);
					
				}
				if(neighborname.equals("hole"))
				{
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					mainWorker.Move(Direction.UP);
					hole.HitBy(mainWorker);
					
				}
				
				
				
				
				}
				
				
				if(mainWorker.getsquareid()>=26&&mainWorker.getsquareid()<=29)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.UP);
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.UP);
				
				neighbor2=neighbor.GetNeighbor(Direction.UP);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
				neighbor3=neighbor2.GetNeighbor(Direction.UP);
				neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					Hole hole = null;
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					mainWorker.Move(Direction.UP);
					switches.HitBy(mainWorker,hole);
					
					
				}
				
				if(neighborname.equals("worker"))
				{
					worker=(Worker)floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					
					worker.HitBy(mainWorker);
				}
				
				/*
				 * 
				 * 
				 * 
				 * */
				if(neighborname.equals("box")&&neighbor2name.equals("box")&&neighbor3name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-18).getthissquare().getObjectOnSquare();
					Hole hole = null;
					box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					box1 = (Box) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					box1.HitBy(box);
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.UP);
					switches.HitBy(box1,hole);
					
					
					
					
				}
				
				if(neighborname.equals("box")&&neighbor2name.equals("worker")&&neighbor3name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-18).getthissquare().getObjectOnSquare();
					Hole hole = null;
					box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					worker=(Worker)floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					worker.HitBy(box);
					
					
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.UP);
					switches.HitBy(worker,hole);
					
				}
				
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.UP);
					switches.HitBy(box, hole);
					
					
					
				}
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("nothing"))//Worker box
				{
					
				box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
				
				box.HitBy(mainWorker);
				
				mainWorker.Move(Direction.UP);
				
				
				}else if(neighborname.equals("box")&&(neighbor2name.equals("pillar")))
				{
					System.out.println("pillar infront, can not push box!");
					
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("worker"))
				{
					if(neighbor3name.equals("box")||neighbor3name.equals("pillar"))
					{
						worker = (Worker) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
						box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.UP);
						
						
					}
					if(neighbor3name.equals("hole"))//worker box worker hole
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
						Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-18).getthissquare().getObjectOnSquare();
						worker = (Worker) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
						
						hole.HitBy(worker);
						box.HitBy(mainWorker);
						
						
						mainWorker.Move(Direction.UP);
						
					}
					if(neighbor3name.equals("worker"))// worker box worker worker
					{
						System.out.println("can not move, stopped by 2 workers");
					}
					
					if(neighbor3name.equals("nothing"))//worker box worker nothing
					{
						
						box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
						worker=(Worker)floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.UP);
						
						
						
					}
				
				}else if(neighborname.equals("box")&&neighbor2name.equals("box"))
				{
					if(neighbor3name.equals("nothing"))
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
						
						
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.UP);
						
						
					}
					if(neighbor3name.equals("hole"))
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
						Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-18).getthissquare().getObjectOnSquare();
						
						
					
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.UP);
						hole.HitBy(box1);
						
						
					}
					if((neighbor3name.equals("pillar")||(neighbor3name.equals("box"))))
					{
						System.out.println("Can not move");
					}
					if((neighbor3name.equals("worker")))//worker box box worker
					{
						
						
						box = (Box) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1-12).getthissquare().getObjectOnSquare();
						worker=(Worker)floor.get(mainWorker.getsquareid()-1-18).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box1);
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.UP);
						
						
					}
					
				}else if(neighborname.equals("nothing"))
				{
					mainWorker.Move(Direction.UP);
					
				}
				if(neighborname.equals("hole"))
				{
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-6).getthissquare().getObjectOnSquare();
					mainWorker.Move(Direction.UP);
					hole.HitBy(mainWorker);
				}
}
				
				
				break;
				
			case DOWN: /***************************************************************************************************************************************************************/
				
				
				if(mainWorker.getsquareid()>=26&&mainWorker.getsquareid()<=29)
				{
				
					
				System.out.println("Wall infront, can not move");
				
				
				
				
				
				
				}
				
				if(mainWorker.getsquareid()>=20&&mainWorker.getsquareid()<=23)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.DOWN);
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.DOWN);
				
				neighbor2=neighbor.GetNeighbor(Direction.DOWN);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
			
				
				if(neighborname.equals("worker"))
				{
					worker = (Worker) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					worker.HitBy(mainWorker);
				}
				if(neighborname.equals("pillar"))
				{
					Pillar pillar = (Pillar) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					pillar.HitBy(mainWorker);
					
				}
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.DOWN);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					switches.HitBy(mainWorker, hole);
					
					
					
				}
				
				
				if(neighborname.equals("hole"))
				{
					////////////////////////////
					
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.DOWN);/*********************************************************************************************************************************/
					
					hole.HitBy(mainWorker);
					
					
				}
				
				if(!neighborname.equals("box")&&!neighborname.equals("pillar")&&!neighborname.equals("worker")&&!neighborname.equals("hole")&&!neighborname.equals("switch"))
				{
					
					
					mainWorker.Move(Direction.DOWN);
					
					
					
				}
				
				if(neighborname.equals("box")&&neighborname.equals("pillar")&&neighborname.equals("worker")){
					
					
					System.out.println("Can not move, thing infront!");
							
							
				}
				
				}
				
				
				if(mainWorker.getsquareid()>=14&&mainWorker.getsquareid()<=17)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.DOWN);
				
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.DOWN);
				
				neighbor2=neighbor.GetNeighbor(Direction.DOWN);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
				neighbor3=neighbor2.GetNeighbor(Direction.DOWN);
				neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
				
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.DOWN);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					switches.HitBy(mainWorker, hole);
					
					
					
				}
				
				if(neighborname.equals("box")&&neighbor2name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					
					box.HitBy(mainWorker);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					
					mainWorker.Move(Direction.DOWN);/*********************************************************************************************************************************/
					switches.HitBy(box, hole);
					
					
					
					
				}
				
				
				
				
				
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("nothing"))//Worker box
				{
					
				box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
				
				box.HitBy(mainWorker);
				
				mainWorker.Move(Direction.DOWN);
				
				
				
				}else if(neighborname.equals("box")&&(neighbor2name.equals("box")||(neighbor2name.equals("pillar"))))
				{
					box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					box.HitBy(mainWorker);
					
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("hole"))
				{		
					box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
					
					box.HitBy(mainWorker);
					
					
					
					
					//box.HitBy(mainWorker);
					mainWorker.Move(Direction.DOWN);
					hole.HitBy(box);
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("worker"))
				{
					
					box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					worker = (Worker) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
					
					worker.HitBy(box);
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.DOWN);
					
				
				}
				
				if(neighborname.equals("worker"))
				{
					worker = (Worker) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					worker.HitBy(mainWorker);
				}
				if(neighborname.equals("pillar"))
				{
					Pillar pillar = (Pillar) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					pillar.HitBy(mainWorker);
					
				}
					
				if(neighborname.equals("nothing"))
				{
					mainWorker.Move(Direction.DOWN);
					
				}
				if(neighborname.equals("hole"))
				{
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					mainWorker.Move(Direction.DOWN);
					hole.HitBy(mainWorker);
					
				}
				
				
				
				
				}
				
				
				if(mainWorker.getsquareid()>=8&&mainWorker.getsquareid()<=11)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.DOWN);
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.DOWN);
				
				neighbor2=neighbor.GetNeighbor(Direction.DOWN);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
				neighbor3=neighbor2.GetNeighbor(Direction.DOWN);
				neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					Hole hole = null;
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					mainWorker.Move(Direction.DOWN);
					switches.HitBy(mainWorker,hole);
					
					
				}
				
				if(neighborname.equals("worker"))
				{
					worker=(Worker)floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					
					worker.HitBy(mainWorker);
				}
				
				/*
				 * 
				 * 
				 * 
				 * */
				if(neighborname.equals("box")&&neighbor2name.equals("box")&&neighbor3name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+18).getthissquare().getObjectOnSquare();
					Hole hole = null;
					box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					box1 = (Box) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					box1.HitBy(box);
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.DOWN);
					switches.HitBy(box1,hole);
					
					
					
					
				}
				
				if(neighborname.equals("box")&&neighbor2name.equals("worker")&&neighbor3name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+18).getthissquare().getObjectOnSquare();
					Hole hole = null;
					box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					worker=(Worker)floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					worker.HitBy(box);
					
					
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.DOWN);
					switches.HitBy(worker,hole);
					
				}
				
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.DOWN);
					switches.HitBy(box, hole);
					
					
					
				}
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("nothing"))//Worker box
				{
					
				box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
				
				box.HitBy(mainWorker);
				
				mainWorker.Move(Direction.DOWN);
				
				
				}else if(neighborname.equals("box")&&(neighbor2name.equals("pillar")))
				{
					System.out.println("pillar infront, can not push box!");
					
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("worker"))
				{
					if(neighbor3name.equals("box")||neighbor3name.equals("pillar"))
					{
						worker = (Worker) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
						box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.DOWN);
						
						
					}
					if(neighbor3name.equals("hole"))//worker box worker hole
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
						Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+18).getthissquare().getObjectOnSquare();
						worker = (Worker) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
						
						hole.HitBy(worker);
						box.HitBy(mainWorker);
						
						
						mainWorker.Move(Direction.DOWN);
						
					}
					if(neighbor3name.equals("worker"))// worker box worker worker
					{
						System.out.println("can not move, stopped by 2 workers");
					}
					
					if(neighbor3name.equals("nothing"))//worker box worker nothing
					{
						
						box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
						worker=(Worker)floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.DOWN);
						
						
						
					}
				
				}else if(neighborname.equals("box")&&neighbor2name.equals("box"))
				{
					if(neighbor3name.equals("nothing"))
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
						
						
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.DOWN);
						
						
					}
					if(neighbor3name.equals("hole"))
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
						Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+18).getthissquare().getObjectOnSquare();
						
						
					
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.DOWN);
						hole.HitBy(box1);
						
						
					}
					if((neighbor3name.equals("pillar")||(neighbor3name.equals("box"))))
					{
						System.out.println("Can not move");
					}
					if((neighbor3name.equals("worker")))//worker box box worker
					{
						
						
						box = (Box) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1+12).getthissquare().getObjectOnSquare();
						worker=(Worker)floor.get(mainWorker.getsquareid()-1+18).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box1);
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.DOWN);
						
						
					}
					
				}else if(neighborname.equals("nothing"))
				{
					mainWorker.Move(Direction.DOWN);
					
				}
				
				if(neighborname.equals("hole"))
				{
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+6).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.DOWN);
					
					hole.HitBy(mainWorker);
					
				}
}
				break;
			case LEFT:   /***************************************************************************************************************************************************************/
				
				
				if(mainWorker.getsquareid()%6==2)
				{
				
					
				System.out.println("Wall infront, can not move");
				
				
				
				
				
				
				}
				
				if(mainWorker.getsquareid()%6==3)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.LEFT);
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.LEFT);
				
				neighbor2=neighbor.GetNeighbor(Direction.LEFT);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
			
				
				if(neighborname.equals("worker"))
				{
					worker = (Worker) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					worker.HitBy(mainWorker);
				}
				if(neighborname.equals("pillar"))
				{
					Pillar pillar = (Pillar) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					pillar.HitBy(mainWorker);
					
				}
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.LEFT);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					switches.HitBy(mainWorker, hole);
					
					
					
				}
				
				
				if(neighborname.equals("hole"))
				{
					////////////////////////////
					
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.LEFT);/*********************************************************************************************************************************/
					
					hole.HitBy(mainWorker);
					
				}
				
				if(!neighborname.equals("box")&&!neighborname.equals("pillar")&&!neighborname.equals("worker")&&!neighborname.equals("hole")&&!neighborname.equals("switch"))
				{
					
					
					mainWorker.Move(Direction.LEFT);
					
					
					
				}
				
				if(neighborname.equals("box")&&neighborname.equals("pillar")&&neighborname.equals("worker")){
					
					
					System.out.println("Can not move, thing infront!");
							
							
				}
				
				}
				
				
				if(mainWorker.getsquareid()%6==4)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.LEFT);
				
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.LEFT);
				
				neighbor2=neighbor.GetNeighbor(Direction.LEFT);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
				neighbor3=neighbor2.GetNeighbor(Direction.LEFT);
				neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
				
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.LEFT);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					switches.HitBy(mainWorker, hole);
					
					
					
				}
				
				if(neighborname.equals("box")&&neighbor2name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					
					box.HitBy(mainWorker);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					
					mainWorker.Move(Direction.LEFT);/*********************************************************************************************************************************/
					switches.HitBy(box, hole);
					
					
					
					
				}
				
				
				
				
				
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("nothing"))//Worker box
				{
					
				box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
				
				box.HitBy(mainWorker);
				
				mainWorker.Move(Direction.LEFT);
				
				
				
				}else if(neighborname.equals("box")&&(neighbor2name.equals("box")||(neighbor2name.equals("pillar"))))
				{
					box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					box.HitBy(mainWorker);
					
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("hole"))
				{		
					box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
					
					box.HitBy(mainWorker);
					
					
					
					
					//box.HitBy(mainWorker);
					mainWorker.Move(Direction.LEFT);
					hole.HitBy(box);
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("worker"))
				{
					
					box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					worker = (Worker) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
					
					worker.HitBy(box);
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.LEFT);
					
				
				}
				
				if(neighborname.equals("worker"))
				{
					worker = (Worker) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					worker.HitBy(mainWorker);
				}
				if(neighborname.equals("pillar"))
				{
					Pillar pillar = (Pillar) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					pillar.HitBy(mainWorker);
					
				}
					
				if(neighborname.equals("nothing"))
				{
					mainWorker.Move(Direction.LEFT);
					
				}
				if(neighborname.equals("hole"))
				{
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					mainWorker.Move(Direction.LEFT);
					hole.HitBy(mainWorker);
					
				}
				
				
				
				
				}
				
				
				if(mainWorker.getsquareid()%6==5)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.LEFT);
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.LEFT);
				
				neighbor2=neighbor.GetNeighbor(Direction.LEFT);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
				neighbor3=neighbor2.GetNeighbor(Direction.LEFT);
				neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					Hole hole = null;
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					mainWorker.Move(Direction.LEFT);
					switches.HitBy(mainWorker,hole);
					
					
				}
				
				if(neighborname.equals("worker"))
				{
					worker=(Worker)floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					
					worker.HitBy(mainWorker);
				}
				
				/*
				 * 
				 * 
				 * 
				 * */
				if(neighborname.equals("box")&&neighbor2name.equals("box")&&neighbor3name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-3).getthissquare().getObjectOnSquare();
					Hole hole = null;
					box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					box1 = (Box) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					box1.HitBy(box);
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.LEFT);
					switches.HitBy(box1,hole);
					
					
					
					
				}
				
				if(neighborname.equals("box")&&neighbor2name.equals("worker")&&neighbor3name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-3).getthissquare().getObjectOnSquare();
					Hole hole = null;
					box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					worker=(Worker)floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					worker.HitBy(box);
					
					
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.LEFT);
					switches.HitBy(worker,hole);
					
				}
				
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.LEFT);
					switches.HitBy(box, hole);
					
					
					
				}
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("nothing"))//Worker box
				{
					
				box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
				
				box.HitBy(mainWorker);
				
				mainWorker.Move(Direction.LEFT);
				
				
				}else if(neighborname.equals("box")&&(neighbor2name.equals("pillar")))
				{
					System.out.println("pillar infront, can not push box!");
					
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("worker"))
				{
					if(neighbor3name.equals("box")||neighbor3name.equals("pillar"))
					{
						worker = (Worker) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
						box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.LEFT);
						
						
					}
					if(neighbor3name.equals("hole"))//worker box worker hole
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
						Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-3).getthissquare().getObjectOnSquare();
						worker = (Worker) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
						
						hole.HitBy(worker);
						box.HitBy(mainWorker);
						
						
						mainWorker.Move(Direction.LEFT);
						
					}
					if(neighbor3name.equals("worker"))// worker box worker worker
					{
						System.out.println("can not move, stopped by 2 workers");
					}
					
					if(neighbor3name.equals("nothing"))//worker box worker nothing
					{
						
						box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
						worker=(Worker)floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.LEFT);
						
						
						
					}
				
				}else if(neighborname.equals("box")&&neighbor2name.equals("box"))
				{
					if(neighbor3name.equals("nothing"))
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
						
						
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.LEFT);
						
						
					}
					if(neighbor3name.equals("hole"))
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
						Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-3).getthissquare().getObjectOnSquare();
						
						
					
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.LEFT);
						hole.HitBy(box1);
						
						
					}
					if((neighbor3name.equals("pillar")||(neighbor3name.equals("box"))))
					{
						System.out.println("Can not move");
					}
					if((neighbor3name.equals("worker")))//worker box box worker
					{
						
						
						box = (Box) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1-2).getthissquare().getObjectOnSquare();
						worker=(Worker)floor.get(mainWorker.getsquareid()-1-3).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box1);
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.LEFT);
						
						
					}
					
				}else if(neighborname.equals("nothing"))
				{
					mainWorker.Move(Direction.LEFT);
					
				}
				if(neighborname.equals("hole"))
				{
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1-1).getthissquare().getObjectOnSquare();
					mainWorker.Move(Direction.LEFT);
					hole.HitBy(mainWorker);
				}
}
				
				break;
			case RIGHT: /************************************************************************************************************************/
				
				if(mainWorker.getsquareid()%6==5)
				{
				
					
				System.out.println("Wall infront, can not move");
				
				
				
				
				
				
				}
				
				if(mainWorker.getsquareid()%6==4)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.RIGHT);
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.RIGHT);
				
				neighbor2=neighbor.GetNeighbor(Direction.RIGHT);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
			
				
				if(neighborname.equals("worker"))
				{
					worker = (Worker) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					worker.HitBy(mainWorker);
				}
				if(neighborname.equals("pillar"))
				{
					Pillar pillar = (Pillar) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					pillar.HitBy(mainWorker);
					
				}
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.RIGHT);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					switches.HitBy(mainWorker, hole);
					
					
					
				}
				
				
				if(neighborname.equals("hole"))
				{
					////////////////////////////
					
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.RIGHT);/*********************************************************************************************************************************/
					
					hole.HitBy(mainWorker);
					
				}
				
				if(!neighborname.equals("box")&&!neighborname.equals("pillar")&&!neighborname.equals("worker")&&!neighborname.equals("hole")&&!neighborname.equals("switch"))
				{
					
					
					mainWorker.Move(Direction.RIGHT);
					
					
					
				}
				
				if(neighborname.equals("box")&&neighborname.equals("pillar")&&neighborname.equals("worker")){
					
					
					System.out.println("Can not move, thing infront!");
							
							
				}
				
				}
				
				
				if(mainWorker.getsquareid()%6==3)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.RIGHT);
				
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.RIGHT);
				
				neighbor2=neighbor.GetNeighbor(Direction.RIGHT);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
				neighbor3=neighbor2.GetNeighbor(Direction.RIGHT);
				neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
				
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					
					mainWorker.Move(Direction.RIGHT);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					switches.HitBy(mainWorker, hole);
					
					
					
				}
				
				if(neighborname.equals("box")&&neighbor2name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					
					box.HitBy(mainWorker);
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					
					mainWorker.Move(Direction.RIGHT);/*********************************************************************************************************************************/
					switches.HitBy(box, hole);
					
					
					
					
				}
				
				
				
				
				
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("nothing"))//Worker box
				{
					
				box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
				
				box.HitBy(mainWorker);
				
				mainWorker.Move(Direction.RIGHT);
				
				
				
				}else if(neighborname.equals("box")&&(neighbor2name.equals("box")||(neighbor2name.equals("pillar"))))
				{
					box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					box.HitBy(mainWorker);
					
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("hole"))
				{		
					box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
					
					box.HitBy(mainWorker);
					
					
					
					
					//box.HitBy(mainWorker);
					mainWorker.Move(Direction.RIGHT);
					hole.HitBy(box);
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("worker"))
				{
					
					box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					worker = (Worker) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
					
					worker.HitBy(box);
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.RIGHT);
					
				
				}
				
				if(neighborname.equals("worker"))
				{
					worker = (Worker) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					worker.HitBy(mainWorker);
				}
				if(neighborname.equals("pillar"))
				{
					Pillar pillar = (Pillar) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					pillar.HitBy(mainWorker);
					
				}
					
				if(neighborname.equals("nothing"))
				{
					mainWorker.Move(Direction.RIGHT);
					
				}
				if(neighborname.equals("hole"))
				{
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					mainWorker.Move(Direction.RIGHT);
					hole.HitBy(mainWorker);
					
				}
				
				
				
				
				}
				
				
				if(mainWorker.getsquareid()%6==2)
				{
				neighborname=floor.get(mainWorker.getsquareid()-1).GetNeighborStringName(Direction.RIGHT);
				neighbor=floor.get(mainWorker.getsquareid()-1).GetNeighbor(Direction.RIGHT);
				
				neighbor2=neighbor.GetNeighbor(Direction.RIGHT);
				neighbor2name=neighbor2.getOccupieThingOnSquareWithString();
				
				neighbor3=neighbor2.GetNeighbor(Direction.RIGHT);
				neighbor3name=neighbor3.getOccupieThingOnSquareWithString();
				
				if(neighborname.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					Hole hole = null;
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					mainWorker.Move(Direction.RIGHT);
					switches.HitBy(mainWorker,hole);
					
					
				}
				
				if(neighborname.equals("worker"))
				{
					worker=(Worker)floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					
					worker.HitBy(mainWorker);
				}
				
				/*
				 * 
				 * 
				 * 
				 * */
				if(neighborname.equals("box")&&neighbor2name.equals("box")&&neighbor3name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+3).getthissquare().getObjectOnSquare();
					Hole hole = null;
					box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					box1 = (Box) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					box1.HitBy(box);
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.RIGHT);
					switches.HitBy(box1,hole);
					
					
					
					
				}
				
				if(neighborname.equals("box")&&neighbor2name.equals("worker")&&neighbor3name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+3).getthissquare().getObjectOnSquare();
					Hole hole = null;
					box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					worker=(Worker)floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					worker.HitBy(box);
					
					
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.RIGHT);
					switches.HitBy(worker,hole);
					
				}
				
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("switch"))
				{
					Switch switches = (Switch) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
					Hole hole = null;// = (Hole) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					
					
					for(int i=0;i<holelist.size();i++)
					{
						if(holelist.get(i).getid()==switches.getid())
						{
							hole=holelist.get(i);
							
						}
					}
					box.HitBy(mainWorker);
					mainWorker.Move(Direction.RIGHT);
					switches.HitBy(box, hole);
					
					
					
				}
				
				
				if(neighborname.equals("box")&&neighbor2name.equals("nothing"))//Worker box
				{
					
				box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
				
				box.HitBy(mainWorker);
				
				mainWorker.Move(Direction.RIGHT);
				
				
				}else if(neighborname.equals("box")&&(neighbor2name.equals("pillar")))
				{
					System.out.println("pillar infront, can not push box!");
					
					
				}else if(neighborname.equals("box")&&neighbor2name.equals("worker"))
				{
					if(neighbor3name.equals("box")||neighbor3name.equals("pillar"))
					{
						worker = (Worker) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
						box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.RIGHT);
						
						
					}
					if(neighbor3name.equals("hole"))//worker box worker hole
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
						Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+3).getthissquare().getObjectOnSquare();
						worker = (Worker) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
						
						hole.HitBy(worker);
						box.HitBy(mainWorker);
						
						
						mainWorker.Move(Direction.RIGHT);
						
					}
					if(neighbor3name.equals("worker"))// worker box worker worker
					{
						System.out.println("can not move, stopped by 2 workers");
					}
					
					if(neighbor3name.equals("nothing"))//worker box worker nothing
					{
						
						box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
						worker=(Worker)floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.RIGHT);
						
						
						
					}
				
				}else if(neighborname.equals("box")&&neighbor2name.equals("box"))
				{
					if(neighbor3name.equals("nothing"))
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
						
						
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.RIGHT);
						
						
					}
					if(neighbor3name.equals("hole"))
					{
						box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
						Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+3).getthissquare().getObjectOnSquare();
						
						
					
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.RIGHT);
						hole.HitBy(box1);
						
						
					}
					if((neighbor3name.equals("pillar")||(neighbor3name.equals("box"))))
					{
						System.out.println("Can not move");
					}
					if((neighbor3name.equals("worker")))//worker box box worker
					{
						
						
						box = (Box) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
						box1 = (Box) floor.get(mainWorker.getsquareid()-1+2).getthissquare().getObjectOnSquare();
						worker=(Worker)floor.get(mainWorker.getsquareid()-1+3).getthissquare().getObjectOnSquare();
						
						worker.HitBy(box1);
						box1.HitBy(box);
						box.HitBy(mainWorker);
						mainWorker.Move(Direction.RIGHT);
						
						
					}
					
				}else if(neighborname.equals("nothing"))
				{
					mainWorker.Move(Direction.RIGHT);
					
				}
				if(neighborname.equals("hole"))
				{
					Hole hole = (Hole) floor.get(mainWorker.getsquareid()-1+1).getthissquare().getObjectOnSquare();
					mainWorker.Move(Direction.RIGHT);
					hole.HitBy(mainWorker);
				}
}
				break;
			}	
		
			
			
			
				
			
		}
		
	}
}


	
