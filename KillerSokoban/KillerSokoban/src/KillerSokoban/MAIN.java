package KillerSokoban;

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
		//CREATE OBJECTS
		Floor floor1= new Floor();
		View view = new View();
		floor1.setView(view);
		FieldMap map = new FieldMap(6,6);
		ArrayList<Square> floor = new ArrayList<Square>();
		floor = Floor.getSquare();
		ArrayList<Integer> WorkerId = new ArrayList<Integer>();
		ArrayList<Integer> BoxId = new ArrayList<Integer>();
		ArrayList<Integer> HoleId = new ArrayList<Integer>();
		ArrayList<Integer> SwitchId = new ArrayList<Integer>();
		ArrayList<Integer> PillarId = new ArrayList<Integer>();
		floor = Floor.CreateFloor(floor);  //create map
		view.setVisible(true); 
		ArrayList<Worker> workerlist = new ArrayList<Worker>();
		ArrayList<Box> boxlist = new ArrayList<Box>();
		ArrayList<Hole> holelist = new ArrayList<Hole>();
		//--------------
		workerlist=Floor.workerlist;
		holelist=Floor.holelist;
		
		System.out.println("Add things now:\n");
		System.out.println("Avaliable things: Worker,Box,Hole,Switch,Pillar");
		System.out.println("The syntax is object objectid squareid");
		//System.out.println("enter start to start game\n");
		String userInput;
		Scanner scan = new Scanner(System.in);
		userInput = scan.nextLine();
		userInput=userInput.toLowerCase();
		
		while(!userInput.equals("start")) //Loop for creating objects on the map
		{
		String[] Input = userInput.split(" ");
		userInput = Input[0].toLowerCase();
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
			//COMPARE USER INPUT SO THAT THE PROGRAM CAN REALIZE IT AND CREATE ON MAP
			if(floor.get(squareID-1).IsOccupied==false||userInput.equals("hole")||userInput.equals("switch"))
			{
			if(userInput.equals("worker")) //create worker
			{
				Worker worker = new Worker(thingId);
				worker.setsquareid(squareID);
				WorkerId.add(thingId);// add this ID to the worker ID list				
				workerlist.add(worker);
				floor.get(squareID-1).SetObjectOnSquare(worker);

				
				
			}else if(userInput.equals("box")) //create box
			{
				Box box = new Box(thingId);
				boxlist.add(box);
				box.setsquareid(squareID);
				BoxId.add(thingId);// add this ID to the box ID list				
				
				floor.get(squareID-1).SetObjectOnSquare(box);
				
				
				
			}else if(userInput.equals("hole")) //create hole
			{
				Hole hole = new Hole(thingId);
				hole.setsquareid(squareID);
				HoleId.add(thingId);// add this ID to the box ID list		
				holelist.add(hole);
				floor.get(squareID-1).SetHoleOnSquare(hole);
				
			}else if(userInput.equals("switch")) //create switch
			{
				Switch switches = new Switch(thingId);
				switches.setsquareid(squareID);
				SwitchId.add(thingId);// add this ID to the box ID list				
				
				floor.get(squareID-1).SetSwitchOnSquare(switches);
			}else if(userInput.equals("pillar")) //create pillar
			{
				Pillar pillar = new Pillar(thingId);
				pillar.setsquareid(squareID);
				PillarId.add(thingId);// add this ID to the box ID list
				
				
				floor.get(squareID-1).SetObjectOnSquare(pillar);
			}
			
			}else{System.out.println("Occupied square! Failed to create");}
			
		}else{ System.out.println("The input ID is invalid, please choose another ID!");}
		
		}else{System.out.println("please insert integer format!");}
		map.refresh(floor); //refresh the map every time object is created
		System.out.println("--Keep adding objects, or enter 'start' to start game--	" );
		userInput = scan.nextLine();
			
		}
		System.out.println("Game started!!");
		
		
		boolean AllBoxesAreStuckCheckFirst=true;
		
		
		//check if boxes are stuck, if it is, the game will end
		for(int i=0;i<boxlist.size();i++)
		{
			if(boxlist.get(i).getsquareid()!=8&&boxlist.get(i).getsquareid()!=11&&boxlist.get(i).getsquareid()!=26&&boxlist.get(i).getsquareid()!=29)
			{
				AllBoxesAreStuckCheckFirst=false;
				
			}
		}
		
		if(AllBoxesAreStuckCheckFirst)
		{
			System.out.println("All boxes are stuck, game ends now!!");
			System.exit(0);
		}
		
		
		
		
		
		Game game = new Game();
		System.out.println("Make actions:");
		System.out.println("Syntax: Worker workerid direction ");
		System.out.println("Enter 'end' to stop game");

		
		while(game.IsStart) // THE GAME START AND PROCESS THE GAME FOR WHENEVER WORKER MOVE
		{
		
			
			String userInput1;
			Scanner scanner = new Scanner(System.in);
			userInput1 = scanner.nextLine();
			userInput1 = userInput1.toLowerCase();
			String[] Input1 = userInput1.split(" ");
			if(Input1.length==1)
			{
				game.IsStart=false;
				System.out.println("Game END!");
				System.exit(0);
			}
			String firstelement = Input1[0].toLowerCase();
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
			for(int i=0;i<workerlist.size();i++)
			{
			if(workerlist.get(i).getworkerid()==workerid)
				{
					mainWorker=workerlist.get(i);
				}
			
			}
		
			
			
			switch(d)
			{
			case UP:	mainWorker.Move(Direction.UP);  break;
				
			case DOWN:	mainWorker.Move(Direction.DOWN);	break;
				
			case LEFT:	mainWorker.Move(Direction.LEFT);	break;
				
			case RIGHT:	mainWorker.Move(Direction.RIGHT);	break;
			
			}
			map.refresh(floor);
			
			boolean AllBoxesAreStuckCheckSecond=true;
			
		
			
			for(int i=0;i<boxlist.size();i++)
			{
				if(boxlist.get(i).getsquareid()!=8&&boxlist.get(i).getsquareid()!=11&&boxlist.get(i).getsquareid()!=26&&boxlist.get(i).getsquareid()!=29)
				{
					AllBoxesAreStuckCheckSecond=false;
					
				}
			}
			//CHECK CONDITION FOR GAME ENDING
			if(AllBoxesAreStuckCheckSecond)
			{
				System.out.println("All boxes are stuck, game ends now!!");
				System.exit(0);
			}
			
			
			if(workerlist.size()==0)
			{
				System.out.println("All workers died, game end");
				System.exit(0);
			}
			
		}
		
	}
}


	
