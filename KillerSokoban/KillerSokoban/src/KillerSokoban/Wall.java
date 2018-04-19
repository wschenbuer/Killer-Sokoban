package KillerSokoban;

public class Wall extends Obstacle {

	private int id;
	private int squareId;
	
	public int getsquareid()
	{
		return this.squareId;
	}
	
	Wall(int id, int squareId)
	{
		this.id=id;
		this.squareId=squareId;
	}
}
