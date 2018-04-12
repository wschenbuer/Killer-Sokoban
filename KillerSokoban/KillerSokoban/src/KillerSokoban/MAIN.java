package KillerSokoban;

import java.util.ArrayList;
import java.util.Scanner;


public class MAIN {


	
	public static void main(String[] args) {
		ArrayList<Square> floor = new ArrayList<Square>();
		
		Floor.CreateFloor(floor);
		
		System.out.println("Add things now:\n");
		System.out.println("Avaliable things: Worker,Box,Hole,Switch,Pillar\n");
		System.out.println("The syntax is object objectid squareid\n");
		
		String userInput;
		Scanner scan = new Scanner(System.in);
		userInput = scan.nextLine();
		
		while(!userInput.equals("start"))
		{
			
			
		String[] Input = userInput.split(" ");
		userInput = Input[0];
		String thingId = Input[1];
		String squareID = Input[2];
		int thingidInt = Integer.parseInt(thingId);
		int squareIDInt = Integer.parseInt(squareID);
		int index = squareIDInt -1;
		if(floor.get(index).IsOccupied==false)
		{
			
			
			if(userInput.equals("Worker"))
			{
				
			}
			
		}else{ System.out.println("Occupied square!");}
		
		
		
		
		userInput = scan.nextLine();
		}
	}

	
}
