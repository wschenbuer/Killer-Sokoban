package KillerSokoban;

import java.util.Scanner;

public class MAIN {

	
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
        int choice = 0;
       
        do {
            
            
            System.out.println("****");
            System.out.println("1.");
            System.out.println("2.");
            System.out.println("3.");
            System.out.println("4.");
            System.out.println("5.");
            System.out.println("********************************");
            System.out.println("Make a choice");
            choice = inp.nextInt();
            switch(choice){
                case 1: b.createCustomer();
                        choice = 6;
                        
                case 2: b.withDraw();
                        break;
                    
                case 3:
                    
                case 4: b.Display();
                        break;
                        
                        
                case 5: System.out.println("Do you really want to exit ?(y/n) ");
                        String yesno = inp.next();
                        if ((yesno.compareTo("y")==0 )||(yesno.compareTo("Y")==0 )){
                        System.out.println("Exiting ...!");    
                        break;
                        } else {
                            System.out.println("return to menu");
                            choice =6;
                        }
                    
            }
        } while (choice !=5);
	}

}
