package KillerSokoban;

public class Switch extends Thing {
	public void HitBy(Box b){System.out.println("[:Switch].HitBy(b)");}
	public void HitBy(Worker w){System.out.println("[:Switch].HitBy(w)");}
}
