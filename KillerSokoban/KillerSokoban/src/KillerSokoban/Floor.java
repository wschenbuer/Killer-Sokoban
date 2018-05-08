package KillerSokoban;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;


public class Floor extends JPanel implements Steppable
{
	static ArrayList<Square> floor = new ArrayList<Square>();
	static ArrayList<Worker> workerlist = new ArrayList<Worker>();
	static ArrayList<Hole> holelist = new ArrayList<Hole>();
	static View view= new View();

	public void setView(View view)
	{
		this.view= view;
	}
	
	public static ArrayList<Square> getSquare()
	{
		return floor;
		
	}
	
	
	 public static void SetWall(int size)
	{
		ArrayList<Wall> wall = new ArrayList<Wall>();
		 int WallId=1;
		
		 int x=0,y=0;
		 //Iterate through all squares
		for(int i=1;i<=size*size;i++)
		{
			
			//  top side      || left side || right side|| bottom side
			if((i>=1&&i<=size)||(i%size==1)||(i%size==0)||(i>=(size*(size-1)+1)))
			{
				Wall walls = new Wall(WallId,i);
				wall.add(new Wall(WallId,i));//add walls into squares that has ID = i
				System.out.println("Wall with ID"+ WallId +" has been created on Square with ID " + i);
				
				for(int u=0;u<size*size;u++)
				{
					
					if(floor.get(u).getid()==i)
					{
						x=floor.get(u).getX()-1;
						y=floor.get(u).getY()-1;
					}
				}
				
				
				//view.createWall(x, y);/*create wall on GUI*/
				
				
				
				floor.get(i-1).SetObjectOnSquare(walls);/*Create wall in game engine*/
				
				
				WallId++;//each time we place a new wall, the next wall should have the id = WallID++
				
			
			}
				
		}
		
	}
	
	 
	static public void CreateFloor(ArrayList<Square> floor)
	{
	
	System.out.println("Building map");
	int size = 6; // map size 15*15
	
	
    int squareid = 1;
	
	for(int i=1;i<=size;i++)
	{
		for(int j=1;j<=size;j++)
		{
			floor.add(new Square(i,j,squareid));
			System.out.println("Square with ID: " + squareid + " has been created");
			squareid++;
		}
	}
	
	
	for(int i =1,j =2;j<=size*size;i++,j++)
	{
		//right-most column
		if(i%size==0)
		{
	
	int a=i+size;//connects to the square under it, in n*n matrix, i + n is the ID of the square under square i
	System.out.println("Square with ID "+ i +" has connected to the squre with ID"+ a);
		}else //non right-most columns
		{	
			
			int b = i+size;//connects to the square under it
			
			//making sure that last square do no connect to the square under it. 
			if(b<size*size+1)/* eg. in 3 by 3 matrix, Square with ID 9 should not connect to 
								the square under it since it self is the last square.*/
			{
			System.out.println("Square with ID "+ i +" has connected to the squre with ID"+ b);//b=i+size; b is under i;
			}
			System.out.println("Square with ID "+ i +" has connected to the squre with ID"+ j);//j=i+1;
			
		}
	
		
		
	
	}
	SetWall(size);// calls setwall function after creating map
	}
	public Worker GetWorker(Square s){
		return null;}
	
	public void CreateThing(){};
	
	
	
	public void Eliminate(Box b){}

	

	public void Step(Direction d) {
		// TODO Auto-generated method stub
		
	};
}
