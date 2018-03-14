package KillerSokoban;

import java.util.Scanner;

public class makinof {
	Worker w1 = new Worker();
	Worker w2 = new Worker();
	Box b1 = new Box();
	Square s1 = new Square();
	Square s2 = new Square();
	Square s3 = new Square();
	Thing t = new Thing();
	
	w1.Move(d);
	b1.Hitby(w1);
	w2.Hitby(b1);
	s1.Getneighbor(d);
	Scanner scanner = new Scanner(System.in);
    System.out.print("Does square 1 has a neighbor? Y/N");
    String input = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s1.GetNeighbor(d);
    }
    
    System.out.print("Does square 2 has a neighbor? Y/N");
    String input1 = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s2.GetNeighbor(d);
    }
    
    System.out.print("Does square 3 has a neighbor? Y/N");
    String input2 = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s3.GetNeighbor(d);
    }
    
    System.out.print("Can we remove worker1 from square? Y/N");
    String input3 = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s1.Remove(t);
    }
    
    System.out.print("Can we remove box from square? Y/N");
    String input4 = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s2.Remove(t);
    }
    
    System.out.print("Can we remove worker2 from square? Y/N");
    String input5 = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s3.Remove(t);
    }
    
    System.out.print("Can we remove worker2 from square? Y/N");
    String input6 = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s3.Remove(t);
    }
    
    System.out.print("Can we accept worker1 from square? Y/N");
    String input7 = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s3.Accept(t);
    }
    
    System.out.print("Can we accept box from square? Y/N");
    String input7 = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s3.Accept(t);
    }

    scanner.close();	
}
