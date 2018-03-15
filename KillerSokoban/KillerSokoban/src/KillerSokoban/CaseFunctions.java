package KillerSokoban;

import java.util.Scanner;

public class CaseFunctions {


	
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
		
		
		
		
		square.Remove(worker);
		
		System.out.println("Can we remove worker1 from square?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.Remove(worker);}
		
		
		
		
		
		square.Remove(box);
		System.out.println("Can we remove box1 from square?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.Remove(box);}
		
		
		square.Accept(worker);
		System.out.println("Can we accept worker1 from square?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.Accept(worker);}
		
		
		square.Accept(box);
		System.out.println("Can we accept box1 from square?Y/N");
		reader = scanner.nextLine();
		answer = reader.charAt(0);
		if(answer=='Y'){square.Accept(box);}
		
		
		
		
		
	}
	public static void BoxPushBox1(Worker worker, Box box, Square square,
			 Thing t, Direction d) {	
		
		worker.Move(d);
		worker.HitBy(worker);
		worker.HitBy(worker);
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
	    
	    square.Remove(worker);
	    System.out.print("Can we remove worker1 from square? Y/N");
	    String input3 = scanner.nextLine();
	    char c3 = input3.charAt(0);
	    if(c3 == 'Y'){
	    	square.Remove(worker);
	    }else
	    	return;
	    
	    square.Remove(box);
	    System.out.print("Can we remove box1 from square? Y/N");
	    String input4 = scanner.nextLine();
	    char c4 = input4.charAt(0);
	    if(c4 == 'Y'){
	    	square.Remove(box);
	    }else
	    	return;
	    
	    square.Remove(box);
	    System.out.print("Can we remove box2 from square? Y/N");
	    String input5 = scanner.nextLine();
	    char c5 = input5.charAt(0);
	    if(c5 == 'Y'){
	    	square.Remove(box);
	    }else
	    	return;
	    
	  
	    
	    square.Accept(worker);
	    System.out.print("Can we accept worker1 from square? Y/N");
	    String input7 = scanner.nextLine();
	    char c7 = input7.charAt(0);
	    if(c7 == 'Y'){
	    	square.Accept(worker);
	    }else
	    	return;
	    
	    square.Accept(box);
	    System.out.print("Can we accept box1 from square? Y/N");
	    String input8 = scanner.nextLine();
	    char c8 = input8.charAt(0);
	    if(c8 == 'Y'){
	    	square.Accept(box);
	    }else
	    	return;
	    
	    square.Accept(box);
	    System.out.print("Can we accept box2 from square? Y/N");
	    String input9 = scanner.nextLine();
	    char c9 = input9.charAt(0);
	    if(c9 == 'Y'){
	    	square.Accept(box);
	    }else
	    	return;

	    
	}
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
	public static void BoxPushBox(Worker w, Box b, Square square,Direction d) {
		Scanner inp = new Scanner(System.in);
		String choice;
		w.Move(d);
		b.HitBy(w);
		b.HitBy(b);
		square.GetNeighbor(d);
		System.out.println("Does square 1 has a neighbor? Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			square.GetNeighbor(d);
			square.GetNeighbor(d);
		} 
		System.out.println("Does square 2 has a neighbor? Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			square.GetNeighbor(d);
			square.GetNeighbor(d);
		}
		System.out.println("Does square 3 has a neighbor? Y/N");
		choice = inp.next();
			if (choice.compareTo("Y")==0) {
				square.GetNeighbor(d);
				square.Remove(w);
			}
		System.out.println("Can we remove worker1 from square?Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			square.Remove(w);
			square.Remove(b);
		}
		System.out.println("Can we remove box1 from square?Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			square.Remove(w);
			square.Remove(b);
		}
		System.out.println("Can we remove box2 from square?Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			square.Remove(w);
			square.Remove(b);
		}
		System.out.println("Can we accept worker1 from square?Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			square.Accept(w);
			square.Accept(b);
		}
		System.out.println("Can we accept box1 from square?Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			square.Accept(w);
			square.Accept(b);
		}
		System.out.println("Can we accept box2 from square?Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			square.Accept(w);
			square.Accept(b);
		}
	}
	public static void HoleAppear(Switch switch1,Hole hole,Box b ) {
		Scanner inp = new Scanner(System.in);
		String choice;
		System.out.println("Can I change the switch off to on? Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			switch1.HitBy(b);
			hole.SwitchedOn();
		} 
				
	}
	public static void HoleDisappear(Switch switch1,Hole hole,Box b ) {
		Scanner inp = new Scanner(System.in);
		String choice;
		System.out.println("Can I change the switch on to off? Y/N");
		choice = inp.next();
		if (choice.compareTo("Y")==0) {
			switch1.HitBy(b);
			hole.SwitchedOFF();
		} 
				
	}
	
}
