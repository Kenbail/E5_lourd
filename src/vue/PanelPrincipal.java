package vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class PanelPrincipal extends JPanel {
	public PanelPrincipal(String message) {

		this.setLayout(null);
		this.setBackground(Color.gray);
		JLabel lbTitre = new JLabel(message);
		lbTitre.setBounds(300, 40, 400, 40);

		// création d'une police d'écriture
		Font unePolice = new Font("Arial", Font.BOLD, 30);
		lbTitre.setFont(unePolice);
		this.setBounds(10, 60, 1200, 1600);
		this.add(lbTitre);

		this.setVisible(false);
	}
}
