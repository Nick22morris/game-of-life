import javax.swing.JOptionPane;

public class runner {
	public static void main(String[] args) {
		Life kanye = new Life(50, 50, 0.50);
		kanye.build();
		int n = 0;
		int count = 0;
		while (n == 0) {
			JOptionPane.showMessageDialog(null, count);
			kanye.update();
			kanye.print();
			count++;
		}
	}
}
