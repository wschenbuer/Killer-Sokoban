package KillerSokoban;

import java.util.Scanner;

public class makinof {
	Worker w1 = new Worker();
	Worker w2 = new Worker();
	Box b1 = new Box();
	Square s1 = new Square();
	Square s2 = new Square();
	Square s3 = new Square();
	
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
    String input = scanner.nextLine();
    if(input == 'Y' || 'y' ){
    s2.GetNeighbor(d);
    }
    
    scanner.close();
	
}
