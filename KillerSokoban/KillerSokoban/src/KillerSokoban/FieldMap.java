package KillerSokoban;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FieldMap {
	
	JFrame frame=new JFrame(); //creates frame
    
	JButton[][] grid; //names the grid of buttons

    
    
    public FieldMap(int width, int length){ //constructor
            
    	frame.setLayout(new GridLayout(width,length)); //set layout
            
        grid=new JButton[width][length]; //allocate the size of grid
        
        for(int x=0; x<width; x++){
            for(int y=0; y<length; y++){
                 grid[x][y]=new JButton("("+x+","+y+")"); //creates new button
                 grid[x][y].setPreferredSize(new Dimension(200, 200));
                 frame.add(grid[x][y]); //adds button to grid
            }
        }
            
        	//set up the color for object
            for(int y = 0; y < length; y++) {
            	grid[0][y].setBackground(Color.PINK);
            	grid[5][y].setBackground(Color.PINK);
            }
            
            for(int x = 0; x < length; x++) {
            	grid[x][0].setBackground(Color.PINK);
            	grid[x][5].setBackground(Color.PINK);
            }
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack(); //sets appropriate size for frame
            frame.setVisible(true); //makes frame visible
    }
    
    
    public void refresh(ArrayList<Square> floor) {
    	for (int i = 0; i < 36; i++) {
    		String obj = floor.get(i).getOccupieThingOnSquareWithString();
    		//if(i==2)System.out.println(i);
    		switch (obj) {
    		case "worker" :
				grid[(i/6)][(i%6)].setBackground(Color.RED);
			break;
				case "box" :
					grid[(i/6)][(i%6)].setBackground(Color.YELLOW);
				break;
				
				case "pillar" :
					grid[(i/6)][(i%6)].setBackground(Color.PINK);
				break;
				
				case "wall" :
					grid[(i/6)][(i%6)].setBackground(Color.PINK);
				break;
				
				
				case "switch" :
					grid[(i/6)][(i%6)].setBackground(Color.GREEN);
				break;
				
				case "hole" :
					grid[(i/6)][(i%6)].setBackground(Color.BLACK);
				break;
				
				default : grid[(i/6)][(i%6)].setBackground(new JButton().getBackground());
				break;
    		
    		}
    		frame.invalidate();
    		
    		}
    	}
   }

