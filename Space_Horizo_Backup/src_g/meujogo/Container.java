package meujogo;

import javax.swing.JFrame;

import meujogo.modelo.Fase;

public class Container extends JFrame {

	public Container() {

		add(new Fase());
		setTitle("Space Horizon");
		setBounds(100, 100, 970, 560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Container();
	}
}