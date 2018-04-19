package KillerSokoban;

import java.awt.List;
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
		
		
		
		System.out.println("Add things now:\n");
		System.out.println("Avaliable things: Worker,Box,Hole,Switch,Pillar\n");
		System.out.println("The syntax is object objectid squareid\n");
		System.out.println("enter start to start game\n");
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
				
				/*for(int i = 0; i<workerlist.size();i++)
				{
					if(workerlist.get(i).getsquareid()==box.getsquareid()-1)
					{
						box.HitBy(workerlist.get(i));
					}
				}*/
				
			}else if(userInput.equals("hole"))
			{
				Hole hole = new Hole(thingId);
				hole.setsquareid(squareID);
				HoleId.add(thingId);// add this ID to the box ID list				
				
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
		
		System.out.println("--------------------------Enter start to start game" );
		userInput = scan.nextLine();
			
		}
		System.out.println("Game started!!");
		
		
		
		Game game = new Game();
		
		while(game.IsStart)
		{
			System.out.println("Make actions:");
			System.out.println("Syntax: Worker workerid direction \n");
			
			String userInput1;
			Scanner scanner = new Scanner(System.in);
			userInput1 = scanner.nextLine();
			userInput1 = userInput1.toLowerCase();
			String[] Input1 = userInput1.split(" ");
			
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
			
			
			for(int i=0;i<workerlist.size();i++)
			{
			if(workerlist.get(i).getworkerid()==workerid)
			{
				workerlist.get(i).Move(d);
			}
			}
			
			
			
			System.out.println("Do you want to continue playing?YES/NO");
			String answer = scanner.nextLine().toUpperCase();
			if(answer.equals("NO"))
			{
				game.IsStart=false;
			}
		}
		
	}

	
}
