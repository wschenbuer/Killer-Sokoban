package KillerSokoban;

import java.util.Scanner;

public class MAIN {

	/*Functions here*/
	public static void WorkerPushBox(Worker worker, Square square,Box box,Direction d,Thing t)
	{
		
		
		
		
		
		worker.Move(d);
		box.HitBy(worker);
		worker.HitBy(box);
		
		
		Scanner scanner = new Scanner(System.in);
		
		square.GetNeighbor(d);
		
		System.out.println("Does square1 has a neighbor?Y/N");
		String reader = scanner.nextLine();
		char answer = reader.charAt(0);
		if(answer=='Y'){square.GetNeighbor(d); }
		else return;
		
		
		
		square.GetNeighbor(d);
		
		System.out.println("Does square2 has a neighbor?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.GetNeighbor(d);}
		
		
		
		
		square.Remove(t);
		
		System.out.println("Can we remove worker1 from square?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.GetNeighbor(d);}
		
		
		
		
		square.Remove(t);
		
		System.out.println("Can we remove box1 from square?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.GetNeighbor(d);}
		
		
		
		System.out.println("Can we accept worker1 from square?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.GetNeighbor(d);}
		
		
		
		System.out.println("Can we accept box1 from square?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.GetNeighbor(d);}
		
		
		
		
		
	}
	/*Function here*/
	public static void BoxPushBox1(Worker worker, Box b1, Square square,
			 Thing t, Direction d) {	
		
		worker.Move(d);
		b1.HitBy(worker);
		worker.HitBy(b1);
		square.GetNeighbor(d);
		
		Scanner scanner = new Scanner(System.in);
		
	    System.out.print("Does square 1 has a neighbor? Y/N");
	    String input = scanner.nextLine();
	    char c = input.charAt(0);
	    if(c == 'Y'){
	    	square.GetNeighbor(d);
	    }else
	    	return;
	    
	    System.out.print("Does square 2 has a neighbor? Y/N");
	    String input1 = scanner.nextLine();
	    char c1 = input1.charAt(0);
	    if(c1 == 'Y'){
	    	square.GetNeighbor(d);
	    }else
	    	return;
	    
	    System.out.print("Does square 3 has a neighbor? Y/N");
	    String input2 = scanner.nextLine();
	    char c2 = input2.charAt(0);
	    if(c2 == 'Y'){
	    	square.GetNeighbor(d);
	    }else
	    	return;
	    
	    System.out.print("Can we remove worker1 from square? Y/N");
	    String input3 = scanner.nextLine();
	    char c3 = input3.charAt(0);
	    if(c3 == 'Y'){
	    	square.Remove(t);
	    }else
	    	return;
	    
	    System.out.print("Can we remove box from square? Y/N");
	    String input4 = scanner.nextLine();
	    char c4 = input4.charAt(0);
	    if(c4 == 'Y'){
	    	square.Remove(t);
	    }else
	    	return;
	    
	    System.out.print("Can we remove worker2 from square? Y/N");
	    String input5 = scanner.nextLine();
	    char c5 = input5.charAt(0);
	    if(c5 == 'Y'){
	    	square.Remove(t);
	    }else
	    	return;
	    
	    System.out.print("Can we remove worker2 from square? Y/N");
	    String input6 = scanner.nextLine();
	    char c6 = input6.charAt(0);
	    if(c6 == 'Y'){
	    	square.Remove(t);
	    }else
	    	return;
	    
	    System.out.print("Can we accept worker1 from square? Y/N");
	    String input7 = scanner.nextLine();
	    char c7 = input7.charAt(0);
	    if(c7 == 'Y'){
	    	square.Accept(t);
	    }else
	    	return;
	    
	    System.out.print("Can we accept box1 from square? Y/N");
	    String input8 = scanner.nextLine();
	    char c8 = input8.charAt(0);
	    if(c8 == 'Y'){
	    	square.Accept(t);
	    }else
	    	return;
	    
	    System.out.print("Can we accept worker2 from square? Y/N");
	    String input9 = scanner.nextLine();
	    char c9 = input9.charAt(0);
	    if(c9 == 'Y'){
	    	square.Accept(t);
	    }else
	    	return;

	    
	}
	
	/*Function here*/
	public static void WorkerDiesbyHole(Hole hole, Worker worker, Game game) {
        hole.HitBy(worker);
        worker.Die();
        System.out.println("Is worker on the floor? Y/N ");
        Scanner scanner = new Scanner(System.in);
        String reader= scanner.nextLine();
        char answer=reader.charAt(0);
        if (answer=='Y')
       { game.endGame();}
       
         else  return;
     }
	/*Function here*/
	public static void SwitchOn(Box box, Worker worker, Switch s,Direction d,Square square,Hole hole)
	{
	       worker.Move(d);
	       box.HitBy(worker);
	       s.HitBy(box);
	       square.GetNeighbor(d);
	       Scanner scanner = new Scanner(System.in);
	        System.out.println("Does square1 has a neighbor? Y/N  ");
	       String reader1= scanner.nextLine();
	       char answer1=reader1.charAt(0);
	      if (answer1=='Y')
	     {
	       square.GetNeighbor(d);
	      }
	     else  return;
	       square.GetNeighbor(d);
	System.out.println("Does square2 has a neighbor? Y/N  ");
	       String reader2= scanner.nextLine();
	       char answer2=reader2.charAt(0);
	if (answer2=='Y')
	     {
	       square.GetNeighbor(d);
	     }
	else  return;
	       square.GetNeighbor(d);
	System.out.println("Does square3 has a neighbor? Y/N  ");
	       String reader3= scanner.nextLine();
	       char answer3=reader3.charAt(0);
	if (answer3=='Y')
	     {
	       square.GetNeighbor(d);
	     }
	else  return;
	       square.Remove(worker);
	System.out.println("can we remove worker from square? Y/N  ");
	       String reader4= scanner.nextLine();
	       char answer4=reader4.charAt(0);
	if (answer4=='Y')
	     {
	       square.Remove(worker);
	      }else return;
	
	     square.Remove(box);
	System.out.println("can we remove box from square? Y/N  ");
	       String reader5= scanner.nextLine();
	       char answer5=reader5.charAt(0);
	if (answer5=='Y')
	     {
	     square.Remove(box);
	     }
	else  return;

	System.out.println("can we turn on? Y/N  ");
	       String reader6= scanner.nextLine();
	       char answer6=reader6.charAt(0);
	if (answer6=='Y')
	     {
	     hole.SwitchedOn();
	     }
	else  return;
	}
	
	
	
	/*Function here*/
	 public static void workerDiesBySandwich(Worker worker,Box box,Square square,Direction d,Obstacle obstacle,Game game) 
	 {
	        worker.Move(d);
	        box.HitBy(worker);
	        worker.HitBy(box);
	        square.GetNeighbor(d);
	        String s;
	        char c;
	        System.out.println("4.1 Does square 1 have a neighbor? Y/N");
	        Scanner reader = new Scanner(System.in);
	        s = reader.nextLine();
	        c = s.charAt(0);
	        if (c == 'Y') { square.GetNeighbor(d);;
	           
	        }else return;
	        
	        square.GetNeighbor(d);
	        System.out.println("4.1.2 Does square 2 have a neighbor? Y/N");
	        s = reader.nextLine();
	        c = s.charAt(0);
	        if (c == 'Y') {square.GetNeighbor(d);

	        }else return;
	        
	        square.Remove(worker);
	        System.out.println("4.2 Can we remove worker? Y/N");
	        s = reader.nextLine();
	        c = s.charAt(0);
	        if (c == 'Y') {square.Remove(worker);

	        }else return;
	        
	        
	        square.Remove(box);
	        System.out.println("4.3 Can we remove box? Y/N");
	        s = reader.nextLine();
	        c = s.charAt(0);
	        if (c == 'Y') {square.Remove(box);

	        }else return;
	        
	        square.Remove(worker);
	        System.out.println("4.4 Can we remove worker? Y/N");
	        s = reader.nextLine();
	        c = s.charAt(0);
	        if (c == 'Y') {square.Remove(worker);

	        }else return;
	        
	        System.out.println("4.5");
	        obstacle.HitBy(worker);
	        worker.Die();
	        System.out.println("4.6 No more workers? Y/N");
	        s = reader.nextLine();
	        c = s.charAt(0);
	        if (c == 'Y') {game.endGame();}

	        
	    }
	 /*Function here*/
	 public static void boxDisappear(Worker worker,Box box,Floor floor,Game game,Obstacle obstacle,
			 Hole hole,Switch switch1, Square square, Direction d) {
	       
	       
	        worker.Move(d);
	        box.HitBy(worker);
	        hole.HitBy(box);
	        square.GetNeighbor(d);
	        System.out.println("11.1 Does square 1 have a neighbor? Y/N");
	        Scanner reader = new Scanner(System.in);
	        String s = reader.nextLine();
	        char c = s.charAt(0);
	        if (c == 'Y') {square.GetNeighbor(d);
	            
	        }
	        
	        square.Remove(worker);
	        System.out.println("11.2 Can we remove worker from square? Y/N");
	        s = reader.nextLine();
	        c = s.charAt(0);
	        if (c == 'Y') {
	        	square.Remove(worker);
	            
	        }
	        
	        square.Remove(box);
	        System.out.println("11.3 Can we remove box from square? Y/N");
	        s = reader.nextLine();
	        c = s.charAt(0);
	        if (c == 'Y') {
	        	square.Remove(box);
	            
	        }
	        
	        
	        floor.Eliminate(box);
	    }
		/*Function here*/
		public static void SwitchOff(Box box, Worker worker, Switch s,Direction d,Square square,Hole hole)
		{
		       worker.Move(d);
		       box.HitBy(worker);
		       s.HitBy(box);
		       square.GetNeighbor(d);
		       Scanner scanner = new Scanner(System.in);
		        System.out.println("Does square1 has a neighbor? Y/N  ");
		       String reader1= scanner.nextLine();
		       char answer1=reader1.charAt(0);
		      if (answer1=='Y')
		     {
		       square.GetNeighbor(d);
		      }
		     else  return;
		       square.GetNeighbor(d);
		System.out.println("Does square2 has a neighbor? Y/N  ");
		       String reader2= scanner.nextLine();
		       char answer2=reader2.charAt(0);
		if (answer2=='Y')
		     {
		       square.GetNeighbor(d);
		     }
		else  return;
		       square.GetNeighbor(d);
		System.out.println("Does square3 has a neighbor? Y/N  ");
		       String reader3= scanner.nextLine();
		       char answer3=reader3.charAt(0);
		if (answer3=='Y')
		     {
		       square.GetNeighbor(d);
		     }
		else  return;
		       square.Remove(worker);
		System.out.println("can we remove worker from square? Y/N  ");
		       String reader4= scanner.nextLine();
		       char answer4=reader4.charAt(0);
		if (answer4=='Y')
		     {
		       square.Remove(worker);
		      }else return;
		
		     square.Remove(box);
		System.out.println("can we remove box from square? Y/N  ");
		       String reader5= scanner.nextLine();
		       char answer5=reader5.charAt(0);
		if (answer5=='Y')
		     {
		     square.Remove(box);
		     }
		else  return;

		System.out.println("can we turn off? Y/N  ");
		       String reader6= scanner.nextLine();
		       char answer6=reader6.charAt(0);
		if (answer6=='Y')
		     {
		     hole.SwitchedOFF();
		     }
		else  return;
		}
	/*Function here*/
		public static void WorkerMove(Square square, Worker worker, Direction d,Thing t)
		{
			square.GetNeighbor(d);
			System.out.println("Is there a Neighbor for square? N/Y");
			
			Scanner scanner = new Scanner(System.in);
			String reader = scanner.nextLine();
			char answer = reader.charAt(0);
			if(answer=='Y'){square.GetNeighbor(d);}
			else return;
			
			square.Accept(worker);
			System.out.println("Accept worker to next square? Y/N");
			
			reader = scanner.nextLine();
			answer = reader.charAt(0);
			if(answer=='Y'){square.Accept(worker);}
			else return;
			
			square.Remove(worker);
			System.out.println("Remove worker from previous square? Y/N");
			reader = scanner.nextLine();
			answer = reader.charAt(0);
			if(answer=='Y'){square.Remove(worker);;}
			else return;
			
			
			
			
		}
		
	
	public static void main(String[] args) {
		
		Thing thing = new Thing();
		Worker worker = new Worker();
		Box box = new Box();
		Floor floor = new Floor();
		Game game = new Game();
		Obstacle obstacle = new Obstacle();
		Hole hole = new Hole();
		Switch switch1 = new Switch();
		Square square = new Square();
		Direction d = null ;
		
		
		Scanner inp = new Scanner(System.in);
	
        int choice = 0;
       
        
        
        do {
            
            
            System.out.println("****");
           
            System.out.println("********************************");
            System.out.println("Make a choice (1-11), Enter 12 to exit!");
            choice = inp.nextInt();
            switch(choice){
                case 1: WorkerPushBox(worker,square,box,d,thing);break;
                        
                case 2: BoxPushBox1(worker,box,square,thing,d);break;
                    
                case 3:/*Duc*/
                    
                case 4:workerDiesBySandwich(worker,box,square,d,obstacle,game);break;
                        
                        
                case 5:WorkerDiesbyHole(hole,worker,game); break;
                	
                case 6:/*Duc*/
                	
                case 7:/*Duc*/
                	
                case 8:SwitchOn(box,worker,switch1,d,square, hole);break;
                	
                case 9:SwitchOff(box, worker,switch1, d,square, hole);break;
                	
                case 10:WorkerMove(square, worker,d,thing);break;
                	
                case 11: boxDisappear(worker,box,floor,game,obstacle,
           			 hole,switch1, square, d); break;
                        
                case 12: break;
            
            
            }
                    
            
	
        } while (choice  !=  12);
        
        
	}
		
	
	}

	

