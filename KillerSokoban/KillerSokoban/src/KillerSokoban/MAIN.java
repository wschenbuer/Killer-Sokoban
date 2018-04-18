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
		
		System.out.println("Add things now:\n");
		System.out.println("Avaliable things: Worker,Box,Hole,Switch,Pillar\n");
		System.out.println("The syntax is object objectid squareid\n");
		
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
			
		if(!WorkerId.contains(thingId)&&thingId>=0)
		{
			
			if(floor.get(squareID-1).IsOccupied==false)
			{
			if(userInput.equals("worker"))
			{
				Worker worker = new Worker(thingId);
				worker.setsquareid(squareID);
				WorkerId.add(thingId);// add this ID to the worker ID list				
				
				floor.get(squareID-1).SetObjectOnSquare(worker);
				
				
			}else if(userInput.equals("box"))
			{
				Box box = new Box(thingId);
				box.setmap(floor);
				box.setsquareid(squareID);
				BoxId.add(thingId);// add this ID to the box ID list				
				
				floor.get(squareID-1).SetObjectOnSquare(box);
				
				System.out.println(floor.get(8).getOccupieThingOnSquareWithString());
				System.out.println(floor.get(8).getid());
				System.out.println("-----------------------------------");
				box.Step(Direction.UP);
				box.Step(Direction.LEFT);
				box.Step(Direction.DOWN);
				System.out.println(floor.get(24).getOccupieThingOnSquareWithString());
				
				
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
		
		
		userInput = scan.nextLine();
			
		}
		
		
	}

	
}
