import java.util.Random;

public class Gene {
	
	 private int x;
	 private int y;
	 
	 public int getX() {
	    return x;
	 }
	 
	 public int getY() {
	    return y;
	}
    
	 /* 
     * Cria um gene aleatoriamente
     */
    public Gene() {
        Random rand = new Random();
        this.x = (int) rand.nextInt(10000);
        this.y = (int) rand.nextInt(10000);
    }
}