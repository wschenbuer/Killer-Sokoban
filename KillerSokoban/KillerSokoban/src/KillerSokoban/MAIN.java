package KillerSokoban;

import java.util.Scanner;

public class MAIN {


	
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
                case 1: CaseFunctions.WorkerPushBox(worker, square, box, d, thing);break;
                        
                case 2: CaseFunctions.BoxPushBox1(worker, box, square, thing, d);break;
                    
                case 3:/*Duc*/
                    
                case 4:CaseFunctions.workerDiesBySandwich(worker,box,square,d,obstacle,game);break;
                        
                        
                case 5:CaseFunctions.WorkerDiesbyHole(hole,worker,game); break;
                	
                case 6:/*Duc*/
                	
                case 7:/*Duc*/
                	
                case 8:CaseFunctions.SwitchOn(box,worker,switch1,d,square, hole);break;
                	
                case 9:CaseFunctions.SwitchOff(box, worker,switch1, d,square, hole);break;
                	
                case 10:CaseFunctions.WorkerMove(square, worker,d,thing);break;
                	
                case 11: CaseFunctions.boxDisappear(worker,box,floor,game,obstacle,
           			 hole,switch1, square, d); break;
                        
                case 12: break;
            
            
            }
                    
            
	
        } while (choice  !=  12);
        
        
	}
		
	
	}

	

