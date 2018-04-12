package KillerSokoban;


public class Floor implements Steppable
{

	int[][] floor= new int [100][100];
	public void printFloor() {
		for (int i=0; i<100; i++) {
			for (int j= 0; j<100; j++) {
				floor[i][j]=0;
				System.out.printf(" ",floor[i][j]);
			}
		}
	}
	public Worker GetWorker(Square s){
		return null;}
	
	public void CreateThing(){};
	
	
	
	public void Eliminate(Box b){}

	

	public void Step(Direction d) {
		// TODO Auto-generated method stub
		
	};
}
