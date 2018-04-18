package KillerSokoban;

public class Game {

	
	public  boolean IsStart;
	Game()
	{
		this.IsStart=true;
	}
	
	
    public void startGame(){
    
    	IsStart=true;
    }

    public void endGame(){
    		
    	IsStart=false;
    }

}
