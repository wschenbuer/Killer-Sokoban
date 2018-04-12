package KillerSokoban;

import java.util.ArrayList;
import java.util.Scanner;


public class Floor implements Steppable
{
	
	 public static void SetWall(int size,ArrayList<Square> floor)
	{
		 ArrayList<Wall> wall = new ArrayList<Wall>();
		 int WallId=1;
		 
		for(int i=1;i<=size*size;++i)
		{
			
			
			if((i>=1&&i<=size)||(i%size==1)||(i%size==0)||(i>=(size*(size-1)+1)))
			{
				wall.add(new Wall(WallId,i));
				System.out.println("Wall with ID"+ WallId +" has been created on Square with ID " + i);
				
				int index= i-1;
				floor.get(index).IsOccupied=true;
				
				WallId++;
				
			
			}
				
		}
		 
	}
	
	 
	static public void CreateFloor(ArrayList<Square> floor)
	{
	
	System.out.println("Enter the size of map!\n");
	Scanner scan = new Scanner(System.in);
	int size = scan.nextInt();
	
	
    int idCounter = 1;
	
	for(int i=1;i<=size;i++)
	{
		for(int j=1;j<=size;j++)
		{
			floor.add(new Square(i,j,idCounter));
			System.out.println("Square with ID: " + idCounter + " has been created");
			idCounter++;
		}
	}
	
	
	for(int i =1,j =2;j<=size*size;i++,j++)
	{
	
		if(i%size==0)
		{
	
	int a=i+size;
	System.out.println("Square with ID "+ i +" has connected to the squre with ID"+ a);
		}else 
		{	
			int b = i+size;
			if(b<size*size+1)
			{
			System.out.println("Square with ID "+ i +" has connected to the squre with ID"+ b);
			}
			System.out.println("Square with ID "+ i +" has connected to the squre with ID"+ j);
			
		}
	
		
		
	
	}
	SetWall(size,floor);
	}
	public Worker GetWorker(Square s){
		return null;}
	
	public void CreateThing(){};
	
	
	
	public void Eliminate(Box b){}

	

	public void Step(Direction d) {
		// TODO Auto-generated method stub
		
	};
}
