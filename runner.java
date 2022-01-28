import javax.swing.JOptionPane;
public class runner {
	public static void main(String[] args) {
		Life life = new Life(50, 50, 0.5);
		//System.out.print(kanye.isAlive(0, 0));
		while (true) {
			life.nextGeneration();
		}
	}
}
