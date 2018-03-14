package KillerSokoban;

import java.util.Scanner;

public class MAIN {

	/*Functions here*/
	
	public static void main(String[] args) {
		
		
		Worker worker = new Worker();
		Box box = new Box();
		Floor floor = new Floor();
		Game game = new Game();
		
		
		Scanner inp = new Scanner(System.in);
        int choice = 0;
       
        do {
            
            
            System.out.println("****");
           
            System.out.println("********************************");
            System.out.println("Make a choice (1-11)");
            choice = inp.nextInt();
            switch(choice){
                case 1: WorkerPushBox();
                        
                case 2: 
                    
                case 3:
                    
                case 4:
                        
                        
                case 5:
                	
                case 6:
                	
                case 7:
                	
                case 8:
                	
                case 9:
                	
                case 10:
                	
                case 11:
                        
                case 12: break;
            
            
            }
                    
            
	
        } while (choice  !=12);
	}
	

}
